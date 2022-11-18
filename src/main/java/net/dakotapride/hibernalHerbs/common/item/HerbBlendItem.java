package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbBlendItem extends Item {
    public HerbBlendItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regeneration").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_poison").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_slowness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_mining_fatigue").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_haste").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_speed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_fire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_wither").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }
    }
}
