package net.dakotapride.hibernalherbs.init.enum_registry;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmourTiers implements StringRepresentable, ArmorMaterial {
    ARKONIUM("arkonium", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Archaeology.Metals.ARKONIUM.getIngotItem())),
    SYRUM("syrum", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Archaeology.Metals.SYRUM.getIngotItem()));
//    public static final Holder<ArmorMaterial> DALUM = register("dalum", Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
//        enumMap.put(ArmorItem.Type.BOOTS, 3);
//        enumMap.put(ArmorItem.Type.LEGGINGS, 6);
//        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
//        enumMap.put(ArmorItem.Type.HELMET, 3);
//        enumMap.put(ArmorItem.Type.BODY, 6);
//    }), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Archaeology.Metals.DALUM.getIngotItem()));

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS, 13);
        enumMap.put(ArmorItem.Type.LEGGINGS, 15);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 16);
        enumMap.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmourTiers(String string2, int j, EnumMap<ArmorItem.Type, Integer> enumMap, int k,
                   SoundEvent soundEvent, float f, float g, Supplier<Ingredient> supplier) {
        this.name = string2;
        this.durabilityMultiplier = j;
        this.protectionFunctionForType = enumMap;
        this.enchantmentValue = k;
        this.sound = soundEvent;
        this.toughness = f;
        this.knockbackResistance = g;
        this.repairIngredient = new LazyLoadedValue<>(supplier);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
