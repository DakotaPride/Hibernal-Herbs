package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.FertilizerTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HerbHumusItem extends Item {
    public HerbHumusItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();

        FertilizerTypes.applyHerbHumusFunction(level, blockPos, itemStack, player);

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {

        if (!HibernalHerbsMod.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
        } else if (HibernalHerbsMod.hasShiftDown()) {

            FertilizerTypes.applyFertilizerAssistanceTooltip(stack, tooltip);

            FertilizerTypes.applyProductionValueTooltip(stack, tooltip);

            if (!HibernalHerbsMod.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
            } else {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.humus.additional_text.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.humus.additional_text.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.humus.additional_text.three").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.right_click").withStyle(ChatFormatting.DARK_GRAY));

                FertilizerTypes.applyHumusAssistanceTooltip(stack, tooltip);
            }
        }

    }

}
