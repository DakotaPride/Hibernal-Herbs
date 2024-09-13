package net.dakotapride.hibernalHerbs.common.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.recipe.EmiCookingRecipe;
import dev.emi.emi.runtime.EmiReloadLog;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.RecipeInit;
import net.dakotapride.hibernalHerbs.common.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

@EmiEntrypoint
public class HibernalHerbsEmiPlugin implements EmiPlugin {
    public static final ResourceLocation SPRITE_SHEET = HibernalHerbsCommonMod.asResource("textures/gui/recipe_viewer/emi.png");
    public static final EmiStack MYSTICAL_CAMPFIRE = EmiStack.of(BlockInit.MYSTICAL_CAMPFIRE.get());
    public static final EmiRecipeCategory MYSTICAL_CAMPFIRE_CONVERSION =
            new EmiRecipeCategory(HibernalHerbsCommonMod.asResource("mystical_campfire_conversion"),
                    MYSTICAL_CAMPFIRE, new EmiTexture(SPRITE_SHEET, 0, 0, 16, 16));

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(MYSTICAL_CAMPFIRE_CONVERSION);

        // Add all the workstations your category uses
        registry.addWorkstation(MYSTICAL_CAMPFIRE_CONVERSION, MYSTICAL_CAMPFIRE);

        for (MysticalCampfireCookingRecipe recipe : getRecipes(registry, RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE.get())) {
            addRecipeSafe(registry, () -> new EmiCookingRecipe(recipe, MYSTICAL_CAMPFIRE_CONVERSION, 1, true), recipe);
        }
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().getAllRecipesFor(type).stream().map(RecipeHolder::value)::iterator;
    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing vanilla recipe " + EmiPort.getId(recipe));
            EmiReloadLog.error(e);
        }
    }
}
