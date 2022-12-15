package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.item.HerbBlendItem;
import net.dakotapride.hibernalHerbs.common.item.HerbPouchItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class itemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<Item> HERB_FERTILIZER = ITEMS.register("herb_fertilizer",
            () -> new Item(new Item.Properties().tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> POUCH = ITEMS.register("pouch",
            () -> new HerbPouchItem(new Item.Properties().stacksTo(1).tab(HibernalHerbsForge.HIBERNAL_HERBS), 256));

    public static final RegistryObject<Item> POUNDED_ROSEMARY = ITEMS.register("pounded_rosemary",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_THYME = ITEMS.register("pounded_thyme",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_TARRAGON = ITEMS.register("pounded_tarragon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_CHAMOMILE = ITEMS.register("pounded_chamomile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_CHIVES = ITEMS.register("pounded_chives",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_VERBENA = ITEMS.register("pounded_verbena",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_SORREL = ITEMS.register("pounded_sorrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_MARJORAM = ITEMS.register("pounded_marjoram",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_CHERVIL = ITEMS.register("pounded_chervil",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_FENNSEL = ITEMS.register("pounded_fennsel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_CEILLIS = ITEMS.register("pounded_ceillis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_PUNUEL = ITEMS.register("pounded_punuel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_ESSITTE = ITEMS.register("pounded_essitte",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));

    // Resource Dependant (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_THYOCIELLE = ITEMS.register("pounded_thyocielle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(6f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> POUNDED_FENNKYSTRAL = ITEMS.register("pounded_fennkystral",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(6f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));

    public static final RegistryObject<Item> REGENERATIVE_BLEND = ITEMS.register("blend_regeneration",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> VIRULENT_BLEND = ITEMS.register("blend_poison",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.POISON, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SEDATING_BLEND = ITEMS.register("blend_slowness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> HINDERING_BLEND = ITEMS.register("blend_mining_fatigue",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DASHING_BLEND = ITEMS.register("blend_haste",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> ACCELERATION_BLEND = ITEMS.register("blend_speed",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> INCINERATING_BLEND = ITEMS.register("blend_fire",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).alwaysEat().saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DECAYING_BLEND = ITEMS.register("blend_wither",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WITHER, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> OBSERVING_BLEND = ITEMS.register("blend_night_vision",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DIMINISHED_BLEND = ITEMS.register("blend_weakness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SHADED_BLEND = ITEMS.register("blend_blindness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    // Resource Dependant (Blends) Herbs (Forge)
    public static final RegistryObject<Item> CONFLICTING_BLEND = ITEMS.register("blend_regen_slow",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> ALTERNATIVE_BLEND = ITEMS.register("blend_regen_speed_weak",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 420, 1), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 420, 1), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, 420, 1), 1.0F).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
