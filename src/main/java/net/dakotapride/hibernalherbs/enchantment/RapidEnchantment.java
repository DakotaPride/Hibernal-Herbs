package net.dakotapride.hibernalherbs.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class RapidEnchantment extends Enchantment {
    public RapidEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
