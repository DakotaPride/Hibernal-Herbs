package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class PotionsInit {
    public static final Holder<Potion> MYSTERIOUS = register("mysterious", new Potion());
    public static final Holder<Potion> FROST_RESISTANCE = register("frost_resistance",
            new Potion("frost_resistance", new MobEffectInstance(StatusEffectInit.FROST_RESISTANCE, 3600)));

    private static Holder<Potion> register(String string, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, HibernalHerbsMod.asResource(string), potion);
    }

    public static void register() {}
}
