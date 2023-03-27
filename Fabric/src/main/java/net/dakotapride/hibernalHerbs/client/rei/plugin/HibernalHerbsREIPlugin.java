package net.dakotapride.hibernalHerbs.client.rei.plugin;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.dakotapride.hibernalHerbs.client.rei.category.HerbalConjurationRecipeCategory;
import net.dakotapride.hibernalHerbs.client.rei.display.HerbalConjurationRecipeDisplay;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsREIPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<HerbalConjurationRecipeDisplay> HERBAL_CONJURATION =
            CategoryIdentifier.of(new Identifier(MOD_ID, "herbal_conjuration"));

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new HerbalConjurationRecipeCategory());
        registry.addWorkstations(HERBAL_CONJURATION, HerbalConjurationRecipeCategory.ICON);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(HerbalConjurationRecipe.class, HerbalConjurationRecipeDisplay::new);
    }
}
