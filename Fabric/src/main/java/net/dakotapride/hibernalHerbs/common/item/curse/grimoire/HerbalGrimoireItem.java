package net.dakotapride.hibernalHerbs.common.item.curse.grimoire;

import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalGrimoireItem extends Item {
    public HerbalGrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("text.hibernalherbs.unfinished"));

        tooltip.add(Text.literal(" "));

        if (stack.isOf(ItemInit.HERBAL_GRIMOIRE)) {
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.isOf(ItemInit.SINGED_GRIMOIRE)) {
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire.singed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }
    }
}
