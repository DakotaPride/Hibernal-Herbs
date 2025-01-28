package net.dakotapride.hibernalherbs.item;

import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AttributeArmourItem extends ArmorItem {
    private final Supplier<ItemAttributeModifiers> modifiers;
    Holder<Attribute> attribute;
    float value;

    public AttributeArmourItem(Holder<ArmorMaterial> holder, Type type, Holder<Attribute> attribute, float value, Properties properties) {
        super(holder, type, properties);
        this.attribute = attribute;
        this.value = value;
        this.modifiers = Suppliers.memoize(() -> {
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
            int i = holder.value().getDefense(type);
            float f = holder.value().toughness();
            builder.add(Attributes.ARMOR, new AttributeModifier(resourceLocation, i, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourceLocation, f, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            float g = holder.value().knockbackResistance();
            if (g > 0.0F) {
                builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourceLocation, g, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            }
            builder.add(attribute, new AttributeModifier(resourceLocation, value, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);

            return builder.build();
        });
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.modifiers.get();
    }
}
