package net.dakotapride.hibernalHerbs.common.integration.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.dakotapride.hibernalHerbs.common.integration.rei.ReiHibernalHerbsPlugin;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Collections;
import java.util.List;

public class HerbalConjurationDisplay implements Display {
    private final List<EntryIngredient> input;
    private final List<EntryIngredient> output;

    public HerbalConjurationDisplay(HerbalConjurationRecipe recipe) {
        input = EntryIngredients.ofIngredients(recipe.getIngredients());
        output = Collections.singletonList(EntryIngredients.of(recipe.getOutput()));
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return input;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return output;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ReiHibernalHerbsPlugin.HERBAL_CONJURATION;
    }
}
