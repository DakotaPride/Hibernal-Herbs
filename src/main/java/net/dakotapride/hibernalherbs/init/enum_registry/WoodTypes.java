package net.dakotapride.hibernalherbs.init.enum_registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.block.ModHangingSignBlock;
import net.dakotapride.hibernalherbs.block.ModSignBlock;
import net.dakotapride.hibernalherbs.block.ModWallHangingSignBlock;
import net.dakotapride.hibernalherbs.block.ModWallSignBlock;
import net.dakotapride.hibernalherbs.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalherbs.grower.MyquesteTreeGrower;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.ModBoatItem;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@SuppressWarnings({"unused"})
public enum WoodTypes {
    MYQUESTE();

    public final String wood_id;

    public final BlockSetType wood_set;
    public final WoodType wood_type;

    public final Block leaves_block;
    public final Block log_block;
    public final Block stripped_log_block;
    public final Block wood_block;
    public final Block stripped_wood_block;
    public final Block planks_block;
    public final Block slab_block;
    public final Block stairs_block;
    public final Block fence_block;
    public final Block fence_gate_block;
    public final Block button_block;
    public final Block pressure_plate_block;
    public final Block door_block;
    public final Block trapdoor_block;
    public final Block sign_block;
    public final Item sign_block_item;
    public final Block wall_sign_block;
    public final Block hanging_sign_block;
    public final Item hanging_sign_block_item;
    public final Block wall_hanging_sign_block;
    public final Item boat;
    public final Item chest_boat;
    public final Block sapling;
    public final Block potted_sapling;

    public final MyquesteTreeGrower grower;

    public final TagKey<Block> logs_block_tag;
    public final TagKey<Item> logs_item_tag;

    WoodTypes() {
        this.wood_id = name().toLowerCase(Locale.ROOT);

        this.wood_set = BlockSetTypes.register(new BlockSetType(wood_id));
        this.wood_type = WoodTypesUtils.register(new WoodType(wood_id, wood_set));

        this.leaves_block = BlockInit.register(wood_id + "_leaves", Blocks.leaves(SoundType.GRASS));

        this.log_block = BlockInit.register(wood_id + "_log", Blocks.log(MapColor.PODZOL, MapColor.COLOR_BROWN));
        this.stripped_log_block = BlockInit.register("stripped_" + wood_id + "_log", Blocks.log(MapColor.PODZOL, MapColor.PODZOL));
        this.wood_block = BlockInit.register(wood_id + "_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.PODZOL)));
        this.stripped_wood_block = BlockInit.register("stripped_" + wood_id + "_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.PODZOL)));

        this.planks_block = BlockInit.register(wood_id + "_planks", new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));

        this.slab_block = BlockInit.register(wood_id + "_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));
        this.stairs_block = BlockInit.register(wood_id + "_stairs", new StairBlock(planks_block.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));

        this.fence_block = BlockInit.register(wood_id + "_fence", new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(MapColor.PODZOL)));
        this.fence_gate_block = BlockInit.register(wood_id + "_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PODZOL), wood_type));

        this.button_block = BlockInit.register(wood_id + "_button", Blocks.woodenButton(wood_set));
        this.pressure_plate_block = BlockInit.register(wood_id + "_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.PODZOL), wood_set));

        this.door_block = BlockInit.register(wood_id + "_door", new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(MapColor.PODZOL), wood_set));
        this.trapdoor_block = BlockInit.register(wood_id + "_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.PODZOL), wood_set));

        this.sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_sign", new ModSignBlock(wood_type, BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_sign", new ModWallSignBlock(wood_type, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(sign_block).mapColor(MapColor.PODZOL)));
        this.hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_hanging_sign", new ModHangingSignBlock(wood_type, BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_hanging_sign", new ModWallHangingSignBlock(wood_type, BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(hanging_sign_block).mapColor(MapColor.PODZOL)));

        this.sign_block_item = ItemInit.register(wood_id + "_sign", new SignItem(new Item.Properties().stacksTo(16), sign_block, wall_sign_block));
        this.hanging_sign_block_item = ItemInit.register(wood_id + "_hanging_sign", new HangingSignItem(hanging_sign_block, wall_hanging_sign_block, new Item.Properties().stacksTo(16)));

        this.boat = ItemInit.register(wood_id + "_boat", new ModBoatItem(false, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));
        this.chest_boat = ItemInit.register(wood_id + "_chest_boat", new ModBoatItem(true, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));

        this.grower  = new MyquesteTreeGrower();

        this.sapling = BlockInit.register(wood_id + "_sapling", new SaplingBlock(grower, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).mapColor(MapColor.PODZOL)));
        this.potted_sapling = BlockInit.registerWithoutBlockItem("potted_" + wood_id + "_sapling", new FlowerPotBlock(sapling, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

        this.logs_block_tag = Tags.Blocks.create(wood_id + "_logs");
        this.logs_item_tag = Tags.Items.create(wood_id + "_logs");
    }

    public String getWoodId() {
        return wood_id;
    }

    public BlockSetType getWoodSet() {
        return wood_set;
    }

    public WoodType getWoodType() {
        return wood_type;
    }

    public TagKey<Block> getLogsBlockTag() {
        return logs_block_tag;
    }

    public TagKey<Item> getLogsItemTag() {
        return logs_item_tag;
    }

    public Block getLeavesBlock() {
        return leaves_block;
    }

    public Block getLogBlock() {
        return log_block;
    }

    public Block getStrippedLogBlock() {
        return stripped_log_block;
    }

    public Block getWoodBlock() {
        return wood_block;
    }

    public Block getStrippedWoodBlock() {
        return stripped_wood_block;
    }

    public Block getPlanksBlock() {
        return planks_block;
    }

    public Block getStairsBlock() {
        return stairs_block;
    }

    public Block getSlabBlock() {
        return slab_block;
    }

    public Block getFenceBlock() {
        return fence_block;
    }

    public Block getFenceGateBlock() {
        return fence_gate_block;
    }

    public Block getButtonBlock() {
        return button_block;
    }

    public Block getPressurePlateBlock() {
        return pressure_plate_block;
    }

    public Block getDoorBlock() {
        return door_block;
    }

    public Block getTrapdoorBlock() {
        return trapdoor_block;
    }

    public Block getSignBlock() {
        return sign_block;
    }

    public Block getWallSignBlock() {
        return wall_sign_block;
    }

    public Block getHangingSignBlock() {
        return hanging_sign_block;
    }

    public Block getWallHangingSignBlock() {
        return wall_hanging_sign_block;
    }

    public Item getBoatItem() {
        return boat;
    }

    public Item getChestBoatItem() {
        return chest_boat;
    }

    public Block getSaplingBlock() {
        return sapling;
    }

    public Block getPottedSaplingBlock() {
        return potted_sapling;
    }

    public static void register() {
        for (WoodTypes types : WoodTypes.values()) {
            StrippableBlockRegistry.register(types.getLogBlock(), types.getStrippedLogBlock());
            StrippableBlockRegistry.register(types.getWoodBlock(), types.getStrippedWoodBlock());
        }
    }

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

    public static class WoodTypesUtils {
        private static final Map<String, WoodType> TYPES = new Object2ObjectArrayMap<>();

        private static WoodType register(WoodType woodType) {
            TYPES.put(HibernalHerbsMod.MOD_ID + ":" + woodType.name(), woodType);
            return woodType;
        }

        public static Stream<WoodType> values() {
            return TYPES.values().stream();
        }

        static {
            Objects.requireNonNull(TYPES);
        }
    }
}
