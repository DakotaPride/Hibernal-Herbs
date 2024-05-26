package net.dakotapride.hibernalHerbs.common.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@JeiPlugin
public class JEIHibernalHerbsPlugin implements IModPlugin {
    public static RecipeType<HerbalConjurationRecipe> HERBAL_CONJURATION_TYPE =
            RecipeType.create(MOD_ID, "herbal_conjuration", HerbalConjurationRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(MOD_ID, "jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                HerbalConjurationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.CONJURATION_ALTAR.get()), HERBAL_CONJURATION_TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<HerbalConjurationRecipe> herbalConjurationRecipes = rm.getAllRecipesFor(HerbalConjurationRecipe.Type.INSTANCE);
        registration.addRecipes(HERBAL_CONJURATION_TYPE, herbalConjurationRecipes);
    }
}
