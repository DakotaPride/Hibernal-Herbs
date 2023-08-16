package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.item.*;
import net.dakotapride.hibernalHerbs.common.item.canister.AbstractCanisterItem;
import net.dakotapride.hibernalHerbs.common.item.curse.CursedPadlockItem;
import net.dakotapride.hibernalHerbs.common.item.curse.grimoire.HerbalGrimoireItem;
import net.dakotapride.hibernalHerbs.common.item.pouch.AbstractPouchItem;
import net.dakotapride.hibernalHerbs.common.item.ring.GluttonousRingItem;
import net.dakotapride.hibernalHerbs.common.item.ring.adv.AdvancedGluttonousRingItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ItemInit {

    public static Item GROUND_HERBS = new Item(new FabricItemSettings());

    public static Item HERBAL_GRIMOIRE = new HerbalGrimoireItem(new FabricItemSettings().maxCount(1));
    public static Item SINGED_GRIMOIRE = new HerbalGrimoireItem(new FabricItemSettings().maxCount(1));

    public static Item SILIPTIUM_PETAL = new Item(new FabricItemSettings());
    public static Item LUMBINETRIK_PETAL = new Item(new FabricItemSettings());

    public static Item VEXATION_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item VEXATION_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item PIQUE_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item PIQUE_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item GOURMANDIZING_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item GOURMANDIZING_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item AVARICE_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item AVARICE_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item SPITEFUL_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item SPITEFUL_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item APATHY_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item APATHY_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item SALACIOUS_PADLOCK_BOUND = new CursedPadlockItem(new FabricItemSettings().maxCount(1).maxDamage(1));
    public static Item SALACIOUS_PADLOCK = new CursedPadlockItem(new FabricItemSettings().maxCount(1));

    public static Item RING = new Item(new FabricItemSettings()
            .maxCount(1));
    public static Item GLUTTONOUS_RING = new GluttonousRingItem(new FabricItemSettings()
            .maxCount(1));
    public static Item ADV_GLUTTONOUS_RING = new AdvancedGluttonousRingItem(new FabricItemSettings()
            .maxCount(1));

    public static Item CRACKED_SIGIL = new Item(new FabricItemSettings()
            );
    public static Item SIGIL = new HerbalSigilItem(new FabricItemSettings()
            );

    public static Item SIGIL_PRIDE = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_SLOTH = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_LUST = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_GLUTTONY = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_WRATH = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_GREED = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_ENVY = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));

    public static Item SIGIL_CONFIGURATION = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_CONFIGURATION_ADVANCED = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_MASTERY = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));
    public static Item SIGIL_MASTERY_ADVANCED = new HerbalSigilItem(new FabricItemSettings()
            .maxCount(1));

    public static Item POUNDED_ROSEMARY = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_THYME = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_TARRAGON = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_CHAMOMILE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_CHIVES = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_VERBENA = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_SORREL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_MARJORAM = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_CHERVIL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_FENNSEL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_CEILLIS = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_PUNUEL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));
    public static Item POUNDED_ESSITTE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));

    // Resource Dependant (Pounded) Herbs

    public static Item POUNDED_THYOCIELLE = new Item(new FabricItemSettings().food(FoodComponentInit.ARTIFICIAL_HERB));
    public static Item POUNDED_FENNKYSTRAL = new Item(new FabricItemSettings().food(FoodComponentInit.ARTIFICIAL_HERB));

    // Spring (Pounded) Herb(s)

    public static Item POUNDED_CALENDULA = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));

    public static Item POUNDED_SAGE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB));

    public static Item DRIED_CALENDULA = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_ROSEMARY = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_THYME = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_TARRAGON = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_CHAMOMILE = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_CHIVES = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_VERBENA = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_SORREL = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_MARJORAM = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_CHERVIL = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_FENNSEL = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_CEILLIS = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_PUNUEL = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_ESSITTE = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_THYOCIELLE = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_FENNKYSTRAL = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));
    public static Item DRIED_SAGE = new Item(new FabricItemSettings().food(FoodComponentInit.DRIED_HERB));

    public static HerbBlendItem REGENERATIVE_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.REGENERATIVE_BLEND)
            .maxCount(1));
    public static HerbBlendItem VIRULENT_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.VIRULENT_BLEND)
            .maxCount(1));
    public static HerbBlendItem SEDATING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SEDATING_BLEND)
            .maxCount(1));
    public static HerbBlendItem HINDERING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.HINDERING_BLEND)
            .maxCount(1));
    public static HerbBlendItem DASHING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DASHING_BLEND)
            .maxCount(1));
    public static HerbBlendItem ACCELERATION_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.ACCELERATION_BLEND)
            .maxCount(1));
    public static HerbBlendItem INCINERATING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.INCINERATING_BLEND)
            .maxCount(1));
    public static HerbBlendItem DECAYING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DECAYING_BLEND)
            .maxCount(1));
    public static HerbBlendItem OBSERVING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.OBSERVING_BLEND)
            .maxCount(1));
    public static HerbBlendItem DIMINISHED_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DIMINISHED_BLEND)
            .maxCount(1));
    public static HerbBlendItem SHADED_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SHADED_BLEND)
            .maxCount(1));

    // Resource Dependant (Blends) Herbs

    public static HerbBlendItem CONFLICTING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.CONFLICTING_BLEND)
            .maxCount(1));
    public static HerbBlendItem ALTERNATIVE_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.ALTERNATIVE_BLEND)
            .maxCount(1));

    public static HerbFertilizerItem HERB_FERTILIZER = new HerbFertilizerItem(new FabricItemSettings());

    public static HerbFertilizerItem HERB_FERTILIZER_OAK = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_DARK_OAK = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_BIRCH = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_JUNGLE = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_ACACIA = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_SPRUCE = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_MANGROVE = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_CHERRY = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_CRIMSON = new HerbFertilizerItem(new FabricItemSettings());
    public static HerbFertilizerItem HERB_FERTILIZER_WARPED = new HerbFertilizerItem(new FabricItemSettings());

    public static HerbFertilizerItem HERB_FERTILIZER_MYQUESTE = new HerbFertilizerItem(new FabricItemSettings());

    public static HerbHumusItem HERB_HUMUS = new HerbHumusItem(new FabricItemSettings());

    public static HerbHumusItem HERB_HUMUS_OAK = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_DARK_OAK = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_BIRCH = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_JUNGLE = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_ACACIA = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_SPRUCE = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_MANGROVE = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_CHERRY = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_CRIMSON = new HerbHumusItem(new FabricItemSettings());
    public static HerbHumusItem HERB_HUMUS_WARPED = new HerbHumusItem(new FabricItemSettings());

    public static HerbHumusItem HERB_HUMUS_MYQUESTE = new HerbHumusItem(new FabricItemSettings());

    // Smoked Herb Blends (Fabric)
    public static SmokedHerbBlendItem SMOKED_REGENERATIVE_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_REGENERATIVE_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_VIRULENT_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_VIRULENT_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_SEDATING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_SEDATING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_HINDERING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_HINDERING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_DASHING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DASHING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_ACCELERATION_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_ACCELERATION_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_INCINERATING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_INCINERATING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_DECAYING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DECAYING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_OBSERVING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_OBSERVING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_DIMINISHED_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DIMINISHED_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_SHADED_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_SHADED_BLEND)
            .maxCount(1));

    // Resource Dependant (Smoked Blends) Herbs

    public static SmokedHerbBlendItem SMOKED_CONFLICTING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_CONFLICTING_BLEND)
            .maxCount(1));
    public static SmokedHerbBlendItem SMOKED_ALTERNATIVE_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_ALTERNATIVE_BLEND)
            .maxCount(1));

    // Refined Pouches/Canisters

    public static AbstractPouchItem SCRATCHED_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1), 64);
    public static AbstractCanisterItem IRON_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1), 128);

    public static AbstractPouchItem STITCHED_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1), 192);
    public static AbstractCanisterItem AMETHYST_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1), 256);

    public static AbstractPouchItem PROPER_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1), 256);
    public static AbstractCanisterItem DIAMOND_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1), 384);

    // Legacy

    public static AbstractPouchItem POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1), 256);
    public static AbstractCanisterItem CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1), 384);

    public static void init () {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ground_herbs"), GROUND_HERBS);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sin_petals"), SILIPTIUM_PETAL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lumbinetrik_petals"), LUMBINETRIK_PETAL);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "singed_grimoire"), SINGED_GRIMOIRE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "grimoire"), HERBAL_GRIMOIRE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ring"), RING);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "gluttonous_ring"), GLUTTONOUS_RING);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "gluttonous_ring_adv"), ADV_GLUTTONOUS_RING);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_wrath"), VEXATION_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_wrath"), VEXATION_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_pride"), PIQUE_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_pride"), PIQUE_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_gluttony"), GOURMANDIZING_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_gluttony"), GOURMANDIZING_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_greed"), AVARICE_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_greed"), AVARICE_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_envy"), SPITEFUL_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_envy"), SPITEFUL_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_sloth"), APATHY_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_sloth"), APATHY_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_padlock_lust"), SALACIOUS_PADLOCK_BOUND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "padlock_lust"), SALACIOUS_PADLOCK);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_rosemary"), POUNDED_ROSEMARY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_thyme"), POUNDED_THYME);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_tarragon"), POUNDED_TARRAGON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_chamomile"), POUNDED_CHAMOMILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_chives"), POUNDED_CHIVES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_verbena"), POUNDED_VERBENA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_sorrel"), POUNDED_SORREL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_marjoram"), POUNDED_MARJORAM);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_chervil"), POUNDED_CHERVIL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_fennsel"), POUNDED_FENNSEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_ceillis"), POUNDED_CEILLIS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_punuel"), POUNDED_PUNUEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_essitte"), POUNDED_ESSITTE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_thyocielle"), POUNDED_THYOCIELLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_fennkystral"), POUNDED_FENNKYSTRAL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_calendula"), POUNDED_CALENDULA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pounded_sage"), POUNDED_SAGE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_calendula"), DRIED_CALENDULA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_rosemary"), DRIED_ROSEMARY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_thyme"), DRIED_THYME);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_tarragon"), DRIED_TARRAGON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_chamomile"), DRIED_CHAMOMILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_chives"), DRIED_CHIVES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_verbena"), DRIED_VERBENA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_sorrel"), DRIED_SORREL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_marjoram"), DRIED_MARJORAM);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_chervil"), DRIED_CHERVIL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_fennsel"), DRIED_FENNSEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_ceillis"), DRIED_CEILLIS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_punuel"), DRIED_PUNUEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_essitte"), DRIED_ESSITTE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_thyocielle"), DRIED_THYOCIELLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_fennkystral"), DRIED_FENNKYSTRAL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dried_sage"), DRIED_SAGE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regeneration"), REGENERATIVE_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_poison"), VIRULENT_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_slowness"), SEDATING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_mining_fatigue"), HINDERING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_haste"), DASHING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_speed"), ACCELERATION_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_fire"), INCINERATING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_wither"), DECAYING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_night_vision"), OBSERVING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_weakness"), DIMINISHED_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_blindness"), SHADED_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regen_slow"), CONFLICTING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regen_speed_weak"), ALTERNATIVE_BLEND);

        // Smoked
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regeneration_smoked"), SMOKED_REGENERATIVE_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_poison_smoked"), SMOKED_VIRULENT_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_slowness_smoked"), SMOKED_SEDATING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_mining_fatigue_smoked"), SMOKED_HINDERING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_haste_smoked"), SMOKED_DASHING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_speed_smoked"), SMOKED_ACCELERATION_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_fire_smoked"), SMOKED_INCINERATING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_wither_smoked"), SMOKED_DECAYING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_night_vision_smoked"), SMOKED_OBSERVING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_weakness_smoked"), SMOKED_DIMINISHED_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_blindness_smoked"), SMOKED_SHADED_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regen_slow_smoked"), SMOKED_CONFLICTING_BLEND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blend_regen_speed_weak_smoked"), SMOKED_ALTERNATIVE_BLEND);

        // Refined Pouches/Canisters
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pouch_scratched"), SCRATCHED_POUCH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pouch_stitched"), STITCHED_POUCH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pouch_proper"), PROPER_POUCH);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "canister_iron"), IRON_CANISTER);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "canister_amethyst"), AMETHYST_CANISTER);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "canister_diamond"), DIAMOND_CANISTER);


        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer"), HERB_FERTILIZER);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_oak"), HERB_FERTILIZER_OAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_dark_oak"), HERB_FERTILIZER_DARK_OAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_jungle"), HERB_FERTILIZER_JUNGLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_acacia"), HERB_FERTILIZER_ACACIA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_birch"), HERB_FERTILIZER_BIRCH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_spruce"), HERB_FERTILIZER_SPRUCE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_mangrove"), HERB_FERTILIZER_MANGROVE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_cherry"), HERB_FERTILIZER_CHERRY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_crimson"), HERB_FERTILIZER_CRIMSON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_warped"), HERB_FERTILIZER_WARPED);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_fertilizer_myqueste"), HERB_FERTILIZER_MYQUESTE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus"), HERB_HUMUS);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_oak"), HERB_HUMUS_OAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_dark_oak"), HERB_HUMUS_DARK_OAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_jungle"), HERB_HUMUS_JUNGLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_acacia"), HERB_HUMUS_ACACIA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_birch"), HERB_HUMUS_BIRCH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_spruce"), HERB_HUMUS_SPRUCE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_mangrove"), HERB_HUMUS_MANGROVE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_cherry"), HERB_HUMUS_CHERRY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_crimson"), HERB_HUMUS_CRIMSON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_warped"), HERB_HUMUS_WARPED);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "herb_humus_myqueste"), HERB_HUMUS_MYQUESTE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil"), SIGIL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_pride"), SIGIL_PRIDE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_sloth"), SIGIL_SLOTH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_lust"), SIGIL_LUST);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_gluttony"), SIGIL_GLUTTONY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_wrath"), SIGIL_WRATH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_greed"), SIGIL_GREED);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_envy"), SIGIL_ENVY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_configuration"), SIGIL_CONFIGURATION);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_mastery"), SIGIL_MASTERY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_configuration_adv"), SIGIL_CONFIGURATION_ADVANCED);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sigil_mastery_adv"), SIGIL_MASTERY_ADVANCED);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cracked_sigil"), CRACKED_SIGIL);

        // Legacy
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pouch"), POUCH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "canister"), CANISTER);
    }

}
