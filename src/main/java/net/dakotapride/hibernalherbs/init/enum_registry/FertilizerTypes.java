package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.CriteriaTriggersInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.StatsInit;
import net.dakotapride.hibernalherbs.item.HerbFertilizerItem;
import net.dakotapride.hibernalherbs.item.HerbHumusItem;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused"})
public enum FertilizerTypes {
    NONE("text.nothing_to_see_here.null_registry", 0),
    OAK(Blocks.STRIPPED_OAK_LOG, 3),
    SPRUCE(Blocks.STRIPPED_SPRUCE_LOG, 4),
    BIRCH(Blocks.STRIPPED_BIRCH_LOG, 3),
    ACACIA(Blocks.STRIPPED_ACACIA_LOG, 2),
    CHERRY(Blocks.STRIPPED_CHERRY_LOG, 3),
    JUNGLE(Blocks.STRIPPED_JUNGLE_LOG, 3),
    DARK_OAK(Blocks.STRIPPED_DARK_OAK_LOG, 3),
    CRIMSON(Blocks.STRIPPED_CRIMSON_STEM, 2),
    WARPED(Blocks.STRIPPED_WARPED_STEM, 2),
    MANGROVE(Blocks.STRIPPED_MANGROVE_LOG, 3),
    BAMBOO(Blocks.STRIPPED_BAMBOO_BLOCK, 3),
    MYQUESTE(WoodTypes.MYQUESTE.getStrippedLogBlock(), 4);

    public final String fertilizer_id;


    public Item herbal_fertilizer;
    public final Item herbal_humus;
    public final int production_value;

    public Block from_block;

    FertilizerTypes(Block block, int prod_value) {
        this.fertilizer_id = name().toLowerCase(Locale.ROOT);
        this.production_value = prod_value;

        this.herbal_fertilizer = ItemInit.register(fertilizer_id + "_herb_fertilizer", new HerbFertilizerItem(new Item.Properties().stacksTo(16)));
        this.herbal_humus = ItemInit.register(fertilizer_id + "_herb_humus", new HerbHumusItem(new Item.Properties().stacksTo(16)));

        this.from_block = block;
    }

    FertilizerTypes(String nothing, int prod_value) {
        this.fertilizer_id = name().toLowerCase(Locale.ROOT);
        this.production_value = prod_value;

        this.herbal_humus = ItemInit.register("herb_humus", new HerbHumusItem(new Item.Properties()));
    }

    public Item getFertilizerItem() {
        return herbal_fertilizer;
    }

    public Item getHerbHumusItem() {
        return herbal_humus;
    }

    public Block getBlockFrom() {
        return from_block;
    }

    public int getProductionValue() {
        return production_value;
    }

    public String getFertilizerId() {
        return fertilizer_id;
    }

    public static void register() {}

    private static boolean isValidType(FertilizerTypes type) {
        return type != FertilizerTypes.NONE;
    }

    public static boolean checkHerbalFertilizer(ItemStack stack, FertilizerTypes type) {
        return isValidType(type) && stack.getItem() == type.getFertilizerItem();
    }

    public static boolean checkHerbalHumus(ItemStack stack, FertilizerTypes type) {
        return isValidType(type) && stack.getItem() == type.getHerbHumusItem();
    }

    // Tooltips

    public static void getFertilizerAssistance(ItemStack stack, List<Component> tooltip, FertilizerTypes type) {
        if (checkHerbalFertilizer(stack, type)) {
            tooltip.add(Component.translatable("text.hibernalherbs.association." + type.getFertilizerId()).withStyle(ChatFormatting.GRAY));
        }
    }

    public static void getUniversalAssistance(ItemStack stack, List<Component> tooltip, FertilizerTypes type) {
        if (isValidType(type) && checkHerbalFertilizer(stack, type)) {
            tooltip.add(Component.translatable("text.hibernalherbs.association." + type.getFertilizerId()).withStyle(ChatFormatting.GRAY));
        } else if (isValidType(type) && checkHerbalHumus(stack, type)) {
            tooltip.add(Component.translatable("text.hibernalherbs.association." + type.getFertilizerId()).withStyle(ChatFormatting.GRAY));
        }
    }

