package net.dakotapride.hibernalHerbs.common.integration.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.integration.rei.ReiHibernalHerbsPlugin;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Collections;
import java.util.List;

public class HerbalConjurationDisplay implements Display {
    private final List<EntryIngredient> input;
    private final List<EntryIngredient> output;
    private final List<EntryIngredient> crackedSigil;

    public HerbalConjurationDisplay(HerbalConjurationRecipe recipe) {
        input = EntryIngredients.ofIngredients(recipe.getIngredients());
        output = Collections.singletonList(EntryIngredients.of(recipe.getOutput()));
        crackedSigil = Collections.singletonList(EntryIngredients.of(ItemInit.CRACKED_SIGIL));
    }

    public List<EntryIngredient> getCrackedSigil() { return crackedSigil; }

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
