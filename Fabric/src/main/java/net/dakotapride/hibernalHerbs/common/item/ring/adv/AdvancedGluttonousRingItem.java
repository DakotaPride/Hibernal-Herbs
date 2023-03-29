package net.dakotapride.hibernalHerbs.common.item.ring.adv;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdvancedGluttonousRingItem extends Item {
    public AdvancedGluttonousRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("text.hibernalherbs.inventory").formatted(Formatting.WHITE));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("text.hibernalherbs.ring.gluttonous.1.adv").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("text.hibernalherbs.ring.gluttonous.2.adv").formatted(Formatting.BLUE));
    }
}
