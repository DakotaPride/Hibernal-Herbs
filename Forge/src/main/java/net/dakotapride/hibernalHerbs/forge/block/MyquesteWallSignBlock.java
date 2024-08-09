package net.dakotapride.hibernalherbs.forge.block;

import net.dakotapride.hibernalherbs.forge.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MyquesteWallSignBlock extends WallSignBlock {

    public MyquesteWallSignBlock(Settings settings, WoodType type) {
        super(settings, type);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.MYQUESTE_SIGN.get().instantiate(pos, state);
    }

}