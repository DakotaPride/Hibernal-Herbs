package net.dakotapride.hibernalherbs.fabric.registry;

import net.dakotapride.hibernalherbs.fabric.item.GrimoireItem;
import net.dakotapride.hibernalherbs.fabric.item.PadlockItem;
import net.dakotapride.hibernalherbs.item.curse.Sins;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class ItemRegistry {

    // Fabric Grimoires
    public static Item HERBAL_GRIMOIRE = new GrimoireItem(new Item.Settings().maxCount(1));
    public static Item SINGED_GRIMOIRE = new GrimoireItem(new Item.Settings().maxCount(1));
    // Fabric Padlocks
    public static Item WRATH_PADLOCK_BOUND = new PadlockItem(Sins.WRATH, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item WRATH_PADLOCK = new PadlockItem(Sins.WRATH, new Item.Settings().maxCount(1));
    public static Item PRIDE_PADLOCK_BOUND = new PadlockItem(Sins.PRIDE, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item PRIDE_PADLOCK = new PadlockItem(Sins.PRIDE, new Item.Settings().maxCount(1));
    public static Item GLUTTONY_PADLOCK_BOUND = new PadlockItem(Sins.GLUTTONY, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item GLUTTONY_PADLOCK = new PadlockItem(Sins.GLUTTONY, new Item.Settings().maxCount(1));
    public static Item GREED_PADLOCK_BOUND = new PadlockItem(Sins.GREED, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item GREED_PADLOCK = new PadlockItem(Sins.GREED, new Item.Settings().maxCount(1));
    public static Item ENVY_PADLOCK_BOUND = new PadlockItem(Sins.ENVY, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item ENVY_PADLOCK = new PadlockItem(Sins.ENVY, new Item.Settings().maxCount(1));
    public static Item SLOTH_PADLOCK_BOUND = new PadlockItem(Sins.SLOTH, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item SLOTH_PADLOCK = new PadlockItem(Sins.SLOTH, new Item.Settings().maxCount(1));
    public static Item LUST_PADLOCK_BOUND = new PadlockItem(Sins.LUST, new Item.Settings().maxCount(1).maxDamage(1));
    public static Item LUST_PADLOCK = new PadlockItem(Sins.LUST, new Item.Settings().maxCount(1));


    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "singed_grimoire"), SINGED_GRIMOIRE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "grimoire"), HERBAL_GRIMOIRE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_wrath"), WRATH_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_wrath"), WRATH_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_pride"), PRIDE_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_pride"), PRIDE_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_gluttony"), GLUTTONY_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_gluttony"), GLUTTONY_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_greed"), GREED_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_greed"), GREED_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_envy"), ENVY_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_envy"), ENVY_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_sloth"), SLOTH_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_sloth"), SLOTH_PADLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_lust"), LUST_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_lust"), LUST_PADLOCK);
    }
}
