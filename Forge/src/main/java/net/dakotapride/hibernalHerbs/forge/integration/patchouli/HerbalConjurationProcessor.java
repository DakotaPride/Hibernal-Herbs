package net.dakotapride.hibernalherbs.forge.integration.patchouli;

import net.dakotapride.hibernalherbs.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalherbs.forge.registry.RecipeRegistry;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

@SuppressWarnings("ConstantConditions")
public class HerbalConjurationProcessor implements IComponentProcessor {
    @Nullable
    private HerbalConjurationRecipe recipe;

    @Override
    public void setup(World level, IVariableProvider vars) {
        this.recipe = PatchouliUtils.getRecipe(HerbalConjurationRecipe.class, RecipeRegistry.HERBAL_CONJURATION_TYPE.get(), vars.get("recipe").asString());
    }

    @Override
    public IVariable process(World level, String key) {
        if (recipe == null) return IVariable.empty();

        if (key.equals("output")) {
            return IVariable.from(this.recipe.getOutput(DynamicRegistryManager.EMPTY));
        } else if (key.equals("ingredient0")) {
            return IVariable.from(this.getInput(0).getMatchingStacks());
        } else if (key.equals("ingredient1")) {
            return IVariable.from(this.getInput(1).getMatchingStacks());
        } else if (key.equals("ingredient2")) {
            return IVariable.from(this.getInput(2).getMatchingStacks());
        } else if (key.equals("ingredient3")) {
            return IVariable.from(this.getInput(3).getMatchingStacks());
        } else if (key.equals("ingredient4")) {
            return IVariable.from(this.getInput(4).getMatchingStacks());
        } else if (key.equals("ingredient5")) {
            return IVariable.from(this.getInput(5).getMatchingStacks());
        } else if (key.equals("header")) {
            return IVariable.from(Text.translatable("text.hibernalherbs.herbal_conjuration"));
        }

        return null;
    }

    private Ingredient getInput(int idx) {
        if (this.recipe == null) return Ingredient.EMPTY;
        List<Ingredient> list = this.recipe.getIngredients();
        if (idx < 0 || idx >= list.size()) return Ingredient.EMPTY;
        return list.get(idx);
    }
}
