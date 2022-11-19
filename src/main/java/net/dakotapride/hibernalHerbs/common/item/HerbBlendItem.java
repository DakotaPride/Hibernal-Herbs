package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        if (stack.getItem().getDefaultStack().isOf(ItemInit.REGENERATIVE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regeneration").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.VIRULENT_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_poison").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SEDATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_slowness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.HINDERING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_mining_fatigue").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DASHING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_haste").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.ACCELERATION_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_speed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_fire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DECAYING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_wither").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.OBSERVING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_night_vision").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DIMINISHED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_weakness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SHADED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_blindness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);

        return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode
                ? itemStack : new ItemStack(Items.BOWL);
    }
}
