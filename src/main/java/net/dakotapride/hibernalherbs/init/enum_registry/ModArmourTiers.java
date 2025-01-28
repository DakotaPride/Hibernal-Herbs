package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmourTiers {
    public static final Holder<ArmorMaterial> ARKONIUM = register("arkonium", Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Archaeology.Metals.ARKONIUM.getIngotItem()));
    public static final Holder<ArmorMaterial> SYRUM = register("syrum", Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 5);
    }), 9, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(Archaeology.Metals.SYRUM.getIngotItem()));

    private static Holder<ArmorMaterial> register(
            String string, EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> holder, float f, float g, Supplier<Ingredient> supplier
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(HibernalHerbsMod.asResource(string)));
        return register(string, enumMap, i, holder, f, g, supplier, list);
    }

    private static Holder<ArmorMaterial> register(
            String string,
            EnumMap<ArmorItem.Type, Integer> enumMap,
            int i,
            Holder<SoundEvent> holder,
            float f,
            float g,
            Supplier<Ingredient> supplier,
            List<ArmorMaterial.Layer> list
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap2 = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap2.put(type, enumMap.get(type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL, HibernalHerbsMod.asResource(string), new ArmorMaterial(enumMap2, i, holder, supplier, list, f, g)
        );
    }
}
