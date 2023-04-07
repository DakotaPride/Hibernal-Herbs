package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponentInit implements FoodComponentList {

    public static final FoodComponent POUNDED_HERB = (new FoodComponent.Builder()).snack().hunger(4).saturationModifier(0.3F).build();
    public static final FoodComponent DRIED_HERB = (new FoodComponent.Builder()).snack().hunger(8).saturationModifier(0.5F).build();

    public static final FoodComponent ARTIFICIAL_HERB = (new FoodComponent.Builder()).snack().hunger(8).saturationModifier(0.6F).build();

    public static final FoodComponent REGENERATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent VIRULENT_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, healthDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent SEDATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent HINDERING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, miningSpeedDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent DASHING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, miningSpeedDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent ACCELERATION_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent INCINERATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F).build();
    public static final FoodComponent DECAYING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, healthDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent OBSERVING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, visionDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent DIMINISHED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent SHADED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration, baseMultiplier), baseChance).build();

    // Resource Dependant (Blend Components) Herbs

    public static final FoodComponent CONFLICTING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration, baseMultiplier), baseChance).build();
    public static final FoodComponent ALTERNATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration + 120, baseMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration + 100, baseMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration + 80, baseMultiplier), baseChance).build();

    // Smoked
    public static final FoodComponent SMOKED_REGENERATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_VIRULENT_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, smokedHealthDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_SEDATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_HINDERING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, smokedMiningSpeedDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_DASHING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, smokedMiningSpeedDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_ACCELERATION_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_INCINERATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F).build();
    public static final FoodComponent SMOKED_DECAYING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, smokedHealthDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_OBSERVING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_DIMINISHED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_SHADED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier), baseChance).build();

    // Resource Dependant (Smoked Blend Components) Herbs

    public static final FoodComponent SMOKED_CONFLICTING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration, smokedMultiplier), baseChance).build();
    public static final FoodComponent SMOKED_ALTERNATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration + 120, smokedMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration + 100, smokedMultiplier), baseChance)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration + 80, smokedMultiplier), baseChance).build();

}
