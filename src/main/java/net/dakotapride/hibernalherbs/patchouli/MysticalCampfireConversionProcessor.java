package net.dakotapride.hibernalherbs.patchouli;

import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

@SuppressWarnings("ConstantConditions")
public class MysticalCampfireConversionProcessor implements IComponentProcessor {
    @Nullable
    private MysticalCampfireCookingRecipe recipe;

    @Override
    public void setup(Level level, IVariableProvider vars) {
        String recipeId = vars.get("recipe", level.registryAccess()).asString();
        RecipeManager manager = level.getRecipeManager();
        this.recipe = (MysticalCampfireCookingRecipe) manager.byKey(ResourceLocation.tryParse(recipeId)).orElseThrow(IllegalArgumentException::new).value();
        //this.recipe = PatchouliUtils.getRecipe(MysticalCampfireCookingRecipe.class, RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE, vars.get("recipe").asString());
    }

    @Override
    public @NotNull IVariable process(Level level, String key) {
        if (recipe == null) return IVariable.empty();

        return switch (key) {
            case "output" -> IVariable.from(this.recipe.getResultItem(level.registryAccess()), level.registryAccess());
            case "input" -> IVariable.from(this.recipe.getIngredients().getFirst(), level.registryAccess());
            //case "time" -> IVariable.from(this.recipe.getCookingTime(), RegistryAccess.EMPTY);
            //case "experience" -> IVariable.from(this.recipe.getExperience(), RegistryAccess.EMPTY);
            case "header" -> IVariable.from(this.recipe.getResultItem(level.registryAccess()).getHoverName(), level.registryAccess());
            default -> null;
        };

    }
}
