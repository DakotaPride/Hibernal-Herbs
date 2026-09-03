package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.enchantment.CullingEnchantment;
import net.dakotapride.hibernalherbs.enchantment.RapidEnchantment;
import net.dakotapride.hibernalherbs.enchantment.SlashingEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentsInit {
    public static final Enchantment SLASHING = register("slashing", new SlashingEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final Enchantment CULLING = register("culling", new CullingEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static final Enchantment RAPID = register("rapid", new RapidEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void load() {}

    private static Enchantment register(String string, Enchantment enchantment) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT, HibernalHerbsMod.asResource(string), enchantment);
    }
}
