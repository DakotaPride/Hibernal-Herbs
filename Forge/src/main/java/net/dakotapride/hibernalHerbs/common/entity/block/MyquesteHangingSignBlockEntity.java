package net.dakotapride.hibernalHerbs.common.entity.block;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MyquesteHangingSignBlockEntity extends HangingSignBlockEntity {

    public MyquesteHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return HibernalBlockEntities.MYQUESTE_HANGING_SIGN.get();
    }

}
