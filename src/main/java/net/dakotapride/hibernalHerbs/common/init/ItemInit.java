package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsMod;
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

    public static Item HERB_FERTILIZER = new Item(new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS));


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

        Registry.register(Registry.ITEM, new Identifier(HIBERNAL_HERBS_ID, "herb_fertilizer"), HERB_FERTILIZER);
    }

}
