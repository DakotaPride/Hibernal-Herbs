package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalSigilItem extends Item {
    public HerbalSigilItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!stack.isOf(ItemInit.SIGIL)) {
            tooltip.add(Text.translatable("text.hibernalherbs.sigil.type").formatted(Formatting.GRAY));
            if (Screen.hasShiftDown()) {
                if (stack.isOf(ItemInit.SIGIL_PRIDE)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.pride").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_SLOTH)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.sloth").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_LUST)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.lust").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_GLUTTONY)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.gluttony").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_WRATH)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.wrath").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_GREED)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.greed").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_ENVY)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.envy").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_CONFIGURATION)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.configuration").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_MASTERY)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.mastery").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_CONFIGURATION_ADVANCED)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.configuration.adv").formatted(Formatting.GRAY));
                } else if (stack.isOf(ItemInit.SIGIL_MASTERY_ADVANCED)) {
                    tooltip.add(Text.translatable("text.hibernalherbs.sigil.mastery.adv").formatted(Formatting.GRAY));
                }
            }
        }
    }
}
