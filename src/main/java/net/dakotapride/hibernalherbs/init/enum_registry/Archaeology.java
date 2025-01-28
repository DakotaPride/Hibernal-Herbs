package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.block.ModBrushableBlock;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.ModBrushItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.Locale;

public class Archaeology {

    public enum Metals {
        ARKONIUM(),
        SYRUM();

        public final String metal_id;

        public final Item ingot;
        public final Item nugget;
        public final Block block;

        public Item alloy_ingredient0;
        public Item alloy_ingredient1;
        public Item scrap_item;

        Metals() {
            this.metal_id = name().toLowerCase(Locale.ROOT);

            this.ingot = ItemInit.register(metal_id + "_ingot", new Item(new Item.Properties()));
            this.nugget = ItemInit.register(metal_id + "_nugget", new Item(new Item.Properties()));
            this.block = BlockInit.register(metal_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));
        }

        Metals(Item alloy_ingredient0, Item alloy_ingredient1) {
            this.metal_id = name().toLowerCase(Locale.ROOT);

            this.ingot = ItemInit.register(metal_id + "_alloy", new Item(new Item.Properties()));
            this.alloy_ingredient0 = alloy_ingredient0;
            this.alloy_ingredient1 = alloy_ingredient1;
            //this.scrap_item = ItemInit.register(metal_id + "_scrap", new Item(new Item.Properties()));

            this.nugget = ItemInit.register(metal_id + "_nugget", new Item(new Item.Properties()));
            this.block = BlockInit.register(metal_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));
        }

        Metals(Item alloy_ingredient0) {
            this.metal_id = name().toLowerCase(Locale.ROOT);

            this.ingot = ItemInit.register(metal_id + "_alloy", new Item(new Item.Properties()));
            this.alloy_ingredient0 = alloy_ingredient0;
            this.alloy_ingredient1 = scrap_item;
            this.scrap_item = ItemInit.register(metal_id + "_scrap", new Item(new Item.Properties()));

            this.nugget = ItemInit.register(metal_id + "_nugget", new Item(new Item.Properties()));
            this.block = BlockInit.register(metal_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));
        }

        public String getMetalId() {
            return metal_id;
        }

        public boolean isAlloy() {
            return alloy_ingredient0 != null;
        }

        public Item getAlloyIngredient() {
            return alloy_ingredient0;
        }

        public Item getSecondaryAlloyIngredient() {
            return alloy_ingredient1;
        }

        public Item getScrapItem() {
            return scrap_item;
        }

        public Item getIngotItem() {
            return ingot;
        }

        public Item getNuggetItem() {
            return nugget;
        }

        public Block getBlock() {
            return block;
        }

        public static void register() {}
    }

    public enum Brushes {
        SYRUM(Metals.SYRUM),;

        public final String brush_id;

        public final Item brush;
        public final Metals metal;

        Brushes(Metals metal) {
            this.brush_id = name().toLowerCase(Locale.ROOT);

            this.metal = metal;

            this.brush = ItemInit.register(brush_id + "_brush", new ModBrushItem(new Item.Properties().durability(96).stacksTo(1)));
        }

        public String getBrushId() {
            return brush_id;
        }

        public Item getBrushItem() {
            return brush;
        }

        public static void register() {}
    }

    public enum SuspiciousBlocks {
        //DIRT(Blocks.DIRT, false),
        END_STONE(Blocks.END_STONE, Tags.Blocks.REQUIRES_HIGH_TIER_BRUSH.getTag(), true);

        public final String block_id;

        public final Block block;
        public final Block turns_to;
        public final boolean requires_tier_above_basic;

        public TagKey<Block> brushable_by;

        SuspiciousBlocks(Block turns_to, boolean requires_tier_above_basic) {
            this.block_id = name().toLowerCase(Locale.ROOT);

            this.turns_to = turns_to;
            this.requires_tier_above_basic = requires_tier_above_basic;

            this.block = BlockInit.register("suspicious_" + block_id,
                    new ModBrushableBlock(turns_to,
                            SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED,
                            BlockBehaviour.Properties.ofFullCopy(turns_to).pushReaction(PushReaction.DESTROY)));
        }

        SuspiciousBlocks(Block turns_to, TagKey<Block> brushable_by, boolean requires_tier_above_basic) {
            this.block_id = name().toLowerCase(Locale.ROOT);

            this.turns_to = turns_to;
            this.requires_tier_above_basic = requires_tier_above_basic;
            this.brushable_by = brushable_by;

            this.block = BlockInit.register("suspicious_" + block_id,
                    new ModBrushableBlock(turns_to,
                            SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED,
                            BlockBehaviour.Properties.ofFullCopy(turns_to).pushReaction(PushReaction.DESTROY)));
        }

        public String getBlockId() {
            return block_id;
        }

        public Block getTransitionStateBlock() {
            return turns_to;
        }

        public boolean requiresTierAboveBasicBrush() {
            return requires_tier_above_basic;
        }

        public TagKey<Block> getBrushableByTagKey() {
            return brushable_by;
        }

        public Block getBlock() {
            return block;
        }

        public static void register() {}
    }

    public enum Ashes {
        PRIDE(),
        SLOTH(),
        WRATH(),
        LUST(),
        GREED(),
        GLUTTONY(),
        ENVY();

        public final String ashes_id;

        public final Item ashes;

        Ashes() {
            this.ashes_id = name().toLowerCase(Locale.ROOT);

            this.ashes = ItemInit.register(ashes_id + "_ashes", new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
        }

        public String getAshesId() {
            return ashes_id;
        }

        public Item getAshesItem() {
            return ashes;
        }

        public static void register() {}
    }

    public static void register() {
        Metals.register();
        Brushes.register();
        SuspiciousBlocks.register();
        Ashes.register();
    }

}
