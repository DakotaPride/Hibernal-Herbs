package net.dakotapride.hibernalHerbs.common.gen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsConfigured {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYQUESTE_CONFIGURED = registerKey("myqueste");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HERBS_CONFIGURED = registerKey("herbs");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, name));
    }



}
