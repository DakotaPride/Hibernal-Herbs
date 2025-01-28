package net.dakotapride.hibernalherbs.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dakotapride.hibernalherbs.init.BlockEntityTypeInit;
import net.dakotapride.hibernalherbs.init.CriteriaTriggersInit;
import net.dakotapride.hibernalherbs.init.StatsInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MysticalCampfireBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<MysticalCampfireBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(Codec.BOOL.fieldOf("spawn_particles").forGetter((campfireBlock) -> {
            return campfireBlock.spawnParticles;
        }), Codec.intRange(0, 1000).fieldOf("fire_damage").forGetter((campfireBlock) -> {
            return campfireBlock.fireDamage;
        }), propertiesCodec()).apply(instance, MysticalCampfireBlock::new);
    });
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);
    public static final BooleanProperty LIT;
    public static final BooleanProperty SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    private static final VoxelShape VIRTUAL_FENCE_POST;
    private static final int SMOKE_DISTANCE = 5;
    private final boolean spawnParticles;
    private final int fireDamage;

    public MapCodec<MysticalCampfireBlock> codec() {
        return CODEC;
    }

    public MysticalCampfireBlock(boolean bl, int i, Properties properties) {
        super(properties);
        this.spawnParticles = bl;
        this.fireDamage = i;
        this.registerDefaultState(((((this.stateDefinition.any()).setValue(LIT, true)).setValue(SIGNAL_FIRE, false)).setValue(WATERLOGGED, false)).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof MysticalCampfireBlockEntity campfireBlockEntity) {
            ItemStack itemStack2 = player.getItemInHand(interactionHand);
            Optional<RecipeHolder<MysticalCampfireCookingRecipe>> optional = campfireBlockEntity.getCookableRecipe(itemStack2);
            if (optional.isPresent()) {
                if (!level.isClientSide && campfireBlockEntity.placeFood(player, itemStack2, ((MysticalCampfireCookingRecipe)((RecipeHolder)optional.get()).value()).getCookingTime())) {
                    if (player instanceof ServerPlayer player1) {
                        CriteriaTriggersInit.MYSTICAL_CAMPFIRE_INTERACTIONS.get().trigger(player1, blockPos);
                        player1.awardStat(StatsInit.MYSTICAL_CAMPFIRE_INTERACTIONS.get().get(this));
                    }
                    return ItemInteractionResult.SUCCESS;
                }

                return ItemInteractionResult.CONSUME;
            }
        }

        if (itemStack.is(ItemTags.SHOVELS) && blockState.getValue(LIT)) {
            level.setBlock(blockPos, this.defaultBlockState().setValue(LIT, false).setValue(FACING, blockState.getValue(FACING)), 3);
            //this.defaultBlockState().setValue(LIT, false);
            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            dowse(null, level, blockPos, blockState);
            return ItemInteractionResult.SUCCESS;

        }

        if (!blockState.getValue(LIT) && (itemStack.is(Items.FLINT_AND_STEEL) || itemStack.is(Items.FIRE_CHARGE))) {
            level.setBlock(blockPos, this.defaultBlockState().setValue(LIT, true).setValue(FACING, blockState.getValue(FACING)), 3);
            //this.defaultBlockState().setValue(LIT, true);
            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));

            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (blockState.getValue(LIT) && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().campfire(), (float)this.fireDamage);
        }

        super.entityInside(blockState, level, blockPos, entity);
    }

    @Override
    protected void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof MysticalCampfireBlockEntity) {
                Containers.dropContents(level, blockPos, ((MysticalCampfireBlockEntity)blockEntity).getItems());
            }

            super.onRemove(blockState, level, blockPos, blockState2, bl);
        }
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelAccessor levelAccessor = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        boolean bl = levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER;
        return (((this.defaultBlockState().setValue(WATERLOGGED, bl)).setValue(SIGNAL_FIRE, this.isSmokeSource(levelAccessor.getBlockState(blockPos.below())))).setValue(LIT, !bl)).setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    protected BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return direction == Direction.DOWN ? blockState.setValue(SIGNAL_FIRE, this.isSmokeSource(blockState2)) : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    private boolean isSmokeSource(BlockState arg) {
        return arg.is(Tags.Blocks.DRIED_HERB_BLOCKS.getTag());
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (blockState.getValue(LIT)) {
            if (randomSource.nextInt(10) == 0) {
                level.playLocalSound((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + randomSource.nextFloat(), randomSource.nextFloat() * 0.7F + 0.6F, false);
            }

            if (this.spawnParticles && randomSource.nextInt(5) == 0) {
                for(int i = 0; i < randomSource.nextInt(1) + 1; ++i) {
                    level.addParticle(ParticleTypes.PORTAL, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5, (double)(randomSource.nextFloat() / 2.0F), 5.0E-5, (double)(randomSource.nextFloat() / 2.0F));
                }
            }

        }
    }

    public static void dowse(@Nullable Entity entity, LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        if (levelAccessor.isClientSide()) {
            for(int i = 0; i < 20; ++i) {
                makeParticles((Level)levelAccessor, blockPos, blockState.getValue(SIGNAL_FIRE), true);
            }
        }

        BlockEntity blockEntity = levelAccessor.getBlockEntity(blockPos);
        if (blockEntity instanceof MysticalCampfireBlockEntity) {
            ((MysticalCampfireBlockEntity)blockEntity).dowse();
        }

        levelAccessor.gameEvent(entity, GameEvent.BLOCK_CHANGE, blockPos);
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        if (!(Boolean)blockState.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            boolean bl = blockState.getValue(LIT);
            if (bl) {
                if (!levelAccessor.isClientSide()) {
                    levelAccessor.playSound(null, blockPos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                dowse(null, levelAccessor, blockPos, blockState);
            }

            levelAccessor.setBlock(blockPos, (blockState.setValue(WATERLOGGED, true)).setValue(LIT, false).setValue(FACING, blockState.getValue(FACING)), 3);
            levelAccessor.scheduleTick(blockPos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        if (!level.isClientSide && projectile.isOnFire() && projectile.mayInteract(level, blockPos) && !(Boolean)blockState.getValue(LIT) && !(Boolean)blockState.getValue(WATERLOGGED)) {
            level.setBlock(blockPos, blockState.setValue(BlockStateProperties.LIT, true), 11);
        }

    }

    public static void makeParticles(Level level, BlockPos blockPos, boolean bl, boolean bl2) {
        RandomSource randomSource = level.getRandom();
        SimpleParticleType simpleParticleType = bl ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
        level.addAlwaysVisibleParticle(simpleParticleType, true, (double)blockPos.getX() + 0.5 + randomSource.nextDouble() / 3.0 * (double)(randomSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + randomSource.nextDouble() + randomSource.nextDouble(), (double)blockPos.getZ() + 0.5 + randomSource.nextDouble() / 3.0 * (double)(randomSource.nextBoolean() ? 1 : -1), 0.0, 0.07, 0.0);
        if (bl2) {
            level.addParticle(ParticleTypes.SMOKE, (double)blockPos.getX() + 0.5 + randomSource.nextDouble() / 4.0 * (double)(randomSource.nextBoolean() ? 1 : -1), (double)blockPos.getY() + 0.4, (double)blockPos.getZ() + 0.5 + randomSource.nextDouble() / 4.0 * (double)(randomSource.nextBoolean() ? 1 : -1), 0.0, 0.005, 0.0);
        }

    }

    public static boolean isSmokeyPos(Level level, BlockPos blockPos) {
        for(int i = 1; i <= 5; ++i) {
            BlockPos blockPos2 = blockPos.below(i);
            BlockState blockState = level.getBlockState(blockPos2);
            if (isLitCampfire(blockState)) {
                return true;
            }

            boolean bl = Shapes.joinIsNotEmpty(VIRTUAL_FENCE_POST, blockState.getCollisionShape(level, blockPos, CollisionContext.empty()), BooleanOp.AND);
            if (bl) {
                BlockState blockState2 = level.getBlockState(blockPos2.below());
                return isLitCampfire(blockState2);
            }
        }

        return false;
    }

    public static boolean isLitCampfire(BlockState blockState) {
        return blockState.hasProperty(LIT) && blockState.is(BlockTags.CAMPFIRES) && (Boolean)blockState.getValue(LIT);
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MysticalCampfireBlockEntity(blockPos, blockState);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, BlockEntityTypeInit.MYSTICAL_CAMPFIRE.get(), MysticalCampfireBlockEntity::particleTick) : null;
        } else {
            return blockState.getValue(LIT) ? createTickerHelper(blockEntityType, BlockEntityTypeInit.MYSTICAL_CAMPFIRE.get(), MysticalCampfireBlockEntity::cookTick) : createTickerHelper(blockEntityType, BlockEntityTypeInit.MYSTICAL_CAMPFIRE.get(), MysticalCampfireBlockEntity::cooldownTick);
        }
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    public static boolean canLight(BlockState blockState) {
        return blockState.is(BlockTags.CAMPFIRES, (blockStateBase) -> blockStateBase.hasProperty(WATERLOGGED) && blockStateBase.hasProperty(LIT)) && !(Boolean)blockState.getValue(WATERLOGGED) && !(Boolean)blockState.getValue(LIT);
    }

    static {
        LIT = BlockStateProperties.LIT;
        SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        VIRTUAL_FENCE_POST = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    }
}
