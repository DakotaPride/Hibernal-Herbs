package net.dakotapride.hibernalHerbs.common.init.gen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ConfiguredFeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MYQUESTE_CONFIGURED = registerKey("myqueste");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HERBS_CONFIGURED = registerKey("herbs");

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MOD_ID, name));
    }

}
