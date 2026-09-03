package net.dakotapride.hibernalherbs.block;

import net.dakotapride.hibernalherbs.init.BlockEntityTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock {

    public ModWallHangingSignBlock(WoodType type, Properties properties) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityTypeInit.MOD_HANGING_SIGN.create(pos, state);
    }

}