package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        if (level.getBlockState(blockPos).is(Blocks.STRIPPED_SPRUCE_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_SPRUCE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_ACACIA_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_ACACIA.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_OAK_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_OAK.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_DARK_OAK_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_DARK_OAK.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_BIRCH_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_BIRCH.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_JUNGLE_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_JUNGLE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_MANGROVE_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_MANGROVE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_CRIMSON_STEM)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_CRIMSON.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_WARPED_STEM)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_WARPED.get()));

        } else if (level.getBlockState(blockPos).is(blockRegistry.STRIPPED_MYQUESTE_LOG.get())) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(itemRegistry.HERB_HUMUS_MYQUESTE.get()));

        }

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {

        if (!Screen.hasShiftDown()) {
            list.add(Component.translatable("text.hibernalherbs.association").withStyle(ChatFormatting.GRAY));
        }

        if (Screen.hasShiftDown()) {
            if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS.get())) {
                list.add(Component.translatable("hibernalherbs.association.none").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_OAK.get())) {
                list.add(Component.translatable("hibernalherbs.association.oak").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_SPRUCE.get())) {
                list.add(Component.translatable("hibernalherbs.association.spruce").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_ACACIA.get())) {
                list.add(Component.translatable("hibernalherbs.association.acacia").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_DARK_OAK.get())) {
                list.add(Component.translatable("hibernalherbs.association.dark_oak").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_JUNGLE.get())) {
                list.add(Component.translatable("hibernalherbs.association.jungle").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_BIRCH.get())) {
                list.add(Component.translatable("hibernalherbs.association.birch").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_MANGROVE.get())) {
                list.add(Component.translatable("hibernalherbs.association.mangrove").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_CRIMSON.get())) {
                list.add(Component.translatable("hibernalherbs.association.crimson").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_WARPED.get())) {
                list.add(Component.translatable("hibernalherbs.association.warped").withStyle(ChatFormatting.GRAY));
            } else if (this.asItem().getDefaultInstance().is(itemRegistry.HERB_HUMUS_MYQUESTE.get())) {
                list.add(Component.translatable("hibernalherbs.association.myqueste").withStyle(ChatFormatting.GRAY));
            }

            list.add(Component.literal(" "));
            list.add(Component.translatable("text.hibernalherbs.informationalText").withStyle(ChatFormatting.GRAY));
        }

    }

}
