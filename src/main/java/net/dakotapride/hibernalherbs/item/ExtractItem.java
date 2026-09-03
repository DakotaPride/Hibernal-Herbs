package net.dakotapride.hibernalherbs.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExtractItem extends Item {
    String accessor;
    public ExtractItem(String st, Properties properties) {
        super(properties);
        this.accessor = st;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("text.hibernalherbs.extract.effect", Component.literal(accessor).withStyle(ChatFormatting.GOLD)));

    }
}
