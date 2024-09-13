package net.dakotapride.hibernalHerbs.platform.fabric;

import net.dakotapride.hibernalHerbs.mixin.WoodTypeAccessor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CommonPlatformHelperImpl {

    public static WoodType createWoodType(String name, BlockSetType setType) {
        return new WoodType(name, setType);
    }

    public static WoodType registerWoodType(WoodType woodType) {
        return WoodTypeAccessor.invokeRegister(woodType);
    }
}
