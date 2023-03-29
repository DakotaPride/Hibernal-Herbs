package net.dakotapride.hibernalHerbs.common.integration.rei.category;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.integration.rei.ReiHibernalHerbsPlugin;
import net.dakotapride.hibernalHerbs.common.integration.rei.display.HerbalConjurationDisplay;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HerbalConjurationCategory implements DisplayCategory<HerbalConjurationDisplay> {
    public static final Text TITLE = Text.translatable("text.hibernalherbs.herbal_conjuration");
    public static final EntryStack<ItemStack> ICON = EntryStacks.of(BlockInit.CONJURATION_ALTAR.asItem());

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
        return 64;
    }

    @Override
    public CategoryIdentifier<? extends HerbalConjurationDisplay> getCategoryIdentifier() {
        return ReiHibernalHerbsPlugin.HERBAL_CONJURATION;
    }

    @Override
    public List<Widget> setupDisplay(HerbalConjurationDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 64, bounds.getCenterY() - 16);
        Point outputPoint = new Point(startPoint.x + 108, startPoint.y + 8);

        List<Widget> widgets = new ArrayList<>();

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createArrow(new Point(startPoint.x + 78, startPoint.y + 8)));



        widgets.add(Widgets.createSlot(new Point(startPoint.x + 34, startPoint.y - 8))
                .entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 56, startPoint.y - 4))
                .entries(display.getInputEntries().get(1)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 12, startPoint.y + 18))
                .entries(display.getInputEntries().get(2)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 34, startPoint.y + 22))
                .entries(display.getInputEntries().get(3)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 56, startPoint.y + 18))
                .entries(display.getInputEntries().get(4)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 12, startPoint.y - 4))
                .entries(display.getInputEntries().get(5)).markInput());



        // widgets.add(Widgets.createResultSlotBackground(outputPoint));
        widgets.add(Widgets.createSlot(outputPoint).entries(display.getOutputEntries().get(0)).markOutput());

        return widgets;
    }
}