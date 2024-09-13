package net.dakotapride.hibernalHerbs.common.recipe;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.RecipeInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class MysticalCampfireCookingRecipe extends AbstractCookingRecipe {
    public MysticalCampfireCookingRecipe(String string, CookingBookCategory cookingBookCategory, Ingredient ingredient, ItemStack itemStack, float f, int i) {
        super(RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE.get(), string, cookingBookCategory, ingredient, itemStack, f, i);
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.MYSTICAL_CAMPFIRE.get());
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_SERIALIZER.get();
    }
}
