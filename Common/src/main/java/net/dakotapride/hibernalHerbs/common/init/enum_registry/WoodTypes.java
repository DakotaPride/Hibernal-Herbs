package net.dakotapride.hibernalHerbs.common.init.enum_registry;

import dev.architectury.registry.registries.RegistrySupplier;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.block.ModHangingSignBlock;
import net.dakotapride.hibernalHerbs.common.block.ModSignBlock;
import net.dakotapride.hibernalHerbs.common.block.ModWallHangingSignBlock;
import net.dakotapride.hibernalHerbs.common.block.ModWallSignBlock;
import net.dakotapride.hibernalHerbs.common.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.item.ModBoatItem;
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

    public final RegistrySupplier<Block> leaves_block;
    public final RegistrySupplier<Block> log_block;
    public final RegistrySupplier<Block> stripped_log_block;
    public final RegistrySupplier<Block> wood_block;
    public final RegistrySupplier<Block> stripped_wood_block;
    public final RegistrySupplier<Block> planks_block;
    public final RegistrySupplier<Block> fence_block;
    public final RegistrySupplier<Block> fence_gate_block;
    public final RegistrySupplier<Block> button_block;
    public final RegistrySupplier<Block> pressure_plate_block;
    public final RegistrySupplier<Block> door_block;
    public final RegistrySupplier<Block> trapdoor_block;
    public final RegistrySupplier<Block> sign_block;
    public final RegistrySupplier<Item> sign_block_item;
    public final RegistrySupplier<Block> wall_sign_block;
    public final RegistrySupplier<Block> hanging_sign_block;
    public final RegistrySupplier<Item> hanging_sign_block_item;
    public final RegistrySupplier<Block> wall_hanging_sign_block;
    public final RegistrySupplier<Item> boat;
    public final RegistrySupplier<Item> chest_boat;

    WoodTypes() {
        this.wood_id = name().toLowerCase(Locale.ROOT);

        this.wood_set = BlockSetTypes.register(new BlockSetType("myqueste"));
        this.wood_type = WoodTypesUtils.register(new WoodType("myqueste", wood_set));

        this.leaves_block = BlockInit.register(wood_id + "_leaves", Blocks.leaves(SoundType.GRASS));

        this.log_block = BlockInit.register(wood_id + "_log", Blocks.log(MapColor.PODZOL, MapColor.COLOR_BROWN));
        this.stripped_log_block = BlockInit.register("stripped_" + wood_id + "_log", Blocks.log(MapColor.PODZOL, MapColor.PODZOL));
        this.wood_block = BlockInit.register(wood_id + "_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.PODZOL)));
        this.stripped_wood_block = BlockInit.register("stripped_" + wood_id + "_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.PODZOL)));

        this.planks_block = BlockInit.register(wood_id + "_planks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.PODZOL)));

        this.fence_block = BlockInit.register(wood_id + "_fence", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.PODZOL)));
        this.fence_gate_block = BlockInit.register(wood_id + "_fence_gate", new FenceGateBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PODZOL)));

        this.button_block = BlockInit.register(wood_id + "_button", Blocks.woodenButton(wood_set));
        this.pressure_plate_block = BlockInit.register(wood_id + "_pressure_plate", new PressurePlateBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.PODZOL)));

        this.door_block = BlockInit.register(wood_id + "_door", new DoorBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.PODZOL)));
        this.trapdoor_block = BlockInit.register(wood_id + "_trapdoor", new TrapDoorBlock(wood_set, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.PODZOL)));

        this.sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_sign", new ModSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_sign", new ModWallSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).dropsLike(sign_block.get()).mapColor(MapColor.PODZOL)));
        this.hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_hanging_sign", new ModHangingSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.PODZOL)));
        this.wall_hanging_sign_block = BlockInit.registerWithoutBlockItem(wood_id + "_wall_hanging_sign", new ModWallHangingSignBlock(wood_type, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(hanging_sign_block.get()).mapColor(MapColor.PODZOL)));

        this.sign_block_item = ItemInit.register(wood_id + "_sign", new SignItem(new Item.Properties().stacksTo(16), sign_block.get(), wall_sign_block.get()));
        this.hanging_sign_block_item = ItemInit.register(wood_id + "_hanging_sign", new HangingSignItem(hanging_sign_block.get(), wall_hanging_sign_block.get(), new Item.Properties().stacksTo(16)));

        this.boat = ItemInit.register(wood_id + "_boat", new ModBoatItem(false, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));
        this.chest_boat = ItemInit.register(wood_id + "_chest_boat", new ModBoatItem(true, ModBoatEntity.Type.MYQUESTE, new Item.Properties().stacksTo(1)));
    }

    public BlockSetType getWoodSet() {
        return wood_set;
    }

    public WoodType getWoodType() {
        return wood_type;
    }

    public RegistrySupplier<Block> getLeavesBlock() {
        return leaves_block;
    }

    public RegistrySupplier<Block> getLogBlock() {
        return log_block;
    }

    public RegistrySupplier<Block> getStrippedLogBlock() {
        return stripped_log_block;
    }

    public RegistrySupplier<Block> getWoodBlock() {
        return wood_block;
    }

    public RegistrySupplier<Block> getStrippedWoodBlock() {
        return stripped_wood_block;
    }

    public RegistrySupplier<Block> getPlanksBlock() {
        return planks_block;
    }

    public RegistrySupplier<Block> getFenceBlock() {
        return fence_block;
    }

    public RegistrySupplier<Block> getFence_gateBlock() {
        return fence_gate_block;
    }

    public RegistrySupplier<Block> getButtonBlock() {
        return button_block;
    }

    public RegistrySupplier<Block> getPressure_plateBlock() {
        return pressure_plate_block;
    }

    public RegistrySupplier<Block> getDoorBlock() {
        return door_block;
    }

    public RegistrySupplier<Block> getTrapdoorBlock() {
        return trapdoor_block;
    }

    public RegistrySupplier<Block> getSignBlock() {
        return sign_block;
    }

    public RegistrySupplier<Block> getWallSignBlock() {
        return wall_sign_block;
    }

    public RegistrySupplier<Block> getHangingSignBlock() {
        return hanging_sign_block;
    }

    public RegistrySupplier<Block> getWallHangingSignBlock() {
        return wall_hanging_sign_block;
    }

    public RegistrySupplier<Item> getBoatItem() {
        return boat;
    }

    public RegistrySupplier<Item> getChestBoatItem() {
        return chest_boat;
    }

    public static void register() {}

    public static class BlockSetTypes {
        private static final Map<String, BlockSetType> TYPES = new Object2ObjectArrayMap<>();

        private static BlockSetType register(BlockSetType blockSetType) {
            TYPES.put(HibernalHerbsCommonMod.MOD_ID + ":" + blockSetType.name(), blockSetType);
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
            TYPES.put(HibernalHerbsCommonMod.MOD_ID + ":" + woodType.name(), woodType);
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
