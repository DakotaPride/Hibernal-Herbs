package net.dakotapride.hibernalHerbs.common.gen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsPlaced {
    public static final ResourceKey<PlacedFeature> MYQUESTE_PLACED = registerKey("myqueste_placed");
    public static final ResourceKey<PlacedFeature> HERBS_PLACED = registerKey("herbs_placed");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, name));
    }
}
