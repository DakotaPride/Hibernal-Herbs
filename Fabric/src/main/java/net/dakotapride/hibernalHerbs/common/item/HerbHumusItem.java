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
            tooltip.add(Text.translatable("text.hibernalherbs.association").formatted(Formatting.GRAY));
        }

        if (Screen.hasShiftDown()) {
            if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS)) {
                tooltip.add(Text.translatable("hibernalherbs.association.none").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_OAK)) {
                tooltip.add(Text.translatable("hibernalherbs.association.oak").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_SPRUCE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.spruce").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_ACACIA)) {
                tooltip.add(Text.translatable("hibernalherbs.association.acacia").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_DARK_OAK)) {
                tooltip.add(Text.translatable("hibernalherbs.association.dark_oak").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_JUNGLE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.jungle").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_BIRCH)) {
                tooltip.add(Text.translatable("hibernalherbs.association.birch").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_MANGROVE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.mangrove").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_CRIMSON)) {
                tooltip.add(Text.translatable("hibernalherbs.association.crimson").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_WARPED)) {
                tooltip.add(Text.translatable("hibernalherbs.association.warped").formatted(Formatting.GRAY));
            } else if (this.asItem().getDefaultStack().isOf(ItemInit.HERB_HUMUS_MYQUESTE)) {
                tooltip.add(Text.translatable("hibernalherbs.association.myqueste").formatted(Formatting.GRAY));
            }

            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("text.hibernalherbs.informationalText").formatted(Formatting.GRAY));
        }

    }

}
