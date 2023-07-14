package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class RecipeInit {

    public static RecipeSerializer<HerbalConjurationRecipe> HERBAL_CONJURATION_SERIALIZER;

    public static RecipeType<HerbalConjurationRecipe> HERBAL_CONJURATION_TYPE;

    public static void init() {
        HERBAL_CONJURATION_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER,
                new Identifier(MOD_ID, HerbalConjurationRecipe.Serializer.ID), HerbalConjurationRecipe.Serializer.INSTANCE);
        HERBAL_CONJURATION_TYPE = Registry.register(Registries.RECIPE_TYPE,
                new Identifier(MOD_ID, HerbalConjurationRecipe.Type.ID), HerbalConjurationRecipe.Type.INSTANCE);
    }
}
