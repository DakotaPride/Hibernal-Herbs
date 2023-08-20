package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.text.Text;

import java.util.List;

public class HerbFertilizerItem extends Item implements ITooltipProvider {
    public HerbFertilizerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.isOf(ItemInit.HERB_FERTILIZER_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_SPRUCE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.spruce").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_BIRCH)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.birch").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_ACACIA)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.acacia").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_JUNGLE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.jungle").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_DARK_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.dark_oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_MANGROVE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.mangrove").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_CHERRY)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.cherry").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_CRIMSON)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.crimson").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_WARPED)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.warped").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_MYQUESTE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.myqueste").formatted(Formatting.GRAY));
            }

            else if (!stack.isIn(util.FERTILIZER)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.none").formatted(Formatting.GRAY));
            }

            HerbHumusItem.getProductionValueTooltip(stack, tooltip);

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.fertilizer.additional_text.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.fertilizer.additional_text.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.fertilizer.additional_text.three").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.fertilizer.additional_text.four").formatted(Formatting.DARK_PURPLE));
            }
        }

    }
}
