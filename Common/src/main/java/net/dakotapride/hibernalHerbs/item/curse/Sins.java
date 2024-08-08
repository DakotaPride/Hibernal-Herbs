package net.dakotapride.hibernalherbs.item.curse;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.minecraft.entity.attribute.EntityAttributeModifier;

import java.util.UUID;

public enum Sins {
    WRATH("vexation", "wrath"),
    PRIDE("pique", "pride"),
    LUST("salacious", "lust"),
    GLUTTONY("gourmandizing", "gluttony"),
    GREED("avarice", "greed"),
    ENVY("spiteful", "envy"),
    SLOTH("apathy", "sloth");

    final String alt_name;
    final String name;

    Sins(String alt, String name) {
        this.alt_name = alt;
        this.name = name;
    }

    public String getAltName() {
        return alt_name;
    }

    public String getName() {
        return name;
    }

    public static EntityAttributeModifier createHealthAttribute(UUID uuid, String name0, float value, EntityAttributeModifier.Operation operation) {
        return new EntityAttributeModifier(uuid, (HibernalHerbsCommon.MOD_ID + ":" + name0 + "_health"), value, operation);
    }
    public static EntityAttributeModifier createDamageAttribute(UUID uuid, String name0, float value, EntityAttributeModifier.Operation operation) {
        return new EntityAttributeModifier(uuid, (HibernalHerbsCommon.MOD_ID + ":" + name0 + "_damage"), value, operation);
    }
    public static EntityAttributeModifier createMovementAttribute(UUID uuid, String name0, float value, EntityAttributeModifier.Operation operation) {
        return new EntityAttributeModifier(uuid, (HibernalHerbsCommon.MOD_ID + ":" + name0 + "_movement"), value, operation);
    }
}
