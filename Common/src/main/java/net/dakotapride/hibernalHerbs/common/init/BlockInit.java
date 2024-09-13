package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.block.MysticalCampfireBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockInit {
    public static Registrar<Block> blocks = HibernalHerbsCommonMod.MANAGER.get().get(Registries.BLOCK);

    // WIP
    public static RegistrySupplier<Block> MYSTICAL_CAMPFIRE = register("mystical_campfire",
            new MysticalCampfireBlock(true, 10, BlockBehaviour.Properties.of().noOcclusion()));

    // Collective Registration
    public static void register() {}

    public static RegistrySupplier<Block> register(String name, Block block) {
        registerBlockItem(name, block, new Item.Properties());
        return blocks.register(HibernalHerbsCommonMod.asResource(name), () -> block);
    }

    public static RegistrySupplier<Block> registerWithoutBlockItem(String name, Block block) {
        return blocks.register(HibernalHerbsCommonMod.asResource(name), () -> block);
    }

    public static RegistrySupplier<Item> registerBlockItem(String name, Block block, Item.Properties properties) {
        return ItemInit.register(name, new BlockItem(block, properties));
    }
}
