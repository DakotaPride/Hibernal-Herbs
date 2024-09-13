package net.dakotapride.hibernalHerbs.common.block;

import net.dakotapride.hibernalHerbs.common.init.BlockEntityTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModSignBlock extends StandingSignBlock {

    public ModSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityTypeInit.MOD_SIGN.create(pos, state);
    }

}