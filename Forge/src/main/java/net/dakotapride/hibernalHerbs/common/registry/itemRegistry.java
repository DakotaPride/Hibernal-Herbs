package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.item.*;
import net.dakotapride.hibernalHerbs.common.item.abstractItem.AbstractCanisterItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class itemRegistry implements FoodComponentList {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<Item> MYQUESTE_BOAT = ITEMS.register("myqueste_boat",
            () -> new MyquesteBoatItem(false, MyquesteBoatEntity.BoatType.MYQUESTE, new Item.Properties()));
    public static final RegistryObject<Item> MYQUESTE_CHEST_BOAT = ITEMS.register("myqueste_chest_boat",
            () -> new MyquesteBoatItem(true, MyquesteBoatEntity.BoatType.MYQUESTE, new Item.Properties()));

    public static final RegistryObject<Item> MYQUESTE_SIGN = ITEMS.register("myqueste_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16).tab(HibernalHerbsForge.HIBERNAL_HERBS),
                    blockRegistry.MYQUESTE_SIGN.get(), blockRegistry.MYQUESTE_WALL_SIGN.get()));

    public static final RegistryObject<Item> HERB_FERTILIZER = ITEMS.register("herb_fertilizer",
            () -> new HerbFertilizerItem(new Item.Properties().tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    public static final RegistryObject<Item> HERB_FERTILIZER_OAK = ITEMS.register("herb_fertilizer_oak",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_BIRCH = ITEMS.register("herb_fertilizer_birch",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_DARK_OAK = ITEMS.register("herb_fertilizer_dark_oak",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_ACACIA = ITEMS.register("herb_fertilizer_acacia",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_JUNGLE = ITEMS.register("herb_fertilizer_jungle",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_SPRUCE = ITEMS.register("herb_fertilizer_spruce",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_MANGROVE = ITEMS.register("herb_fertilizer_mangrove",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_CRIMSON = ITEMS.register("herb_fertilizer_crimson",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_WARPED = ITEMS.register("herb_fertilizer_warped",
            () -> new HerbFertilizerItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_FERTILIZER_MYQUESTE = ITEMS.register("herb_fertilizer_myqueste",
            () -> new HerbFertilizerItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_HUMUS = ITEMS.register("herb_humus",
            () -> new HerbHumusItem(new Item.Properties().tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    public static final RegistryObject<Item> HERB_HUMUS_OAK = ITEMS.register("herb_humus_oak",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_BIRCH = ITEMS.register("herb_humus_birch",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_DARK_OAK = ITEMS.register("herb_humus_dark_oak",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_ACACIA = ITEMS.register("herb_humus_acacia",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_JUNGLE = ITEMS.register("herb_humus_jungle",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_SPRUCE = ITEMS.register("herb_humus_spruce",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_MANGROVE = ITEMS.register("herb_humus_mangrove",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_CRIMSON = ITEMS.register("herb_humus_crimson",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_WARPED = ITEMS.register("herb_humus_warped",
            () -> new HerbHumusItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_HUMUS_MYQUESTE = ITEMS.register("herb_humus_myqueste",
            () -> new HerbHumusItem(new Item.Properties()));


    // Refined Pouches/Canisters
    public static final RegistryObject<Item> POUCH_SCRATCHED = ITEMS.register("pouch_scratched",
            () -> new HerbPouchItem(new Item.Properties().stacksTo(1).tab(HibernalHerbsForge.HIBERNAL_HERBS), 64));
    public static final RegistryObject<Item> CANISTER_IRON = ITEMS.register("canister_iron",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1).tab(HibernalHerbsForge.HIBERNAL_HERBS), 128));
    public static final RegistryObject<Item> POUCH_STITCHED = ITEMS.register("pouch_stitched",
            () -> new HerbPouchItem(new Item.Properties().stacksTo(1), 192));
    public static final RegistryObject<Item> CANISTER_AMETHYST = ITEMS.register("canister_amethyst",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1).tab(HibernalHerbsForge.HIBERNAL_HERBS), 256));
    public static final RegistryObject<Item> POUCH_PROPER = ITEMS.register("pouch_proper",
            () -> new HerbPouchItem(new Item.Properties().stacksTo(1), 256));
    public static final RegistryObject<Item> CANISTER_DIAMOND = ITEMS.register("canister_diamond",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1).tab(HibernalHerbsForge.HIBERNAL_HERBS), 384));


    // Legacy
    public static final RegistryObject<Item> POUCH = ITEMS.register("pouch",
            () -> new HerbPouchItem(new Item.Properties().stacksTo(1), 256));
    public static final RegistryObject<Item> CANISTER = ITEMS.register("canister",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1), 384));

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

    // Spring (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_CALENDULA = ITEMS.register("pounded_calendula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(6f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));

    public static final RegistryObject<Item> DRIED_CALENDULA = ITEMS.register("dried_calendula",
            () -> new Item(new Item.Properties().tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_ROSEMARY = ITEMS.register("dried_rosemary",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_THYME = ITEMS.register("dried_thyme",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_TARRAGON = ITEMS.register("dried_tarragon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_CHAMOMILE = ITEMS.register("dried_chamomile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_CHIVES = ITEMS.register("dried_chives",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_VERBENA = ITEMS.register("dried_verbena",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_SORREL = ITEMS.register("dried_sorrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_MARJORAM = ITEMS.register("dried_marjoram",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_CHERVIL = ITEMS.register("dried_chervil",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_FENNSEL = ITEMS.register("dried_fennsel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_CEILLIS = ITEMS.register("dried_ceillis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_PUNUEL = ITEMS.register("dried_punuel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_ESSITTE = ITEMS.register("dried_essitte",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_THYOCIELLE = ITEMS.register("dried_thyocielle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(6f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));
    public static final RegistryObject<Item> DRIED_FENNKYSTRAL = ITEMS.register("dried_fennkystral",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(6f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));

    // Compat (Pounded) Herbs (Forge)
    public static final RegistryObject<Item> POUNDED_BLOFORIA = ITEMS.register("pounded_bloforia",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(3f).build()).tab(HibernalHerbsForge.POUNDED_HERBS)));

    public static final RegistryObject<Item> REGENERATIVE_BLEND = ITEMS.register("blend_regeneration",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> VIRULENT_BLEND = ITEMS.register("blend_poison",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.POISON, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SEDATING_BLEND = ITEMS.register("blend_slowness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> HINDERING_BLEND = ITEMS.register("blend_mining_fatigue",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, miningSpeedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DASHING_BLEND = ITEMS.register("blend_haste",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, miningSpeedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> ACCELERATION_BLEND = ITEMS.register("blend_speed",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> INCINERATING_BLEND = ITEMS.register("blend_fire",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).alwaysEat().saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DECAYING_BLEND = ITEMS.register("blend_wither",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WITHER, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> OBSERVING_BLEND = ITEMS.register("blend_night_vision",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, visionDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> DIMINISHED_BLEND = ITEMS.register("blend_weakness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SHADED_BLEND = ITEMS.register("blend_blindness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, visionDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    // Resource Dependant (Blends) Herbs (Forge)
    public static final RegistryObject<Item> CONFLICTING_BLEND = ITEMS.register("blend_regen_slow",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> ALTERNATIVE_BLEND = ITEMS.register("blend_regen_speed_weak",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration + 120, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration + 100, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration + 80, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    // Compat Herbs (Forge)
    public static final RegistryObject<Item> BLOOMING_BLEND = ITEMS.register("blend_glowing",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.GLOWING, glowingDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    // Smoked
    public static final RegistryObject<Item> SMOKED_REGENERATIVE_BLEND = ITEMS.register("blend_regeneration_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_VIRULENT_BLEND = ITEMS.register("blend_poison_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_SEDATING_BLEND = ITEMS.register("blend_slowness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_HINDERING_BLEND = ITEMS.register("blend_mining_fatigue_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_DASHING_BLEND = ITEMS.register("blend_haste_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_ACCELERATION_BLEND = ITEMS.register("blend_speed_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_INCINERATING_BLEND = ITEMS.register("blend_fire_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).alwaysEat().saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_DECAYING_BLEND = ITEMS.register("blend_wither_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_OBSERVING_BLEND = ITEMS.register("blend_night_vision_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_DIMINISHED_BLEND = ITEMS.register("blend_weakness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_SHADED_BLEND = ITEMS.register("blend_blindness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    // Resource Dependant (Smoked Blends) Herbs (Forge)
    public static final RegistryObject<Item> SMOKED_CONFLICTING_BLEND = ITEMS.register("blend_regen_slow_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));
    public static final RegistryObject<Item> SMOKED_ALTERNATIVE_BLEND = ITEMS.register("blend_regen_speed_weak_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration + 120, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration + 100, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration + 80, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    // Compat Herbs (Forge)
    public static final RegistryObject<Item> SMOKED_BLOOMING_BLEND = ITEMS.register("blend_glowing_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.GLOWING, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(6).build()).tab(HibernalHerbsForge.HIBERNAL_HERBS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
