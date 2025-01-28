package net.dakotapride.hibernalherbs.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SickleItem extends SwordItem {
    protected static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> CHANGE_BLOCKSTATE = Maps.newHashMap(
            ImmutableMap.of(
                    Blocks.GRASS_BLOCK,
                    Pair.of(SickleItem::onlyIfAirAbove, changeIntoState(Blocks.FARMLAND.defaultBlockState())),
                    Blocks.DIRT_PATH,
                    Pair.of(SickleItem::onlyIfAirAbove, changeIntoState(Blocks.FARMLAND.defaultBlockState())),
                    Blocks.DIRT,
                    Pair.of(SickleItem::onlyIfAirAbove, changeIntoState(Blocks.FARMLAND.defaultBlockState())),
                    Blocks.COARSE_DIRT,
                    Pair.of(SickleItem::onlyIfAirAbove, changeIntoState(Blocks.DIRT.defaultBlockState())),
                    BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK,
                    Pair.of(SickleItem::onlyIfAirAbove, changeIntoState(BlockInit.SACRIFICIAL_RUNE_BLOCK.defaultBlockState())),
                    Blocks.ROOTED_DIRT,
                    Pair.of(useOnContext -> true, changeIntoStateAndDropItem(Blocks.DIRT.defaultBlockState(), Items.HANGING_ROOTS))
            )
    );

    public static final ResourceLocation BASE_ENTITY_INTERACTION_RANGE = ResourceLocation.withDefaultNamespace("base_entity_interaction_range");
    public static final ResourceLocation BASE_BLOCK_INTERACTION_RANGE = ResourceLocation.withDefaultNamespace("base_block_interaction_range");
    //unused
    //public static final ResourceLocation BASE_SNEAKING_SPEED = ResourceLocation.withDefaultNamespace("base_sneaking_speed");

    public SickleItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public static Consumer<UseOnContext> changeIntoState(BlockState blockState) {
        return useOnContext -> {
            useOnContext.getLevel().setBlock(useOnContext.getClickedPos(), blockState, 11);
            useOnContext.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, useOnContext.getClickedPos(), GameEvent.Context.of(useOnContext.getPlayer(), blockState));
        };
    }

    public static Consumer<UseOnContext> changeIntoStateAndDropItem(BlockState blockState, ItemLike itemLike) {
        return useOnContext -> {
            useOnContext.getLevel().setBlock(useOnContext.getClickedPos(), blockState, 11);
            useOnContext.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, useOnContext.getClickedPos(), GameEvent.Context.of(useOnContext.getPlayer(), blockState));
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(itemLike));
        };
    }

    public static boolean onlyIfAirAbove(UseOnContext useOnContext) {
        return useOnContext.getClickedFace() != Direction.DOWN && useOnContext.getLevel().getBlockState(useOnContext.getClickedPos().above()).isAir();
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = CHANGE_BLOCKSTATE.get(
                level.getBlockState(blockPos).getBlock()
        );
        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(useOnContext)) {
                Player player = useOnContext.getPlayer();
                if (level.getBlockState(blockPos).is(BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK)) {
                    level.playSound(player, blockPos, SoundEvents.DEEPSLATE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

                    if (player instanceof ServerPlayer serverPlayer) {
                        CriteriaTriggersInit.SACRIFICIAL_RUNE_RESTORATION.trigger(serverPlayer, blockPos);
                        serverPlayer.awardStat(StatsInit.SACRIFICIAL_RUNE_RESTORATION.get(useOnContext.getLevel().getBlockState(blockPos).getBlock()));
                    }

                } else {
                    level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
                if (!level.isClientSide) {
                    consumer.accept(useOnContext);
                    if (player != null) {
                        useOnContext.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(useOnContext.getHand()));
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }


    public static @NotNull ItemAttributeModifiers createAttributes(Tier tier, int i, float f, float k) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, ((float)i + tier.getAttackDamageBonus()),
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, f,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE, k,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(BASE_BLOCK_INTERACTION_RANGE, k,
                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
//                .add(Attributes.SNEAKING_SPEED,
//                        new AttributeModifier(BASE_SNEAKING_SPEED, j,
//                                AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);

        if (EnchantmentHelper.hasTag(itemStack, Tags.Enchantments.HARVESTS_LIFE_FORCE.getTag())) {
            list.add(Component.translatable("text.hibernalherbs.sickles.on_attack").withStyle(ChatFormatting.GRAY));
            list.add(Component.translatable("text.hibernalherbs.sickles.provides_life_force").withStyle(Style.EMPTY.withColor(0xC3F422)));
            list.add(Component.literal(""));
        }

    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity2) {
        super.postHurtEnemy(itemStack, livingEntity, livingEntity2);

        if (livingEntity2 instanceof Player player) {
            if (player.getOffhandItem().is(Items.GLASS_BOTTLE)
                    && EnchantmentHelper.hasTag(itemStack, Tags.Enchantments.HARVESTS_LIFE_FORCE.getTag())) {
                livingEntity2.getOffhandItem().shrink(1);

                player.addItem(new ItemStack(ItemInit.LIFE_FORCE_BOTTLE, 1));
            }


            if (livingEntity.isDeadOrDying() && livingEntity.getType().is(Tags.EntityTypes.LIVESTOCK.getTag()) && !player.getCooldowns().isOnCooldown(itemStack.getItem()) && EnchantmentHelper.hasTag(itemStack, Tags.Enchantments.SIPHONS_LIVESTOCK.getTag())) {
                ResourceKey<Enchantment> key = EnchantmentKeys.CULLING;
                Holder<Enchantment> holder = player.level().registryAccess().registry(Registries.ENCHANTMENT).orElseThrow().getHolderOrThrow(key);
                int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(holder, itemStack);

                player.heal(2.0F * (enchantmentLevel + 1));

                player.getCooldowns().addCooldown(itemStack.getItem(), 100);
            }
        }
    }
}
