package net.dakotapride.hibernalherbs.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class AttributeArmourItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> modifiers;
    Attribute attribute;
    float value;

    public AttributeArmourItem(ArmorMaterial material, Type type, Attribute attribute, float value, Properties properties) {
        super(material, type, properties);
        this.attribute = attribute;
        this.value = value;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        int i = material.getDefenseForType(type);
        float f = material.getToughness();
        builder.put(Attributes.ARMOR, new AttributeModifier("armor." + type.getName(), i, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier("armor." + type.getName(), f, AttributeModifier.Operation.ADDITION));
        float g = material.getKnockbackResistance();
        if (g > 0.0F) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier("armor." + type.getName(), g, AttributeModifier.Operation.ADDITION));
        }
        builder.put(attribute, new AttributeModifier("armor." + type.getName(), value, AttributeModifier.Operation.ADDITION));
        this.modifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        return this.modifiers;
    }
}
