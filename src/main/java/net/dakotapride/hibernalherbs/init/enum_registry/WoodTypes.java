package net.dakotapride.hibernalherbs.init.enum_registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.block.ModHangingSignBlock;
import net.dakotapride.hibernalherbs.block.ModSignBlock;
import net.dakotapride.hibernalherbs.block.ModWallHangingSignBlock;
import net.dakotapride.hibernalherbs.block.ModWallSignBlock;
import net.dakotapride.hibernalherbs.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.FeaturesInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.ModBoatItem;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings({"unused"})
public enum WoodTypes {
    MYQUESTE();

    public final String wood_id;

    public final BlockSetType wood_set;
    public final WoodType wood_type;

    public final DeferredBlock<Block> leaves_block;
    public final DeferredBlock<Block> log_block;
    public final DeferredBlock<Block> stripped_log_block;
    public final DeferredBlock<Block> wood_block;
    public final DeferredBlock<Block> stripped_wood_block;
    public final DeferredBlock<Block> planks_block;
    public final DeferredBlock<Block> slab_block;
    public final DeferredBlock<Block> stairs_block;
    public final DeferredBlock<Block> fence_block;
    public final DeferredBlock<Block> fence_gate_block;
    public final DeferredBlock<Block> button_block;
    public final DeferredBlock<Block> pressure_plate_block;
    public final DeferredBlock<Block> door_block;
    public final DeferredBlock<Block> trapdoor_block;
    public final DeferredBlock<Block> sign_block;
    public final DeferredItem<Item> sign_block_item;
    public final DeferredBlock<Block> wall_sign_block;
    public final DeferredBlock<Block> hanging_sign_block;
    public final DeferredItem<Item> hanging_sign_block_item;
    public final DeferredBlock<Block> wall_hanging_sign_block;
    public final DeferredItem<Item> boat;
    public final DeferredItem<Item> chest_boat;
    public final DeferredBlock<Block> sapling;
    public final DeferredBlock<Block> potted_sapling;

    public final TreeGrower grower;

    public final TagKey<Block> logs_block_tag;
    public final TagKey<Item> logs_item_tag;

    WoodTypes() {
        this.wood_id = name().toLowerCase(Locale.ROOT);

        //this.wood_set = BlockSetTypes.register(new BlockSetType(wood_id));
        this.wood_set = BlockSetType.register(new BlockSetType(HibernalHerbsMod.MOD_ID + ":" + wood_id));
        //this.wood_type = WoodTypesUtils.register(new WoodType(wood_id, wood_set));
        this.wood_type = WoodType.register(new WoodType(HibernalHerbsMod.MOD_ID + ":" + wood_id, wood_set));

        this.leaves_block = BlockInit.register(wood_id + "_leaves", () -> Blocks.leaves(SoundType.GRASS));

        this.log_block = BlockInit.register(wood_id + "_log", () -> Blocks.log(MapColor.PODZOL, MapColor.COLOR_BROWN));
        this.stripped_log_block = BlockInit.register("stripped_" + wood_id + "_log", () -> Blocks.log(MapColor.PODZOL, MapColor.PODZOL));
        this.wood_block = BlockInit.register(wood_id + "_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.PODZOL)));
        this.stripped_wood_block = BlockInit.register("stripped_" + wood_id + "_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.PODZOL)));

        this.planks_block = BlockInit.register(wood_id + "_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));

        this.slab_block = BlockInit.register(wood_id + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));
        this.stairs_block = BlockInit.register(wood_id + "_stairs", () -> new StairBlock(planks_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));

        this.fence_block = BlockInit.register(wood_id + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.PODZOL)));
        this.fence_gate_block = BlockInit.register(wood_id + "_fence_gate", () -> new FenceGateBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PODZOL)));

        this.button_block = BlockInit.register(wood_id + "_button", () -> Blocks.woodenButton(wood_set));
        this.pressure_plate_block = BlockInit.register(wood_id + "_pressure_plate", () -> new PressurePlateBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.PODZOL)));

        this.door_block = BlockInit.register(wood_id + "_door", () -> new DoorBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.PODZOL)));
        this.trapdoor_block = BlockInit.register(wood_id + "_trapdoor", () -> new TrapDoorBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.PODZOL)));

        this.sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_sign", () -> new ModSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_sign", () -> new ModWallSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).dropsLike(sign_block.get()).mapColor(MapColor.PODZOL)));
        this.hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_hanging_sign", () -> new ModHangingSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_hanging_sign", () -> new ModWallHangingSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(hanging_sign_block.get()).mapColor(MapColor.PODZOL)));

        this.sign_block_item = ItemInit.register(wood_id + "_sign", () -> new SignItem(new Item.Properties().stacksTo(16), sign_block.get(), wall_sign_block.get()));
        this.hanging_sign_block_item = ItemInit.register(wood_id + "_hanging_sign", () -> new HangingSignItem(hanging_sign_block.get(), wall_hanging_sign_block.get(), new Item.Properties().stacksTo(16)));

        this.boat = ItemInit.register(wood_id + "_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));
        this.chest_boat = ItemInit.register(wood_id + "_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));

        this.grower  = new TreeGrower(wood_id, Optional.empty(), Optional.of(FeaturesInit.MYQUESTE_CONFIGURED), Optional.empty());

        this.sapling = BlockInit.register(wood_id + "_sapling", () -> new SaplingBlock(grower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.PODZOL)));
        this.potted_sapling = BlockInit.registerWithoutBlockItem("potted_" + wood_id + "_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, sapling, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));

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
        return leaves_block.get();
    }

    public Block getLogBlock() {
        return log_block.get();
    }

    public DeferredBlock<Block> getStrippedLogBlock() {
        return stripped_log_block;
    }

    public Block getWoodBlock() {
        return wood_block.get();
    }

    public Block getStrippedWoodBlock() {
        return stripped_wood_block.get();
    }

    public Block getPlanksBlock() {
        return planks_block.get();
    }

    public Block getStairsBlock() {
        return stairs_block.get();
    }

    public Block getSlabBlock() {
        return slab_block.get();
    }

    public Block getFenceBlock() {
        return fence_block.get();
    }

    public Block getFenceGateBlock() {
        return fence_gate_block.get();
    }

    public Block getButtonBlock() {
        return button_block.get();
    }

    public Block getPressurePlateBlock() {
        return pressure_plate_block.get();
    }

    public Block getDoorBlock() {
        return door_block.get();
    }

    public Block getTrapdoorBlock() {
        return trapdoor_block.get();
    }

    public Block getSignBlock() {
        return sign_block.get();
    }

    public Block getWallSignBlock() {
        return wall_sign_block.get();
    }

    public Block getHangingSignBlock() {
        return hanging_sign_block.get();
    }

    public Block getWallHangingSignBlock() {
        return wall_hanging_sign_block.get();
    }

    public Item getBoatItem() {
        return boat.get();
    }

    public Item getChestBoatItem() {
        return chest_boat.get();
    }

    public Block getSaplingBlock() {
        return sapling.get();
    }

    public Block getPottedSaplingBlock() {
        return potted_sapling.get();
    }

    public static void register() {
//        for (WoodTypes types : WoodTypes.values()) {
//            StrippableBlockRegistry.register(types.getLogBlock(), types.getStrippedLogBlock());
//            StrippableBlockRegistry.register(types.getWoodBlock(), types.getStrippedWoodBlock());
//        }
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
