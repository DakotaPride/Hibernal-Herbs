package net.dakotapride.hibernalherbs.item;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Optional;
import java.util.function.Supplier;

public class LifeForceBottleItem extends Item {
    public static final Supplier<BiMap<Block, Block>> DETERIORATABLE = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK)
                    .build()
    );

    public LifeForceBottleItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        return getDeterioratedState(blockState).map(blockStatex -> {
            Player player = useOnContext.getPlayer();
            ItemStack itemStack = useOnContext.getItemInHand();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
            }

            itemStack.shrink(1);
            player.addItem(new ItemStack(Items.GLASS_BOTTLE, 1));
            level.setBlock(blockPos, blockStatex, 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockStatex));
            //level.levelEvent(player, 3003, blockPos, 0);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }).orElse(InteractionResult.PASS);
    }

    public static Optional<BlockState> getDeterioratedState(BlockState blockState) {
        return Optional.ofNullable((Block)((BiMap) DETERIORATABLE.get()).get(blockState.getBlock())).map(block -> block.withPropertiesOf(blockState));
    }
}
