package net.dakotapride.hibernalHerbs.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CommonPlatformHelper {

    @ExpectPlatform
    public static WoodType createWoodType(String name, BlockSetType setType) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static WoodType registerWoodType(WoodType woodType) {
        throw new AssertionError();
    }
}