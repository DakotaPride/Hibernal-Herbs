package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HibernalHerbsMod.MOD_ID);
    // WIP
    public static DeferredBlock<Block> SACRIFICIAL_RUNE_BLOCK = register("sacrificial_rune_block",
            () -> new SacrificialRuneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static DeferredBlock<Block> FROZE_STATE_SACRIFICIAL_RUNE_BLOCK = register("froze_state_sacrificial_rune_block",
            () -> new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static DeferredBlock<Block> DETERIORATED_SACRIFICIAL_RUNE_BLOCK = register("deteriorated_sacrificial_rune_block",
            () -> new DeterioratedSacrificialRuneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));

    public static DeferredBlock<Block> MYSTICAL_CAMPFIRE = register("mystical_campfire",
            () -> new MysticalCampfireBlock(true, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).noOcclusion()));
    public static DeferredBlock<Block> INCENSE_PROVIDER = register("incense_provider",
            () -> new IncenseProviderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).noOcclusion().lightLevel(incenseLightEmission(7)).requiresCorrectToolForDrops()));

    public static ToIntFunction<BlockState> incenseLightEmission(int i) {
        return blockState -> blockState.getValue(PropertiesInit.FED) ? i : 0;
    }

    // Collective Registration
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = registerWithoutBlockItem(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> DeferredBlock<T> registerWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
