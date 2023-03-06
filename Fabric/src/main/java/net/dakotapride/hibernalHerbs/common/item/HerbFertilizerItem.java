package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.text.Text;

import java.util.List;

public class HerbFertilizerItem extends Item {
    public HerbFertilizerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("text.hibernalherbs.association").formatted(Formatting.GRAY));
        }

        if (Screen.hasShiftDown()) {
            if (this.getDefaultStack().isOf(ItemInit.HERB_FERTILIZER)) {
                tooltip.add(Text.translatable("hibernalherbs.association.none").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.none.information").formatted(Formatting.GRAY));
            } else if (this.getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_OAK)) {
                tooltip.add(Text.translatable("hibernalherbs.association.oak").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.oak.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_SPRUCE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.spruce").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.spruce.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_ACACIA)) {
                tooltip.add(Text.translatable("hibernalherbs.association.acacia").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.acacia.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_DARK_OAK)) {
                tooltip.add(Text.translatable("hibernalherbs.association.dark_oak").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.dark_oak.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_JUNGLE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.jungle").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.jungle.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_BIRCH)) {
                tooltip.add(Text.translatable("hibernalherbs.association.birch").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.birch.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_MANGROVE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.mangrove").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.mangrove.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_CRIMSON)) {
                tooltip.add(Text.translatable("hibernalherbs.association.crimson").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.crimson.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_WARPED)) {
                tooltip.add(Text.translatable("hibernalherbs.association.warped").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.warped.information").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_FERTILIZER_MYQUESTE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.myqueste").formatted(Formatting.GRAY));

                tooltip.add(Text.literal(" "));
                tooltip.add(Text.translatable("hibernalherbs.association.myqueste.information").formatted(Formatting.GRAY));
            }
        }
    }
}
