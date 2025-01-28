package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.StatType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

public class StatsInit {
    public static final DeferredRegister<StatType<?>> STAT_TYPES = DeferredRegister.create(Registries.STAT_TYPE, HibernalHerbsMod.MOD_ID);

    public static final DeferredHolder<StatType<?>, StatType<Item>> USED_AGGLOMERATION = makeRegistryStatType("agglomeration_uses", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> USED_TOME = makeRegistryStatType("tome_uses", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> SACRIFICED_BLOOD_FROM_AGGLOMERATION = makeRegistryStatType("agglomeration_sacrifices", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> SACRIFICED_HUNGER_FROM_TOME = makeRegistryStatType("tome_sacrifice", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> CONJURED_ITEMS_FROM_AGGLOMERATION = makeRegistryStatType("agglomeration_conjured_items", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> CONJURED_ITEMS_FROM_TOME = makeRegistryStatType("tome_conjured_items", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> USED_SIGIL = makeRegistryStatType("used_sigil", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> USED_SIGIL_WITH_AGGLOMERATION = makeRegistryStatType("used_sigil_with_agglomeration", BuiltInRegistries.ITEM);
    public static final DeferredHolder<StatType<?>, StatType<Item>> USED_SIGIL_WITH_TOME = makeRegistryStatType("used_sigil_with_tome", BuiltInRegistries.ITEM);

    public static final DeferredHolder<StatType<?>, StatType<Block>> DETERIORATED_RUNE_BLOCK = makeRegistryStatType("deteriorated_rune_block", BuiltInRegistries.BLOCK);

    public static final DeferredHolder<StatType<?>, StatType<Block>> FROZE_BLOCKSTATE = makeRegistryStatType("froze_blockstate", BuiltInRegistries.BLOCK);
    public static final DeferredHolder<StatType<?>, StatType<Block>> UNFROZE_BLOCKSTATE = makeRegistryStatType("unfroze_blockstate", BuiltInRegistries.BLOCK);

    public static final DeferredHolder<StatType<?>, StatType<Block>> SACRIFICIAL_RUNE_RESTORATION = makeRegistryStatType("sacrificial_rune_restoration", BuiltInRegistries.BLOCK);

    public static final DeferredHolder<StatType<?>, StatType<Block>> INCENSE_PROVIDER_INTERACTIONS = makeRegistryStatType("incense_provider_interactions", BuiltInRegistries.BLOCK);
    public static final DeferredHolder<StatType<?>, StatType<Block>> MYSTICAL_CAMPFIRE_INTERACTIONS = makeRegistryStatType("mystical_campfire_interactions", BuiltInRegistries.BLOCK);

    public static final DeferredHolder<StatType<?>, StatType<Block>> USE_HERB_HUMUS_ON_LOG = makeRegistryStatType("use_herb_humus_on_log", BuiltInRegistries.BLOCK);

    //public static final StatType<EntityType<?>> COMPLETED_SACRIFICIAL_RITUAL = makeRegistryStatType("sacrificial_ritual_completed", BuiltInRegistries.ENTITY_TYPE);

    private static <T> DeferredHolder<StatType<?>, StatType<T>> makeRegistryStatType(String string, Registry<T> registry) {
        Component component = Component.translatable("stat_type.hibernalherbs." + string);
        return STAT_TYPES.register(string, () -> new StatType<>(registry, component));
        //return Registry.register(BuiltInRegistries.STAT_TYPE, HibernalHerbsMod.asResource(string), new StatType<>(registry, component));
    }

    public static void load(IEventBus bus) {
        STAT_TYPES.register(bus);
    }

    // vanilla (private) methods

    private static ItemUsedOnLocationTrigger.TriggerInstance itemUsedOnLocation(LocationPredicate.Builder builder, ItemPredicate.Builder builder2) {
        ContextAwarePredicate contextAwarePredicate = ContextAwarePredicate.create(
                LocationCheck.checkLocation(builder).build(), MatchTool.toolMatches(builder2).build()
        );
        return new ItemUsedOnLocationTrigger.TriggerInstance(Optional.empty(), Optional.of(contextAwarePredicate));
    }

    // end vanilla (private) methods

    public static Criterion<ConsumeItemTrigger.TriggerInstance> usedAgglomeration(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.USED_AGGLOMERATION.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> sacrificedBloodFromAgglomeration(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.SACRIFICED_BLOOD_FROM_AGGLOMERATION.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> conjuredItemsFromAgglomeration(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.CONJURED_ITEMS_FROM_AGGLOMERATION.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> usedTome(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.USED_TOME.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> sacrificedHungerFromTome(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.SACRIFICED_HUNGER_FROM_TOME.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> conjuredItemsFromTome(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.CONJURED_ITEMS_FROM_TOME.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> deterioratedSacrificialRuneBlock(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.DETERIORATED_RUNE_BLOCK.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> frozeBlockstate(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.FROZE_BLOCKSTATE.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> unfrozeBlockstate(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.UNFROZE_BLOCKSTATE.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> restoredSacrificialRuneBlock(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.SACRIFICIAL_RUNE_RESTORATION.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> usedHerbalSigil(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.USED_SIGIL.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> usedHerbalSigilWithAgglomeration(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.USED_SIGIL_WITH_AGGLOMERATION.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<ConsumeItemTrigger.TriggerInstance> usedHerbalSigilWithTome(ItemPredicate.Builder builder) {
        return CriteriaTriggersInit.USED_SIGIL_WITH_TOME.get().createCriterion(new ConsumeItemTrigger.TriggerInstance(Optional.empty(), Optional.of(builder.build())));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> interactedWithIncenseProvider(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.INCENSE_PROVIDER_INTERACTIONS.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<DefaultBlockInteractionTrigger.TriggerInstance> interactedWithMysticalCampfire(BlockPredicate.Builder builder) {
        return CriteriaTriggersInit.MYSTICAL_CAMPFIRE_INTERACTIONS.get().createCriterion(new DefaultBlockInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
    }

    public static Criterion<ItemUsedOnLocationTrigger.TriggerInstance> useHerbHumusOnLog(LocationPredicate.Builder builder, ItemPredicate.Builder builder2) {
        return CriteriaTriggersInit.USE_HERB_HUMUS_ON_LOG.get().createCriterion(itemUsedOnLocation(builder, builder2));
    }

//    public static Criterion<SummonedEntityTrigger.TriggerInstance> completedSacrificialRitual(EntityPredicate.Builder builder) {
//        return CriteriaTriggersInit.COMPLETED_SACRIFICIAL_RITUAL.createCriterion(new SummonedEntityTrigger.TriggerInstance(Optional.empty(), Optional.of(EntityPredicate.wrap(builder))));
//    }
}
