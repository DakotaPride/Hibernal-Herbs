package net.dakotapride.hibernalherbs.block;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.CriteriaTriggersInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.PropertiesInit;
import net.dakotapride.hibernalherbs.init.StatsInit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SacredAltarBlock extends Block {
    public static final BooleanProperty RARE = PropertiesInit.RARE;
    public static final BooleanProperty SEALED = PropertiesInit.SEALED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private final ResourceLocation commonLootLocation;
    private final ResourceLocation rareLootLocation;
    private final int lootCooldown;

    public SacredAltarBlock(int lootCooldown, ResourceLocation commonLootLocation, ResourceLocation rareLootLocation, Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(RARE, Boolean.FALSE)
                        .setValue(SEALED, Boolean.TRUE)
                        .setValue(FACING, Direction.NORTH)
        );
        this.commonLootLocation = commonLootLocation;
        this.rareLootLocation = rareLootLocation;
        this.lootCooldown = lootCooldown;
    }

    public SacredAltarBlock(int lootCooldown, String commonLootId, String rareLootId, Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(RARE, Boolean.FALSE)
                        .setValue(SEALED, Boolean.TRUE)
                        .setValue(FACING, Direction.NORTH)
        );
        this.commonLootLocation = HibernalHerbsMod.asResource(commonLootId);
        this.rareLootLocation = HibernalHerbsMod.asResource(rareLootId);
        this.lootCooldown = lootCooldown;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    @NotNull
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    @NotNull
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RARE).add(SEALED).add(FACING);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(interactionHand).is(ItemInit.FORGOTTEN_BLESSING)) {
            if (blockState.getValue(SEALED)) {
                LootTable lootTable;
                if (level instanceof ServerLevel serverLevel) {
                    if (blockState.getValue(RARE)) {
                        lootTable = level.getServer().getLootData().getLootTable(rareLootLocation);
                    } else {
                        lootTable = level.getServer().getLootData().getLootTable(commonLootLocation);
                    }

                    LootParams lootparams = (new LootParams.Builder(serverLevel))
                            .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockPos))
                            .withLuck(player.getLuck()).withParameter(LootContextParams.THIS_ENTITY, player).create(LootContextParamSets.CHEST);
                    for (int i = 0; i < lootTable.getRandomItems(lootparams).size(); i++) {
                        popResourceFromFace(level, blockPos, Direction.UP, lootTable.getRandomItems(lootparams).get(i));
                    }
                }

                level.playSound(null, blockPos, SoundEvents.NOTE_BLOCK_BASEDRUM.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlock(blockPos, blockState.setValue(SEALED, Boolean.FALSE), 3);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                level.scheduleTick(blockPos, blockState.getBlock(), this.lootCooldown);

                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, player.getItemInHand(interactionHand));
                    CriteriaTriggersInit.USE_BLESSING_ON_ALTAR.trigger(serverPlayer, blockPos, player.getItemInHand(interactionHand));
                    serverPlayer.awardStat(Stats.ITEM_USED.get(player.getItemInHand(interactionHand).getItem()));
                    serverPlayer.awardStat(StatsInit.BLESSINGS_USED_ON_ALTARS, 1);
                }

                player.getItemInHand(interactionHand).shrink(1);
                return InteractionResult.CONSUME;
            } else {
                if (player instanceof ServerPlayer serverPlayer)
                    serverPlayer.sendSystemMessage(Component.literal("Something that great gods have thrown off the edge of time...").withStyle(ChatFormatting.RED), true);
            }
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!serverLevel.getBlockTicks().hasScheduledTick(blockPos, blockState.getBlock())) {
            serverLevel.playSound(null, blockPos, SoundEvents.NOTE_BLOCK_BELL.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
            serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(SEALED, Boolean.TRUE));
            Player player = Minecraft.getInstance().player;
            if (player != null)
                serverLevel.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return makeShape();
    }

    public VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 1, 0.875), BooleanOp.OR);

        return shape;
    }
}
