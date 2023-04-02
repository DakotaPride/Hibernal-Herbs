package net.dakotapride.hibernalHerbs.common.item.curse.grimoire;

import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalGrimoireItem extends Item {
    public HerbalGrimoireItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (stack.is(itemRegistry.HERBAL_GRIMOIRE.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.grimoire").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.is(itemRegistry.SINGED_GRIMOIRE.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.grimoire.singed").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        }
    }
}
