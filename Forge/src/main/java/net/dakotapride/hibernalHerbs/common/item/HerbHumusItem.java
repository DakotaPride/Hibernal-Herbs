package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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

public class HerbHumusItem extends Item implements ITooltipProvider {
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

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_SPRUCE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_ACACIA_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_ACACIA.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_OAK_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_OAK.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_DARK_OAK_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_DARK_OAK.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_BIRCH_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_BIRCH.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_JUNGLE_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_JUNGLE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_MANGROVE_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_MANGROVE.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_CHERRY_LOG)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_CHERRY.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_CRIMSON_STEM)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_CRIMSON.get()));

        } else if (level.getBlockState(blockPos).is(Blocks.STRIPPED_WARPED_STEM)) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_WARPED.get()));

        } else if (level.getBlockState(blockPos).is(BlockRegistry.STRIPPED_MYQUESTE_LOG.get())) {
            itemStack.shrink(1);

            player.addItem(new ItemStack(ItemRegistry.HERB_HUMUS_MYQUESTE.get()));

        }

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {

        if (!Screen.hasShiftDown()) {
            list.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.is(ItemRegistry.HERB_HUMUS_OAK.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.oak").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_SPRUCE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.spruce").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_BIRCH.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.birch").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_ACACIA.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.acacia").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_JUNGLE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.jungle").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_DARK_OAK.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.dark_oak").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_MANGROVE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.mangrove").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_CHERRY.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.cherry").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_CRIMSON.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.crimson").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_WARPED.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.warped").withStyle(ChatFormatting.GRAY));
            }
            if (stack.is(ItemRegistry.HERB_HUMUS_MYQUESTE.get())) {
                list.add(Component.translatable("text.hibernalherbs.association.myqueste").withStyle(ChatFormatting.GRAY));
            }

            else if (!stack.is(HibernalHerbsForge.HUMUS_TAG)) {
                list.add(Component.translatable("text.hibernalherbs.association.none").withStyle(ChatFormatting.GRAY));
            }

            getProductionValueTooltip(stack, list);

            if (!Screen.hasAltDown()) {
                list.add(Component.literal(""));
                list.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
            } else {
                list.add(Component.literal(""));
                list.add(Component.translatable("text.hibernalherbs.humus.additional_text.one").withStyle(ChatFormatting.DARK_PURPLE));
                list.add(Component.translatable("text.hibernalherbs.humus.additional_text.two").withStyle(ChatFormatting.DARK_PURPLE));
                list.add(Component.translatable("text.hibernalherbs.humus.additional_text.three").withStyle(ChatFormatting.DARK_PURPLE));

                list.add(Component.literal(""));
                list.add(Component.translatable(rightClickControlsText).withStyle(ChatFormatting.DARK_GRAY));

                getAssociationTooltip(stack, list);
            }
        }

    }

    public static void getAssociationTooltip(ItemStack stack, List<Component> tooltip) {
        MutableComponent association = Associations.NONE.getTranslatableAssociation();

        if (stack.is(ItemRegistry.HERB_HUMUS_OAK.get())) {
            association = Associations.OAK.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_SPRUCE.get())) {
            association = Associations.SPRUCE.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_BIRCH.get())) {
            association = Associations.BIRCH.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_ACACIA.get())) {
            association = Associations.ACACIA.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_JUNGLE.get())) {
            association = Associations.JUNGLE.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_DARK_OAK.get())) {
            association = Associations.DARK_OAK.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_MANGROVE.get())) {
            association = Associations.MANGROVE.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_CHERRY.get())) {
            association = Associations.CHERRY.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_CRIMSON.get())) {
            association = Associations.CRIMSON.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_WARPED.get())) {
            association = Associations.WARPED.getTranslatableAssociation();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_MYQUESTE.get())) {
            association = Associations.MYQUESTE.getTranslatableAssociation();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.humus.usage.first").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.humus.usage.secondary", association).withStyle(ChatFormatting.DARK_PURPLE));

    }

    public static void getProductionValueTooltip(ItemStack stack, List<Component> tooltip) {
        int productionValue = Associations.NONE.getProductionValue();

        if (stack.is(ItemRegistry.HERB_HUMUS_OAK.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_OAK.get())) {
            productionValue = Associations.OAK.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_SPRUCE.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_SPRUCE.get())) {
            productionValue = Associations.SPRUCE.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_BIRCH.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_BIRCH.get())) {
            productionValue = Associations.BIRCH.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_ACACIA.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_ACACIA.get())) {
            productionValue = Associations.ACACIA.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_JUNGLE.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_JUNGLE.get())) {
            productionValue = Associations.JUNGLE.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_DARK_OAK.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_DARK_OAK.get())) {
            productionValue = Associations.DARK_OAK.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_MANGROVE.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_MANGROVE.get())) {
            productionValue = Associations.MANGROVE.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_CHERRY.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_CHERRY.get())) {
            productionValue = Associations.CHERRY.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_CRIMSON.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_CRIMSON.get())) {
            productionValue = Associations.CRIMSON.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_WARPED.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_WARPED.get())) {
            productionValue = Associations.WARPED.getProductionValue();
        }
        if (stack.is(ItemRegistry.HERB_HUMUS_MYQUESTE.get()) || stack.is(ItemRegistry.HERB_FERTILIZER_MYQUESTE.get())) {
            productionValue = Associations.MYQUESTE.getProductionValue();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.humus.production", productionValue).withStyle(ChatFormatting.GRAY));
    }

}