    public static void applyFertilizerAssistanceTooltip(ItemStack stack, List<Component> tooltip) {
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.OAK);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.SPRUCE);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.BIRCH);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.ACACIA);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.CHERRY);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.JUNGLE);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.DARK_OAK);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.CRIMSON);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.WARPED);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.MANGROVE);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.BAMBOO);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.MYQUESTE);
        FertilizerTypes.getUniversalAssistance(stack, tooltip, FertilizerTypes.NONE);

        // Required check for herbal humus inside of fertilizer method
//        if (checkHerbalHumus(stack, FertilizerTypes.NONE)) {
//            tooltip.add(Component.translatable("text.hibernalherbs.association." + FertilizerTypes.NONE.getFertilizerId()).withStyle(ChatFormatting.GRAY));
//        }
    }

    public static void getProductionValue(ItemStack stack, List<Component> tooltip, FertilizerTypes type) {
        if (checkHerbalHumus(stack, type) || (isValidType(type) && checkHerbalFertilizer(stack, type))) {
            tooltip.add(Component.translatable("text.hibernalherbs.humus.production", type.getProductionValue()).withStyle(ChatFormatting.GRAY));
        }
    }

    public static void applyProductionValueTooltip(ItemStack stack, List<Component> tooltip) {
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.OAK);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.SPRUCE);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.BIRCH);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.ACACIA);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.CHERRY);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.JUNGLE);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.DARK_OAK);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.CRIMSON);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.WARPED);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.MANGROVE);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.BAMBOO);
        FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.MYQUESTE);
        if (checkHerbalHumus(stack, FertilizerTypes.NONE)) {
            FertilizerTypes.getProductionValue(stack, tooltip, FertilizerTypes.NONE);
        }
    }

    public static void getHumusAssistance(ItemStack stack, List<Component> tooltip, FertilizerTypes type) {
        if (checkHerbalHumus(stack, type)) {
            tooltip.add(Component.translatable("text.hibernalherbs.humus.usage.first").withStyle(ChatFormatting.DARK_PURPLE));
            tooltip.add(Component.translatable("text.hibernalherbs.humus.usage.secondary", Component.translatable("text.hibernalherbs.association.help." + type.getFertilizerId())).withStyle(ChatFormatting.DARK_PURPLE));
        }
    }

    public static void applyHumusAssistanceTooltip(ItemStack stack, List<Component> tooltip) {
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.OAK);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.SPRUCE);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.BIRCH);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.ACACIA);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.CHERRY);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.JUNGLE);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.DARK_OAK);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.CRIMSON);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.WARPED);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.MANGROVE);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.BAMBOO);
        FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.MYQUESTE);
        if (checkHerbalHumus(stack, FertilizerTypes.NONE)) {
            FertilizerTypes.getHumusAssistance(stack, tooltip, FertilizerTypes.NONE);
        }
    }

    // Humus "recipes"

    public static void createHerbHumus(Level level, BlockPos blockPos, ItemStack itemStack, Player player, FertilizerTypes type) {
        if (level.getBlockState(blockPos).is(type.getBlockFrom())) {
            itemStack.shrink(1);
            player.addItem(new ItemStack(type.getHerbHumusItem(), 1));
            player.getCooldowns().addCooldown(itemStack.getItem(), 10);

            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
                CriteriaTriggersInit.USE_HERB_HUMUS_ON_LOG.trigger(serverPlayer, blockPos, itemStack);
                serverPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                serverPlayer.awardStat(StatsInit.USE_HERB_HUMUS_ON_LOG.get(type.getBlockFrom()));
            }
        }
    }

    public static void applyHerbHumusFunction(Level level, BlockPos blockPos, ItemStack itemStack, Player player) {
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.OAK);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.SPRUCE);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.BIRCH);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.ACACIA);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.CHERRY);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.JUNGLE);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.DARK_OAK);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.CRIMSON);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.WARPED);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.MANGROVE);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.BAMBOO);
        FertilizerTypes.createHerbHumus(level, blockPos, itemStack, player, FertilizerTypes.MYQUESTE);
    }
}
