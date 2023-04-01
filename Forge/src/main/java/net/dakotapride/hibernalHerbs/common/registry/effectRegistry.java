package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.effect.HerbalCurseEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class effectRegistry {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Constants.MOD_ID);

    public static final RegistryObject<MobEffect> SCENTED_HERBAL_CURSE = MOB_EFFECTS.register("scented_curse",
            () -> new HerbalCurseEffect(MobEffectCategory.BENEFICIAL, 0x4A8F28));
    public static final RegistryObject<MobEffect> BITTER_HERBAL_CURSE = MOB_EFFECTS.register("bitter_curse",
            () -> new HerbalCurseEffect(MobEffectCategory.HARMFUL, 0x4A9F28));
    public static final RegistryObject<MobEffect> SOUR_HERBAL_CURSE = MOB_EFFECTS.register("sour_curse",
            () -> new HerbalCurseEffect(MobEffectCategory.HARMFUL, 0x4A9F28));
    public static final RegistryObject<MobEffect> WARDED_HERBAL_CURSE = MOB_EFFECTS.register("warded_curse",
            () -> new HerbalCurseEffect(MobEffectCategory.NEUTRAL, 0x4A9F28)
                    .addAttributeModifier(Attributes.ARMOR, "51884d70-fae3-4061-8731-9327b39287b8",
                            2, AttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(Attributes.MAX_HEALTH, "2ee98b9b-7180-46ac-97ce-d8f7307bffb4",
                            -2, AttributeModifier.Operation.ADDITION));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
