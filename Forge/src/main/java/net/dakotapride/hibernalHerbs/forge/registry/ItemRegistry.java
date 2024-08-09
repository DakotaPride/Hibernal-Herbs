package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.forge.item.GrimoireItem;
import net.dakotapride.hibernalherbs.forge.item.MyquesteBoatItem;
import net.dakotapride.hibernalherbs.forge.item.PadlockItem;
import net.dakotapride.hibernalherbs.item.*;
import net.dakotapride.hibernalherbs.item.canister.AbstractCanisterItem;
import net.dakotapride.hibernalherbs.item.curse.Sins;
import net.dakotapride.hibernalherbs.item.pouch.AbstractPouchItem;
import net.dakotapride.hibernalherbs.item.ring.GluttonousRingItem;
import net.dakotapride.hibernalherbs.item.ring.adv.AdvancedGluttonousRingItem;
import net.dakotapride.hibernalherbs.registry.FoodComponentRegistry;
import net.dakotapride.hibernalherbs.registry.TypeRegistry;
import net.minecraft.block.WoodType;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> GROUND_HERBS = ITEMS.register("ground_herbs",
            () -> new Item(new Item.Settings()));

    public static final RegistryObject<Item> HERBAL_GRIMOIRE = ITEMS.register("grimoire",
            () -> new GrimoireItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SINGED_GRIMOIRE = ITEMS.register("singed_grimoire",
            () -> new GrimoireItem(new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> SILIPTIUM_PETAL = ITEMS.register("sin_petals",
            () -> new Item(new Item.Settings().maxCount(16)));
    public static final RegistryObject<Item> LUMBINETRIK_PETAL = ITEMS.register("lumbinetrik_petals",
            () -> new Item(new Item.Settings().maxCount(16)));

    public static final RegistryObject<Item> WRATH_PADLOCK_BOUND = ITEMS.register("bound_padlock_wrath",
            () -> new PadlockItem(Sins.WRATH, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> WRATH_PADLOCK = ITEMS.register("padlock_wrath",
            () -> new PadlockItem(Sins.WRATH, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> PRIDE_PADLOCK_BOUND = ITEMS.register("bound_padlock_pride",
            () -> new PadlockItem(Sins.PRIDE, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> PRIDE_PADLOCK = ITEMS.register("padlock_pride",
            () -> new PadlockItem(Sins.PRIDE, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> GLUTTONY_PADLOCK_BOUND = ITEMS.register("bound_padlock_gluttony",
            () -> new PadlockItem(Sins.GLUTTONY, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> GLUTTONY_PADLOCK = ITEMS.register("padlock_gluttony",
            () -> new PadlockItem(Sins.GLUTTONY, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> GREED_PADLOCK_BOUND = ITEMS.register("bound_padlock_greed",
            () -> new PadlockItem(Sins.GREED, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> GREED_PADLOCK = ITEMS.register("padlock_greed",
            () -> new PadlockItem(Sins.GREED, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> ENVY_PADLOCK_BOUND = ITEMS.register("bound_padlock_envy",
            () -> new PadlockItem(Sins.ENVY, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> ENVY_PADLOCK = ITEMS.register("padlock_envy",
            () -> new PadlockItem(Sins.ENVY, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> SLOTH_PADLOCK_BOUND = ITEMS.register("bound_padlock_sloth",
            () -> new PadlockItem(Sins.SLOTH, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> SLOTH_PADLOCK = ITEMS.register("padlock_sloth",
            () -> new PadlockItem(Sins.SLOTH, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> LUST_PADLOCK_BOUND = ITEMS.register("bound_padlock_lust",
            () -> new PadlockItem(Sins.LUST, new Item.Settings().maxCount(1).maxDamage(1)));
    public static final RegistryObject<Item> LUST_PADLOCK = ITEMS.register("padlock_lust",
            () -> new PadlockItem(Sins.LUST, new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> RING = ITEMS.register("ring",
            () -> new Item(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> GLUTTONOUS_RING = ITEMS.register("gluttonous_ring",
            () -> new GluttonousRingItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> ADV_GLUTTONOUS_RING = ITEMS.register("gluttonous_ring_adv",
            () -> new AdvancedGluttonousRingItem(new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> CRACKED_SIGIL = ITEMS.register("cracked_sigil",
            () -> new Item(new Item.Settings()));
    public static final RegistryObject<Item> SIGIL = ITEMS.register("sigil",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(8)));

    public static final RegistryObject<Item> SIGIL_WRATH = ITEMS.register("sigil_wrath",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_GREED = ITEMS.register("sigil_greed",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_LUST = ITEMS.register("sigil_lust",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_GLUTTONY = ITEMS.register("sigil_gluttony",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_ENVY = ITEMS.register("sigil_envy",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_PRIDE = ITEMS.register("sigil_pride",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_SLOTH = ITEMS.register("sigil_sloth",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> SIGIL_CONFIGURATION = ITEMS.register("sigil_configuration",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_MASTERY = ITEMS.register("sigil_mastery",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> SIGIL_CONFIGURATION_ADVANCED = ITEMS.register("sigil_configuration_adv",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));
    public static final RegistryObject<Item> SIGIL_MASTERY_ADVANCED = ITEMS.register("sigil_mastery_adv",
            () -> new HerbalSigilItem(new Item.Settings().maxCount(1)));

    public static final RegistryObject<Item> MYQUESTE_BOAT = ITEMS.register("myqueste_boat",
            () -> new MyquesteBoatItem(false, new Item.Settings().maxCount(1), WoodType.ACACIA));
    public static final RegistryObject<Item> MYQUESTE_CHEST_BOAT = ITEMS.register("myqueste_chest_boat",
            () -> new MyquesteBoatItem(true, new Item.Settings().maxCount(1), WoodType.ACACIA));

    public static final RegistryObject<Item> MYQUESTE_SIGN = ITEMS.register("myqueste_sign",
            () -> new SignItem(new Item.Settings().maxCount(16),
                    BlockRegistry.MYQUESTE_SIGN.get(), BlockRegistry.MYQUESTE_WALL_SIGN.get()));
    public static final RegistryObject<Item> MYQUESTE_HANGING_SIGN = ITEMS.register("myqueste_hanging_sign",
            () -> new HangingSignItem(BlockRegistry.MYQUESTE_HANGING_SIGN.get(), BlockRegistry.MYQUESTE_WALL_HANGING_SIGN.get(),
                    new Item.Settings().maxCount(16)));

    public static final RegistryObject<Item> HERB_FERTILIZER = ITEMS.register("herb_fertilizer",
            () -> new HerbFertilizerItem(new Item.Settings()));

    public static final RegistryObject<Item> HERB_FERTILIZER_OAK = ITEMS.register("herb_fertilizer_oak",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_BIRCH = ITEMS.register("herb_fertilizer_birch",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_DARK_OAK = ITEMS.register("herb_fertilizer_dark_oak",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_ACACIA = ITEMS.register("herb_fertilizer_acacia",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_JUNGLE = ITEMS.register("herb_fertilizer_jungle",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_SPRUCE = ITEMS.register("herb_fertilizer_spruce",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_MANGROVE = ITEMS.register("herb_fertilizer_mangrove",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_CHERRY = ITEMS.register("herb_fertilizer_cherry",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_CRIMSON = ITEMS.register("herb_fertilizer_crimson",
            () -> new HerbFertilizerItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_FERTILIZER_WARPED = ITEMS.register("herb_fertilizer_warped",
            () -> new HerbFertilizerItem(new Item.Settings()));

    public static final RegistryObject<Item> HERB_FERTILIZER_MYQUESTE = ITEMS.register("herb_fertilizer_myqueste",
            () -> new HerbFertilizerItem(new Item.Settings()));

    public static final RegistryObject<Item> HERB_HUMUS = ITEMS.register("herb_humus",
            () -> new HerbHumusItem(new Item.Settings()));

    public static final RegistryObject<Item> HERB_HUMUS_OAK = ITEMS.register("herb_humus_oak",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_BIRCH = ITEMS.register("herb_humus_birch",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_DARK_OAK = ITEMS.register("herb_humus_dark_oak",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_ACACIA = ITEMS.register("herb_humus_acacia",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_JUNGLE = ITEMS.register("herb_humus_jungle",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_SPRUCE = ITEMS.register("herb_humus_spruce",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_MANGROVE = ITEMS.register("herb_humus_mangrove",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_CHERRY = ITEMS.register("herb_humus_cherry",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_CRIMSON = ITEMS.register("herb_humus_crimson",
            () -> new HerbHumusItem(new Item.Settings()));
    public static final RegistryObject<Item> HERB_HUMUS_WARPED = ITEMS.register("herb_humus_warped",
            () -> new HerbHumusItem(new Item.Settings()));

    public static final RegistryObject<Item> HERB_HUMUS_MYQUESTE = ITEMS.register("herb_humus_myqueste",
            () -> new HerbHumusItem(new Item.Settings()));


    // Refined Pouches/Canisters
    public static final RegistryObject<Item> SCRATCHED_POUCH = ITEMS.register("pouch_scratched",
            () -> new AbstractPouchItem(new Item.Settings().maxCount(1), 64));
    public static final RegistryObject<Item> IRON_CANISTER = ITEMS.register("canister_iron",
            () -> new AbstractCanisterItem(new Item.Settings().maxCount(1), 128));
    public static final RegistryObject<Item> STITCHED_POUCH = ITEMS.register("pouch_stitched",
            () -> new AbstractPouchItem(new Item.Settings().maxCount(1), 192));
    public static final RegistryObject<Item> AMETHYST_CANISTER = ITEMS.register("canister_amethyst",
            () -> new AbstractCanisterItem(new Item.Settings().maxCount(1), 256));
    public static final RegistryObject<Item> PROPER_POUCH = ITEMS.register("pouch_proper",
            () -> new AbstractPouchItem(new Item.Settings().maxCount(1), 256));
    public static final RegistryObject<Item> DIAMOND_CANISTER = ITEMS.register("canister_diamond",
            () -> new AbstractCanisterItem(new Item.Settings().maxCount(1), 384));


    // Legacy
    public static final RegistryObject<Item> POUCH = ITEMS.register("pouch",
            () -> new AbstractPouchItem(new Item.Settings().maxCount(1), 256));
    public static final RegistryObject<Item> CANISTER = ITEMS.register("canister",
            () -> new AbstractCanisterItem(new Item.Settings().maxCount(1), 384));

    public static final RegistryObject<Item> POUNDED_ROSEMARY = ITEMS.register("pounded_rosemary",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_THYME = ITEMS.register("pounded_thyme",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_TARRAGON = ITEMS.register("pounded_tarragon",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_CHAMOMILE = ITEMS.register("pounded_chamomile",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_CHIVES = ITEMS.register("pounded_chives",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_VERBENA = ITEMS.register("pounded_verbena",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_SORREL = ITEMS.register("pounded_sorrel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_MARJORAM = ITEMS.register("pounded_marjoram",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_CHERVIL = ITEMS.register("pounded_chervil",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_FENNSEL = ITEMS.register("pounded_fennsel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_CEILLIS = ITEMS.register("pounded_ceillis",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_PUNUEL = ITEMS.register("pounded_punuel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));
    public static final RegistryObject<Item> POUNDED_ESSITTE = ITEMS.register("pounded_essitte",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));

    // Resource Dependant (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_THYOCIELLE = ITEMS.register("pounded_thyocielle",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.ARTIFICIAL_HERB)));
    public static final RegistryObject<Item> POUNDED_FENNKYSTRAL = ITEMS.register("pounded_fennkystral",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.ARTIFICIAL_HERB)));

    // Spring (Pounded) Herbs (Forge)

    public static final RegistryObject<Item> POUNDED_CALENDULA = ITEMS.register("pounded_calendula",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.ARTIFICIAL_HERB)));

    public static final RegistryObject<Item> POUNDED_SAGE = ITEMS.register("pounded_sage",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.POUNDED_HERB)));

    public static final RegistryObject<Item> DRIED_CALENDULA = ITEMS.register("dried_calendula",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_ROSEMARY = ITEMS.register("dried_rosemary",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_THYME = ITEMS.register("dried_thyme",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_TARRAGON = ITEMS.register("dried_tarragon",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_CHAMOMILE = ITEMS.register("dried_chamomile",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_CHIVES = ITEMS.register("dried_chives",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_VERBENA = ITEMS.register("dried_verbena",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_SORREL = ITEMS.register("dried_sorrel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_MARJORAM = ITEMS.register("dried_marjoram",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_CHERVIL = ITEMS.register("dried_chervil",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_FENNSEL = ITEMS.register("dried_fennsel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_CEILLIS = ITEMS.register("dried_ceillis",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_PUNUEL = ITEMS.register("dried_punuel",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_ESSITTE = ITEMS.register("dried_essitte",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_THYOCIELLE = ITEMS.register("dried_thyocielle",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_FENNKYSTRAL = ITEMS.register("dried_fennkystral",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));
    public static final RegistryObject<Item> DRIED_SAGE = ITEMS.register("dried_sage",
            () -> new Item(new Item.Settings().food(FoodComponentRegistry.DRIED_HERB)));

    public static final RegistryObject<Item> REGENERATION_BLEND = ITEMS.register("blend_regeneration",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.REGENERATION_BLEND)));
    public static final RegistryObject<Item> POISON_BLEND = ITEMS.register("blend_poison",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.POISON_BLEND)));
    public static final RegistryObject<Item> SLOWNESS_BLEND = ITEMS.register("blend_slowness",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.SLOWNESS_BLEND)));
    public static final RegistryObject<Item> MINING_FATIGUE_BLEND = ITEMS.register("blend_mining_fatigue",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.MINING_FATIGUE_BLEND)));
    public static final RegistryObject<Item> HASTE_BLEND = ITEMS.register("blend_haste",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.HASTE_BLEND)));
    public static final RegistryObject<Item> SPEED_BLEND = ITEMS.register("blend_speed",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.SPEED_BLEND)));
    public static final RegistryObject<Item> FIRE_BLEND = ITEMS.register("blend_fire",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.FIRE_BLEND)));
    public static final RegistryObject<Item> WITHER_BLEND = ITEMS.register("blend_wither",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.WITHER_BLEND)));
    public static final RegistryObject<Item> NIGHT_VISION_BLEND = ITEMS.register("blend_night_vision",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.NIGHT_VISION_BLEND)));
    public static final RegistryObject<Item> WEAKNESS_BLEND = ITEMS.register("blend_weakness",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.WEAKNESS_BLEND)));
    public static final RegistryObject<Item> BLINDNESS_BLEND = ITEMS.register("blend_blindness",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.BLINDNESS_BLEND)));
    // Resource Dependant (Blends) Herbs (Forge)
    public static final RegistryObject<Item> REGENERATION_SLOWNESS_BLEND = ITEMS.register("blend_regen_slow",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.CONFLICTING_BLEND)));
    public static final RegistryObject<Item> REGENERATION_SPEED_WEAKNESS_BLEND = ITEMS.register("blend_regen_speed_weak",
            () -> new HerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.ALTERNATIVE_BLEND)));

    // Smoked
    public static final RegistryObject<Item> SMOKED_REGENERATION_BLEND = ITEMS.register("blend_regeneration_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.REGENERATION_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_POISON_BLEND = ITEMS.register("blend_poison_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.POISON_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_SLOWNESS_BLEND = ITEMS.register("blend_slowness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.SLOWNESS_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_MINING_FATIGUE_BLEND = ITEMS.register("blend_mining_fatigue_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.MINING_FATIGUE_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_HASTE_BLEND = ITEMS.register("blend_haste_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.HASTE_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_SPEED_BLEND = ITEMS.register("blend_speed_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.SPEED_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_FIRE_BLEND = ITEMS.register("blend_fire_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.FIRE_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_WITHER_BLEND = ITEMS.register("blend_wither_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.WITHER_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_NIGHT_VISION_BLEND = ITEMS.register("blend_night_vision_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.NIGHT_VISION_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_WEAKNESS_BLEND = ITEMS.register("blend_weakness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.WEAKNESS_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_BLINDNESS_BLEND = ITEMS.register("blend_blindness_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.BLINDNESS_SMOKED_BLEND)));
    // Resource Dependant (Smoked Blends) Herbs (Forge)
    public static final RegistryObject<Item> SMOKED_REGENERATION_SLOWNESS_BLEND = ITEMS.register("blend_regen_slow_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.ALTERNATIVE_SMOKED_BLEND)));
    public static final RegistryObject<Item> SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND = ITEMS.register("blend_regen_speed_weak_smoked",
            () -> new SmokedHerbBlendItem(new Item.Settings().maxCount(1).food(FoodComponentRegistry.ALTERNATIVE_SMOKED_BLEND)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
