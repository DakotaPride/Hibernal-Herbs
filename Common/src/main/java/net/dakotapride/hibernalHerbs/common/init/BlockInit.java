package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockInit {
    public static Registrar<Block> blocks = HibernalHerbsCommonMod.MANAGER.get().get(Registries.BLOCK);

    // Collective Registration
    public static void register() {}

    public static RegistrySupplier<Block> register(String name, Block block) {
        registerBlockItem(name, block, new Item.Properties());
        return blocks.register(HibernalHerbsCommonMod.asResource(name), () -> block);
    }

    public static RegistrySupplier<Item> registerBlockItem(String name, Block block, Item.Properties properties) {
        return ItemInit.register(name, new BlockItem(block, properties));
    }
}
