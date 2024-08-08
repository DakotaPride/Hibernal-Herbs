package net.dakotapride.hibernalherbs.fabric.integration.patchouli;

import net.minecraft.client.MinecraftClient;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class PatchouliUtils {

    @Nullable
    public static <C extends Inventory, T extends Recipe<C>, X extends T> X getRecipe(Class<X> cls, RecipeType<T> type, @Nullable String id) {
        return getRecipe(cls, type, id == null ? null : Identifier.tryParse(id));
    }

    @Nullable
    public static <C extends Inventory, T extends Recipe<C>> T getRecipe(RecipeType<T> type, @Nullable Identifier id) {
        if (id == null) return null;
        RecipeManager rm = MinecraftClient.getInstance().getNetworkHandler() == null ? null : MinecraftClient.getInstance().getNetworkHandler().getRecipeManager();
        return rm == null ? null : rm.getAllOfType(type).getOrDefault(id, null);
    }

    @Nullable
    public static <C extends Inventory, T extends Recipe<C>, X extends T> X getRecipe(Class<X> cls, RecipeType<T> type, @Nullable Identifier id) {
        T recipe = getRecipe(type, id);
        if (recipe == null || cls.isAssignableFrom(recipe.getClass())) {
            //noinspection unchecked
            return (X) recipe;
        } else {
            return null;
        }
    }


}
