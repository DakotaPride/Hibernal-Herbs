package net.dakotapride.hibernalHerbs.common.integration.patchouli;

import net.dakotapride.hibernalHerbs.common.init.RecipeInit;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliAPIImpl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class HerbalConjurationProcessor implements IComponentProcessor {
    @Nullable
    private HerbalConjurationRecipe recipe;

    @Override
    public void setup(World level, IVariableProvider vars) {
        this.recipe = PatchouliUtils.getRecipe(HerbalConjurationRecipe.class, RecipeInit.HERBAL_CONJURATION_TYPE, vars.get("recipe").asString());
    }

    @Nonnull
    @Override
    public IVariable process(World level, @Nonnull String key) {
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
