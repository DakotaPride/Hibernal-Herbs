package net.dakotapride.hibernalherbs.forge.block;

import net.dakotapride.hibernalherbs.forge.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MyquesteHangingSignBlock extends WallHangingSignBlock {

    public MyquesteHangingSignBlock(Settings settings, WoodType type) {
        super(settings, type);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.MYQUESTE_HANGING_SIGN.get().instantiate(pos, state);
    }

}