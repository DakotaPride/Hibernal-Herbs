package net.dakotapride.hibernalherbs.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockUpdateFakeRecipe implements EmiRecipe {
    private int width = 110, height = 28;
    //EmiIngredient input, result;
    ItemStack input, result;

    UpdateTypes type;

    public BlockUpdateFakeRecipe(ItemStack input, ItemStack result, UpdateTypes type) {
        this.input = input;
        this.result = result;
        this.type = type;
    }

    @Override
    public int getDisplayWidth() {
        return width;
    }

    @Override
    public int getDisplayHeight() {
        return height;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return type.getCategory();
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return HibernalHerbsMod.asResource(type.getId() + "/" + BuiltInRegistries.ITEM.getKey(input.getItem()).getPath());
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(EmiIngredient.of(Ingredient.of(input)));
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(EmiStack.of(result));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addSlot(EmiIngredient.of(Ingredient.of(input)), 24, 6);
        //widgets.addTexture(EmiTexture.PLUS, 26, 8);
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 44, 6);
        //widgets.addTexture(EmiTexture.PLUS, 2 - EmiTexture.PLUS.width / 2, -6  * 9);

        widgets.addSlot(EmiIngredient.of(Ingredient.of(result)), 44 + EmiTexture.EMPTY_ARROW.width + 2, 6).recipeContext(this);
    }

    public static class DeteriorationRecipe extends BlockUpdateFakeRecipe {
        public DeteriorationRecipe(ItemStack input, ItemStack result) {
            super(input, result, UpdateTypes.DETERIORATION);
        }
    }

    public static class RevertDeteriorationRecipe extends BlockUpdateFakeRecipe {
        public RevertDeteriorationRecipe(ItemStack input, ItemStack result) {
            super(input, result, UpdateTypes.REVERT_DETERIORATION);
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addSlot(EmiIngredient.of(Ingredient.of(result)), 24, 6);
            //widgets.addTexture(EmiTexture.PLUS, 26, 8);
            widgets.addTexture(EmiTexture.EMPTY_ARROW, 44, 6);
            //widgets.addTexture(EmiTexture.PLUS, 2 - EmiTexture.PLUS.width / 2, -6  * 9);

            widgets.addSlot(EmiIngredient.of(Ingredient.of(input)), 44 + EmiTexture.EMPTY_ARROW.width + 2, 6).recipeContext(this);
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(Ingredient.of(result)));
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of(EmiStack.of(input));
        }
    }

    public static class FreezingStateRecipe extends BlockUpdateFakeRecipe {
        public FreezingStateRecipe(ItemStack input, ItemStack result) {
            super(input, result, UpdateTypes.FREEZE_STATE);
        }
    }

    public static class UnfreezingStateRecipe extends BlockUpdateFakeRecipe {
        public UnfreezingStateRecipe(ItemStack input, ItemStack result) {
            super(input, result, UpdateTypes.UNFREEZE_STATE);
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addSlot(EmiIngredient.of(Ingredient.of(result)), 24, 6);
            //widgets.addTexture(EmiTexture.PLUS, 26, 8);
            widgets.addTexture(EmiTexture.EMPTY_ARROW, 44, 6);
            //widgets.addTexture(EmiTexture.PLUS, 2 - EmiTexture.PLUS.width / 2, -6  * 9);

            widgets.addSlot(EmiIngredient.of(Ingredient.of(input)), 44 + EmiTexture.EMPTY_ARROW.width + 2, 6).recipeContext(this);
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(Ingredient.of(result)));
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of(EmiStack.of(input));
        }
    }
}
