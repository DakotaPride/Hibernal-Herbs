package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.block.*;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Locale;

public enum FrozeBlockstates {
    COPPER(Blocks.COPPER_BLOCK, Blocks.CUT_COPPER, Blocks.CUT_COPPER_SLAB, Blocks.CUT_COPPER_STAIRS, Blocks.COPPER_DOOR, Blocks.COPPER_TRAPDOOR, Blocks.COPPER_BULB, Blocks.COPPER_GRATE, Blocks.CHISELED_COPPER),
    EXPOSED_COPPER(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.EXPOSED_COPPER_DOOR, Blocks.EXPOSED_COPPER_TRAPDOOR, Blocks.EXPOSED_COPPER_BULB, Blocks.EXPOSED_COPPER_GRATE, Blocks.EXPOSED_CHISELED_COPPER),
    WEATHERED_COPPER(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.WEATHERED_COPPER_DOOR, Blocks.WEATHERED_COPPER_TRAPDOOR, Blocks.WEATHERED_COPPER_BULB, Blocks.WEATHERED_COPPER_GRATE, Blocks.WEATHERED_CHISELED_COPPER),
    OXIDISED_COPPER(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_COPPER_DOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR, Blocks.OXIDIZED_COPPER_BULB, Blocks.OXIDIZED_COPPER_GRATE, Blocks.OXIDIZED_CHISELED_COPPER),;

    final String id;

    final Block froze_state;
    final Block froze_cut_state;
    final Block froze_cut_slab_state;
    final Block froze_cut_stairs_state;
    final Block froze_door_state;
    final Block froze_trapdoor_state;
    final Block froze_bulb_state;
    final Block froze_grate_state;
    final Block froze_chiseled_state;

    final Block base;
    final Block cut;
    final Block cut_slab;
    final Block cut_stairs;
    final Block door;
    final Block trapdoor;
    final Block bulb;
    final Block grate;
    final Block chiseled;

    FrozeBlockstates(Block base, Block cut, Block cut_slab, Block cut_stairs, Block door, Block trapdoor, Block bulb, Block grate, Block chiseled) {
        this.id = name().toLowerCase(Locale.ROOT);

        this.base = base;
        this.cut = cut;
        this.cut_slab = cut_slab;
        this.cut_stairs = cut_stairs;
        this.door = door;
        this.trapdoor = trapdoor;
        this.bulb = bulb;
        this.grate = grate;
        this.chiseled = chiseled;

        this.froze_state = BlockInit.register("froze_state_" + id + "_block", new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
        this.froze_cut_state = BlockInit.register("froze_state_cut_" + id + "_block", new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
        this.froze_cut_slab_state = BlockInit.register("froze_state_cut_" + id + "_slab", new FrozeStateSlabBlock(BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
        this.froze_cut_stairs_state = BlockInit.register("froze_state_cut_" + id + "_stairs", new FrozeStateStairsBlock(froze_state.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
        this.froze_door_state = BlockInit.register("froze_state_" + id + "_door", new FrozeStateDoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(base).noOcclusion().requiresCorrectToolForDrops()));
        this.froze_trapdoor_state = BlockInit.register("froze_state_" + id + "_trapdoor", new FrozeStateTrapdoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.ofFullCopy(base).noOcclusion().requiresCorrectToolForDrops()));
        this.froze_bulb_state = BlockInit.register("froze_state_" + id + "_bulb", new FrozeStateBulbBlock(BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
        this.froze_grate_state = BlockInit.register("froze_state_" + id + "_grate", new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(base).noOcclusion().requiresCorrectToolForDrops()));
        this.froze_chiseled_state = BlockInit.register("froze_state_chiseled_" + id + "_block", new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(base).requiresCorrectToolForDrops()));
    }

    public String getId() {
        return id;
    }

    public Block getBaseBlock() {
        return base;
    }

    public Block getCutBlock() {
        return cut;
    }

    public Block getCutStairsBlock() {
        return cut_stairs;
    }

    public Block getCutSlabBlock() {
        return cut_slab;
    }

    public Block getDoorBlock() {
        return door;
    }

    public Block getTrapdoorBlock() {
        return trapdoor;
    }

    public Block getBulbBlock() {
        return bulb;
    }

    public Block getGrateBlock() {
        return grate;
    }

    public Block getChiseledBlock() {
        return chiseled;
    }

    public Block getFrozeState() {
        return froze_state;
    }
    public Block getFrozeCutState() {
        return froze_cut_state;
    }
    public Block getFrozeCutStairsState() {
        return froze_cut_stairs_state;
    }
    public Block getFrozeCutSlabState() {
        return froze_cut_slab_state;
    }
    public Block getFrozeDoorState() {
        return froze_door_state;
    }
    public Block getFrozeTrapdoorState() {
        return froze_trapdoor_state;
    }
    public Block getFrozeBulbState() {
        return froze_bulb_state;
    }
    public Block getFrozeGrateState() {
        return froze_grate_state;
    }
    public Block getFrozeChiseledState() {
        return froze_chiseled_state;
    }

    public static void register() {}
}
