package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsMod;
import net.dakotapride.hibernalHerbs.common.item.AbstractPouchItem;
import net.dakotapride.hibernalHerbs.common.item.HerbBlendItem;
import net.dakotapride.hibernalHerbs.common.item.HerbPouchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.HibernalHerbsMod.HIBERNAL_HERBS_ID;

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

    public static AbstractPouchItem POUCH = new AbstractPouchItem(new FabricItemSettings().maxCount(1)
            .group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), 256);

    public static void init () {
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_rosemary"), POUNDED_ROSEMARY);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_thyme"), POUNDED_THYME);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_tarragon"), POUNDED_TARRAGON);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_chamomile"), POUNDED_CHAMOMILE);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_chives"), POUNDED_CHIVES);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_verbena"), POUNDED_VERBENA);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_sorrel"), POUNDED_SORREL);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_marjoram"), POUNDED_MARJORAM);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_chervil"), POUNDED_CHERVIL);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_fennsel"), POUNDED_FENNSEL);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_ceillis"), POUNDED_CEILLIS);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_punuel"), POUNDED_PUNUEL);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_essitte"), POUNDED_ESSITTE);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_thyocielle"), POUNDED_THYOCIELLE);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pounded_fennkystral"), POUNDED_FENNKYSTRAL);

        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_regeneration"), REGENERATIVE_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_poison"), VIRULENT_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_slowness"), SEDATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_mining_fatigue"), HINDERING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_haste"), DASHING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_speed"), ACCELERATION_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_fire"), INCINERATING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_wither"), DECAYING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_night_vision"), OBSERVING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_weakness"), DIMINISHED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_blindness"), SHADED_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_regen_slow"), CONFLICTING_BLEND);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "blend_regen_speed_weak"), ALTERNATIVE_BLEND);

        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "herb_fertilizer"), HERB_FERTILIZER);
        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "pouch"), POUCH);
    }

}
