package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.item.HerbalGrimoireItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static Registrar<Item> items = HibernalHerbsCommonMod.MANAGER.get().get(Registries.ITEM);

    public static RegistrySupplier<Item> GROUND_HERBS = register("ground_herbs", new Item(new Item.Properties()));

    public static RegistrySupplier<Item> SILIPTIUM_PETALS = register("siliptium_petals", new Item(new Item.Properties()));
    public static RegistrySupplier<Item> LUMBINETRIK_PETALS = register("lumbinetrik_petals", new Item(new Item.Properties()));
    public static RegistrySupplier<Item> JULISIUM_PETALS = register("julisium_petals", new Item(new Item.Properties()));

    public static RegistrySupplier<Item> GRIMOIRE = register("grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));
    public static RegistrySupplier<Item> SINGED_GRIMOIRE = register("singed_grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));

    // Collective Registration
    public static void register() {}

    public static RegistrySupplier<Item> register(String name, Item item) {
        return items.register(HibernalHerbsCommonMod.asResource(name), () -> item);
    }
}
