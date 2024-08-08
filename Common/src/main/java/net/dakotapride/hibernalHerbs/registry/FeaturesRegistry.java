package net.dakotapride.hibernalherbs.registry;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class FeaturesRegistry {

    // Placed Features
    public static final RegistryKey<PlacedFeature> MYQUESTE_PLACED = registerPlacedKey("myqueste_placed");
    public static final RegistryKey<PlacedFeature> HERBS_PLACED = registerPlacedKey("herbs_placed");

    public static RegistryKey<PlacedFeature> registerPlacedKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, name));
    }

    // Configured Features
    public static final RegistryKey<ConfiguredFeature<?, ?>> MYQUESTE_CONFIGURED = registerConfiguredKey("myqueste");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HERBS_CONFIGURED = registerConfiguredKey("herbs");

    public static RegistryKey<ConfiguredFeature<?, ?>> registerConfiguredKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MOD_ID, name));
    }

    public static void register() {
        // Load This Class
    }

}
