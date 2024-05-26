package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.item.*;
import net.dakotapride.hibernalHerbs.common.item.abstractItem.AbstractCanisterItem;
import net.dakotapride.hibernalHerbs.common.item.abstractItem.AbstractPouchItem;
import net.dakotapride.hibernalHerbs.common.item.curse.CursedPadlockItem;
import net.dakotapride.hibernalHerbs.common.item.curse.grimoire.HerbalGrimoireItem;
import net.dakotapride.hibernalHerbs.common.item.ring.GluttonousRingItem;
import net.dakotapride.hibernalHerbs.common.item.ring.adv.AdvancedGluttonousRingItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ItemRegistry implements FoodComponentList {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> GROUND_HERBS = ITEMS.register("ground_herbs",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HERBAL_GRIMOIRE = ITEMS.register("grimoire",
            () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SINGED_GRIMOIRE = ITEMS.register("singed_grimoire",
            () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SILIPTIUM_PETAL = ITEMS.register("sin_petals",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LUMBINETRIK_PETAL = ITEMS.register("lumbinetrik_petals",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VEXATION_PADLOCK_BOUND = ITEMS.register("bound_padlock_wrath",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> VEXATION_PADLOCK = ITEMS.register("padlock_wrath",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PIQUE_PADLOCK_BOUND = ITEMS.register("bound_padlock_pride",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> PIQUE_PADLOCK = ITEMS.register("padlock_pride",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> GOURMANDIZING_PADLOCK_BOUND = ITEMS.register("bound_padlock_gluttony",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> GOURMANDIZING_PADLOCK = ITEMS.register("padlock_gluttony",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> AVARICE_PADLOCK_BOUND = ITEMS.register("bound_padlock_greed",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> AVARICE_PADLOCK = ITEMS.register("padlock_greed",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPITEFUL_PADLOCK_BOUND = ITEMS.register("bound_padlock_envy",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> SPITEFUL_PADLOCK = ITEMS.register("padlock_envy",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> APATHY_PADLOCK_BOUND = ITEMS.register("bound_padlock_sloth",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> APATHY_PADLOCK = ITEMS.register("padlock_sloth",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SALACIOUS_PADLOCK_BOUND = ITEMS.register("bound_padlock_lust",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1).defaultDurability(1)));
    public static final RegistryObject<Item> SALACIOUS_PADLOCK = ITEMS.register("padlock_lust",
            () -> new CursedPadlockItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RING = ITEMS.register("ring",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GLUTTONOUS_RING = ITEMS.register("gluttonous_ring",
            () -> new GluttonousRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ADV_GLUTTONOUS_RING = ITEMS.register("gluttonous_ring_adv",
            () -> new AdvancedGluttonousRingItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CRACKED_SIGIL = ITEMS.register("cracked_sigil",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SIGIL = ITEMS.register("sigil",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(8)));

    public static final RegistryObject<Item> SIGIL_WRATH = ITEMS.register("sigil_wrath",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_GREED = ITEMS.register("sigil_greed",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_LUST = ITEMS.register("sigil_lust",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_GLUTTONY = ITEMS.register("sigil_gluttony",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_ENVY = ITEMS.register("sigil_envy",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_PRIDE = ITEMS.register("sigil_pride",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_SLOTH = ITEMS.register("sigil_sloth",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SIGIL_CONFIGURATION = ITEMS.register("sigil_configuration",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_MASTERY = ITEMS.register("sigil_mastery",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SIGIL_CONFIGURATION_ADV = ITEMS.register("sigil_configuration_adv",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SIGIL_MASTERY_ADV = ITEMS.register("sigil_mastery_adv",
            () -> new HerbalSigilItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MYQUESTE_BOAT = ITEMS.register("myqueste_boat",
            () -> new MyquesteBoatItem(false, new Item.Properties().stacksTo(1), BlockRegistry.MYQUESTE_TYPE));
    public static final RegistryObject<Item> MYQUESTE_CHEST_BOAT = ITEMS.register("myqueste_chest_boat",
            () -> new MyquesteBoatItem(true, new Item.Properties().stacksTo(1), BlockRegistry.MYQUESTE_TYPE));

    public static final RegistryObject<Item> MYQUESTE_SIGN = ITEMS.register("myqueste_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    BlockRegistry.MYQUESTE_SIGN.get(), BlockRegistry.MYQUESTE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MYQUESTE_HANGING_SIGN = ITEMS.register("myqueste_hanging_sign",
            () -> new HangingSignItem(BlockRegistry.MYQUESTE_HANGING_SIGN.get(), BlockRegistry.MYQUESTE_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HERB_FERTILIZER = ITEMS.register("herb_fertilizer",
            () -> new HerbFertilizerItem(new Item.Properties()));

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
    public static final RegistryObject<Item> HERB_FERTILIZER_CHERRY = ITEMS.register("herb_fertilizer_cherry",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_CRIMSON = ITEMS.register("herb_fertilizer_crimson",
            () -> new HerbFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_FERTILIZER_WARPED = ITEMS.register("herb_fertilizer_warped",
            () -> new HerbFertilizerItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_FERTILIZER_MYQUESTE = ITEMS.register("herb_fertilizer_myqueste",
            () -> new HerbFertilizerItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_HUMUS = ITEMS.register("herb_humus",
            () -> new HerbHumusItem(new Item.Properties()));

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
    public static final RegistryObject<Item> HERB_HUMUS_CHERRY = ITEMS.register("herb_humus_cherry",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_CRIMSON = ITEMS.register("herb_humus_crimson",
            () -> new HerbHumusItem(new Item.Properties()));
    public static final RegistryObject<Item> HERB_HUMUS_WARPED = ITEMS.register("herb_humus_warped",
            () -> new HerbHumusItem(new Item.Properties()));

    public static final RegistryObject<Item> HERB_HUMUS_MYQUESTE = ITEMS.register("herb_humus_myqueste",
            () -> new HerbHumusItem(new Item.Properties()));


    // Refined Pouches/Canisters
    public static final RegistryObject<Item> POUCH_SCRATCHED = ITEMS.register("pouch_scratched",
            () -> new AbstractPouchItem(new Item.Properties().stacksTo(1), 64));
    public static final RegistryObject<Item> CANISTER_IRON = ITEMS.register("canister_iron",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1), 128));
    public static final RegistryObject<Item> POUCH_STITCHED = ITEMS.register("pouch_stitched",
            () -> new AbstractPouchItem(new Item.Properties().stacksTo(1), 192));
    public static final RegistryObject<Item> CANISTER_AMETHYST = ITEMS.register("canister_amethyst",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1), 256));
    public static final RegistryObject<Item> POUCH_PROPER = ITEMS.register("pouch_proper",
            () -> new AbstractPouchItem(new Item.Properties().stacksTo(1), 256));
    public static final RegistryObject<Item> CANISTER_DIAMOND = ITEMS.register("canister_diamond",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1), 384));


    // Legacy
    public static final RegistryObject<Item> POUCH = ITEMS.register("pouch",
            () -> new AbstractPouchItem(new Item.Properties().stacksTo(1), 256));
    public static final RegistryObject<Item> CANISTER = ITEMS.register("canister",
            () -> new AbstractCanisterItem(new Item.Properties().stacksTo(1), 384));

    public static final RegistryObject<Item> POUNDED_ROSEMARY = ITEMS.register("pounded_rosemary",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_THYME = ITEMS.register("pounded_thyme",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_TARRAGON = ITEMS.register("pounded_tarragon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_CHAMOMILE = ITEMS.register("pounded_chamomile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_CHIVES = ITEMS.register("pounded_chives",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_VERBENA = ITEMS.register("pounded_verbena",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_SORREL = ITEMS.register("pounded_sorrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_MARJORAM = ITEMS.register("pounded_marjoram",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_CHERVIL = ITEMS.register("pounded_chervil",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_FENNSEL = ITEMS.register("pounded_fennsel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_CEILLIS = ITEMS.register("pounded_ceillis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_PUNUEL = ITEMS.register("pounded_punuel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> POUNDED_ESSITTE = ITEMS.register("pounded_essitte",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));

    // Resource Dependant (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_THYOCIELLE = ITEMS.register("pounded_thyocielle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> POUNDED_FENNKYSTRAL = ITEMS.register("pounded_fennkystral",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.6f).build())));

    // Spring (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_CALENDULA = ITEMS.register("pounded_calendula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.6f).build())));

    public static final RegistryObject<Item> POUNDED_SAGE = ITEMS.register("pounded_sage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(4).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> DRIED_CALENDULA = ITEMS.register("dried_calendula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_ROSEMARY = ITEMS.register("dried_rosemary",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_THYME = ITEMS.register("dried_thyme",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_TARRAGON = ITEMS.register("dried_tarragon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_CHAMOMILE = ITEMS.register("dried_chamomile",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_CHIVES = ITEMS.register("dried_chives",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_VERBENA = ITEMS.register("dried_verbena",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_SORREL = ITEMS.register("dried_sorrel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_MARJORAM = ITEMS.register("dried_marjoram",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_CHERVIL = ITEMS.register("dried_chervil",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_FENNSEL = ITEMS.register("dried_fennsel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_CEILLIS = ITEMS.register("dried_ceillis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_PUNUEL = ITEMS.register("dried_punuel",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_ESSITTE = ITEMS.register("dried_essitte",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_THYOCIELLE = ITEMS.register("dried_thyocielle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_FENNKYSTRAL = ITEMS.register("dried_fennkystral",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));
    public static final RegistryObject<Item> DRIED_SAGE = ITEMS.register("dried_sage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .fast().nutrition(8).saturationMod(0.5F).build())));

    // Compat (Pounded) Herbs (Forge)
    public static final RegistryObject<Item> POUNDED_BLOFORIA = ITEMS.register("pounded_bloforia",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REGENERATION_BLEND = ITEMS.register("blend_regeneration",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> POISON_BLEND = ITEMS.register("blend_poison",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.POISON, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SLOWNESS_BLEND = ITEMS.register("blend_slowness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> MINING_FATIGUE_BLEND = ITEMS.register("blend_mining_fatigue",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, miningSpeedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> HASTE_BLEND = ITEMS.register("blend_haste",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, miningSpeedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SPEED_BLEND = ITEMS.register("blend_speed",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> FIRE_BLEND = ITEMS.register("blend_fire",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).alwaysEat().saturationMod(0.6f).build())));
    public static final RegistryObject<Item> WITHER_BLEND = ITEMS.register("blend_wither",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WITHER, healthDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> NIGHT_VISION_BLEND = ITEMS.register("blend_night_vision",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, visionDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> WEAKNESS_BLEND = ITEMS.register("blend_weakness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> BLINDNESS_BLEND = ITEMS.register("blend_blindness",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, visionDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    // Resource Dependant (Blends) Herbs (Forge)
    public static final RegistryObject<Item> REGENERATION_SLOWNESS_BLEND = ITEMS.register("blend_regen_slow",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> REGENERATION_SPEED_WEAKNESS_BLEND = ITEMS.register("blend_regen_speed_weak",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration + 120, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration + 100, baseMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration + 80, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));

    // Compat Herbs (Forge)
    public static final RegistryObject<Item> GLOWING_BLEND = ITEMS.register("blend_glowing",
            () -> new HerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.GLOWING, glowingDuration, baseMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));

    // Smoked
    public static final RegistryObject<Item> SMOKED_REGENERATION_BLEND = ITEMS.register("blend_regeneration_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_POISON_BLEND = ITEMS.register("blend_poison_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_SLOWNESS_BLEND = ITEMS.register("blend_slowness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_MINING_FATIGUE_BLEND = ITEMS.register("blend_mining_fatigue_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_HASTE_BLEND = ITEMS.register("blend_haste_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_SPEED_BLEND = ITEMS.register("blend_speed_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_FIRE_BLEND = ITEMS.register("blend_fire_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(7).alwaysEat().saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_WITHER_BLEND = ITEMS.register("blend_wither_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_NIGHT_VISION_BLEND = ITEMS.register("blend_night_vision_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_WEAKNESS_BLEND = ITEMS.register("blend_weakness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_BLINDNESS_BLEND = ITEMS.register("blend_blindness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    // Resource Dependant (Smoked Blends) Herbs (Forge)
    public static final RegistryObject<Item> SMOKED_REGENERATION_SLOWNESS_BLEND = ITEMS.register("blend_regen_slow_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND = ITEMS.register("blend_regen_speed_weak_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration + 120, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration + 100, smokedMultiplier), baseChance)
                    .effect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration + 80, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));

    // Compat Herbs (Forge)
    public static final RegistryObject<Item> SMOKED_GLOWING_BLEND = ITEMS.register("blend_glowing_smoked",
            () -> new SmokedHerbBlendItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .effect(new MobEffectInstance(MobEffects.GLOWING, smokedVisionDuration, smokedMultiplier), baseChance).alwaysEat().nutrition(7).saturationMod(0.6f).build())));

    // Tabs
    public static final RegistryObject<CreativeModeTab> HIBERNAL_HERBS_TAB = CREATIVE_MODE_TABS.register("hibernal_herbs",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.hibernalherbs.hibernal_herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.CONJURATION_ALTAR.get().asItem())).displayItems((parameters, output) -> {
                        output.accept(GROUND_HERBS.get());
                        output.accept(HERB_FERTILIZER.get());
                        output.accept(HERB_HUMUS.get());
                        output.accept(POUCH_SCRATCHED.get());
                        output.accept(POUCH_STITCHED.get());
                        output.accept(POUCH_PROPER.get());
                        output.accept(CANISTER_IRON.get());
                        output.accept(CANISTER_AMETHYST.get());
                        output.accept(CANISTER_DIAMOND.get());

                        output.accept(REGENERATION_BLEND.get());
                        output.accept(SMOKED_REGENERATION_BLEND.get());
                        output.accept(POISON_BLEND.get());
                        output.accept(SMOKED_POISON_BLEND.get());
                        output.accept(SLOWNESS_BLEND.get());
                        output.accept(SMOKED_SLOWNESS_BLEND.get());
                        output.accept(MINING_FATIGUE_BLEND.get());
                        output.accept(SMOKED_MINING_FATIGUE_BLEND.get());
                        output.accept(HASTE_BLEND.get());
                        output.accept(SMOKED_HASTE_BLEND.get());
                        output.accept(SPEED_BLEND.get());
                        output.accept(SMOKED_SPEED_BLEND.get());
                        output.accept(FIRE_BLEND.get());
                        output.accept(SMOKED_FIRE_BLEND.get());
                        output.accept(WITHER_BLEND.get());
                        output.accept(SMOKED_WITHER_BLEND.get());
                        output.accept(NIGHT_VISION_BLEND.get());
                        output.accept(SMOKED_NIGHT_VISION_BLEND.get());
                        output.accept(WEAKNESS_BLEND.get());
                        output.accept(SMOKED_WEAKNESS_BLEND.get());
                        output.accept(BLINDNESS_BLEND.get());
                        output.accept(SMOKED_BLINDNESS_BLEND.get());
                        output.accept(REGENERATION_SLOWNESS_BLEND.get());
                        output.accept(SMOKED_REGENERATION_SLOWNESS_BLEND.get());
                        output.accept(REGENERATION_SPEED_WEAKNESS_BLEND.get());
                        output.accept(SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.get());

                        output.accept(HERBAL_GRIMOIRE.get());
                        output.accept(SINGED_GRIMOIRE.get());

                        output.accept(SILIPTIUM_PETAL.get());
                        output.accept(LUMBINETRIK_PETAL.get());

                        output.accept(SIGIL.get());
                        output.accept(SIGIL_PRIDE.get());
                        output.accept(SIGIL_WRATH.get());
                        output.accept(SIGIL_GLUTTONY.get());
                        output.accept(SIGIL_SLOTH.get());
                        output.accept(SIGIL_LUST.get());
                        output.accept(SIGIL_ENVY.get());
                        output.accept(SIGIL_GREED.get());
                        output.accept(SIGIL_CONFIGURATION.get());
                        output.accept(SIGIL_CONFIGURATION_ADV.get());
                        output.accept(SIGIL_MASTERY.get());
                        output.accept(SIGIL_MASTERY_ADV.get());

                        output.accept(PIQUE_PADLOCK.get());
                        output.accept(PIQUE_PADLOCK_BOUND.get());
                        output.accept(VEXATION_PADLOCK.get());
                        output.accept(VEXATION_PADLOCK_BOUND.get());
                        output.accept(GOURMANDIZING_PADLOCK.get());
                        output.accept(GOURMANDIZING_PADLOCK_BOUND.get());
                        output.accept(APATHY_PADLOCK.get());
                        output.accept(APATHY_PADLOCK_BOUND.get());
                        output.accept(SALACIOUS_PADLOCK.get());
                        output.accept(SALACIOUS_PADLOCK_BOUND.get());
                        output.accept(SPITEFUL_PADLOCK.get());
                        output.accept(SPITEFUL_PADLOCK_BOUND.get());
                        output.accept(AVARICE_PADLOCK.get());
                        output.accept(AVARICE_PADLOCK_BOUND.get());

                        output.accept(RING.get());
                        output.accept(GLUTTONOUS_RING.get());
                        output.accept(ADV_GLUTTONOUS_RING.get());

                        output.accept(BlockRegistry.CONJURATION_ALTAR.get().asItem());

                        output.accept(BlockRegistry.CALENDULA_LANTERN.get().asItem());
                        output.accept(BlockRegistry.ROSEMARY_LANTERN.get().asItem());
                        output.accept(BlockRegistry.THYME_LANTERN.get().asItem());
                        output.accept(BlockRegistry.TARRAGON_LANTERN.get().asItem());
                        output.accept(BlockRegistry.CHAMOMILE_LANTERN.get().asItem());
                        output.accept(BlockRegistry.CHIVES_LANTERN.get().asItem());
                        output.accept(BlockRegistry.VERBENA_LANTERN.get().asItem());
                        output.accept(BlockRegistry.SORREL_LANTERN.get().asItem());
                        output.accept(BlockRegistry.MARJORAM_LANTERN.get().asItem());
                        output.accept(BlockRegistry.CHERVIL_LANTERN.get().asItem());
                        output.accept(BlockRegistry.FENNSEL_LANTERN.get().asItem());
                        output.accept(BlockRegistry.CEILLIS_LANTERN.get().asItem());
                        output.accept(BlockRegistry.PUNUEL_LANTERN.get().asItem());
                        output.accept(BlockRegistry.ESSITTE_LANTERN.get().asItem());
                        output.accept(BlockRegistry.FENNKYSTRAL_LANTERN.get().asItem());
                        output.accept(BlockRegistry.THYOCIELLE_LANTERN.get().asItem());
                        output.accept(BlockRegistry.SAGE_LANTERN.get().asItem());

                        output.accept(BlockRegistry.CALENDULA_BARREL.get().asItem());
                        output.accept(BlockRegistry.ROSEMARY_BARREL.get().asItem());
                        output.accept(BlockRegistry.THYME_BARREL.get().asItem());
                        output.accept(BlockRegistry.TARRAGON_BARREL.get().asItem());
                        output.accept(BlockRegistry.CHAMOMILE_BARREL.get().asItem());
                        output.accept(BlockRegistry.CHIVES_BARREL.get().asItem());
                        output.accept(BlockRegistry.VERBENA_BARREL.get().asItem());
                        output.accept(BlockRegistry.SORREL_BARREL.get().asItem());
                        output.accept(BlockRegistry.MARJORAM_BARREL.get().asItem());
                        output.accept(BlockRegistry.CHERVIL_BARREL.get().asItem());
                        output.accept(BlockRegistry.FENNSEL_BARREL.get().asItem());
                        output.accept(BlockRegistry.CEILLIS_BARREL.get().asItem());
                        output.accept(BlockRegistry.PUNUEL_BARREL.get().asItem());
                        output.accept(BlockRegistry.ESSITTE_BARREL.get().asItem());
                        output.accept(BlockRegistry.FENNKYSTRAL_BARREL.get().asItem());
                        output.accept(BlockRegistry.THYOCIELLE_BARREL.get().asItem());
                        output.accept(BlockRegistry.SAGE_BARREL.get().asItem());

                        output.accept(BlockRegistry.MYQUESTE_LEAF_PILE.get().asItem());
                        output.accept(BlockRegistry.CALENDULA_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.ROSEMARY_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.THYME_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.TARRAGON_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.CHAMOMILE_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.CHIVES_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.VERBENA_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.SORREL_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.MARJORAM_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.CHERVIL_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.FENNSEL_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.CEILLIS_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.PUNUEL_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.ESSITTE_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.FENNKYSTRAL_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.THYOCIELLE_HERB_PILE.get().asItem());
                        output.accept(BlockRegistry.SAGE_HERB_PILE.get().asItem());

                        output.accept(BlockRegistry.MYQUESTE_LOG.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_WOOD.get().asItem());
                        output.accept(BlockRegistry.STRIPPED_MYQUESTE_LOG.get().asItem());
                        output.accept(BlockRegistry.STRIPPED_MYQUESTE_WOOD.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_PLANKS.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_STAIRS.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_SLAB.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_FENCE.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_FENCE_GATE.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_DOOR.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_TRAPDOOR.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_PRESSURE_PLATE.get().asItem());
                        output.accept(BlockRegistry.MYQUESTE_BUTTON.get().asItem());
                        output.accept(MYQUESTE_BOAT.get());
                        output.accept(MYQUESTE_CHEST_BOAT.get());
                        output.accept(MYQUESTE_SIGN.get());
                        output.accept(MYQUESTE_HANGING_SIGN.get());


                    }).build());
    public static final RegistryObject<CreativeModeTab> POUNDED_HERBS_TAB = CREATIVE_MODE_TABS.register("pounded_herbs",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.hibernalherbs.pounded_herbs"))
                    .icon(() -> new ItemStack(POUNDED_TARRAGON.get())).displayItems(((parameters, output) -> {
                        output.accept(POUNDED_CALENDULA.get());
                        output.accept(POUNDED_ROSEMARY.get());
                        output.accept(POUNDED_THYME.get());
                        output.accept(POUNDED_TARRAGON.get());
                        output.accept(POUNDED_CHAMOMILE.get());
                        output.accept(POUNDED_CHIVES.get());
                        output.accept(POUNDED_VERBENA.get());
                        output.accept(POUNDED_SORREL.get());
                        output.accept(POUNDED_MARJORAM.get());
                        output.accept(POUNDED_CHERVIL.get());
                        output.accept(POUNDED_FENNSEL.get());
                        output.accept(POUNDED_CEILLIS.get());
                        output.accept(POUNDED_PUNUEL.get());
                        output.accept(POUNDED_ESSITTE.get());
                        output.accept(POUNDED_FENNKYSTRAL.get());
                        output.accept(POUNDED_THYOCIELLE.get());
                        output.accept(POUNDED_SAGE.get());

                        output.accept(DRIED_CALENDULA.get());
                        output.accept(DRIED_ROSEMARY.get());
                        output.accept(DRIED_THYME.get());
                        output.accept(DRIED_TARRAGON.get());
                        output.accept(DRIED_CHAMOMILE.get());
                        output.accept(DRIED_CHIVES.get());
                        output.accept(DRIED_VERBENA.get());
                        output.accept(DRIED_SORREL.get());
                        output.accept(DRIED_MARJORAM.get());
                        output.accept(DRIED_CHERVIL.get());
                        output.accept(DRIED_FENNSEL.get());
                        output.accept(DRIED_CEILLIS.get());
                        output.accept(DRIED_PUNUEL.get());
                        output.accept(DRIED_ESSITTE.get());
                        output.accept(DRIED_FENNKYSTRAL.get());
                        output.accept(DRIED_THYOCIELLE.get());
                        output.accept(DRIED_SAGE.get());
                    })).build());
    public static final RegistryObject<CreativeModeTab> HERBS_TAB = CREATIVE_MODE_TABS.register("herbs",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.hibernalherbs.herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.TARRAGON.get().asItem())).displayItems(((parameters, output) -> {
                        output.accept(BlockRegistry.CALENDULA.get().asItem());
                        output.accept(BlockRegistry.ROSEMARY.get().asItem());
                        output.accept(BlockRegistry.THYME.get().asItem());
                        output.accept(BlockRegistry.TARRAGON.get().asItem());
                        output.accept(BlockRegistry.CHAMOMILE.get().asItem());
                        output.accept(BlockRegistry.CHIVES.get().asItem());
                        output.accept(BlockRegistry.VERBENA.get().asItem());
                        output.accept(BlockRegistry.SORREL.get().asItem());
                        output.accept(BlockRegistry.MARJORAM.get().asItem());
                        output.accept(BlockRegistry.CHERVIL.get().asItem());
                        output.accept(BlockRegistry.FENNSEL.get().asItem());
                        output.accept(BlockRegistry.CEILLIS.get().asItem());
                        output.accept(BlockRegistry.PUNUEL.get().asItem());
                        output.accept(BlockRegistry.ESSITTE.get().asItem());
                        output.accept(BlockRegistry.FENNKYSTRAL.get().asItem());
                        output.accept(BlockRegistry.THYOCIELLE.get().asItem());
                        output.accept(BlockRegistry.SAGE.get().asItem());

                        output.accept(BlockRegistry.PRIDE_HERB.get());
                        output.accept(BlockRegistry.WRATH_HERB.get());
                        output.accept(BlockRegistry.GLUTTONY_HERB.get());
                        output.accept(BlockRegistry.SLOTH_HERB.get());
                        output.accept(BlockRegistry.LUST_HERB.get());
                        output.accept(BlockRegistry.ENVY_HERB.get());
                        output.accept(BlockRegistry.GREED_HERB.get());
                    })).build());
    public static final RegistryObject<CreativeModeTab> AUTOMATION_TAB = CREATIVE_MODE_TABS.register("reproduction",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.hibernalherbs.reproduction"))
                    .icon(() -> new ItemStack(HERB_FERTILIZER.get())).displayItems(((parameters, output) -> {
                        output.accept(HERB_FERTILIZER_OAK.get().asItem());
                        output.accept(HERB_FERTILIZER_DARK_OAK.get().asItem());
                        output.accept(HERB_FERTILIZER_ACACIA.get().asItem());
                        output.accept(HERB_FERTILIZER_SPRUCE.get().asItem());
                        output.accept(HERB_FERTILIZER_BIRCH.get().asItem());
                        output.accept(HERB_FERTILIZER_JUNGLE.get().asItem());
                        output.accept(HERB_FERTILIZER_MANGROVE.get().asItem());
                        output.accept(HERB_FERTILIZER_CHERRY.get().asItem());
                        output.accept(HERB_FERTILIZER_MYQUESTE.get().asItem());

                        output.accept(HERB_HUMUS_OAK.get().asItem());
                        output.accept(HERB_HUMUS_DARK_OAK.get().asItem());
                        output.accept(HERB_HUMUS_ACACIA.get().asItem());
                        output.accept(HERB_HUMUS_SPRUCE.get().asItem());
                        output.accept(HERB_HUMUS_BIRCH.get().asItem());
                        output.accept(HERB_HUMUS_JUNGLE.get().asItem());
                        output.accept(HERB_HUMUS_MANGROVE.get().asItem());
                        output.accept(HERB_HUMUS_CHERRY.get().asItem());
                        output.accept(HERB_HUMUS_MYQUESTE.get().asItem());
                    })).build());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
