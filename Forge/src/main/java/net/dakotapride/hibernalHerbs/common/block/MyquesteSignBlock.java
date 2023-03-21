package net.dakotapride.hibernalHerbs.common.block;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Properties;

public class MyquesteSignBlock extends StandingSignBlock {

    public MyquesteSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return HibernalBlockEntities.MYQUESTE_SIGN.get().create(pos, state);
    }

}