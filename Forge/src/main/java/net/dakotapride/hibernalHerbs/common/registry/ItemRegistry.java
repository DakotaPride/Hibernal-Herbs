package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.item.*;
import net.dakotapride.hibernalHerbs.common.item.abstractItem.AbstractCanisterItem;
import net.dakotapride.hibernalHerbs.common.item.abstractItem.AbstractPouchItem;
import net.dakotapride.hibernalHerbs.common.item.curse.CursedPadlockItem;
import net.dakotapride.hibernalHerbs.common.item.curse.grimoire.HerbalGrimoireItem;
import net.dakotapride.hibernalHerbs.common.item.ring.GluttonousRingItem;
import net.dakotapride.hibernalHerbs.common.item.ring.adv.AdvancedGluttonousRingItem;
import net.dakotapride.hibernalHerbs.common.registry.wood.MyquesteType;
import net.minecraft.core.NonNullList;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ItemRegistry implements FoodComponentList {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> GROUND_HERBS = ITEMS.register("ground_herbs",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HERBAL_GRIMOIRE = ITEMS.register("grimoire",
            () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SINGED_GRIMOIRE = ITEMS.register("singed_grimoire",
            () -> new HerbalGrimoireItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SILIPTIUM_PETAL = ITEMS.register("sin_petals",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LUMBINETRIK_PETAL = ITEMS.register("lumbinetrik_petals",
            () -> new Item(new Item.Properties().stacksTo(16)));

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
            () -> new MyquesteBoatItem(false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MYQUESTE_CHEST_BOAT = ITEMS.register("myqueste_chest_boat",
            () -> new MyquesteBoatItem(true, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MYQUESTE_SIGN = ITEMS.register("myqueste_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    BlockRegistry.MYQUESTE_SIGN.get(), BlockRegistry.MYQUESTE_WALL_SIGN.get()));

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

    public static final CreativeModeTab HIBERNAL_HERBS_TAB = new CreativeModeTab("hibernal_herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(BlockRegistry.MYQUESTE_LOG.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> nonNullList) {
            nonNullList.add(GROUND_HERBS.get().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER.get().getDefaultInstance());
            nonNullList.add(HERB_HUMUS.get().getDefaultInstance());
            nonNullList.add(POUCH_SCRATCHED.get().getDefaultInstance());
            nonNullList.add(POUCH_STITCHED.get().getDefaultInstance());
            nonNullList.add(POUCH_PROPER.get().getDefaultInstance());
            nonNullList.add(CANISTER_IRON.get().getDefaultInstance());
            nonNullList.add(CANISTER_AMETHYST.get().getDefaultInstance());
            nonNullList.add(CANISTER_DIAMOND.get().getDefaultInstance());

            nonNullList.add(REGENERATION_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_REGENERATION_BLEND.get().getDefaultInstance());
            nonNullList.add(POISON_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_POISON_BLEND.get().getDefaultInstance());
            nonNullList.add(SLOWNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_SLOWNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(MINING_FATIGUE_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_MINING_FATIGUE_BLEND.get().getDefaultInstance());
            nonNullList.add(HASTE_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_HASTE_BLEND.get().getDefaultInstance());
            nonNullList.add(SPEED_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_SPEED_BLEND.get().getDefaultInstance());
            nonNullList.add(FIRE_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_FIRE_BLEND.get().getDefaultInstance());
            nonNullList.add(WITHER_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_WITHER_BLEND.get().getDefaultInstance());
            nonNullList.add(NIGHT_VISION_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_NIGHT_VISION_BLEND.get().getDefaultInstance());
            nonNullList.add(WEAKNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_WEAKNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(BLINDNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_BLINDNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(REGENERATION_SLOWNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_REGENERATION_SLOWNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(REGENERATION_SPEED_WEAKNESS_BLEND.get().getDefaultInstance());
            nonNullList.add(SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.get().getDefaultInstance());

            nonNullList.add(HERBAL_GRIMOIRE.get().getDefaultInstance());
            nonNullList.add(SINGED_GRIMOIRE.get().getDefaultInstance());

            nonNullList.add(SILIPTIUM_PETAL.get().getDefaultInstance());
            nonNullList.add(LUMBINETRIK_PETAL.get().getDefaultInstance());

            nonNullList.add(SIGIL.get().getDefaultInstance());
            nonNullList.add(SIGIL_PRIDE.get().getDefaultInstance());
            nonNullList.add(SIGIL_WRATH.get().getDefaultInstance());
            nonNullList.add(SIGIL_GLUTTONY.get().getDefaultInstance());
            nonNullList.add(SIGIL_SLOTH.get().getDefaultInstance());
            nonNullList.add(SIGIL_LUST.get().getDefaultInstance());
            nonNullList.add(SIGIL_ENVY.get().getDefaultInstance());
            nonNullList.add(SIGIL_GREED.get().getDefaultInstance());
            nonNullList.add(SIGIL_CONFIGURATION.get().getDefaultInstance());
            nonNullList.add(SIGIL_CONFIGURATION_ADV.get().getDefaultInstance());
            nonNullList.add(SIGIL_MASTERY.get().getDefaultInstance());
            nonNullList.add(SIGIL_MASTERY_ADV.get().getDefaultInstance());

            nonNullList.add(PIQUE_PADLOCK.get().getDefaultInstance());
            nonNullList.add(PIQUE_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(VEXATION_PADLOCK.get().getDefaultInstance());
            nonNullList.add(VEXATION_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(GOURMANDIZING_PADLOCK.get().getDefaultInstance());
            nonNullList.add(GOURMANDIZING_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(APATHY_PADLOCK.get().getDefaultInstance());
            nonNullList.add(APATHY_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(SALACIOUS_PADLOCK.get().getDefaultInstance());
            nonNullList.add(SALACIOUS_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(SPITEFUL_PADLOCK.get().getDefaultInstance());
            nonNullList.add(SPITEFUL_PADLOCK_BOUND.get().getDefaultInstance());
            nonNullList.add(AVARICE_PADLOCK.get().getDefaultInstance());
            nonNullList.add(AVARICE_PADLOCK_BOUND.get().getDefaultInstance());

            nonNullList.add(RING.get().getDefaultInstance());
            nonNullList.add(GLUTTONOUS_RING.get().getDefaultInstance());
            nonNullList.add(ADV_GLUTTONOUS_RING.get().getDefaultInstance());

            nonNullList.add(BlockRegistry.CONJURATION_ALTAR.get().asItem().getDefaultInstance());

            nonNullList.add(BlockRegistry.CALENDULA_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ROSEMARY_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYME_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.TARRAGON_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHAMOMILE_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHIVES_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.VERBENA_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SORREL_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MARJORAM_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHERVIL_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNSEL_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CEILLIS_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.PUNUEL_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ESSITTE_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNKYSTRAL_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYOCIELLE_LANTERN.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SAGE_LANTERN.get().asItem().getDefaultInstance());

            nonNullList.add(BlockRegistry.CALENDULA_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ROSEMARY_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYME_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.TARRAGON_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHAMOMILE_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHIVES_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.VERBENA_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SORREL_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MARJORAM_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHERVIL_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNSEL_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CEILLIS_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.PUNUEL_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ESSITTE_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNKYSTRAL_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYOCIELLE_BARREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SAGE_BARREL.get().asItem().getDefaultInstance());

            nonNullList.add(BlockRegistry.MYQUESTE_LEAF_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CALENDULA_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ROSEMARY_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYME_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.TARRAGON_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHAMOMILE_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHIVES_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.VERBENA_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SORREL_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MARJORAM_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHERVIL_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNSEL_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CEILLIS_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.PUNUEL_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ESSITTE_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNKYSTRAL_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYOCIELLE_HERB_PILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SAGE_HERB_PILE.get().asItem().getDefaultInstance());

            nonNullList.add(BlockRegistry.MYQUESTE_LOG.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_WOOD.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.STRIPPED_MYQUESTE_LOG.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.STRIPPED_MYQUESTE_WOOD.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_PLANKS.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_STAIRS.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_SLAB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_FENCE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_FENCE_GATE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_DOOR.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_TRAPDOOR.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_PRESSURE_PLATE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MYQUESTE_BUTTON.get().asItem().getDefaultInstance());
            nonNullList.add(MYQUESTE_BOAT.get().getDefaultInstance());
            nonNullList.add(MYQUESTE_CHEST_BOAT.get().getDefaultInstance());
            nonNullList.add(MYQUESTE_SIGN.get().getDefaultInstance());
        }
    };
    public static final CreativeModeTab POUNDED_HERBS_TAB = new CreativeModeTab("pounded_herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(POUNDED_TARRAGON.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> nonNullList) {
            nonNullList.add(POUNDED_CALENDULA.get().getDefaultInstance());
            nonNullList.add(POUNDED_ROSEMARY.get().getDefaultInstance());
            nonNullList.add(POUNDED_THYME.get().getDefaultInstance());
            nonNullList.add(POUNDED_TARRAGON.get().getDefaultInstance());
            nonNullList.add(POUNDED_CHAMOMILE.get().getDefaultInstance());
            nonNullList.add(POUNDED_CHIVES.get().getDefaultInstance());
            nonNullList.add(POUNDED_VERBENA.get().getDefaultInstance());
            nonNullList.add(POUNDED_SORREL.get().getDefaultInstance());
            nonNullList.add(POUNDED_MARJORAM.get().getDefaultInstance());
            nonNullList.add(POUNDED_CHERVIL.get().getDefaultInstance());
            nonNullList.add(POUNDED_FENNSEL.get().getDefaultInstance());
            nonNullList.add(POUNDED_CEILLIS.get().getDefaultInstance());
            nonNullList.add(POUNDED_PUNUEL.get().getDefaultInstance());
            nonNullList.add(POUNDED_ESSITTE.get().getDefaultInstance());
            nonNullList.add(POUNDED_FENNKYSTRAL.get().getDefaultInstance());
            nonNullList.add(POUNDED_THYOCIELLE.get().getDefaultInstance());
            nonNullList.add(POUNDED_SAGE.get().getDefaultInstance());

            nonNullList.add(DRIED_CALENDULA.get().getDefaultInstance());
            nonNullList.add(DRIED_ROSEMARY.get().getDefaultInstance());
            nonNullList.add(DRIED_THYME.get().getDefaultInstance());
            nonNullList.add(DRIED_TARRAGON.get().getDefaultInstance());
            nonNullList.add(DRIED_CHAMOMILE.get().getDefaultInstance());
            nonNullList.add(DRIED_CHIVES.get().getDefaultInstance());
            nonNullList.add(DRIED_VERBENA.get().getDefaultInstance());
            nonNullList.add(DRIED_SORREL.get().getDefaultInstance());
            nonNullList.add(DRIED_MARJORAM.get().getDefaultInstance());
            nonNullList.add(DRIED_CHERVIL.get().getDefaultInstance());
            nonNullList.add(DRIED_FENNSEL.get().getDefaultInstance());
            nonNullList.add(DRIED_CEILLIS.get().getDefaultInstance());
            nonNullList.add(DRIED_PUNUEL.get().getDefaultInstance());
            nonNullList.add(DRIED_ESSITTE.get().getDefaultInstance());
            nonNullList.add(DRIED_FENNKYSTRAL.get().getDefaultInstance());
            nonNullList.add(DRIED_THYOCIELLE.get().getDefaultInstance());
            nonNullList.add(DRIED_SAGE.get().getDefaultInstance());
        }
    };
    public static final CreativeModeTab HERBS_TAB = new CreativeModeTab("herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(BlockRegistry.TARRAGON.get().asItem());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> nonNullList) {
            nonNullList.add(BlockRegistry.CALENDULA.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ROSEMARY.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYME.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.TARRAGON.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHAMOMILE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHIVES.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.VERBENA.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SORREL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.MARJORAM.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CHERVIL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNSEL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.CEILLIS.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.PUNUEL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ESSITTE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.FENNKYSTRAL.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.THYOCIELLE.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SAGE.get().asItem().getDefaultInstance());

            nonNullList.add(BlockRegistry.PRIDE_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.WRATH_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.GLUTTONY_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.SLOTH_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.LUST_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.ENVY_HERB.get().asItem().getDefaultInstance());
            nonNullList.add(BlockRegistry.GREED_HERB.get().asItem().getDefaultInstance());
        }
    };
    public static final CreativeModeTab AUTOMATION_TAB = new CreativeModeTab("reproduction") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(HERB_FERTILIZER.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> nonNullList) {
            nonNullList.add(HERB_FERTILIZER_OAK.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_DARK_OAK.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_ACACIA.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_SPRUCE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_BIRCH.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_JUNGLE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_MANGROVE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_CHERRY.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_FERTILIZER_MYQUESTE.get().asItem().getDefaultInstance());

            nonNullList.add(HERB_HUMUS_OAK.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_DARK_OAK.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_ACACIA.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_SPRUCE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_BIRCH.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_JUNGLE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_MANGROVE.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_CHERRY.get().asItem().getDefaultInstance());
            nonNullList.add(HERB_HUMUS_MYQUESTE.get().asItem().getDefaultInstance());
        }
    };

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
