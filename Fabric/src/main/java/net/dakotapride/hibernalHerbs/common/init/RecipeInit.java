package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class RecipeInit {
    public static void init() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, HerbalConjurationRecipe.Serializer.ID),
                HerbalConjurationRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, HerbalConjurationRecipe.Type.ID),
                HerbalConjurationRecipe.Type.INSTANCE);
    }
}