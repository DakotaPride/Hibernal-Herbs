package net.dakotapride.hibernalherbs.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.List;

public class FrozeStateTrapdoorBlock extends TrapDoorBlock {
    String key = "text.hibernalherbs.blockstate.frozen_state";
    public FrozeStateTrapdoorBlock(BlockSetType blockSetType, Properties properties) {
        super(blockSetType, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
    }
}
