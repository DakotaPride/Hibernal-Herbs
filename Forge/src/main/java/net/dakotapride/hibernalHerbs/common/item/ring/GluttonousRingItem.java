package net.dakotapride.hibernalHerbs.common.item.ring;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GluttonousRingItem extends Item {
    public GluttonousRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("text.hibernalherbs.inventory").withStyle(ChatFormatting.WHITE));
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("text.hibernalherbs.ring.gluttonous.1").withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("text.hibernalherbs.ring.gluttonous.2").withStyle(ChatFormatting.BLUE));
    }
}
