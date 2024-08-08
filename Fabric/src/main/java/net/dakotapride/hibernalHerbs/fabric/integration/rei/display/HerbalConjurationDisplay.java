package net.dakotapride.hibernalherbs.fabric.integration.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.dakotapride.hibernalherbs.fabric.integration.rei.ReiHibernalHerbsPlugin;
import net.dakotapride.hibernalherbs.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalherbs.registry.ItemRegistry;
import net.minecraft.registry.DynamicRegistryManager;

import java.util.Collections;
import java.util.List;

public class HerbalConjurationDisplay implements Display {
    private final List<EntryIngredient> input;
    private final List<EntryIngredient> output;
    private final List<EntryIngredient> crackedSigil;

    public HerbalConjurationDisplay(HerbalConjurationRecipe recipe) {
        input = EntryIngredients.ofIngredients(recipe.getIngredients());
        output = Collections.singletonList(EntryIngredients.of(recipe.getOutput(DynamicRegistryManager.EMPTY)));
        crackedSigil = Collections.singletonList(EntryIngredients.of(ItemRegistry.CRACKED_SIGIL));
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
