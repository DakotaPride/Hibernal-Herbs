package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalSigilItem extends Item implements ITooltipProvider {
    public HerbalSigilItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            getSigilAlignment(stack, tooltip);

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.padlock.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.padlock.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.padlock.three").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.padlock.four").formatted(Formatting.DARK_PURPLE));

                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.herbs.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.herbs.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.sigil.help.herbs.three").formatted(Formatting.DARK_PURPLE));
            }
        }
    }

    public static void getSigilAlignment(ItemStack stack, List<Text> tooltip) {
        MutableText alignment = SigilAlignments.NONE.getAlignment();

        if (stack.isOf(ItemInit.SIGIL_PRIDE)) {
            alignment = SigilAlignments.PRIDE.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_ENVY)) {
            alignment = SigilAlignments.ENVY.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_SLOTH)) {
            alignment = SigilAlignments.SLOTH.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_WRATH)) {
            alignment = SigilAlignments.WRATH.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_GREED)) {
            alignment = SigilAlignments.GREED.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_LUST)) {
            alignment = SigilAlignments.LUST.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_GLUTTONY)) {
            alignment = SigilAlignments.GLUTTONY.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_MASTERY)) {
            alignment = SigilAlignments.MASTERY.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_MASTERY_ADVANCED)) {
            alignment = SigilAlignments.ADVANCED_MASTERY.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_CONFIGURATION)) {
            alignment = SigilAlignments.CONFIGURATION.getAlignment();
        } else if (stack.isOf(ItemInit.SIGIL_CONFIGURATION_ADVANCED)) {
            alignment = SigilAlignments.ADVANCED_CONFIGURATION.getAlignment();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.sigil.alignment", alignment).formatted(Formatting.GRAY));

    }
}
