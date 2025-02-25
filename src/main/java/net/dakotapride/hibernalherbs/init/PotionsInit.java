package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PotionsInit {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, HibernalHerbsMod.MOD_ID);

    //public static final Holder<Potion> MYSTERIOUS = register("mysterious", new Potion());
    public static final DeferredHolder<Potion, Potion> FROST_RESISTANCE = register("frost_resistance",
            () -> new Potion("frost_resistance", new MobEffectInstance(StatusEffectInit.FROST_RESISTANCE, 3600)));

    public static final DeferredHolder<Potion, Potion> SWARMING = register("swarming",
            () -> new Potion("swarming", new MobEffectInstance(StatusEffectInit.SWARMING, 3600)));
    public static final DeferredHolder<Potion, Potion> INSTABILITY = register("instability",
            () -> new Potion("instability", new MobEffectInstance(StatusEffectInit.INSTABILITY, 3600)));
    public static final DeferredHolder<Potion, Potion> SHRIEKING = register("shrieking",
            () -> new Potion("shrieking", new MobEffectInstance(StatusEffectInit.SHRIEKING, 3600)));

    private static DeferredHolder<Potion, Potion> register(String string, Supplier<Potion> potion) {
        return POTIONS.register(string, potion);
    }

    public static void register(IEventBus bus) {
        //potionRecipes();
        POTIONS.register(bus);
    }

    //private static void potionRecipes() {}

}