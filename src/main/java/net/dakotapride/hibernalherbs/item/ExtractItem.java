package net.dakotapride.hibernalherbs.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ExtractItem extends Item {
    String accessor;
    public ExtractItem(String st, Properties properties) {
        super(properties);
        this.accessor = st;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("text.hibernalherbs.extract.effect", Component.literal(accessor).withStyle(ChatFormatting.GOLD)));
        //super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    }
}
