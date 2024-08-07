package net.dakotapride.hibernalHerbs.common.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HerbalConjurationRecipeCategory implements IRecipeCategory<HerbalConjurationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(MOD_ID, "herbal_conjuration");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(MOD_ID, "textures/gui/recipe_viewer/testing.png");

    private final IDrawable background;
    private final IDrawable icon;

    public HerbalConjurationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 84);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.CONJURATION_ALTAR.get()));
    }


    @Override
    public RecipeType<HerbalConjurationRecipe> getRecipeType() {
        return JEIHibernalHerbsPlugin.HERBAL_CONJURATION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("text.hibernalherbs.herbal_conjuration");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, HerbalConjurationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 46, 17).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 68, 13).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 90, 17).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 46, 39).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 68, 43).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 90, 39).addIngredients(recipe.getIngredients().get(4));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 57).addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }
}