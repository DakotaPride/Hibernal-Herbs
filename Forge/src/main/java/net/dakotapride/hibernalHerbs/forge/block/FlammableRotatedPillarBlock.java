package net.dakotapride.hibernalherbs.forge.block;

import net.dakotapride.hibernalherbs.forge.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class FlammableRotatedPillarBlock extends PillarBlock {
    public FlammableRotatedPillarBlock(Settings pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockView level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockView level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockView level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, ItemUsageContext context, ToolAction toolAction, boolean simulate) {
        if(context.getStack().getItem() instanceof AxeItem) {
            if(state.isOf(BlockRegistry.MYQUESTE_LOG.get())) {
                return BlockRegistry.STRIPPED_MYQUESTE_LOG.get().getDefaultState().with(AXIS, state.get(AXIS));
            }

            if(state.isOf(BlockRegistry.MYQUESTE_WOOD.get())) {
                return BlockRegistry.STRIPPED_MYQUESTE_WOOD.get().getDefaultState().with(AXIS, state.get(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
