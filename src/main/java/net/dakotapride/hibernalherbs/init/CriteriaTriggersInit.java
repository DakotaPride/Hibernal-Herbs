package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.DefaultBlockInteractionTrigger;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CriteriaTriggersInit {
    public static final DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, HibernalHerbsMod.MOD_ID);

    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> USED_AGGLOMERATION = register("agglomeration_uses", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> USED_TOME = register("tome_uses", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> SACRIFICED_BLOOD_FROM_AGGLOMERATION = register("agglomeration_sacrifices", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> SACRIFICED_HUNGER_FROM_TOME = register("tome_sacrifices", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> CONJURED_ITEMS_FROM_AGGLOMERATION = register("agglomeration_conjured_items", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> CONJURED_ITEMS_FROM_TOME = register("tome_conjured_items", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> USED_SIGIL = register("used_sigil", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> USED_SIGIL_WITH_AGGLOMERATION = register("used_sigil_with_agglomeration", ConsumeItemTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, ConsumeItemTrigger> USED_SIGIL_WITH_TOME = register("used_sigil_with_tome", ConsumeItemTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> DETERIORATED_RUNE_BLOCK = register("deteriorated_rune_block", DefaultBlockInteractionTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> FROZE_BLOCKSTATE = register("froze_blockstate", DefaultBlockInteractionTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> UNFROZE_BLOCKSTATE = register("unfroze_blockstate", DefaultBlockInteractionTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> SACRIFICIAL_RUNE_RESTORATION = register("sacrificial_rune_restoration", DefaultBlockInteractionTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> INCENSE_PROVIDER_INTERACTIONS = register("incense_provider_interactions", DefaultBlockInteractionTrigger::new);
    public static final DeferredHolder<CriterionTrigger<?>, DefaultBlockInteractionTrigger> MYSTICAL_CAMPFIRE_INTERACTIONS = register("mystical_campfire_interactions", DefaultBlockInteractionTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, ItemUsedOnLocationTrigger> USE_HERB_HUMUS_ON_LOG = register("use_herb_humus_on_log", ItemUsedOnLocationTrigger::new);

    //public static final SummonedEntityTrigger COMPLETED_SACRIFICIAL_RITUAL = register("sacrificial_ritual_completed", new SummonedEntityTrigger());

    public static <T extends CriterionTrigger<?>> DeferredHolder<CriterionTrigger<?>, T> register(String string, Supplier<T> criterionTrigger) {
        return CRITERION_TRIGGERS.register(string, criterionTrigger);
        //return Registry.register(BuiltInRegistries.TRIGGER_TYPES, HibernalHerbsMod.asResource(string), criterionTrigger);
    }

    public static void load(IEventBus bus) {
        CRITERION_TRIGGERS.register(bus);
    }
}
