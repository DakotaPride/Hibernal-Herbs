package net.dakotapride.hibernalherbs.init.enum_registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public enum StoneTypes {
    IDIOSYNCRATIC_STONE(Tags.Blocks.IDIOSYNCRATIC_STONE_TYPE.getTag(), Tags.Items.IDIOSYNCRATIC_STONE_TYPE.getTag()),
    NECROMANTIC_STONE(Tags.Blocks.NECROMANTIC_STONE_TYPE.getTag(), Tags.Items.NECROMANTIC_STONE_TYPE.getTag());

    public final String stone_id;

    public final BlockSetType set_type;

    public final Block base_block;
    public final Block cobbled_block;
    public final Block polished_block;
    public final Block bricks_block;
    public final Block slab_block;
    public final Block cobbled_slab_block;
    public final Block polished_slab_block;
    public final Block brick_slab_block;
    public final Block stairs_block;
    public final Block cobbled_stairs_block;
    public final Block polished_stairs_block;
    public final Block brick_stairs_block;
    public final Block wall_block;
    public final Block cobbled_wall_block;
    public final Block polished_wall_block;
    public final Block brick_wall_block;
    public final Block button_block;
    //public final Block polished_button_block;
    //public final Block brick_button_block;
    public final Block pressure_plate_block;
    //public final Block cobbled_pressure_plate_block;
    //public final Block polished_pressure_plate_block;
    //public final Block brick_pressure_plate_block;

    public final TagKey<Block> tag;
    public final TagKey<Item> tag0;

    StoneTypes(TagKey<Block> stone_tag, TagKey<Item> item_tag) {
        this.stone_id = name().toLowerCase(Locale.ROOT);

        this.set_type = BlockSetTypes.register(new BlockSetType(stone_id));

        this.tag = stone_tag;
        this.tag0 = item_tag;

        this.base_block = BlockInit.register(stone_id, new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));
        this.cobbled_block = BlockInit.register("cobbled_" + stone_id, new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));
        this.polished_block = BlockInit.register("polished_" + stone_id, new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));
        this.bricks_block = BlockInit.register(stone_id + "_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops()));

        this.slab_block = BlockInit.register(stone_id + "_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
        this.cobbled_slab_block = BlockInit.register("cobbled_" + stone_id + "_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
        this.polished_slab_block = BlockInit.register("polished_" + stone_id + "_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
        this.brick_slab_block = BlockInit.register(stone_id + "_brick_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).requiresCorrectToolForDrops()));

        this.stairs_block = BlockInit.register(stone_id + "_stairs", new StairBlock(base_block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
        this.cobbled_stairs_block = BlockInit.register("cobbled_" + stone_id + "_stairs", new StairBlock(cobbled_block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
        this.polished_stairs_block = BlockInit.register("polished_" + stone_id + "_stairs", new StairBlock(polished_block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
        this.brick_stairs_block = BlockInit.register(stone_id + "_brick_stairs", new StairBlock(bricks_block.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));

        this.wall_block = BlockInit.register(stone_id + "_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));
        this.cobbled_wall_block = BlockInit.register("cobbled_" + stone_id + "_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));
        this.polished_wall_block = BlockInit.register("polished_" + stone_id + "_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));
        this.brick_wall_block = BlockInit.register(stone_id + "_brick_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        this.button_block = BlockInit.register(stone_id + "_button", new ButtonBlock(set_type, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).requiresCorrectToolForDrops()));
        this.pressure_plate_block = BlockInit.register(stone_id + "_pressure_plate", new PressurePlateBlock(set_type, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).requiresCorrectToolForDrops()));
    }

    public String getStoneId() {
        return stone_id;
    }

    public TagKey<Block> getBlockTag() {
        return tag;
    }

    public TagKey<Item> getItemTag() {
        return tag0;
    }

    public Block getBaseBlock() {
        return base_block;
    }

    public Block getSlabBlock() {
        return slab_block;
    }

    public Block getStairsBlock() {
        return stairs_block;
    }

    public Block getWallBlock() {
        return wall_block;
    }

    public Block getButtonBlock() {
        return button_block;
    }

    public Block getPressurePlateBlock() {
        return pressure_plate_block;
    }

    public Block getCobbledBlock() {
        return cobbled_block;
    }

    public Block getCobbledSlabBlock() {
        return cobbled_slab_block;
    }

    public Block getCobbledStairsBlock() {
        return cobbled_stairs_block;
    }

    public Block getCobbledWallBlock() {
        return cobbled_wall_block;
    }

    public Block getPolishedBlock() {
        return polished_block;
    }

    public Block getPolishedSlabBlock() {
        return polished_slab_block;
    }

    public Block getPolishedStairsBlock() {
        return polished_stairs_block;
    }

    public Block getPolishedWallBlock() {
        return polished_wall_block;
    }

    public Block getBricksBlock() {
        return bricks_block;
    }

    public Block getBrickSlabBlock() {
        return brick_slab_block;
    }

    public Block getBrickStairsBlock() {
        return brick_stairs_block;
    }

    public Block getBrickWallBlock() {
        return brick_wall_block;
    }

    public static void register() {}

    public static class BlockSetTypes {
        private static final Map<String, BlockSetType> TYPES = new Object2ObjectArrayMap<>();

        private static BlockSetType register(BlockSetType blockSetType) {
            TYPES.put(HibernalHerbsMod.MOD_ID + ":" + blockSetType.name(), blockSetType);
            return blockSetType;
        }

        public static Stream<BlockSetType> values() {
            return TYPES.values().stream();
        }

        static {
            Objects.requireNonNull(TYPES);
        }
    }
}
