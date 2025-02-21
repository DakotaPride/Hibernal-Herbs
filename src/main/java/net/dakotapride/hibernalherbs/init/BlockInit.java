package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.ToIntFunction;

public class BlockInit {
    // WIP
    public static Block SACRIFICIAL_RUNE_BLOCK = register("sacrificial_rune_block",
            new SacrificialRuneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static Block FROZE_STATE_SACRIFICIAL_RUNE_BLOCK = register("froze_state_sacrificial_rune_block",
            new FrozeStateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));
    public static Block DETERIORATED_SACRIFICIAL_RUNE_BLOCK = register("deteriorated_sacrificial_rune_block",
            new DeterioratedSacrificialRuneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops()));

    public static Block MYSTICAL_CAMPFIRE = register("mystical_campfire",
            new MysticalCampfireBlock(true, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).noOcclusion()));
    public static Block INCENSE_PROVIDER = register("incense_provider",
            new IncenseProviderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).noOcclusion().lightLevel(incenseLightEmission(7)).requiresCorrectToolForDrops()));

    public static ToIntFunction<BlockState> incenseLightEmission(int i) {
        return blockState -> blockState.getValue(PropertiesInit.FED) ? i : 0;
    }

//    public static Block UNSTABLE_DALUM_ORE = register("unstable_dalum_ore",
//            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).requiresCorrectToolForDrops()));
    // Collective Registration
    public static void register() {}

    public static Block register(String name, Block block) {
        registerBlockItem(name, block, new Item.Properties());
        return Registry.register(BuiltInRegistries.BLOCK, HibernalHerbsMod.asResource(name), block);
    }

    public static Block registerWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, HibernalHerbsMod.asResource(name), block);
    }

    public static Item registerBlockItem(String name, Block block, Item.Properties properties) {
        return ItemInit.register(name, new BlockItem(block, properties));
    }
}
