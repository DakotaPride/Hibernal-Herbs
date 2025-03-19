package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.FertilizerTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HerbFertilizerItem extends Item {
    public HerbFertilizerItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {

        if (!HibernalHerbsMod.hasShiftDown()) {
            list.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
        } else if (HibernalHerbsMod.hasShiftDown()) {
            FertilizerTypes.applyFertilizerAssistanceTooltip(stack, list);

            FertilizerTypes.applyProductionValueTooltip(stack, list);
//            else if (!stack.is(Tags.Items.FERTILIZER.getTag())) {
//                list.add(Component.translatable("text.hibernalherbs.association.none").withStyle(ChatFormatting.GRAY));
//            }

            //HerbHumusItem.getProductionValueTooltip(stack, list);

            if (!HibernalHerbsMod.hasAltDown()) {
                list.add(Component.literal(""));
                list.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
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
