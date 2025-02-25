package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeaturesInit {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYQUESTE_CONFIGURED = registerConfiguredFeature("myqueste");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HERBS_CONFIGURED = registerConfiguredFeature("herbs");

    public static final ResourceKey<PlacedFeature> MYQUESTE_PLACED = registerPlacedFeature("myqueste");
    public static final ResourceKey<PlacedFeature> HERBS_PLACED = registerPlacedFeature("herbs");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, HibernalHerbsMod.asResource(name));
    }

    public static ResourceKey<PlacedFeature> registerPlacedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, HibernalHerbsMod.asResource(name));
    }

}
