package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class StructureKeys {
    public static final ResourceKey<Structure> ARCANE_RUINS = createKey("arcane_ruins");

    public static void load() {}

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, HibernalHerbsMod.asResource(name));
    }
}
