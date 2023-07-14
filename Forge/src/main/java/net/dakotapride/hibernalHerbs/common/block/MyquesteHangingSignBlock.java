package net.dakotapride.hibernalHerbs.common.block;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MyquesteHangingSignBlock extends CeilingHangingSignBlock {

    public MyquesteHangingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return HibernalBlockEntities.MYQUESTE_HANGING_SIGN.get().create(pos, state);
    }

}