package net.dakotapride.hibernalherbs.init.enum_registry;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ModTiers implements Tier {
    ARKONIUM(2, 1561, 6.0F, 2.0F, 14, () -> Ingredient.of(Archaeology.Metals.ARKONIUM.getIngotItem())),
    SYRUM(2, 1561, 12.0F, 0.0F, 22, () -> Ingredient.of(Archaeology.Metals.SYRUM.getIngotItem())),;
    //DALUM(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2045, 12.0F, 2.0F, 18, () -> Ingredient.of(Archaeology.Metals.DALUM.getIngotItem())),;

    private final int miningLevel;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModTiers(final int level, final int j, final float f, final float g, final int k, final Supplier<Ingredient> supplier) {
        this.miningLevel = level;
        this.uses = j;
        this.speed = f;
        this.damage = g;
        this.enchantmentValue = k;
        this.repairIngredient = Suppliers.memoize(supplier::get);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
