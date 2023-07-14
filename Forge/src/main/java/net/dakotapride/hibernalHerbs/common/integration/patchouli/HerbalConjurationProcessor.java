package net.dakotapride.hibernalHerbs.common.integration.patchouli;

import net.dakotapride.hibernalHerbs.common.integration.patchouli.util.PatchouliUtils;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.recipe.HibernalRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
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
    public void setup(Level level, IVariableProvider vars) {
        this.recipe = PatchouliUtils.getRecipe(HerbalConjurationRecipe.class, HibernalRecipes.HERBAL_CONJURATION_TYPE.get(), vars.get("recipe").asString());
    }

    @Nonnull
    @Override
    public IVariable process(Level level, @Nonnull String key) {
        if (recipe == null) return IVariable.empty();

        if (key.equals("output")) {
            return IVariable.from(this.recipe.output);
        } else if (key.equals("ingredient0")) {
            return IVariable.from(this.getInput(0).getItems());
        } else if (key.equals("ingredient1")) {
            return IVariable.from(this.getInput(1).getItems());
        } else if (key.equals("ingredient2")) {
            return IVariable.from(this.getInput(2).getItems());
        } else if (key.equals("ingredient3")) {
            return IVariable.from(this.getInput(3).getItems());
        } else if (key.equals("ingredient4")) {
            return IVariable.from(this.getInput(4).getItems());
        } else if (key.equals("ingredient5")) {
            return IVariable.from(this.getInput(5).getItems());
        } else if (key.equals("header")) {
            return IVariable.from(Component.translatable("text.hibernalherbs.herbal_conjuration"));
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
