package net.dakotapride.hibernalherbs.recipe;

import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.RecipeInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class MysticalCampfireCookingRecipe extends AbstractCookingRecipe {
    public MysticalCampfireCookingRecipe(ResourceLocation location, String string, CookingBookCategory cookingBookCategory, Ingredient ingredient, ItemStack itemStack, float f, int i) {
        super(RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE, location, string, cookingBookCategory, ingredient, itemStack, f, i);
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.MYSTICAL_CAMPFIRE);
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_SERIALIZER;
    }

}
