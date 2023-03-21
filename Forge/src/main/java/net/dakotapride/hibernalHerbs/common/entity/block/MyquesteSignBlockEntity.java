package net.dakotapride.hibernalHerbs.common.entity.block;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MyquesteSignBlockEntity extends SignBlockEntity {

    public MyquesteSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return HibernalBlockEntities.MYQUESTE_SIGN.get();
    }

}
