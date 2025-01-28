package net.dakotapride.hibernalherbs.block;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FrozeStateStairsBlock extends StairBlock {
    String key = "text.hibernalherbs.blockstate.frozen_state";
    public FrozeStateStairsBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
    }
}
