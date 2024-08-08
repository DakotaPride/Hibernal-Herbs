package net.dakotapride.hibernalherbs.fabric.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.fabric.integration.rei.category.HerbalConjurationCategory;
import net.dakotapride.hibernalherbs.fabric.integration.rei.display.HerbalConjurationDisplay;
import net.dakotapride.hibernalherbs.recipe.HerbalConjurationRecipe;
import net.minecraft.util.Identifier;

public class ReiHibernalHerbsPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<HerbalConjurationDisplay> HERBAL_CONJURATION =
            CategoryIdentifier.of(new Identifier(HibernalHerbsCommon.MOD_ID, "plugins/herbal_conjuration"));

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new HerbalConjurationCategory());
        registry.addWorkstations(HERBAL_CONJURATION, HerbalConjurationCategory.ICON);
        registry.setPlusButtonArea(HERBAL_CONJURATION, bounds -> null);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(HerbalConjurationRecipe.class, HerbalConjurationDisplay::new);
    }
}