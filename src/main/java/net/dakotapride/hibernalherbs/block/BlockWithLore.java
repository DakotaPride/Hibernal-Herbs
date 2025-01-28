package net.dakotapride.hibernalherbs.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class BlockWithLore extends Block {
    String key;
    public BlockWithLore(Properties properties, String key) {
        super(properties);
        this.key = key;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
    }
}
