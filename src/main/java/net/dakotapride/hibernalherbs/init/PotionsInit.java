package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class PotionsInit {
    //public static final Holder<Potion> MYSTERIOUS = register("mysterious", new Potion());
    public static final Holder<Potion> FROST_RESISTANCE = register("frost_resistance",
            new Potion("frost_resistance", new MobEffectInstance(StatusEffectInit.FROST_RESISTANCE.value(), 3600)));

    public static final Holder<Potion> SWARMING = register("swarming",
            new Potion("swarming", new MobEffectInstance(StatusEffectInit.SWARMING.value(), 3600)));
    public static final Holder<Potion> INSTABILITY = register("instability",
            new Potion("instability", new MobEffectInstance(StatusEffectInit.INSTABILITY.value(), 3600)));
    public static final Holder<Potion> SHRIEKING = register("shrieking",
            new Potion("shrieking", new MobEffectInstance(StatusEffectInit.SHRIEKING.value(), 3600)));

    private static Holder<Potion> register(String string, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, HibernalHerbsMod.asResource(string), potion);
    }

    public static void register() {
        potionRecipes();
    }

    private static void potionRecipes() {
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(HerbTypes.SAGE.getDriedHerb()), PotionsInit.FROST_RESISTANCE.value());

        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.BEE_NEST), PotionsInit.SWARMING.value());
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.END_ROD), PotionsInit.INSTABILITY.value());
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.SCULK_SHRIEKER), PotionsInit.SHRIEKING.value());

        FabricBrewingRecipeRegistry.registerItemRecipe((PotionItem) Items.POTION, Ingredient.of(ItemInit.MYSTICAL_ASHES), (PotionItem) ItemInit.ENIGMATIC_POTION);
        FabricBrewingRecipeRegistry.registerItemRecipe((PotionItem) Items.POTION, Ingredient.of(Items.CLOCK), (PotionItem) ItemInit.SOLAR_POTION);
        FabricBrewingRecipeRegistry.registerItemRecipe((PotionItem) Items.POTION, Ingredient.of(Items.SCULK), (PotionItem) ItemInit.LUNAR_POTION);
    }

}
