package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
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

public class HerbFertilizerItem extends Item {
    public HerbFertilizerItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {

        if (!Screen.hasShiftDown()) {
            list.add(Component.translatable("text.hibernalherbs.association").withStyle(ChatFormatting.GRAY));
        }

        if (Screen.hasShiftDown()) {
            if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER.get())) {
                list.add(Component.translatable("hibernalherbs.association.none").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.none.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_OAK.get())) {
                list.add(Component.translatable("hibernalherbs.association.oak").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.oak.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_SPRUCE.get())) {
                list.add(Component.translatable("hibernalherbs.association.spruce").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.spruce.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_ACACIA.get())) {
                list.add(Component.translatable("hibernalherbs.association.acacia").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.acacia.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_DARK_OAK.get())) {
                list.add(Component.translatable("hibernalherbs.association.dark_oak").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.dark_oak.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_JUNGLE.get())) {
                list.add(Component.translatable("hibernalherbs.association.jungle").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.jungle.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_BIRCH.get())) {
                list.add(Component.translatable("hibernalherbs.association.birch").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.birch.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_MANGROVE.get())) {
                list.add(Component.translatable("hibernalherbs.association.mangrove").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.mangrove.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_CRIMSON.get())) {
                list.add(Component.translatable("hibernalherbs.association.crimson").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.crimson.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_WARPED.get())) {
                list.add(Component.translatable("hibernalherbs.association.warped").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.warped.information").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_FERTILIZER_MYQUESTE.get())) {
                list.add(Component.translatable("hibernalherbs.association.myqueste").withStyle(ChatFormatting.GRAY));

                list.add(Component.literal(" "));
                list.add(Component.translatable("hibernalherbs.association.myqueste.information").withStyle(ChatFormatting.GRAY));
            }
        }
    }

}
