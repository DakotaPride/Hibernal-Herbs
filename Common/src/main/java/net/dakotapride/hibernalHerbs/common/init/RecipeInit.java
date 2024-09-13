package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;

public class RecipeInit {
    public static Registrar<RecipeType<?>> recipes = HibernalHerbsCommonMod.MANAGER.get().get(Registries.RECIPE_TYPE);
    public static Registrar<RecipeSerializer<?>> recipeSerializers = HibernalHerbsCommonMod.MANAGER.get().get(Registries.RECIPE_SERIALIZER);

    // WIP
    public static RegistrySupplier<RecipeType<MysticalCampfireCookingRecipe>> MYSTICAL_CAMPFIRE_CONVERSION_TYPE = register("mystical_campfire_conversion",
            new RecipeType<>() {
        @Override
        public String toString() {
            return "mystical_campfire_conversion";
        }
    });

    public static RegistrySupplier<RecipeSerializer<MysticalCampfireCookingRecipe>> MYSTICAL_CAMPFIRE_CONVERSION_SERIALIZER = register("mystical_campfire_conversion",
            new SimpleCookingSerializer<>(MysticalCampfireCookingRecipe::new, 100));

    // Collective Registration
    public static void register() {}

    public static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> register(String name, RecipeType<T> recipe) {
        return recipes.register(HibernalHerbsCommonMod.asResource(name), () -> recipe);
    }

    public static <T extends Recipe<?>> RegistrySupplier<RecipeSerializer<T>> register(String name, RecipeSerializer<T> recipeSerializer) {
        return recipeSerializers.register(HibernalHerbsCommonMod.asResource(name), () -> recipeSerializer);
    }

}
