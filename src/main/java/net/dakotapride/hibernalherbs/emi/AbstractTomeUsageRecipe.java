package net.dakotapride.hibernalherbs.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractTomeUsageRecipe implements EmiRecipe {
    EmiIngredient sigil;
    EmiTexture texture;
    List<EmiStack> output;
    List<Component> components;
    Holder<MobEffect> effect;
    private int width = 110, height = 28;

    // Provide an effect upon use
    public AbstractTomeUsageRecipe(Holder<MobEffect> effect, Item item, List<Component> components, EmiTexture texture) {
        this.sigil = EmiIngredient.of(Ingredient.of(item));
        this.texture = texture;
        this.components = components;
        this.effect = effect;
    }

    EmiIngredient input, result;

    // Provide an item upon use
    public AbstractTomeUsageRecipe(ItemStack input, ItemStack result) {
        this.input = EmiIngredient.of(Ingredient.of(input));
        this.result = EmiIngredient.of(Ingredient.of(result));
    }

//    @Override
//    public List<EmiStack> getOutputs() {
//        return List.of();
//    }

    @Override
    public int getDisplayWidth() {
        return width;
    }

    @Override
    public int getDisplayHeight() {
        return height;
    }

    public void createWidgetFromHerbalSigil(WidgetHolder widgets) {
        widgets.addSlot(sigil, 4, 6);
        widgets.addTexture(EmiTexture.PLUS, 26, 8);
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 64, 6);
        //widgets.addTexture(EmiTexture.PLUS, 2 - EmiTexture.PLUS.width / 2, -6  * 9);
        widgets.addSlot(EmiIngredient.of(Ingredient.of(ItemInit.SORCERER_TOME)), 44, 6);

        widgets.addTexture(texture, 62 + EmiTexture.EMPTY_ARROW.width + 2, 6);
        //widgets.addText(Component.translatable(effect.value().getDescriptionId()), 1, 1, 0x0, false);
        widgets.addTooltipText(components, 62 + EmiTexture.EMPTY_ARROW.width + 2, 6, 18, 18);
    }

    public void createCustomWidget(ItemStack stack0, ItemStack stack1, WidgetHolder widgets) {
        widgets.addSlot(EmiIngredient.of(Ingredient.of(stack0)), 4, 6);
        widgets.addTexture(EmiTexture.PLUS, 26, 8);
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 64, 6);
        //widgets.addTexture(EmiTexture.PLUS, 2 - EmiTexture.PLUS.width / 2, -6  * 9);
        widgets.addSlot(EmiIngredient.of(Ingredient.of(ItemInit.SORCERER_TOME)), 44, 6);

        widgets.addSlot(EmiIngredient.of(Ingredient.of(stack1)), 62 + EmiTexture.EMPTY_ARROW.width + 2, 6).recipeContext(this);
    }

    public static class TomeUsageRecipe extends AbstractTomeUsageRecipe {
        public TomeUsageRecipe(Holder<MobEffect> effect, Item item, List<Component> components, EmiTexture texture) {
            super(effect, item, components, texture);
        }

        @Override
        public EmiRecipeCategory getCategory() {
            return HibernalHerbsEmiPlugin.TOME_USAGE_EFFECT;
        }

        @Override
        public @Nullable ResourceLocation getId() {
            return HibernalHerbsMod.asResource("tome_usage/" + BuiltInRegistries.MOB_EFFECT.getKey(effect.value()).getPath());
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(sigil, EmiIngredient.of(Ingredient.of(ItemInit.SORCERER_TOME)));
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            super.createWidgetFromHerbalSigil(widgets);
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of();
        }
    }

    public static class CustomTomeUsageRecipe extends AbstractTomeUsageRecipe {
        ItemStack stack0, stack1;
        boolean has_custom_tooltip;

        private final List<EmiStack> outputs;
        public CustomTomeUsageRecipe(ItemStack stack0, ItemStack stack1, boolean has_custom_tooltip) {
            super(stack0, stack1);
            this.stack0 = stack0;
            this.stack1 = stack1;
            this.has_custom_tooltip = has_custom_tooltip;

            this.outputs = List.of(EmiStack.of(stack1));
            //this.outputs = builder.output.stream().map(i -> (EmiStack) i.stack).toList();
        }

        @Override
        public EmiRecipeCategory getCategory() {
            return HibernalHerbsEmiPlugin.TOME_USAGE_ITEM;
        }

        @Override
        public @Nullable ResourceLocation getId() {
            return HibernalHerbsMod.asResource("tome_usage/" + BuiltInRegistries.ITEM.getKey(stack1.getItem()).getPath());
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(Ingredient.of(stack0)), EmiIngredient.of(Ingredient.of(ItemInit.SORCERER_TOME)));
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            super.createCustomWidget(stack0, stack1, widgets);
        }

        @Override
        public List<EmiStack> getOutputs() {
            return outputs;
        }
    }
}
