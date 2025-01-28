package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;

public class RecipeInit {
    // WIP
    public static RecipeType<MysticalCampfireCookingRecipe> MYSTICAL_CAMPFIRE_CONVERSION_TYPE = register("mystical_campfire_conversion",
            new RecipeType<>() {
        @Override
        public String toString() {
            return "mystical_campfire_conversion";
        }
    });

    public static RecipeSerializer<MysticalCampfireCookingRecipe> MYSTICAL_CAMPFIRE_CONVERSION_SERIALIZER = register("mystical_campfire_conversion",
            new SimpleCookingSerializer<>(MysticalCampfireCookingRecipe::new, 100));

    // Collective Registration
    public static void register() {}

    public static <T extends Recipe<?>> RecipeType<T> register(String name, RecipeType<T> recipe) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, HibernalHerbsMod.asResource(name), recipe);
    }

    public static <T extends Recipe<?>> RecipeSerializer<T> register(String name, RecipeSerializer<T> recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, HibernalHerbsMod.asResource(name), recipeSerializer);
    }

}
