package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.item.HerbalGrimoireItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static Registrar<Item> items = HibernalHerbsCommonMod.MANAGER.get().get(Registries.ITEM);

    public static RegistrySupplier<Item> GRIMOIRE;
    public static RegistrySupplier<Item> SINGED_GRIMOIRE;

    // Collective Registration
    public static void register() {
        GRIMOIRE = register("grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));
        SINGED_GRIMOIRE = register("singed_grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));
    }

    public static RegistrySupplier<Item> register(String name, Item item) {
        return items.register(HibernalHerbsCommonMod.asResource(name), () -> item);
    }
}
