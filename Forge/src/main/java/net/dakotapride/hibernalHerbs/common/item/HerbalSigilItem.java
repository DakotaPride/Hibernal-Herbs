package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalSigilItem extends Item {
    public HerbalSigilItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (!stack.is(itemRegistry.SIGIL.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.sigil.type").withStyle(ChatFormatting.GRAY));
            if (Screen.hasShiftDown()) {
                if (stack.is(itemRegistry.SIGIL_PRIDE.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.pride").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_SLOTH.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.sloth").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_LUST.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.lust").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_GLUTTONY.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.gluttony").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_WRATH.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.wrath").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_GREED.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.greed").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_ENVY.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.envy").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_CONFIGURATION.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.configuration").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_MASTERY.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.mastery").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_CONFIGURATION_ADV.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.configuration.adv").withStyle(ChatFormatting.GRAY));
                } else if (stack.is(itemRegistry.SIGIL_MASTERY_ADV.get())) {
                    tooltip.add(Component.translatable("text.hibernalherbs.sigil.mastery.adv").withStyle(ChatFormatting.GRAY));
                }
            }
        }
    }
}
