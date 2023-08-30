package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalSigilItem extends Item implements ITooltipProvider {
    public HerbalSigilItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            getSigilAlignment(stack, tooltip);

            if (!Screen.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
            } else {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.three").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.four").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.three").withStyle(ChatFormatting.DARK_PURPLE));
            }
        }
    }

    public static void getSigilAlignment(ItemStack stack, List<Component> tooltip) {
        MutableComponent alignment = SigilAlignments.NONE.getAlignment();

        if (stack.is(itemRegistry.SIGIL_PRIDE.get())) {
            alignment = SigilAlignments.PRIDE.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_ENVY.get())) {
            alignment = SigilAlignments.ENVY.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_SLOTH.get())) {
            alignment = SigilAlignments.SLOTH.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_WRATH.get())) {
            alignment = SigilAlignments.WRATH.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_GREED.get())) {
            alignment = SigilAlignments.GREED.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_LUST.get())) {
            alignment = SigilAlignments.LUST.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_GLUTTONY.get())) {
            alignment = SigilAlignments.GLUTTONY.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_MASTERY.get())) {
            alignment = SigilAlignments.MASTERY.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_MASTERY_ADV.get())) {
            alignment = SigilAlignments.ADVANCED_MASTERY.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_CONFIGURATION.get())) {
            alignment = SigilAlignments.CONFIGURATION.getAlignment();
        } else if (stack.is(itemRegistry.SIGIL_CONFIGURATION_ADV.get())) {
            alignment = SigilAlignments.ADVANCED_CONFIGURATION.getAlignment();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.sigil.alignment", alignment).withStyle(ChatFormatting.GRAY));
    }
}
