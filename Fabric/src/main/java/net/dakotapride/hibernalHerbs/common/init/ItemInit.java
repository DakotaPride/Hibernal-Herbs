package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsMod;
import net.dakotapride.hibernalHerbs.common.item.canister.AbstractCanisterItem;
import net.dakotapride.hibernalHerbs.common.item.pouch.AbstractPouchItem;
import net.dakotapride.hibernalHerbs.common.item.HerbBlendItem;
import net.dakotapride.hibernalHerbs.common.item.SmokedHerbBlendItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ItemInit {

    public static Item POUNDED_ROSEMARY = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_THYME = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_TARRAGON = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_CHAMOMILE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_CHIVES = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_VERBENA = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_SORREL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_MARJORAM = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_CHERVIL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_FENNSEL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_CEILLIS = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_PUNUEL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_ESSITTE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));

    // Resource Dependant (Pounded) Herbs

    public static Item POUNDED_THYOCIELLE = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));
    public static Item POUNDED_FENNKYSTRAL = new Item(new FabricItemSettings().food(FoodComponentInit.POUNDED_HERB)
            .group(HibernalHerbsMod.groupManager.POUNDED_HERBS));

    public static HerbBlendItem REGENERATIVE_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.REGENERATIVE_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem VIRULENT_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.VIRULENT_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem SEDATING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SEDATING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem HINDERING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.HINDERING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem DASHING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DASHING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem ACCELERATION_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.ACCELERATION_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem INCINERATING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.INCINERATING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem DECAYING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DECAYING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem OBSERVING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.OBSERVING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem DIMINISHED_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.DIMINISHED_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem SHADED_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SHADED_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));

    // Resource Dependant (Blends) Herbs

    public static HerbBlendItem CONFLICTING_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.CONFLICTING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static HerbBlendItem ALTERNATIVE_BLEND = new HerbBlendItem(new FabricItemSettings().food(FoodComponentInit.ALTERNATIVE_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));

    public static Item HERB_FERTILIZER = new Item(new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));

    // Smoked Herb Blends (Fabric)
    public static SmokedHerbBlendItem SMOKED_REGENERATIVE_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_REGENERATIVE_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_VIRULENT_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_VIRULENT_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_SEDATING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_SEDATING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_HINDERING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_HINDERING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_DASHING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DASHING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_ACCELERATION_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_ACCELERATION_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_INCINERATING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_INCINERATING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_DECAYING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DECAYING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_OBSERVING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_OBSERVING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_DIMINISHED_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_DIMINISHED_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_SHADED_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_SHADED_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));

    // Resource Dependant (Smoked Blends) Herbs

    public static SmokedHerbBlendItem SMOKED_CONFLICTING_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_CONFLICTING_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));
    public static SmokedHerbBlendItem SMOKED_ALTERNATIVE_BLEND = new SmokedHerbBlendItem(new FabricItemSettings().food(FoodComponentInit.SMOKED_ALTERNATIVE_BLEND)
            .maxCount(1).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));

    // Refined Pouches/Canisters

    public static AbstractPouchItem SCRATCHED_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 64);
    public static AbstractCanisterItem IRON_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 128);

    public static AbstractPouchItem STITCHED_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 192);
    public static AbstractCanisterItem AMETHYST_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 256);

    public static AbstractPouchItem PROPER_POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 256);
    public static AbstractCanisterItem DIAMOND_CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 384);

    // Legacy

    public static AbstractPouchItem POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1), 256);
    public static AbstractCanisterItem CANISTER = new AbstractCanisterItem(new FabricItemSettings().maxCount(1), 384);

    public static void init () {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_rosemary"), POUNDED_ROSEMARY);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_thyme"), POUNDED_THYME);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_tarragon"), POUNDED_TARRAGON);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_chamomile"), POUNDED_CHAMOMILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_chives"), POUNDED_CHIVES);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_verbena"), POUNDED_VERBENA);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_sorrel"), POUNDED_SORREL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_marjoram"), POUNDED_MARJORAM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_chervil"), POUNDED_CHERVIL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_fennsel"), POUNDED_FENNSEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_ceillis"), POUNDED_CEILLIS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_punuel"), POUNDED_PUNUEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_essitte"), POUNDED_ESSITTE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_thyocielle"), POUNDED_THYOCIELLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pounded_fennkystral"), POUNDED_FENNKYSTRAL);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regeneration"), REGENERATIVE_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_poison"), VIRULENT_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_slowness"), SEDATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_mining_fatigue"), HINDERING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_haste"), DASHING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_speed"), ACCELERATION_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_fire"), INCINERATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_wither"), DECAYING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_night_vision"), OBSERVING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_weakness"), DIMINISHED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_blindness"), SHADED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regen_slow"), CONFLICTING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regen_speed_weak"), ALTERNATIVE_BLEND);

        // Smoked
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regeneration_smoked"), SMOKED_REGENERATIVE_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_poison_smoked"), SMOKED_VIRULENT_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_slowness_smoked"), SMOKED_SEDATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_mining_fatigue_smoked"), SMOKED_HINDERING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_haste_smoked"), SMOKED_DASHING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_speed_smoked"), SMOKED_ACCELERATION_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_fire_smoked"), SMOKED_INCINERATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_wither_smoked"), SMOKED_DECAYING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_night_vision_smoked"), SMOKED_OBSERVING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_weakness_smoked"), SMOKED_DIMINISHED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_blindness_smoked"), SMOKED_SHADED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regen_slow_smoked"), SMOKED_CONFLICTING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blend_regen_speed_weak_smoked"), SMOKED_ALTERNATIVE_BLEND);

        // Refined Pouches/Canisters
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pouch_scratched"), SCRATCHED_POUCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pouch_stitched"), STITCHED_POUCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pouch_proper"), PROPER_POUCH);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "canister_iron"), IRON_CANISTER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "canister_amethyst"), AMETHYST_CANISTER);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "canister_diamond"), DIAMOND_CANISTER);


        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "herb_fertilizer"), HERB_FERTILIZER);

        // Legacy
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pouch"), POUCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "canister"), CANISTER);
    }

}
