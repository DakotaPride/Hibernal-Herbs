package net.dakotapride.hibernalHerbs.common.item.ring.adv;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdvancedGluttonousRingItem extends Item {
    public AdvancedGluttonousRingItem(Properties properties) {
        super(properties);
    }


    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("text.hibernalherbs.inventory").withStyle(ChatFormatting.WHITE));
        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("text.hibernalherbs.ring.gluttonous.1.adv").withStyle(ChatFormatting.BLUE));
        tooltip.add(Component.translatable("text.hibernalherbs.ring.gluttonous.2.adv").withStyle(ChatFormatting.BLUE));
    }
}
