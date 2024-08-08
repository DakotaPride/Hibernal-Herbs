package net.dakotapride.hibernalherbs.item;


import net.dakotapride.hibernalherbs.client.ITooltipProvider;
import net.dakotapride.hibernalherbs.registry.BlockRegistry;
import net.dakotapride.hibernalherbs.registry.ItemRegistry;
import net.dakotapride.hibernalherbs.registry.Utilities;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HerbHumusItem extends Item implements ITooltipProvider {
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

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_SPRUCE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_ACACIA_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_ACACIA));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_OAK_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_OAK));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_DARK_OAK_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_DARK_OAK));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_BIRCH_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_BIRCH));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_JUNGLE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_JUNGLE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_MANGROVE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_MANGROVE));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_CHERRY_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_CHERRY));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_CRIMSON_STEM)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_CRIMSON));

        } else if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_WARPED_STEM)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_WARPED));

        } else if (world.getBlockState(blockPos).isOf(BlockRegistry.STRIPPED_MYQUESTE_LOG)) {
            itemStack.decrement(1);

            player.giveItemStack(new ItemStack(ItemRegistry.HERB_HUMUS_MYQUESTE));

        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.isOf(ItemRegistry.HERB_HUMUS_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_SPRUCE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.spruce").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_BIRCH)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.birch").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_ACACIA)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.acacia").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_JUNGLE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.jungle").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_DARK_OAK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.dark_oak").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_MANGROVE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.mangrove").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_CHERRY)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.cherry").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_CRIMSON)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.crimson").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_WARPED)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.warped").formatted(Formatting.GRAY));
            }
            if (stack.isOf(ItemRegistry.HERB_HUMUS_MYQUESTE)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.myqueste").formatted(Formatting.GRAY));
            }

            else if (!stack.isIn(Utilities.HUMUS_ITEM_TAG)) {
                tooltip.add(Text.translatable("text.hibernalherbs.association.none").formatted(Formatting.GRAY));
            }

            getProductionValueTooltip(stack, tooltip);

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.humus.additional_text.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.humus.additional_text.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.humus.additional_text.three").formatted(Formatting.DARK_PURPLE));

                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(rightClickControlsText).formatted(Formatting.DARK_GRAY));

                getAssociationTooltip(stack, tooltip);
            }
        }
    }

    public static void getAssociationTooltip(ItemStack stack, List<Text> tooltip) {
        MutableText association = Associations.NONE.getTranslatableAssociation();

        if (stack.isOf(ItemRegistry.HERB_HUMUS_OAK)) {
            association = Associations.OAK.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_SPRUCE)) {
            association = Associations.SPRUCE.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_BIRCH)) {
            association = Associations.BIRCH.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_ACACIA)) {
            association = Associations.ACACIA.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_JUNGLE)) {
            association = Associations.JUNGLE.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_DARK_OAK)) {
            association = Associations.DARK_OAK.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_MANGROVE)) {
            association = Associations.MANGROVE.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_CHERRY)) {
            association = Associations.CHERRY.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_CRIMSON)) {
            association = Associations.CRIMSON.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_WARPED)) {
            association = Associations.WARPED.getTranslatableAssociation();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_MYQUESTE)) {
            association = Associations.MYQUESTE.getTranslatableAssociation();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.humus.usage.first").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.humus.usage.secondary", association).formatted(Formatting.DARK_PURPLE));

    }

    public static void getProductionValueTooltip(ItemStack stack, List<Text> tooltip) {
        int productionValue = Associations.NONE.getProductionValue();

        if (stack.isOf(ItemRegistry.HERB_HUMUS_OAK) || stack.isOf(ItemRegistry.HERB_FERTILIZER_OAK)) {
            productionValue = Associations.OAK.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_SPRUCE) || stack.isOf(ItemRegistry.HERB_FERTILIZER_SPRUCE)) {
            productionValue = Associations.SPRUCE.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_BIRCH) || stack.isOf(ItemRegistry.HERB_FERTILIZER_BIRCH)) {
            productionValue = Associations.BIRCH.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_ACACIA) || stack.isOf(ItemRegistry.HERB_FERTILIZER_ACACIA)) {
            productionValue = Associations.ACACIA.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_JUNGLE) || stack.isOf(ItemRegistry.HERB_FERTILIZER_JUNGLE)) {
            productionValue = Associations.JUNGLE.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_DARK_OAK) || stack.isOf(ItemRegistry.HERB_FERTILIZER_DARK_OAK)) {
            productionValue = Associations.DARK_OAK.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_MANGROVE) || stack.isOf(ItemRegistry.HERB_FERTILIZER_MANGROVE)) {
            productionValue = Associations.MANGROVE.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_CHERRY) || stack.isOf(ItemRegistry.HERB_FERTILIZER_CHERRY)) {
            productionValue = Associations.CHERRY.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_CRIMSON) || stack.isOf(ItemRegistry.HERB_FERTILIZER_CRIMSON)) {
            productionValue = Associations.CRIMSON.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_WARPED) || stack.isOf(ItemRegistry.HERB_FERTILIZER_WARPED)) {
            productionValue = Associations.WARPED.getProductionValue();
        }
        if (stack.isOf(ItemRegistry.HERB_HUMUS_MYQUESTE) || stack.isOf(ItemRegistry.HERB_FERTILIZER_MYQUESTE)) {
            productionValue = Associations.MYQUESTE.getProductionValue();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.humus.production", productionValue).formatted(Formatting.GRAY));
    }

}
