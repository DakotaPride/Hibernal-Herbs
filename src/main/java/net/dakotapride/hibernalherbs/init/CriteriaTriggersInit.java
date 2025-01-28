package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.DefaultBlockInteractionTrigger;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class CriteriaTriggersInit {
    public static final ConsumeItemTrigger USED_AGGLOMERATION = register("agglomeration_uses", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger USED_TOME = register("tome_uses", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger SACRIFICED_BLOOD_FROM_AGGLOMERATION = register("agglomeration_sacrifices", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger SACRIFICED_HUNGER_FROM_TOME = register("tome_sacrifices", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger CONJURED_ITEMS_FROM_AGGLOMERATION = register("agglomeration_conjured_items", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger CONJURED_ITEMS_FROM_TOME = register("tome_conjured_items", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger USED_SIGIL = register("used_sigil", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger USED_SIGIL_WITH_AGGLOMERATION = register("used_sigil_with_agglomeration", new ConsumeItemTrigger());
    public static final ConsumeItemTrigger USED_SIGIL_WITH_TOME = register("used_sigil_with_tome", new ConsumeItemTrigger());

    public static final DefaultBlockInteractionTrigger DETERIORATED_RUNE_BLOCK = register("deteriorated_rune_block", new DefaultBlockInteractionTrigger());

    public static final DefaultBlockInteractionTrigger FROZE_BLOCKSTATE = register("froze_blockstate", new DefaultBlockInteractionTrigger());
    public static final DefaultBlockInteractionTrigger UNFROZE_BLOCKSTATE = register("unfroze_blockstate", new DefaultBlockInteractionTrigger());

    public static final DefaultBlockInteractionTrigger SACRIFICIAL_RUNE_RESTORATION = register("sacrificial_rune_restoration", new DefaultBlockInteractionTrigger());

    public static final DefaultBlockInteractionTrigger INCENSE_PROVIDER_INTERACTIONS = register("incense_provider_interactions", new DefaultBlockInteractionTrigger());
    public static final DefaultBlockInteractionTrigger MYSTICAL_CAMPFIRE_INTERACTIONS = register("mystical_campfire_interactions", new DefaultBlockInteractionTrigger());

    public static final ItemUsedOnLocationTrigger USE_HERB_HUMUS_ON_LOG = register("use_herb_humus_on_log", new ItemUsedOnLocationTrigger());

    //public static final SummonedEntityTrigger COMPLETED_SACRIFICIAL_RITUAL = register("sacrificial_ritual_completed", new SummonedEntityTrigger());

    public static <T extends CriterionTrigger<?>> T register(String string, T criterionTrigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, HibernalHerbsMod.asResource(string), criterionTrigger);
    }

    public static void load() {}
}
