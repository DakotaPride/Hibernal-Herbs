package net.dakotapride.hibernalHerbs.common.init.gen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class PlacedFeatureInit {
    public static final RegistryKey<PlacedFeature> MYQUESTE_PLACED = registerKey("myqueste_placed");
    public static final RegistryKey<PlacedFeature> HERBS_PLACED = registerKey("herbs_placed");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, name));
    }

}
