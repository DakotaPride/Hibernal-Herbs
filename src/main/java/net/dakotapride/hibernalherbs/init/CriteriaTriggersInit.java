package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.criteria.BlockInteractionTrigger;
import net.dakotapride.hibernalherbs.criteria.CustomConsumeItemTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;

public class CriteriaTriggersInit {
    public static final ConsumeItemTrigger USED_AGGLOMERATION = register(new CustomConsumeItemTrigger("agglomeration_uses"));
    public static final ConsumeItemTrigger USED_TOME = register(new CustomConsumeItemTrigger("tome_uses"));
    public static final ConsumeItemTrigger SACRIFICED_BLOOD_FROM_AGGLOMERATION = register(new CustomConsumeItemTrigger("sacrificed_blood_from_agglomeration"));
    public static final ConsumeItemTrigger SACRIFICED_HUNGER_FROM_TOME = register(new CustomConsumeItemTrigger("sacrificed_hunger_from_tome"));
    public static final ConsumeItemTrigger CONJURED_ITEMS_FROM_AGGLOMERATION = register(new CustomConsumeItemTrigger("agglomeration_conjured_items"));
    public static final ConsumeItemTrigger CONJURED_ITEMS_FROM_TOME = register(new CustomConsumeItemTrigger("tome_conjured_items"));
    public static final ConsumeItemTrigger USED_SIGIL = register(new CustomConsumeItemTrigger("used_sigil"));
    public static final ConsumeItemTrigger USED_SIGIL_WITH_AGGLOMERATION = register(new CustomConsumeItemTrigger("used_sigil_with_agglomeration"));
    public static final ConsumeItemTrigger USED_SIGIL_WITH_TOME = register(new CustomConsumeItemTrigger("used_sigil_with_tome"));

    public static final BlockInteractionTrigger DETERIORATED_RUNE_BLOCK = register(new BlockInteractionTrigger("deteriorated_rune_block"));

    public static final BlockInteractionTrigger FROZE_BLOCKSTATE = register(new BlockInteractionTrigger("froze_blockstate"));
    public static final BlockInteractionTrigger UNFROZE_BLOCKSTATE = register(new BlockInteractionTrigger("unfroze_blockstate"));

    public static final BlockInteractionTrigger SACRIFICIAL_RUNE_RESTORATION = register(new BlockInteractionTrigger("sacrificial_rune_restoration"));

    public static final BlockInteractionTrigger INCENSE_PROVIDER_INTERACTIONS = register(new BlockInteractionTrigger("incense_provider_interactions"));
    public static final BlockInteractionTrigger MYSTICAL_CAMPFIRE_INTERACTIONS = register(new BlockInteractionTrigger("mystical_campfire_interactions"));

    public static final BlockInteractionTrigger USE_HERB_HUMUS_ON_LOG = register(new BlockInteractionTrigger("use_herb_humus_on_log"));

    //public static final SummonedEntityTrigger COMPLETED_SACRIFICIAL_RITUAL = register("sacrificial_ritual_completed", new SummonedEntityTrigger());

    public static <T extends CriterionTrigger<?>> T register(T criterionTrigger) {
        return CriteriaTriggers.register(criterionTrigger);
    }

    public static void load() {}
}
