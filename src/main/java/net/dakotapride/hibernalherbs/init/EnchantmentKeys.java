package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentKeys {
    public static final ResourceKey<Enchantment> SLASHING = load("slashing");
    public static final ResourceKey<Enchantment> CULLING = load("culling");
    public static final ResourceKey<Enchantment> RAPID = load("rapid");

    public static void load() {}

    private static ResourceKey<Enchantment> load(String string) {
        return ResourceKey.create(Registries.ENCHANTMENT, HibernalHerbsMod.asResource(string));
    }
}
