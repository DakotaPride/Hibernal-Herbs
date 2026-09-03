package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.init.CriteriaTriggersInit;
import net.dakotapride.hibernalherbs.init.DamageSourceKeysInit;
import net.dakotapride.hibernalherbs.init.StatsInit;
import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbalSigilTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.PadlockTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class SorcererTomeItem extends Item {
    private static final String TAG_IS_BEING_USED = "IsBeingUsed";
    public SorcererTomeItem(Properties properties) {
        super(properties);
    }

    public static boolean isBeingUsed(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        return compoundTag != null && compoundTag.getBoolean(TAG_IS_BEING_USED);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        if (isBeingUsed(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.tome.is_active"));
            list.add(Component.literal(""));
            list.add(Component.translatable("text.hibernalherbs.tome.cannot_utilise"));
        } else if (!isBeingUsed(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.not_active").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        Player player = ctx.getPlayer();

        if (blockState.getBlock() instanceof BonemealableBlock block && level instanceof ServerLevel serverLevel && block.isValidBonemealTarget(serverLevel, blockPos, blockState, level.isClientSide)) {
            block.performBonemeal(serverLevel, level.getRandom(), blockPos, blockState);

            player.getCooldowns().addCooldown(this, (20 * 3));

            BlockState blockState1 = Blocks.GRASS_BLOCK.defaultBlockState();

            Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
            int i = (int) Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);
            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState1), vec3.x, vec3.y, vec3.z, i, 0.3F, 0.3F, 0.3F, 0.15F);

            return InteractionResult.SUCCESS;
        }

        return super.useOn(ctx);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack0 = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStack1 = player.getItemInHand(InteractionHand.OFF_HAND);

        if (!itemStack0.is(this))
            return InteractionResultHolder.fail(this.getDefaultInstance());

        if (itemStack1.is(Tags.Items.CAN_USE_WITH_TOME.getTag()) && !player.getCooldowns().isOnCooldown(itemStack0.getItem()) && !isBeingUsed(itemStack0)) {
            //itemStack0.set(DataComponentInit.IS_BEING_USED, true);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putBoolean(TAG_IS_BEING_USED, true);
            itemStack0.setTag(compoundTag);

            return ItemUtils.startUsingInstantly(level, player, interactionHand);
        } else {
            return InteractionResultHolder.fail(itemStack0);
        }
    }

    private int getDuration(ItemStack stack) {
        if (stack.is(Tags.Items.SHORT_AGGLOMERATION_DURATION.getTag())) {
            return 60;
        }

        if (stack.is(Tags.Items.LONG_AGGLOMERATION_DURATION.getTag())) {
            return 80;
        }

        return 60;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(itemStack, level, livingEntity);

        //ItemStack itemStack0 = livingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStack1 = livingEntity.getOffhandItem();

        if (itemStack1.is(Tags.Items.USABLE_HERBAL_SIGILS.getTag())) {
            //duration = 60;

            if (itemStack1.is(HerbalSigilTypes.PRIDE.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.SANGUINE.value(), (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.SLOTH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.LETHARGY.value(), (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.WRATH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.BARBARIC.value(), (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.LUST.getHerbalSigilItem())) {
                MobEffectInstance instance = new MobEffectInstance(StatusEffectInit.DEVOTION.value(), (20 * 10), 1);
                livingEntity.addEffect(instance);

                final List<Animal> animalList = level.getEntitiesOfClass(Animal.class, livingEntity.getBoundingBox().inflate(8F * instance.getAmplifier()), Objects::nonNull);
                animalList.forEach(animal -> {
                    if (livingEntity instanceof Player player)
                        animal.setInLove(player);
                });
            }

            if (itemStack1.is(HerbalSigilTypes.GREED.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.RAPACITY.value(), (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.GLUTTONY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.ESURIENT.value(), (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.ENVY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.MIMICRY.value(), (20 * 10), 1));
            }


            if (!level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel)level;

                BlockPos blockPos = livingEntity.getOnPosLegacy();

                BlockState blockState = Blocks.HAY_BLOCK.defaultBlockState();

                Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
                int i = (int) Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState), vec3.x, vec3.y, vec3.z, i, 0.3F, 0.3F, 0.3F, 0.15F);
                //this.spawnExtraParticlesOnFall = false;
//                for(int i = 0; i < 360; i++) {
//                    if(i % 20 == 0) {
//                        level.addParticle(ParticleTypes.HEART,
//                                livingEntity.getX() + 0.5d, livingEntity.getY() + 1, livingEntity.getZ() + 0.5d,
//                                Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
//                    }
//                }

                if (livingEntity instanceof ServerPlayer player) {
                    //player.getAdvancements().award(ModAdvancementProvider.AdvancementHolders.sorcerer_agglomeration, "testing");
                    //CriteriaTriggers.CONSUME_ITEM.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_TOME.trigger(player, itemStack);
                    CriteriaTriggersInit.SACRIFICED_HUNGER_FROM_TOME.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL_WITH_TOME.trigger(player, itemStack);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.awardStat(StatsInit.USED_TOME.get(this));
                    player.awardStat(StatsInit.SACRIFICED_HUNGER_FROM_TOME.get(this));
                    player.awardStat(StatsInit.USED_SIGIL.get(this));
                    player.awardStat(StatsInit.USED_SIGIL_WITH_TOME.get(this));

                    player.getCooldowns().addCooldown(this, (20 * 12));

                    player.hurt(DamageSourceKeysInit.getDamageSourceFromKey(level, DamageSourceKeysInit.TOME_HUNGER_SACRIFICE), 1.0F);
                    player.causeFoodExhaustion(0.20F);

                    CompoundTag tag = new CompoundTag();
                    tag.putBoolean(TAG_IS_BEING_USED, false);
                    itemStack.setTag(tag);
                }

            }
        }


        // Fake recipes!
        if (livingEntity instanceof ServerPlayer player) {
            for (PadlockTypes types : PadlockTypes.values()) {
                if (types != PadlockTypes.NONE)
                    createItemConversion(level, player, types.getUnboundPadlockItem(), types.getBoundPadlockItem(), itemStack, itemStack1);
            }
        }

        return itemStack;
    }

    private void createItemConversion(Level level, ServerPlayer player, Item base, Item result, ItemStack itemStack, ItemStack itemStack1) {
        if (!level.isClientSide) {
            if (itemStack1.is(base)) {
                itemStack1.shrink(1);
                player.addItem(new ItemStack(result, 1));

                CriteriaTriggers.CONSUME_ITEM.trigger(player, itemStack1);
                CriteriaTriggersInit.USED_TOME.trigger(player, itemStack);
                CriteriaTriggersInit.CONJURED_ITEMS_FROM_TOME.trigger(player, itemStack);

                player.awardStat(Stats.ITEM_USED.get(this));
                player.awardStat(StatsInit.USED_TOME.get(this));
                player.awardStat(StatsInit.CONJURED_ITEMS_FROM_TOME.get(this));
                player.awardStat(Stats.ITEM_CRAFTED.get(result));

                player.getCooldowns().addCooldown(this, (20 * 12));

                CompoundTag tag = new CompoundTag();
                tag.putBoolean(TAG_IS_BEING_USED, false);
                itemStack.setTag(tag);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            ItemStack itemStack1 = player.getOffhandItem();
            return getDuration(itemStack1);
        }
        return 60;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }
}
