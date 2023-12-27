package net.dakotapride.hibernalHerbs.common.item.ring;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GluttonousRingItem extends Item implements ITooltipProvider {
    public GluttonousRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(inInventoryPassiveText).formatted(Formatting.GRAY));

            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("text.hibernalherbs.gluttony.help.one").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("text.hibernalherbs.gluttony.help.two").formatted(Formatting.DARK_PURPLE));

            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("text.hibernalherbs.warning.gluttony.two").formatted(Formatting.DARK_PURPLE));
        }
    }
}
