package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class PotionsInit {
    //public static final Holder<Potion> MYSTERIOUS = register("mysterious", new Potion());
    public static final Holder<Potion> FROST_RESISTANCE = register("frost_resistance",
            new Potion("frost_resistance", new MobEffectInstance(StatusEffectInit.FROST_RESISTANCE, 3600)));

    public static final Holder<Potion> SWARMING = register("swarming",
            new Potion("swarming", new MobEffectInstance(StatusEffectInit.SWARMING, 3600)));
    public static final Holder<Potion> INSTABILITY = register("instability",
            new Potion("instability", new MobEffectInstance(StatusEffectInit.INSTABILITY, 3600)));
    public static final Holder<Potion> SHRIEKING = register("shrieking",
            new Potion("shrieking", new MobEffectInstance(StatusEffectInit.SHRIEKING, 3600)));

    private static Holder<Potion> register(String string, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, HibernalHerbsMod.asResource(string), potion);
    }

    public static void register() {
        potionRecipes();
    }

    private static void potionRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {

            builder.addContainer(ItemInit.ENIGMATIC_POTION.asItem());
            builder.addContainer(ItemInit.SOLAR_POTION.asItem());
            builder.addContainer(ItemInit.LUNAR_POTION.asItem());

            builder.addMix(Potions.AWKWARD, HerbTypes.SAGE.getDriedHerb(), PotionsInit.FROST_RESISTANCE);

            builder.addMix(Potions.AWKWARD, Items.BEE_NEST, PotionsInit.SWARMING);
            builder.addMix(Potions.AWKWARD, Items.END_ROD, PotionsInit.INSTABILITY);
            builder.addMix(Potions.AWKWARD, Items.SCULK_SHRIEKER, PotionsInit.SHRIEKING);

            builder.addContainerRecipe(Items.POTION, ItemInit.MYSTICAL_ASHES, ItemInit.ENIGMATIC_POTION);
            builder.addContainerRecipe(Items.POTION, Items.CLOCK, ItemInit.SOLAR_POTION);
            builder.addContainerRecipe(ItemInit.SOLAR_POTION, Items.SCULK, ItemInit.LUNAR_POTION);

            //builder.build();
        });
    }

}
