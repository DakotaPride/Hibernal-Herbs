package net.dakotapride.hibernalherbs.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;

public class IncenseItemBurningFakeRecipe implements EmiRecipe {
    private int width = 110, height = 28;
    //EmiIngredient input, result;
    ItemStack input, result;
    final int chance;
    final boolean enchantment;

    public IncenseItemBurningFakeRecipe(ItemStack input, ItemStack result, boolean enchantment, int chance) {
        this.input = input;
        this.result = result;
        this.chance = chance;
        this.enchantment = enchantment;
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
        return HibernalHerbsEmiPlugin.INCENSE_BURNING;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return HibernalHerbsMod.asResource("incense_burning/" + BuiltInRegistries.ITEM.getKey(result.getItem()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(input.getItem()).getPath());
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

        widgets.addTexture(EmiTexture.EMPTY_FLAME, 66 + EmiTexture.EMPTY_ARROW.width + 2, 6);
        if (enchantment)
            widgets.addTooltipText(
                    List.of(Component.literal(chance + "%").withStyle(ChatFormatting.GOLD),
                            Component.translatable("text.hibernalherbs.incense_burner.enchanting.chance").withStyle(ChatFormatting.GOLD),
                            Component.translatable("text.hibernalherbs.incense_burner.enchanting.level").withStyle(ChatFormatting.GRAY)),
                    66 + EmiTexture.EMPTY_ARROW.width + 2, 6, 18, 18);
        if (!enchantment)
            widgets.addTooltipText(List.of(Component.literal(chance + "%").withStyle(ChatFormatting.GOLD)), 66 + EmiTexture.EMPTY_ARROW.width + 2, 6, 18, 18);
    }
}
