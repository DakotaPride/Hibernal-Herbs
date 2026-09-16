package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class StatsInit {

    public static final Stat<?> USED_AGGLOMERATION = makeRegistryStat("agglomeration_uses");
    public static final Stat<?> USED_TOME = makeRegistryStat("tome_uses");
    public static final Stat<?> SACRIFICED_BLOOD_FROM_AGGLOMERATION = makeRegistryStat("agglomeration_sacrifices");
    public static final Stat<?> SACRIFICED_HUNGER_FROM_TOME = makeRegistryStat("tome_sacrifices");
    public static final Stat<?> CONJURED_ITEMS_FROM_AGGLOMERATION = makeRegistryStat("agglomeration_conjured_items");
    public static final Stat<?> CONJURED_ITEMS_FROM_TOME = makeRegistryStat("tome_conjured_items");
    public static final Stat<?> USED_SIGIL = makeRegistryStat("used_sigil");
    public static final Stat<?> USED_SIGIL_WITH_AGGLOMERATION = makeRegistryStat("used_sigil_with_agglomeration");
    public static final Stat<?> USED_SIGIL_WITH_TOME = makeRegistryStat("used_sigil_with_tome");

    public static final Stat<?> DETERIORATED_RUNE_BLOCK = makeRegistryStat("deteriorated_rune_block");

    public static final Stat<?> FROZE_BLOCKSTATE = makeRegistryStat("froze_blockstate");
    public static final Stat<?> UNFROZE_BLOCKSTATE = makeRegistryStat("unfroze_blockstate");

    public static final Stat<?> SACRIFICIAL_RUNE_RESTORATION = makeRegistryStat("sacrificial_rune_restoration");

    public static final Stat<?> INCENSE_PROVIDER_INTERACTIONS = makeRegistryStat("incense_provider_interactions");
    public static final Stat<?> MYSTICAL_CAMPFIRE_INTERACTIONS = makeRegistryStat("mystical_campfire_interactions");

    public static final Stat<?> USE_HERB_HUMUS_ON_LOG = makeRegistryStat("use_herb_humus_on_log");

    public static final Stat<?> BLESSINGS_USED_ON_ALTARS = makeRegistryStat("blessings_used_on_altars");

    //public static final Stat<EntityType<?>> COMPLETED_SACRIFICIAL_RITUAL = makeRegistryStat("sacrificial_ritual_completed", BuiltInRegistries.ENTITY_TYPE);

    private static Stat<?> makeRegistryStat(String key) {
        //Component component = Component.translatable("stat_type.hibernalherbs." + string);
        return Stats.CUSTOM.get(Registry.register(BuiltInRegistries.CUSTOM_STAT, key, HibernalHerbsMod.asResource(key)), StatFormatter.DEFAULT);
    }

    public static void load() {}
}
