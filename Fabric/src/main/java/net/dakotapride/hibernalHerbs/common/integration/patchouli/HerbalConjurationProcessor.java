package net.dakotapride.hibernalHerbs.common.integration.patchouli;

import net.dakotapride.hibernalHerbs.common.init.RecipeInit;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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
        this.recipe = PatchouliUtils.getRecipe(HerbalConjurationRecipe.class, RecipeInit.HERBAL_CONJURATION_TYPE, vars.get("recipe").asString());
    }

    @Nonnull
    @Override
    public IVariable process(@Nonnull String key) {
        if (recipe == null) return IVariable.empty();
        return switch (key) {
            case "output" -> IVariable.from(this.recipe.getOutput());
            case "ingredient0" -> IVariable.from(this.getInput(0).getMatchingStacks());
            case "ingredient1" -> IVariable.from(this.getInput(1).getMatchingStacks());
            case "ingredient2" -> IVariable.from(this.getInput(2).getMatchingStacks());
            case "ingredient3" -> IVariable.from(this.getInput(3).getMatchingStacks());
            case "ingredient4" -> IVariable.from(this.getInput(4).getMatchingStacks());
            case "ingredient5" -> IVariable.from(this.getInput(5).getMatchingStacks());
            case "header" -> IVariable.from(Text.translatable("text.hibernalherbs.herbal_conjuration"));
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
