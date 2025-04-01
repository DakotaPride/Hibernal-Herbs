package net.dakotapride.hibernalherbs.item;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.FrozeBlockstates;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbalSigilTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.StoneTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class SorcererAgglomerationItem extends Item {
    public static final Supplier<BiMap<Block, Block>> FREEZE_STATE = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.FROZE_STATE_SACRIFICIAL_RUNE_BLOCK)
                    .put(Blocks.COPPER_BLOCK, FrozeBlockstates.COPPER.getFrozeState())
                    .put(Blocks.EXPOSED_COPPER, FrozeBlockstates.EXPOSED_COPPER.getFrozeState())
                    .put(Blocks.WEATHERED_COPPER, FrozeBlockstates.WEATHERED_COPPER.getFrozeState())
                    .put(Blocks.OXIDIZED_COPPER, FrozeBlockstates.OXIDISED_COPPER.getFrozeState())
                    .put(Blocks.CUT_COPPER, FrozeBlockstates.COPPER.getFrozeCutState())
                    .put(Blocks.EXPOSED_CUT_COPPER, FrozeBlockstates.EXPOSED_COPPER.getFrozeCutState())
                    .put(Blocks.WEATHERED_CUT_COPPER, FrozeBlockstates.WEATHERED_COPPER.getFrozeCutState())
                    .put(Blocks.OXIDIZED_CUT_COPPER, FrozeBlockstates.OXIDISED_COPPER.getFrozeCutState())
                    .put(Blocks.CUT_COPPER_SLAB, FrozeBlockstates.COPPER.getFrozeCutSlabState())
                    .put(Blocks.EXPOSED_CUT_COPPER_SLAB, FrozeBlockstates.EXPOSED_COPPER.getFrozeCutSlabState())
                    .put(Blocks.WEATHERED_CUT_COPPER_SLAB, FrozeBlockstates.WEATHERED_COPPER.getFrozeCutSlabState())
                    .put(Blocks.OXIDIZED_CUT_COPPER_SLAB, FrozeBlockstates.OXIDISED_COPPER.getFrozeCutSlabState())
                    .put(Blocks.CUT_COPPER_STAIRS, FrozeBlockstates.COPPER.getFrozeCutStairsState())
                    .put(Blocks.EXPOSED_CUT_COPPER_STAIRS, FrozeBlockstates.EXPOSED_COPPER.getFrozeCutStairsState())
                    .put(Blocks.WEATHERED_CUT_COPPER_STAIRS, FrozeBlockstates.WEATHERED_COPPER.getFrozeCutStairsState())
                    .put(Blocks.OXIDIZED_CUT_COPPER_STAIRS, FrozeBlockstates.OXIDISED_COPPER.getFrozeCutStairsState())
                    .put(Blocks.CHISELED_COPPER, FrozeBlockstates.COPPER.getFrozeChiseledState())
                    .put(Blocks.EXPOSED_CHISELED_COPPER, FrozeBlockstates.EXPOSED_COPPER.getFrozeChiseledState())
                    .put(Blocks.WEATHERED_CHISELED_COPPER, FrozeBlockstates.WEATHERED_COPPER.getFrozeChiseledState())
                    .put(Blocks.OXIDIZED_CHISELED_COPPER, FrozeBlockstates.OXIDISED_COPPER.getFrozeChiseledState())
                    .put(Blocks.COPPER_DOOR, FrozeBlockstates.COPPER.getFrozeDoorState())
                    .put(Blocks.EXPOSED_COPPER_DOOR, FrozeBlockstates.EXPOSED_COPPER.getFrozeDoorState())
                    .put(Blocks.WEATHERED_COPPER_DOOR, FrozeBlockstates.WEATHERED_COPPER.getFrozeDoorState())
                    .put(Blocks.OXIDIZED_COPPER_DOOR, FrozeBlockstates.OXIDISED_COPPER.getFrozeDoorState())
                    .put(Blocks.COPPER_TRAPDOOR, FrozeBlockstates.COPPER.getFrozeTrapdoorState())
                    .put(Blocks.EXPOSED_COPPER_TRAPDOOR, FrozeBlockstates.EXPOSED_COPPER.getFrozeTrapdoorState())
                    .put(Blocks.WEATHERED_COPPER_TRAPDOOR, FrozeBlockstates.WEATHERED_COPPER.getFrozeTrapdoorState())
                    .put(Blocks.OXIDIZED_COPPER_TRAPDOOR, FrozeBlockstates.OXIDISED_COPPER.getFrozeTrapdoorState())
                    .put(Blocks.COPPER_GRATE, FrozeBlockstates.COPPER.getFrozeGrateState())
                    .put(Blocks.EXPOSED_COPPER_GRATE, FrozeBlockstates.EXPOSED_COPPER.getFrozeGrateState())
                    .put(Blocks.WEATHERED_COPPER_GRATE, FrozeBlockstates.WEATHERED_COPPER.getFrozeGrateState())
                    .put(Blocks.OXIDIZED_COPPER_GRATE, FrozeBlockstates.OXIDISED_COPPER.getFrozeGrateState())
                    .put(Blocks.COPPER_BULB, FrozeBlockstates.COPPER.getFrozeBulbState())
                    .put(Blocks.EXPOSED_COPPER_BULB, FrozeBlockstates.EXPOSED_COPPER.getFrozeBulbState())
                    .put(Blocks.WEATHERED_COPPER_BULB, FrozeBlockstates.WEATHERED_COPPER.getFrozeBulbState())
                    .put(Blocks.OXIDIZED_COPPER_BULB, FrozeBlockstates.OXIDISED_COPPER.getFrozeBulbState())
                    .build()
    );
    public static final Supplier<BiMap<Block, Block>> UNFREEZE_STATE = Suppliers.memoize(() -> ((BiMap)FREEZE_STATE.get()).inverse());

    public SorcererAgglomerationItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        if (!isNotActive(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.agglomeration.is_active"));
            list.add(Component.literal(""));
            list.add(Component.translatable("text.hibernalherbs.agglomeration.cannot_utilise"));
        } else if (isNotActive(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.not_active").withStyle(ChatFormatting.GRAY));
        }
    }

    public static boolean isNotActive(ItemStack itemStack) {
        return Boolean.FALSE.equals(itemStack.get(DataComponentInit.IS_BEING_USED)) || !(itemStack.has(DataComponentInit.IS_BEING_USED));
    }

    public static Optional<BlockState> getFreezeState(BlockState blockState) {
        return Optional.ofNullable((Block)((BiMap)FREEZE_STATE.get()).get(blockState.getBlock())).map(block -> block.withPropertiesOf(blockState));
    }

    public static Optional<BlockState> getUnfreezeState(BlockState blockState) {
        return Optional.ofNullable((Block)((BiMap)UNFREEZE_STATE.get()).get(blockState.getBlock())).map(block -> block.withPropertiesOf(blockState));
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        Player player = useOnContext.getPlayer();

        Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
        int i = (int)Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);

        if (getFreezeState(blockState).isPresent()) {
            return (InteractionResult)getFreezeState(blockState).map(blockStatex -> {
                level.setBlock(blockPos, blockStatex, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockStatex));

                if (player instanceof ServerPlayer) {
                    player.getCooldowns().addCooldown(this, 10);

                    CriteriaTriggersInit.FROZE_BLOCKSTATE.trigger((ServerPlayer) player, blockPos);
                    player.awardStat(StatsInit.FROZE_BLOCKSTATE.get(blockState.getBlock()));
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }).orElse(InteractionResult.PASS);
        } else if (getUnfreezeState(blockState).isPresent()) {
            return (InteractionResult)getUnfreezeState(blockState).map(blockStatex -> {
                level.setBlock(blockPos, blockStatex, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockStatex));
                if (player instanceof ServerPlayer) {
                    player.getCooldowns().addCooldown(this, 10);

                    CriteriaTriggersInit.UNFROZE_BLOCKSTATE.trigger((ServerPlayer) player, blockPos);
                    player.awardStat(StatsInit.UNFROZE_BLOCKSTATE.get(blockStatex.getBlock()));
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }).orElse(InteractionResult.PASS);
        }

        return InteractionResult.FAIL;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack0 = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStack1 = player.getItemInHand(InteractionHand.OFF_HAND);

        if (!itemStack0.is(this))
            return InteractionResultHolder.fail(this.getDefaultInstance());

        if (itemStack1.is(Tags.Items.CAN_USE_WITH_AGGLOMERATION.getTag()) && !player.getCooldowns().isOnCooldown(itemStack0.getItem()) && isNotActive(itemStack0)) {
            itemStack0.set(DataComponentInit.IS_BEING_USED, true);

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
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.SANGUINE, (20 * 10), 0));
            }

            if (itemStack1.is(HerbalSigilTypes.SLOTH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.LETHARGY, (20 * 10), 0));
            }

            if (itemStack1.is(HerbalSigilTypes.WRATH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.BARBARIC, (20 * 10), 0));
            }

            if (itemStack1.is(HerbalSigilTypes.LUST.getHerbalSigilItem())) {
                MobEffectInstance instance = new MobEffectInstance(StatusEffectInit.DEVOTION, (20 * 10), 0);
                livingEntity.addEffect(instance);

                final List<Animal> animalList = level.getEntitiesOfClass(Animal.class, livingEntity.getBoundingBox().inflate(8F * instance.getAmplifier()), Objects::nonNull);
                animalList.forEach(animal -> {
                    if (livingEntity instanceof Player player)
                        animal.setInLove(player);
                });
            }

            if (itemStack1.is(HerbalSigilTypes.GREED.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.RAPACITY, (20 * 10), 0));
            }

            if (itemStack1.is(HerbalSigilTypes.GLUTTONY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.ESURIENT, (20 * 10), 0));
            }

            if (itemStack1.is(HerbalSigilTypes.ENVY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.MIMICRY, (20 * 10), 0));
            }


            if (!level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel)level;

                BlockPos blockPos = livingEntity.getOnPosLegacy();

                BlockState blockState = Blocks.REDSTONE_BLOCK.defaultBlockState();

                Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
                int i = (int)Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);
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
                    CriteriaTriggersInit.USED_AGGLOMERATION.trigger(player, itemStack);
                    CriteriaTriggersInit.SACRIFICED_BLOOD_FROM_AGGLOMERATION.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL_WITH_AGGLOMERATION.trigger(player, itemStack);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.awardStat(StatsInit.USED_AGGLOMERATION.get(this));
                    player.awardStat(StatsInit.SACRIFICED_BLOOD_FROM_AGGLOMERATION.get(this));
                    player.awardStat(StatsInit.USED_SIGIL.get(this));
                    player.awardStat(StatsInit.USED_SIGIL_WITH_AGGLOMERATION.get(this));

                    player.getCooldowns().addCooldown(this, (20 * 12));

                    player.hurt(player.damageSources().source(DamageSourceKeysInit.AGGLOMERATION_BLOOD_SACRIFICE), 4.0F);

                    itemStack.set(DataComponentInit.IS_BEING_USED, false);
                }

            }
        }


        // Fake recipes!
        if (livingEntity instanceof ServerPlayer player) {
            createItemConversion(level, player, Items.WITHER_ROSE, HerbTypes.SAGE.getBaseBlock().asItem(), itemStack, itemStack1);
            createItemConversion(level, player, Items.LODESTONE, BlockInit.SACRIFICIAL_RUNE_BLOCK.asItem(), itemStack, itemStack1);
            createItemConversion(level, player, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK.asItem(), ItemInit.BLANK_HERBAL_SIGIL, itemStack, itemStack1);
            createStoneToItemConversion(level, player, Items.STONE, Items.COBBLESTONE, Items.STONE_BRICKS, Items.SMOOTH_STONE, StoneTypes.IDIOSYNCRATIC_STONE, itemStack, itemStack1);
            createStoneToItemConversion(level, player, Items.DEEPSLATE, Items.COBBLED_DEEPSLATE, Items.DEEPSLATE_BRICKS, Items.POLISHED_DEEPSLATE, StoneTypes.NECROMANTIC_STONE, itemStack, itemStack1);
        }

        return itemStack;
    }

    private void createStoneToItemConversion(Level level, ServerPlayer player,
                                             Item base, Item cobbled, Item bricks, Item polished,
                                             StoneTypes types,
                                             ItemStack itemStack, ItemStack itemStack1) {
        createItemConversion(level, player, base, types.getBaseBlock().asItem(), itemStack, itemStack1);
        createItemConversion(level, player, cobbled, types.getCobbledBlock().asItem(), itemStack, itemStack1);
        createItemConversion(level, player, bricks, types.getBricksBlock().asItem(), itemStack, itemStack1);
        createItemConversion(level, player, polished, types.getPolishedBlock().asItem(), itemStack, itemStack1);
    }

    private void createItemConversion(Level level, ServerPlayer player, Item base, Item result, ItemStack itemStack, ItemStack itemStack1) {
        if (!level.isClientSide) {
            if (itemStack1.is(base)) {
                itemStack1.shrink(1);
                player.addItem(new ItemStack(result, 1));

                CriteriaTriggers.CONSUME_ITEM.trigger(player, itemStack1);
                CriteriaTriggersInit.USED_AGGLOMERATION.trigger(player, itemStack);
                CriteriaTriggersInit.CONJURED_ITEMS_FROM_AGGLOMERATION.trigger(player, itemStack);

                player.awardStat(Stats.ITEM_USED.get(this));
                player.awardStat(StatsInit.USED_AGGLOMERATION.get(this));
                player.awardStat(StatsInit.CONJURED_ITEMS_FROM_AGGLOMERATION.get(this));
                player.awardStat(Stats.ITEM_CRAFTED.get(result));

                player.getCooldowns().addCooldown(this, (20 * 12));

                itemStack.set(DataComponentInit.IS_BEING_USED, false);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
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
