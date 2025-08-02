package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.item.*;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.PotionContents;

@SuppressWarnings({"unused"})
public class ItemInit {

    public static Item GROUND_HERBS = register("ground_herbs", new Item(new Item.Properties()));

    public static Item LIFE_FORCE_BOTTLE = register("life_force", new LifeForceBottleItem(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON)));

    public static Item INSCRIPTION_SMITHING_TEMPLATE = register("inscription_smithing_template", InscriptionSmithingTemplate.createInscriptionSmithingTemplateItem());

    public static Item BLANK_HERBAL_SIGIL = register("blank_herbal_sigil", new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static Item CRACKED_HERBAL_SIGIL = register("cracked_herbal_sigil", new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static Item SILIPTIUM_PETALS = register("siliptium_petals", new Item(new Item.Properties()));
    public static Item LUMBINETRIK_PETALS = register("lumbinetrik_petals", new Item(new Item.Properties()));
    public static Item JULISIUM_PETALS = register("julisium_petals", new Item(new Item.Properties()));

    public static Item GRIMOIRE = register("grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static Item SINGED_GRIMOIRE = register("singed_grimoire", new HerbalGrimoireItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static Item SORCERER_AGGLOMERATION = register("agglomeration", new SorcererAgglomerationItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static Item SORCERER_TOME = register("tome", new SorcererTomeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));

    public static Item MYSTICAL_ASHES = register("extract_mystical_ashes", new ExtractItem("Mystical Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static Item VILE_ASHES = register("extract_vile_ashes", new ExtractItem("Vile Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static Item VIRTUOUS_ASHES = register("extract_virtuous_ashes", new ExtractItem("Virtuous Flame", new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static Item ENIGMATIC_POTION = register("enigmatic_potion", new EnigmaticPotionItem(new Item.Properties().stacksTo(1).component(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)));
    public static Item SOLAR_POTION = register("solar_potion", new TimeOfDayPotion(TimeOfDayPotion.Time.DAY, new Item.Properties().stacksTo(1).component(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)));
    public static Item LUNAR_POTION = register("lunar_potion", new TimeOfDayPotion(TimeOfDayPotion.Time.NIGHT, new Item.Properties().stacksTo(1).component(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)));

    public static Item CHARRED_PAPER = register("charred_paper",new Item(new Item.Properties()));

    // Collective Registration
    public static void register() {}

    public static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, HibernalHerbsMod.asResource(name), item);
    }
}
