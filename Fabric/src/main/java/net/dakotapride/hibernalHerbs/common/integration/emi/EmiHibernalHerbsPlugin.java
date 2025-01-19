package net.dakotapride.hibernalHerbs.common.integration.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.RecipeInit;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class EmiHibernalHerbsPlugin implements EmiPlugin {
    public static final Identifier SPRITE_SHEET = new Identifier(MOD_ID, "textures/gui/recipe_viewer/emi/sprite_sheet.png");
    public static final EmiStack CONJURATION_ALTAR = EmiStack.of(BlockInit.CONJURATION_ALTAR);
    public static final EmiRecipeCategory CONJURATION_CATEGORY
            = new EmiRecipeCategory(new Identifier(MOD_ID, "herbal_conjuration"), CONJURATION_ALTAR, new EmiTexture(SPRITE_SHEET, 0, 0, 16, 16));

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(CONJURATION_CATEGORY);

        // Add all the workstations your category uses
        registry.addWorkstation(CONJURATION_CATEGORY, CONJURATION_ALTAR);

        RecipeManager manager = registry.getRecipeManager();

        // Use vanilla's concept of your recipes and pass them to your EmiRecipe representation
        for (HerbalConjurationRecipe recipe : manager.listAllOfType(RecipeInit.HERBAL_CONJURATION_TYPE)) {
            registry.addRecipe(new HerbalConjurationEmiRecipe(recipe));
        }
    }
}
