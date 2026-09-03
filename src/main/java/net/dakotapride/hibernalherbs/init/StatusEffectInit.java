package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

@SuppressWarnings({"unused"})
public class StatusEffectInit {
    //public static MobEffect SANGUINE = register("sanguine", new SanguineStatusEffect());

    public static final Holder<MobEffect> SANGUINE = register("sanguine", new SiphonHealthStatusEffect(0.76F, 0xE05974)
            .addAttributeModifier(Attributes.MAX_HEALTH, "bfcd00a2-5970-4f0a-aeb3-f153086a6966", -4.0D, AttributeModifier.Operation.ADDITION));
    public static final Holder<MobEffect> LETHARGY = register("lethargy", new ApplyEffectOnAttackStatusEffect(MobEffects.MOVEMENT_SLOWDOWN, 0x92C8D1)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "7aed2452-6b87-45cc-ad52-eb50e6b1f56f", -0.15F, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final Holder<MobEffect> BARBARIC = register("barbaric", new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xD69489)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "168b2f7a-2a71-44b7-b441-549aa7c77707", 0.05F, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, "934cebbe-8fff-483a-ba1f-ea7c0681431e", 0.15F, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final Holder<MobEffect> DEVOTION = register("devotion", new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xC095D6)
            .addAttributeModifier(Attributes.MAX_HEALTH, "dd456724-b004-4b26-b55b-d5ccdfe46bb2", 4.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final Holder<MobEffect> RAPACITY = register("rapacity", new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xAEDB7A));
    public static final Holder<MobEffect> ESURIENT = register("esurient", new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xAEDB7A)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6ffa9b24-91ba-4660-a892-4e0d31b947e2", -0.15F, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final Holder<MobEffect> MIMICRY = register("mimicry", new MimicryStatusEffect());

    public static final Holder<MobEffect> FROST_RESISTANCE = register("frost_resistance", new BasicStatusEffect(MobEffectCategory.BENEFICIAL, 0xAEC9E5));

    public static final Holder<MobEffect> SWARMING = register("swarming", new SwarmingStatusEffect(MobEffectCategory.HARMFUL,
            0xEDC343, 0.40F, randomSource -> Mth.randomBetweenInclusive(randomSource, 1, 2)));
    public static final Holder<MobEffect> INSTABILITY = register("instability", new InstabilityStatusEffect(MobEffectCategory.HARMFUL,
            0xDB88F7));
    public static final Holder<MobEffect> SHRIEKING = register("shrieking", new ShriekingStatusEffect(MobEffectCategory.HARMFUL,
            0x111B21, 0.01F));

    // Collective Registration
    public static void register() {}

    private static Holder<MobEffect> register(String string, MobEffect mobEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, HibernalHerbsMod.asResource(string), mobEffect);
    }

//    public static MobEffect register(String name, MobEffect item) {
//        return Registry.register(BuiltInRegistries.MOB_EFFECT, HibernalHerbsMod.asResource(name), item);
//    }
}
