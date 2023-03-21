package net.dakotapride.hibernalHerbs.common.block;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MyquesteWallSignBlock extends WallSignBlock {

    public MyquesteWallSignBlock(BlockBehaviour.Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return HibernalBlockEntities.MYQUESTE_SIGN.get().create(pos, state);
    }

}