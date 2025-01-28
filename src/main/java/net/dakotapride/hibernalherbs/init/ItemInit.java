package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.item.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HibernalHerbsMod.MOD_ID);

    public static DeferredItem<Item> GROUND_HERBS = register("ground_herbs", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> LIFE_FORCE_BOTTLE = register("life_force", () -> new LifeForceBottleItem(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON)));

    public static DeferredItem<Item> INSCRIPTION_SMITHING_TEMPLATE = register("inscription_smithing_template", InscriptionSmithingTemplate::createInscriptionSmithingTemplateItem);

    public static DeferredItem<Item> BLANK_HERBAL_SIGIL = register("blank_herbal_sigil", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static DeferredItem<Item> CRACKED_HERBAL_SIGIL = register("cracked_herbal_sigil", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static DeferredItem<Item> SILIPTIUM_PETALS = register("siliptium_petals", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> LUMBINETRIK_PETALS = register("lumbinetrik_petals", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> JULISIUM_PETALS = register("julisium_petals", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> GRIMOIRE = register("grimoire", () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static DeferredItem<Item> SINGED_GRIMOIRE = register("singed_grimoire", () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static DeferredItem<Item> SORCERER_AGGLOMERATION = register("agglomeration", () -> new SorcererAgglomerationItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static DeferredItem<Item> SORCERER_TOME = register("tome", () -> new SorcererTomeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

    public static DeferredItem<Item> MYSTICAL_ASHES = register("extract_mystical_ashes", () -> new ExtractItem("Mystical Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static DeferredItem<Item> VILE_ASHES = register("extract_vile_ashes", () -> new ExtractItem("Vile Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static DeferredItem<Item> VIRTUOUS_ASHES = register("extract_virtuous_ashes", () -> new ExtractItem("Virtuous Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    // Collective Registration
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static DeferredItem<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
        //return Registry.register(BuiltInRegistries.ITEM, HibernalHerbsMod.asResource(name), item);
    }

    public static DeferredItem<SickleItem> sickle(String name, Supplier<SickleItem> item) {
        return ITEMS.register(name, item);
    }
}
