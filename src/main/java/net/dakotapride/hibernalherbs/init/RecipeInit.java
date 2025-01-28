package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeInit {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, HibernalHerbsMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, HibernalHerbsMod.MOD_ID);
    // WIP
    public static DeferredHolder<RecipeType<?>, RecipeType<MysticalCampfireCookingRecipe>> MYSTICAL_CAMPFIRE_CONVERSION_TYPE = register("mystical_campfire_conversion",
            new RecipeType<>() {
        @Override
        public String toString() {
            return "mystical_campfire_conversion";
        }
    });

    public static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MysticalCampfireCookingRecipe>> MYSTICAL_CAMPFIRE_CONVERSION_SERIALIZER = register("mystical_campfire_conversion",
            new SimpleCookingSerializer<>(MysticalCampfireCookingRecipe::new, 100));

    // Collective Registration
    public static void register(IEventBus bus) {
        RECIPE_TYPES.register(bus);
        RECIPE_SERIALIZERS.register(bus);
    }

    public static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> register(String name, RecipeType<T> recipe) {
        return RECIPE_TYPES.register(name, () -> recipe);
        //return Registry.register(BuiltInRegistries.RECIPE_TYPE, HibernalHerbsMod.asResource(name), recipe);
    }

    public static <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> register(String name, RecipeSerializer<T> recipeSerializer) {
        return RECIPE_SERIALIZERS.register(name, () -> recipeSerializer);
        //return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, HibernalHerbsMod.asResource(name), recipeSerializer);
    }

}
