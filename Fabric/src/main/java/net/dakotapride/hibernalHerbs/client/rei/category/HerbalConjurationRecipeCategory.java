package net.dakotapride.hibernalHerbs.client.rei.category;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.dakotapride.hibernalHerbs.client.rei.display.HerbalConjurationRecipeDisplay;
import net.dakotapride.hibernalHerbs.client.rei.plugin.HibernalHerbsREIPlugin;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HerbalConjurationRecipeCategory implements DisplayCategory<HerbalConjurationRecipeDisplay> {
    public static final MutableText TITLE = Text.translatable("block.hibernalherbs.conjuration_altar");
    public static final EntryStack<ItemStack> ICON = EntryStacks.of(BlockInit.CONJURATION_ALTAR);

    @Override
    public Renderer getIcon() {
        return ICON;
    }

    @Override
    public Text getTitle() {
        return TITLE;
    }

    @Override
    public int getDisplayHeight() {
        return 49;
    }

    @Override
    public CategoryIdentifier<? extends HerbalConjurationRecipeDisplay> getCategoryIdentifier() {
        return HibernalHerbsREIPlugin.HERBAL_CONJURATION;
    }

    @Override
    public List<Widget> setupDisplay(HerbalConjurationRecipeDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();

        // The base background of the display
        // Please try to not remove this to preserve a uniform style to REI
        widgets.add(Widgets.createRecipeBase(bounds));

        // The gray arrow
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));

        // We create a result slot background AND
        // disable the actual background of the slots, so the result slot can look bigger
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 35)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
                .entries(display.getOutputEntries().get(0)) // Get the first output ingredient
                .disableBackground() // Disable the background because we have our bigger background
                .markOutput()); // Mark this as the output for REI to identify

        // We add the input slot
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5))
                .entries(display.getInputEntries().get(0)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 24, startPoint.y + 5))
                .entries(display.getInputEntries().get(1)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 5))
                .entries(display.getInputEntries().get(2)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 68, startPoint.y + 5))
                .entries(display.getInputEntries().get(3)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 88, startPoint.y + 5))
                .entries(display.getInputEntries().get(4)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 108, startPoint.y + 5))
                .entries(display.getInputEntries().get(5)) // Get the first input ingredient
                .markInput()); // Mark this as the input for REI to identify

        // We return the list of widgets for REI to display
        return widgets;
    }
}