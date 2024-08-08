package net.dakotapride.hibernalherbs.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class HerbalConjurationRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> input;

    public HerbalConjurationRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.input = recipeItems;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return input;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        List<ItemStack> checklist = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                checklist.add(stack);
            }
        }
        if (input.size() != checklist.size()) {
            return false;
        }

        if (!(input.get(0).test(inventory.getStack(1)))) { return false; }
        if (!(input.get(1).test(inventory.getStack(2)))) { return false; }
        if (!(input.get(2).test(inventory.getStack(3)))) { return false; }
        if (!(input.get(3).test(inventory.getStack(4)))) { return false; }
        if (!(input.get(4).test(inventory.getStack(5)))) { return false; }

        for (Ingredient ingredient : input) {
            boolean found = false;
            for (ItemStack stack : checklist) {
                if (ingredient.test(stack)) {
                    found = true;
                    checklist.remove(stack);
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<HerbalConjurationRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "herbal_conjuration";
    }

    public static class Serializer implements RecipeSerializer<HerbalConjurationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "herbal_conjuration";
        // this is the name given in the json file

        @Override
        public HerbalConjurationRecipe read(Identifier id, JsonObject json) {
            /* JSON Input Order
            *
            * 1st INPUT - 6th item in JSON
            *
            * 2nd INPUT - 1st item in JSON
            *
            * 3rd INPUT - 2nd item in JSON
            *
            * 4th INPUT - 3rd item in JSON
            *
            * 5th INPUT - 4th item in JSON
            *
            * 6th INPUT - 5th item in JSON
            *
            */
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(6, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new HerbalConjurationRecipe(id, output, inputs);
        }

        @Override
        public HerbalConjurationRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new HerbalConjurationRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, HerbalConjurationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(DynamicRegistryManager.EMPTY));
        }
    }
}