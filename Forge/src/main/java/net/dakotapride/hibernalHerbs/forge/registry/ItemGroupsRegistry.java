package net.dakotapride.hibernalherbs.forge.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class ItemGroupsRegistry {
    public static final DeferredRegister<ItemGroup> CREATIVE_MODE_TABS =
            DeferredRegister.create(HibernalHerbsCommon.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> HIBERNAL_HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "hibernal_herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.hibernal_herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.CONJURATION_ALTAR.asItem())).entries((parameters, output) -> {
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.GROUND_HERBS);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SCRATCHED_POUCH);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.STITCHED_POUCH);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.PROPER_POUCH);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.IRON_CANISTER);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.AMETHYST_CANISTER);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DIAMOND_CANISTER);

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POISON_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_POISON_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SLOWNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_SLOWNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.MINING_FATIGUE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_MINING_FATIGUE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HASTE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_HASTE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SPEED_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_SPEED_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.FIRE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_FIRE_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.WITHER_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_WITHER_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.NIGHT_VISION_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_NIGHT_VISION_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.WEAKNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_WEAKNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.BLINDNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_BLINDNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_SLOWNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_SPEED_WEAKNESS_BLEND);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND);

                        output.add(ItemRegistry.HERBAL_GRIMOIRE);
                        output.add(ItemRegistry.SINGED_GRIMOIRE);

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SILIPTIUM_PETAL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.LUMBINETRIK_PETAL);

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_PRIDE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_WRATH);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_GLUTTONY);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_SLOTH);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_LUST);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_ENVY);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_GREED);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_CONFIGURATION);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_CONFIGURATION_ADVANCED);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_MASTERY);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_MASTERY_ADVANCED);

                        output.add(ItemRegistry.PRIDE_PADLOCK);
                        output.add(ItemRegistry.PRIDE_PADLOCK_BOUND);
                        output.add(ItemRegistry.WRATH_PADLOCK);
                        output.add(ItemRegistry.WRATH_PADLOCK_BOUND);
                        output.add(ItemRegistry.GLUTTONY_PADLOCK);
                        output.add(ItemRegistry.GLUTTONY_PADLOCK_BOUND);
                        output.add(ItemRegistry.SLOTH_PADLOCK);
                        output.add(ItemRegistry.SLOTH_PADLOCK_BOUND);
                        output.add(ItemRegistry.LUST_PADLOCK);
                        output.add(ItemRegistry.LUST_PADLOCK_BOUND);
                        output.add(ItemRegistry.ENVY_PADLOCK);
                        output.add(ItemRegistry.ENVY_PADLOCK_BOUND);
                        output.add(ItemRegistry.GREED_PADLOCK);
                        output.add(ItemRegistry.GREED_PADLOCK_BOUND);

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.RING);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.GLUTTONOUS_RING);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.ADV_GLUTTONOUS_RING);

                        output.add(BlockRegistry.CONJURATION_ALTAR.asItem());

                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE_LANTERN.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE_LANTERN.asItem());

                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE_HERB_BARREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE_HERB_BARREL.asItem());

                        output.add(BlockRegistry.MYQUESTE_LEAF_PILE.asItem());
                        output.add(BlockRegistry.CALENDULA_HERB_PILE.asItem());
                        output.add(BlockRegistry.ROSEMARY_HERB_PILE.asItem());
                        output.add(BlockRegistry.THYME_HERB_PILE.asItem());
                        output.add(BlockRegistry.TARRAGON_HERB_PILE.asItem());
                        output.add(BlockRegistry.CHAMOMILE_HERB_PILE.asItem());
                        output.add(BlockRegistry.CHIVES_HERB_PILE.asItem());
                        output.add(BlockRegistry.VERBENA_HERB_PILE.asItem());
                        output.add(BlockRegistry.SORREL_HERB_PILE.asItem());
                        output.add(BlockRegistry.MARJORAM_HERB_PILE.asItem());
                        output.add(BlockRegistry.CHERVIL_HERB_PILE.asItem());
                        output.add(BlockRegistry.FENNSEL_HERB_PILE.asItem());
                        output.add(BlockRegistry.CEILLIS_HERB_PILE.asItem());
                        output.add(BlockRegistry.PUNUEL_HERB_PILE.asItem());
                        output.add(BlockRegistry.ESSITTE_HERB_PILE.asItem());
                        output.add(BlockRegistry.FENNKYSTRAL_HERB_PILE.asItem());
                        output.add(BlockRegistry.THYOCIELLE_HERB_PILE.asItem());
                        output.add(BlockRegistry.SAGE_HERB_PILE.asItem());

                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_LOG.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_WOOD.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_LOG.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_WOOD.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_PLANKS.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_STAIRS.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_SLAB.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_FENCE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_FENCE_GATE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_DOOR.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_TRAPDOOR.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_PRESSURE_PLATE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_BUTTON.asItem());
                        output.add(ItemRegistry.MYQUESTE_BOAT);
                        output.add(ItemRegistry.MYQUESTE_CHEST_BOAT);
                        output.add(ItemRegistry.MYQUESTE_SIGN);
                        output.add(ItemRegistry.MYQUESTE_HANGING_SIGN);


                    }).build());
    public static final RegistrySupplier<ItemGroup> POUNDED_HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "hibernal_herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.pounded_herbs"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_TARRAGON)).entries(((parameters, output) -> {
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CALENDULA);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ROSEMARY);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYME);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_TARRAGON);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHAMOMILE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHIVES);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_VERBENA);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SORREL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_MARJORAM);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHERVIL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNSEL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CEILLIS);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_PUNUEL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ESSITTE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNKYSTRAL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYOCIELLE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SAGE);

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CALENDULA);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ROSEMARY);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYME);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_TARRAGON);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHAMOMILE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHIVES);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_VERBENA);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SORREL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_MARJORAM);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHERVIL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNSEL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CEILLIS);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_PUNUEL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ESSITTE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNKYSTRAL);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYOCIELLE);
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SAGE);
                    })).build());
    public static final RegistrySupplier<ItemGroup> HERBS_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "herbs"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.herbs"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.asItem())).entries(((parameters, output) -> {
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE.asItem());

                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PRIDE_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.WRATH_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.GLUTTONY_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SLOTH_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.LUST_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ENVY_HERB);
                        output.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.GREED_HERB);
                    })).build());
    public static final RegistrySupplier<ItemGroup> AUTOMATION_TAB = CREATIVE_MODE_TABS.register(new Identifier(HibernalHerbsCommon.MOD_ID, "reproduction"),
            () -> ItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.reproduction"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER)).entries(((parameters, output) -> {
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_OAK.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_DARK_OAK.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_ACACIA.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_SPRUCE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_BIRCH.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_JUNGLE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_MANGROVE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_CHERRY.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_MYQUESTE.asItem());

                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_OAK.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_DARK_OAK.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_ACACIA.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_SPRUCE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_BIRCH.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_JUNGLE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_MANGROVE.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_CHERRY.asItem());
                        output.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_MYQUESTE.asItem());
                    })).build());

    public static void register() {
        CREATIVE_MODE_TABS.register();
    }
}
