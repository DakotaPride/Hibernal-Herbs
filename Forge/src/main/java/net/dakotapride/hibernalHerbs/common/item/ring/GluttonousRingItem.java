package net.dakotapride.hibernalHerbs.common.item.ring;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
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

public class GluttonousRingItem extends Item implements ITooltipProvider {
    public GluttonousRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(inInventoryPassiveText).withStyle(ChatFormatting.GRAY));

            tooltip.add(Component.literal(""));
            tooltip.add(Component.translatable("text.hibernalherbs.gluttony.help.one").withStyle(ChatFormatting.DARK_PURPLE));
            tooltip.add(Component.translatable("text.hibernalherbs.gluttony.help.two").withStyle(ChatFormatting.DARK_PURPLE));
        }
    }
}
