package net.dakotapride.hibernalHerbs.common.integration.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import me.shedaniel.math.Point;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class HerbalConjurationEmiRecipe implements EmiRecipe {
    private final Identifier id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;

    public HerbalConjurationEmiRecipe(HerbalConjurationRecipe recipe) {
        this.id = recipe.getId();
        this.input = List.of(
                EmiIngredient.of(recipe.getIngredients().get(5)),EmiIngredient.of(recipe.getIngredients().get(0)),
                EmiIngredient.of(recipe.getIngredients().get(1)),EmiIngredient.of(recipe.getIngredients().get(2)),
                EmiIngredient.of(recipe.getIngredients().get(3)),EmiIngredient.of(recipe.getIngredients().get(4)));
        this.output = List.of(EmiStack.of(recipe.getOutput(DynamicRegistryManager.EMPTY)));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return EmiHibernalHerbsPlugin.CONJURATION_CATEGORY;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 110;
    }

    @Override
    public int getDisplayHeight() {
        return 40;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        // Add an arrow texture to indicate processing
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 63, 11);

        // Adds an input slot on the left
        widgets.addSlot(input.get(0), 3, 21);
        widgets.addSlot(input.get(1), 23, 21);
        widgets.addSlot(input.get(2), 43, 21);
        widgets.addSlot(input.get(3), 3, 1);
        widgets.addSlot(input.get(4), 23, 1);
        widgets.addSlot(input.get(5), 43, 1);

        // Adds an output slot on the right
        // Note that output slots need to call `recipeContext` to inform EMI about their recipe context
        // This includes being able to resolve recipe trees, favorite stacks with recipe context, and more
        widgets.addSlot(output.get(0), 90, 11).recipeContext(this);
    }
}