package net.dakotapride.hibernalherbs.registry;

import net.dakotapride.hibernalherbs.recipe.HerbalConjurationRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class RecipeRegistry {

    public static RecipeSerializer<HerbalConjurationRecipe> HERBAL_CONJURATION_SERIALIZER;

    public static RecipeType<HerbalConjurationRecipe> HERBAL_CONJURATION_TYPE;

    public static void register() {
        HERBAL_CONJURATION_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER,
                new Identifier(MOD_ID, HerbalConjurationRecipe.Serializer.ID), HerbalConjurationRecipe.Serializer.INSTANCE);
        HERBAL_CONJURATION_TYPE = Registry.register(Registries.RECIPE_TYPE,
                new Identifier(MOD_ID, HerbalConjurationRecipe.Type.ID), HerbalConjurationRecipe.Type.INSTANCE);
    }
}
