package net.dakotapride.hibernalHerbs.common.item;


import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HerbHumusItem extends Item {
    public HerbHumusItem(Settings settings) {
        super(settings);
    }

    @Override
    public @NotNull ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = context.getStack();
        if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_SPRUCE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_SPRUCE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_ACACIA_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_ACACIA));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_OAK_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_OAK));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_DARK_OAK_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_DARK_OAK));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_BIRCH_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_BIRCH));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_JUNGLE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_JUNGLE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_MANGROVE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_MANGROVE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_CHERRY_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_CHERRY));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_CRIMSON_STEM)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_CRIMSON));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_WARPED_STEM)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_WARPED));

        } else if (world.getBlockState(blockPos).isOf(BlockInit.STRIPPED_MYQUESTE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemInit.HERB_HUMUS_MYQUESTE));

        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("text.hibernalherbs.shift.details").formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.isOf(ItemInit.HERB_FERTILIZER_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_SPRUCE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.spruce").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_BIRCH)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.birch").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_ACACIA)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.acacia").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_JUNGLE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.jungle").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_DARK_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.dark_oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_MANGROVE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.mangrove").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_CHERRY)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.cherry").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_CRIMSON)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.crimson").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemInit.HERB_FERTILIZER_WARPED)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.warped").formatted(Formatting.GRAY));
            }

            else {
                tooltip.add(Text.translatable("text.hibernalherbs.association.none").formatted(Formatting.GRAY));
            }
        }
    }

}
