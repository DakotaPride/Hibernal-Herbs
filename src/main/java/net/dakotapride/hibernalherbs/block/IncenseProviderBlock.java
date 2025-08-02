package net.dakotapride.hibernalherbs.block;

import dev.emi.emi.EmiPort;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class IncenseProviderBlock extends Block {
    public static final BooleanProperty FED = PropertiesInit.FED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public IncenseProviderBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FED, Boolean.FALSE).setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState blockState) {
        return blockState.getValue(FED);
    }

    @Override
    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return 5;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    protected @NotNull BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    protected @NotNull BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FED).add(FACING);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(FED);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(FED)) {
            if (randomSource.nextInt(1) == 0) {
                serverLevel.setBlock(blockPos, this.defaultBlockState().setValue(FED, false).setValue(FACING, blockState.getValue(FACING)), 3);
            }
        }
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(FED)) {
            if (level.isClientSide()) {
                makeParticles(level, blockPos, randomSource);
            }
        }
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (blockState.is(this) && !player.getCooldowns().isOnCooldown(itemStack.getItem())) {
            if (!blockState.getValue(FED)) {
                for (HerbTypes types : HerbTypes.values()) {
                    if (itemStack.is(types.getPoundedHerb())) {
                        if (types.getIncenseEffect() != null) {
                            provideEffectForIncenseFromPoundedHerb(itemStack, blockState, level, blockPos, player, types.getIncenseEffect());
                        } else {
                            if (types == HerbTypes.ROSEMARY || types == HerbTypes.CALENDULA) {
                                final List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10F), Objects::nonNull);
                                list.forEach(livingEntity -> {
                                    if (!level.isClientSide) {
                                        livingEntity.removeAllEffects();
                                    }
                                });

                                activate(player, itemStack, blockPos, blockState);
                            }
                        }

                        level.setBlock(blockPos, this.defaultBlockState().setValue(FED, true).setValue(FACING, blockState.getValue(FACING)), 3);
                        return ItemInteractionResult.SUCCESS;
                    } else if (itemStack.is(types.getDriedHerb())) {
                        if (types.getIncenseEffect() != null) {
                            provideEffectForIncenseFromDriedHerb(itemStack, blockState, level, blockPos, player, types.getIncenseEffect());
                        } else {
                            if (types == HerbTypes.ROSEMARY || types == HerbTypes.CALENDULA) {
                                final List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10F), Objects::nonNull);
                                list.forEach(livingEntity -> {
                                    if (!level.isClientSide) {
                                        livingEntity.removeAllEffects();
                                    }
                                });

                                activate(player, itemStack, blockPos, blockState);
                            }
                        }

                        level.setBlock(blockPos, this.defaultBlockState().setValue(FED, true).setValue(FACING, blockState.getValue(FACING)), 3);
                        return ItemInteractionResult.SUCCESS;
                    }
                }

                //HibernalHerbsMod.LOGGER.info("[Hibernal Herbs] THIS IS CHECKING FOR AN HERB TYPE");
            } else if (blockState.getValue(FED) && level.getBlockState(blockPos.below()).is(BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK)) {
                if (itemStack.is(Items.PAPER)) {
                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                        player.getCooldowns().addCooldown(itemStack.getItem(), 40);
                    }

                    player.addItem(new ItemStack(ItemInit.CHARRED_PAPER.get(), 1));

                    level.setBlock(blockPos, this.defaultBlockState().setValue(FED, false).setValue(FACING, blockState.getValue(FACING)), 3);

                    return ItemInteractionResult.SUCCESS;
                }
                if (itemStack.is(Items.BOOK)) {

                    if (!player.getAbilities().instabuild) {
                        itemStack.shrink(1);
                        player.getCooldowns().addCooldown(itemStack.getItem(), 40);
                    }

                    int random = new Random().nextInt(100);
                    int source = RandomSource.create().nextInt(100);
                    RandomSource source0 = RandomSource.create(source);

                    if (random < 75) {
                        ItemStack enchantedStack = Items.ENCHANTED_BOOK.getDefaultInstance();

                        Registry<Enchantment> enchantments = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT);

                        List<Enchantment> list = enchantments.stream().toList();
                        Optional<Enchantment> optional = Util.getRandomSafe(list, source0);
                        if (optional.isEmpty()) {
                            HibernalHerbsMod.LOGGER.warn("Couldn't find a compatible enchantment for {}", enchantedStack);
                        } else {
                            enchantItem(enchantedStack, enchantments.wrapAsHolder(optional.get()));
                        }

                        player.addItem(enchantedStack);
                    } else {
                        player.addItem(new ItemStack(ItemInit.CHARRED_PAPER.get(), 1));
                    }

                    level.setBlock(blockPos, this.defaultBlockState().setValue(FED, false).setValue(FACING, blockState.getValue(FACING)), 3);

                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    private static ItemStack enchantItem(ItemStack stack, Holder<Enchantment> enchantment) {
        if (stack.is(Items.BOOK)) {
            stack = new ItemStack(Items.ENCHANTED_BOOK);
        }

        stack.enchant(enchantment, enchantment.value().getMinLevel());
        return stack;
    }

    private static void provideEffectForIncenseFromPoundedHerb(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, Holder<MobEffect> effect) {
        final List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10F), Objects::nonNull);
        list.forEach(livingEntity -> livingEntity.addEffect(new MobEffectInstance(effect, 600, 1 /*, false, false, false*/)));
        activate(player, itemStack, blockPos, blockState);
    }

    private static void provideEffectForIncenseFromDriedHerb(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, Holder<MobEffect> effect) {
        final List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10F), Objects::nonNull);
        list.forEach(livingEntity -> livingEntity.addEffect(new MobEffectInstance(effect, 1200, 2 /*, false, false, false*/)));
        activate(player, itemStack, blockPos, blockState);
    }

    private static void activate(Player player, ItemStack itemStack, BlockPos blockPos, BlockState blockState) {
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
            player.getCooldowns().addCooldown(itemStack.getItem(), 900);
        }

        if (player instanceof ServerPlayer player1) {

            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(player1, blockPos, itemStack);
            CriteriaTriggersInit.INCENSE_PROVIDER_INTERACTIONS.get().trigger(player1, blockPos);
            player1.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            player1.awardStat(StatsInit.INCENSE_PROVIDER_INTERACTIONS.get().get(blockState.getBlock()));
        }
    }

    private static void makeParticles(Level level, BlockPos blockPos, RandomSource randomSource) {
        for(int j = 0; j < 20; ++j) {
            if (randomSource.nextFloat() < 0.2F) {
                double d = (double)blockPos.getX() + 0.5;
                double e = (double)blockPos.getY() + 0.5;
                double g = (double)blockPos.getZ() + 0.5;

                for(int k = 0; k < 1; ++k) {
                    level.addParticle(ParticleTypes.SMOKE, d, e, g, 0.0, 5.0E-4, 0.0);
                }
            }
        }

    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return makeShape();
    }


    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 0.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.11903407423209408, -0.15037097195284893, 0.3125, 0.11903407423209408, 0.03712902804715107, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8809659257679059, -0.15037097195284893, 0.3125, 0.8809659257679059, 0.03712902804715107, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 0.1875, 0.875), BooleanOp.OR);

        return shape;
    }
}
