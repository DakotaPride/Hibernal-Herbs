package net.dakotapride.hibernalherbs.forge.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@SuppressWarnings({"unused"})
public class ItemGroupsRegistry {
    public static final DeferredRegister<ItemGroup> CREATIVE_MODE_TABS =
            DeferredRegister.create(HibernalHerbsCommon.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> HIBERNAL_HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "hibernal_herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.hibernal_herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.CONJURATION_ALTAR.get().asItem())).entries((parameters, output) -> {
                        output.add(ItemRegistry.GROUND_HERBS.get());
                        output.add(ItemRegistry.HERB_FERTILIZER.get());
                        output.add(ItemRegistry.HERB_HUMUS.get());
                        output.add(ItemRegistry.SCRATCHED_POUCH.get());
                        output.add(ItemRegistry.STITCHED_POUCH.get());
                        output.add(ItemRegistry.PROPER_POUCH.get());
                        output.add(ItemRegistry.IRON_CANISTER.get());
                        output.add(ItemRegistry.AMETHYST_CANISTER.get());
                        output.add(ItemRegistry.DIAMOND_CANISTER.get());

                        output.add(ItemRegistry.REGENERATION_BLEND.get());
                        output.add(ItemRegistry.SMOKED_REGENERATION_BLEND.get());
                        output.add(ItemRegistry.POISON_BLEND.get());
                        output.add(ItemRegistry.SMOKED_POISON_BLEND.get());
                        output.add(ItemRegistry.SLOWNESS_BLEND.get());
                        output.add(ItemRegistry.SMOKED_SLOWNESS_BLEND.get());
                        output.add(ItemRegistry.MINING_FATIGUE_BLEND.get());
                        output.add(ItemRegistry.SMOKED_MINING_FATIGUE_BLEND.get());
                        output.add(ItemRegistry.HASTE_BLEND.get());
                        output.add(ItemRegistry.SMOKED_HASTE_BLEND.get());
                        output.add(ItemRegistry.SPEED_BLEND.get());
                        output.add(ItemRegistry.SMOKED_SPEED_BLEND.get());
                        output.add(ItemRegistry.FIRE_BLEND.get());
                        output.add(ItemRegistry.SMOKED_FIRE_BLEND.get());
                        output.add(ItemRegistry.WITHER_BLEND.get());
                        output.add(ItemRegistry.SMOKED_WITHER_BLEND.get());
                        output.add(ItemRegistry.NIGHT_VISION_BLEND.get());
                        output.add(ItemRegistry.SMOKED_NIGHT_VISION_BLEND.get());
                        output.add(ItemRegistry.WEAKNESS_BLEND.get());
                        output.add(ItemRegistry.SMOKED_WEAKNESS_BLEND.get());
                        output.add(ItemRegistry.BLINDNESS_BLEND.get());
                        output.add(ItemRegistry.SMOKED_BLINDNESS_BLEND.get());
                        output.add(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get());
                        output.add(ItemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get());
                        output.add(ItemRegistry.REGENERATION_SPEED_WEAKNESS_BLEND.get());
                        output.add(ItemRegistry.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.get());

                        output.add(ItemRegistry.HERBAL_GRIMOIRE.get());
                        output.add(ItemRegistry.SINGED_GRIMOIRE.get());

                        output.add(ItemRegistry.SILIPTIUM_PETAL.get());
                        output.add(ItemRegistry.LUMBINETRIK_PETAL.get());

                        output.add(ItemRegistry.CRACKED_SIGIL.get());
                        output.add(ItemRegistry.SIGIL.get());
                        output.add(ItemRegistry.SIGIL_PRIDE.get());
                        output.add(ItemRegistry.SIGIL_WRATH.get());
                        output.add(ItemRegistry.SIGIL_GLUTTONY.get());
                        output.add(ItemRegistry.SIGIL_SLOTH.get());
                        output.add(ItemRegistry.SIGIL_LUST.get());
                        output.add(ItemRegistry.SIGIL_ENVY.get());
                        output.add(ItemRegistry.SIGIL_GREED.get());
                        output.add(ItemRegistry.SIGIL_CONFIGURATION.get());
                        output.add(ItemRegistry.SIGIL_CONFIGURATION_ADVANCED.get());
                        output.add(ItemRegistry.SIGIL_MASTERY.get());
                        output.add(ItemRegistry.SIGIL_MASTERY_ADVANCED.get());

                        output.add(ItemRegistry.PRIDE_PADLOCK.get());
                        output.add(ItemRegistry.PRIDE_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.WRATH_PADLOCK.get());
                        output.add(ItemRegistry.WRATH_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.GLUTTONY_PADLOCK.get());
                        output.add(ItemRegistry.GLUTTONY_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.SLOTH_PADLOCK.get());
                        output.add(ItemRegistry.SLOTH_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.LUST_PADLOCK.get());
                        output.add(ItemRegistry.LUST_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.ENVY_PADLOCK.get());
                        output.add(ItemRegistry.ENVY_PADLOCK_BOUND.get());
                        output.add(ItemRegistry.GREED_PADLOCK.get());
                        output.add(ItemRegistry.GREED_PADLOCK_BOUND.get());

                        output.add(ItemRegistry.RING.get());
                        output.add(ItemRegistry.GLUTTONOUS_RING.get());
                        output.add(ItemRegistry.ADV_GLUTTONOUS_RING.get());

                        output.add(BlockRegistry.CONJURATION_ALTAR.get().asItem());

                        output.add(BlockRegistry.CALENDULA_LANTERN.get().asItem());
                        output.add(BlockRegistry.ROSEMARY_LANTERN.get().asItem());
                        output.add(BlockRegistry.THYME_LANTERN.get().asItem());
                        output.add(BlockRegistry.TARRAGON_LANTERN.get().asItem());
                        output.add(BlockRegistry.CHAMOMILE_LANTERN.get().asItem());
                        output.add(BlockRegistry.CHIVES_LANTERN.get().asItem());
                        output.add(BlockRegistry.VERBENA_LANTERN.get().asItem());
                        output.add(BlockRegistry.SORREL_LANTERN.get().asItem());
                        output.add(BlockRegistry.MARJORAM_LANTERN.get().asItem());
                        output.add(BlockRegistry.CHERVIL_LANTERN.get().asItem());
                        output.add(BlockRegistry.FENNSEL_LANTERN.get().asItem());
                        output.add(BlockRegistry.CEILLIS_LANTERN.get().asItem());
                        output.add(BlockRegistry.PUNUEL_LANTERN.get().asItem());
                        output.add(BlockRegistry.ESSITTE_LANTERN.get().asItem());
                        output.add(BlockRegistry.FENNKYSTRAL_LANTERN.get().asItem());
                        output.add(BlockRegistry.THYOCIELLE_LANTERN.get().asItem());
                        output.add(BlockRegistry.SAGE_LANTERN.get().asItem());

                        output.add(BlockRegistry.CALENDULA_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.ROSEMARY_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.THYME_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.TARRAGON_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.CHAMOMILE_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.CHIVES_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.VERBENA_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.SORREL_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.MARJORAM_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.CHERVIL_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.FENNSEL_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.CEILLIS_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.PUNUEL_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.ESSITTE_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.FENNKYSTRAL_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.THYOCIELLE_HERB_BARREL.get().asItem());
                        output.add(BlockRegistry.SAGE_HERB_BARREL.get().asItem());

                        output.add(BlockRegistry.MYQUESTE_LEAF_PILE.get().asItem());
                        output.add(BlockRegistry.CALENDULA_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.ROSEMARY_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.THYME_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.TARRAGON_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.CHAMOMILE_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.CHIVES_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.VERBENA_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.SORREL_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.MARJORAM_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.CHERVIL_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.FENNSEL_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.CEILLIS_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.PUNUEL_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.ESSITTE_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.FENNKYSTRAL_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.THYOCIELLE_HERB_PILE.get().asItem());
                        output.add(BlockRegistry.SAGE_HERB_PILE.get().asItem());

                        output.add(BlockRegistry.MYQUESTE_LOG.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_WOOD.get().asItem());
                        output.add(BlockRegistry.STRIPPED_MYQUESTE_LOG.get().asItem());
                        output.add(BlockRegistry.STRIPPED_MYQUESTE_WOOD.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_PLANKS.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_STAIRS.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_SLAB.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_FENCE.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_FENCE_GATE.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_DOOR.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_TRAPDOOR.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_PRESSURE_PLATE.get().asItem());
                        output.add(BlockRegistry.MYQUESTE_BUTTON.get().asItem());
                        output.add(ItemRegistry.MYQUESTE_BOAT.get());
                        output.add(ItemRegistry.MYQUESTE_CHEST_BOAT.get());
                        output.add(ItemRegistry.MYQUESTE_SIGN.get());
                        output.add(ItemRegistry.MYQUESTE_HANGING_SIGN.get());


                    }).build());
    public static final RegistrySupplier<ItemGroup> POUNDED_HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "hibernal_herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.pounded_herbs"))
                    .icon(() -> new ItemStack(ItemRegistry.POUNDED_TARRAGON.get())).entries(((parameters, output) -> {
                        output.add(ItemRegistry.POUNDED_CALENDULA.get());
                        output.add(ItemRegistry.POUNDED_ROSEMARY.get());
                        output.add(ItemRegistry.POUNDED_THYME.get());
                        output.add(ItemRegistry.POUNDED_TARRAGON.get());
                        output.add(ItemRegistry.POUNDED_CHAMOMILE.get());
                        output.add(ItemRegistry.POUNDED_CHIVES.get());
                        output.add(ItemRegistry.POUNDED_VERBENA.get());
                        output.add(ItemRegistry.POUNDED_SORREL.get());
                        output.add(ItemRegistry.POUNDED_MARJORAM.get());
                        output.add(ItemRegistry.POUNDED_CHERVIL.get());
                        output.add(ItemRegistry.POUNDED_FENNSEL.get());
                        output.add(ItemRegistry.POUNDED_CEILLIS.get());
                        output.add(ItemRegistry.POUNDED_PUNUEL.get());
                        output.add(ItemRegistry.POUNDED_ESSITTE.get());
                        output.add(ItemRegistry.POUNDED_FENNKYSTRAL.get());
                        output.add(ItemRegistry.POUNDED_THYOCIELLE.get());
                        output.add(ItemRegistry.POUNDED_SAGE.get());

                        output.add(ItemRegistry.DRIED_CALENDULA.get());
                        output.add(ItemRegistry.DRIED_ROSEMARY.get());
                        output.add(ItemRegistry.DRIED_THYME.get());
                        output.add(ItemRegistry.DRIED_TARRAGON.get());
                        output.add(ItemRegistry.DRIED_CHAMOMILE.get());
                        output.add(ItemRegistry.DRIED_CHIVES.get());
                        output.add(ItemRegistry.DRIED_VERBENA.get());
                        output.add(ItemRegistry.DRIED_SORREL.get());
                        output.add(ItemRegistry.DRIED_MARJORAM.get());
                        output.add(ItemRegistry.DRIED_CHERVIL.get());
                        output.add(ItemRegistry.DRIED_FENNSEL.get());
                        output.add(ItemRegistry.DRIED_CEILLIS.get());
                        output.add(ItemRegistry.DRIED_PUNUEL.get());
                        output.add(ItemRegistry.DRIED_ESSITTE.get());
                        output.add(ItemRegistry.DRIED_FENNKYSTRAL.get());
                        output.add(ItemRegistry.DRIED_THYOCIELLE.get());
                        output.add(ItemRegistry.DRIED_SAGE.get());
                    })).build());
    public static final RegistrySupplier<ItemGroup> HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.TARRAGON.get().asItem())).entries(((parameters, output) -> {
                        output.add(BlockRegistry.CALENDULA.get().asItem());
                        output.add(BlockRegistry.ROSEMARY.get().asItem());
                        output.add(BlockRegistry.THYME.get().asItem());
                        output.add(BlockRegistry.TARRAGON.get().asItem());
                        output.add(BlockRegistry.CHAMOMILE.get().asItem());
                        output.add(BlockRegistry.CHIVES.get().asItem());
                        output.add(BlockRegistry.VERBENA.get().asItem());
                        output.add(BlockRegistry.SORREL.get().asItem());
                        output.add(BlockRegistry.MARJORAM.get().asItem());
                        output.add(BlockRegistry.CHERVIL.get().asItem());
                        output.add(BlockRegistry.FENNSEL.get().asItem());
                        output.add(BlockRegistry.CEILLIS.get().asItem());
                        output.add(BlockRegistry.PUNUEL.get().asItem());
                        output.add(BlockRegistry.ESSITTE.get().asItem());
                        output.add(BlockRegistry.FENNKYSTRAL.get().asItem());
                        output.add(BlockRegistry.THYOCIELLE.get().asItem());
                        output.add(BlockRegistry.SAGE.get().asItem());

                        output.add(BlockRegistry.PRIDE_HERB.get().asItem());
                        output.add(BlockRegistry.WRATH_HERB.get().asItem());
                        output.add(BlockRegistry.GLUTTONY_HERB.get().asItem());
                        output.add(BlockRegistry.SLOTH_HERB.get().asItem());
                        output.add(BlockRegistry.LUST_HERB.get().asItem());
                        output.add(BlockRegistry.ENVY_HERB.get().asItem());
                        output.add(BlockRegistry.GREED_HERB.get().asItem());
                    })).build());
    public static final RegistrySupplier<ItemGroup> AUTOMATION_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "reproduction"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.reproduction"))
                    .icon(() -> new ItemStack(ItemRegistry.HERB_FERTILIZER.get())).entries(((parameters, output) -> {
                        output.add(ItemRegistry.HERB_FERTILIZER_OAK.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_DARK_OAK.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_ACACIA.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_SPRUCE.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_BIRCH.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_JUNGLE.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_MANGROVE.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_CHERRY.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_CRIMSON.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_WARPED.get());
                        output.add(ItemRegistry.HERB_FERTILIZER_MYQUESTE.get());

                        output.add(ItemRegistry.HERB_HUMUS_OAK.get());
                        output.add(ItemRegistry.HERB_HUMUS_DARK_OAK.get());
                        output.add(ItemRegistry.HERB_HUMUS_ACACIA.get());
                        output.add(ItemRegistry.HERB_HUMUS_SPRUCE.get());
                        output.add(ItemRegistry.HERB_HUMUS_BIRCH.get());
                        output.add(ItemRegistry.HERB_HUMUS_JUNGLE.get());
                        output.add(ItemRegistry.HERB_HUMUS_MANGROVE.get());
                        output.add(ItemRegistry.HERB_HUMUS_CHERRY.get());
                        output.add(ItemRegistry.HERB_HUMUS_CRIMSON.get());
                        output.add(ItemRegistry.HERB_HUMUS_WARPED.get());
                        output.add(ItemRegistry.HERB_HUMUS_MYQUESTE.get());
                    })).build());

    public static void register() {
        CREATIVE_MODE_TABS.register();
    }
}
