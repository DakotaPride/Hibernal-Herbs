package net.dakotapride.hibernalherbs.block;

import net.dakotapride.hibernalherbs.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class DeterioratedSacrificialRuneBlock extends Block {
    public DeterioratedSacrificialRuneBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (explosion.canTriggerBlocks()) {
            this.setStateFromTriggeredExplosion(level, blockState, blockPos);
        }

        super.onExplosionHit(blockState, level, blockPos, explosion, biConsumer);
    }

    public void setStateFromTriggeredExplosion(Level level, BlockState blockState, BlockPos blockPos) {
        if (blockState.is(this)) {
            level.setBlock(blockPos, BlockInit.SACRIFICIAL_RUNE_BLOCK.get().defaultBlockState(), 3);
            //level.setBlock(blockPos, blockState.setValue(OPEN, Boolean.valueOf(bl)), 10);
            //this.playSound(entity, level, blockPos, bl);
            //level.gameEvent(entity, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        }
    }
}
