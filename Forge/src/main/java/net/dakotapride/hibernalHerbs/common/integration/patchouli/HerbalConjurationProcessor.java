package net.dakotapride.hibernalHerbs.common.integration.patchouli;

import net.dakotapride.hibernalHerbs.common.integration.patchouli.util.PatchouliUtils;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.recipe.HibernalRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class HerbalConjurationProcessor implements IComponentProcessor {
    @Nullable
    private HerbalConjurationRecipe recipe;

    @Override
    public void setup(IVariableProvider vars) {
        this.recipe = PatchouliUtils.getRecipe(HerbalConjurationRecipe.class, HibernalRecipes.HERBAL_CONJURATION_TYPE.get(), vars.get("recipe").asString());
    }

    @Nonnull
    @Override
    public IVariable process(@Nonnull String key) {
        if (recipe == null) return IVariable.empty();
        return switch (key) {
            case "output" -> IVariable.from(this.recipe.output);
            case "ingredient0" -> IVariable.from(this.getInput(0).getItems());
            case "ingredient1" -> IVariable.from(this.getInput(1).getItems());
            case "ingredient2" -> IVariable.from(this.getInput(2).getItems());
            case "ingredient3" -> IVariable.from(this.getInput(3).getItems());
            case "ingredient4" -> IVariable.from(this.getInput(4).getItems());
            case "ingredient5" -> IVariable.from(this.getInput(5).getItems());
            default -> IVariable.empty();
        };
    }

    private Ingredient getInput(int idx) {
        if (this.recipe == null) return Ingredient.EMPTY;
        List<Ingredient> list = this.recipe.getIngredients();
        if (idx < 0 || idx >= list.size()) return Ingredient.EMPTY;
        return list.get(idx);
    }
}
