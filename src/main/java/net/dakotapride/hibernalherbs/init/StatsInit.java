package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.stats.StatType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class StatsInit {

    public static final StatType<Item> USED_AGGLOMERATION = makeRegistryStatType("agglomeration_uses", BuiltInRegistries.ITEM);
    public static final StatType<Item> USED_TOME = makeRegistryStatType("tome_uses", BuiltInRegistries.ITEM);
    public static final StatType<Item> SACRIFICED_BLOOD_FROM_AGGLOMERATION = makeRegistryStatType("agglomeration_sacrifices", BuiltInRegistries.ITEM);
    public static final StatType<Item> SACRIFICED_HUNGER_FROM_TOME = makeRegistryStatType("tome_sacrifice", BuiltInRegistries.ITEM);
    public static final StatType<Item> CONJURED_ITEMS_FROM_AGGLOMERATION = makeRegistryStatType("agglomeration_conjured_items", BuiltInRegistries.ITEM);
    public static final StatType<Item> CONJURED_ITEMS_FROM_TOME = makeRegistryStatType("tome_conjured_items", BuiltInRegistries.ITEM);
    public static final StatType<Item> USED_SIGIL = makeRegistryStatType("used_sigil", BuiltInRegistries.ITEM);
    public static final StatType<Item> USED_SIGIL_WITH_AGGLOMERATION = makeRegistryStatType("used_sigil_with_agglomeration", BuiltInRegistries.ITEM);
    public static final StatType<Item> USED_SIGIL_WITH_TOME = makeRegistryStatType("used_sigil_with_tome", BuiltInRegistries.ITEM);

    public static final StatType<Block> DETERIORATED_RUNE_BLOCK = makeRegistryStatType("deteriorated_rune_block", BuiltInRegistries.BLOCK);

    public static final StatType<Block> FROZE_BLOCKSTATE = makeRegistryStatType("froze_blockstate", BuiltInRegistries.BLOCK);
    public static final StatType<Block> UNFROZE_BLOCKSTATE = makeRegistryStatType("unfroze_blockstate", BuiltInRegistries.BLOCK);

    public static final StatType<Block> SACRIFICIAL_RUNE_RESTORATION = makeRegistryStatType("sacrificial_rune_restoration", BuiltInRegistries.BLOCK);

    public static final StatType<Block> INCENSE_PROVIDER_INTERACTIONS = makeRegistryStatType("incense_provider_interactions", BuiltInRegistries.BLOCK);
    public static final StatType<Block> MYSTICAL_CAMPFIRE_INTERACTIONS = makeRegistryStatType("mystical_campfire_interactions", BuiltInRegistries.BLOCK);

    public static final StatType<Block> USE_HERB_HUMUS_ON_LOG = makeRegistryStatType("use_herb_humus_on_log", BuiltInRegistries.BLOCK);

    //public static final StatType<EntityType<?>> COMPLETED_SACRIFICIAL_RITUAL = makeRegistryStatType("sacrificial_ritual_completed", BuiltInRegistries.ENTITY_TYPE);

    private static <T> StatType<T> makeRegistryStatType(String string, Registry<T> registry) {
        //Component component = Component.translatable("stat_type.hibernalherbs." + string);
        return Registry.register(BuiltInRegistries.STAT_TYPE, HibernalHerbsMod.asResource(string), new StatType<>(registry));
    }

    public static void load() {}
}
