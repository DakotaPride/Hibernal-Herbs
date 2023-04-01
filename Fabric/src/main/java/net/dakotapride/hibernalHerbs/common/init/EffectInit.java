package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.effect.HerbalCurseEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class EffectInit {

    public static StatusEffect SCENTED_HERBAL_CURSE = new HerbalCurseEffect(StatusEffectCategory.BENEFICIAL, 0x4A8F28);
    public static StatusEffect BITTER_HERBAL_CURSE = new HerbalCurseEffect(StatusEffectCategory.HARMFUL, 0x4A8F28);
    public static StatusEffect SOUR_HERBAL_CURSE = new HerbalCurseEffect(StatusEffectCategory.HARMFUL, 0x4A8F28);
    public static StatusEffect WARDED_HERBAL_CURSE = new HerbalCurseEffect(StatusEffectCategory.NEUTRAL, 0x4A8F28)
            .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "51884d70-fae3-4061-8731-9327b39287b8",
                    2, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "2ee98b9b-7180-46ac-97ce-d8f7307bffb4",
                    -2, EntityAttributeModifier.Operation.ADDITION);


    public static void init(BiConsumer<StatusEffect, Identifier> biConsumer) {
        biConsumer.accept(SCENTED_HERBAL_CURSE, new Identifier(MOD_ID, "scented_curse"));
        biConsumer.accept(BITTER_HERBAL_CURSE, new Identifier(MOD_ID, "bitter_curse"));
        biConsumer.accept(SOUR_HERBAL_CURSE, new Identifier(MOD_ID, "sour_curse"));
        biConsumer.accept(WARDED_HERBAL_CURSE, new Identifier(MOD_ID, "warded_curse"));
    }

}
