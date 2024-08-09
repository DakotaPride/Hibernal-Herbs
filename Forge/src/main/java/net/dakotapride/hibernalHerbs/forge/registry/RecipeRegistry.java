package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.recipe.HerbalConjurationRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class RecipeRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MOD_ID);

    public static final RegistryObject<RecipeType<HerbalConjurationRecipe>> HERBAL_CONJURATION_TYPE =
            TYPES.register(HerbalConjurationRecipe.Type.ID, () -> HerbalConjurationRecipe.Type.INSTANCE);

    public static final RegistryObject<RecipeSerializer<HerbalConjurationRecipe>> HERBAL_CONJURATION_SERIALIZER =
            SERIALIZERS.register(HerbalConjurationRecipe.Type.ID, () -> HerbalConjurationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
