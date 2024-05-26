package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbFertilizerItem extends Item implements ITooltipProvider {
    public HerbFertilizerItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {

        if (!Screen.hasShiftDown()) {
            list.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.is(ItemRegistry.HERB_FERTILIZER_OAK.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.oak").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_SPRUCE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.spruce").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_BIRCH.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.birch").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_ACACIA.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.acacia").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_JUNGLE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.jungle").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_DARK_OAK.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.dark_oak").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_MANGROVE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.mangrove").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_CHERRY.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.cherry").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_CRIMSON.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.crimson").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_WARPED.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.warped").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_FERTILIZER_MYQUESTE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.myqueste").withStyle(ChatFormatting.GRAY));
            }

            else if (!stack.is(HibernalHerbsForge.FERTILIZER_TAG)) {
                list.add(Component.translatable("text.hibernalherbs.association.none").withStyle(ChatFormatting.GRAY));
            }

            HerbHumusItem.getProductionValueTooltip(stack, list);

            if (!Screen.hasAltDown()) {
                list.add(Component.literal(""));
                list.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
            } else {
                list.add(Component.literal(""));
                list.add(Component.translatable("text.hibernalherbs.fertilizer.additional_text.one").withStyle(ChatFormatting.DARK_PURPLE));
                list.add(Component.translatable("text.hibernalherbs.fertilizer.additional_text.two").withStyle(ChatFormatting.DARK_PURPLE));
                list.add(Component.translatable("text.hibernalherbs.fertilizer.additional_text.three").withStyle(ChatFormatting.DARK_PURPLE));
                list.add(Component.translatable("text.hibernalherbs.fertilizer.additional_text.four").withStyle(ChatFormatting.DARK_PURPLE));
            }
        }
    }

}
