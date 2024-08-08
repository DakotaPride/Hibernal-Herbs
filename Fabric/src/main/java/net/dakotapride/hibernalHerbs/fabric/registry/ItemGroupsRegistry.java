package net.dakotapride.hibernalherbs.fabric.registry;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@SuppressWarnings({"unused"})
public class ItemGroupsRegistry {
    public static final ItemGroup HIBERNAL_HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HibernalHerbsCommon.MOD_ID, "hibernal_herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.hibernal_herbs"))
                    .icon(() -> new ItemStack(BlockRegistry.CONJURATION_ALTAR.asItem())).entries((displayContext, entries) -> {
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.GROUND_HERBS);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SCRATCHED_POUCH);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.STITCHED_POUCH);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.PROPER_POUCH);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.IRON_CANISTER);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.AMETHYST_CANISTER);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DIAMOND_CANISTER);

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POISON_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_POISON_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SLOWNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_SLOWNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.MINING_FATIGUE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_MINING_FATIGUE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HASTE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_HASTE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SPEED_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_SPEED_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.FIRE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_FIRE_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.WITHER_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_WITHER_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.NIGHT_VISION_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_NIGHT_VISION_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.WEAKNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_WEAKNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.BLINDNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_BLINDNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_SLOWNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.REGENERATION_SPEED_WEAKNESS_BLEND);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND);

                        entries.add(ItemRegistry.HERBAL_GRIMOIRE);
                        entries.add(ItemRegistry.SINGED_GRIMOIRE);

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SILIPTIUM_PETAL);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.LUMBINETRIK_PETAL);

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_PRIDE);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_WRATH);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_GLUTTONY);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_SLOTH);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_LUST);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_ENVY);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_GREED);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_CONFIGURATION);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_CONFIGURATION_ADVANCED);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_MASTERY);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.SIGIL_MASTERY_ADVANCED);

                        entries.add(ItemRegistry.PRIDE_PADLOCK);
                        entries.add(ItemRegistry.PRIDE_PADLOCK_BOUND);
                        entries.add(ItemRegistry.WRATH_PADLOCK);
                        entries.add(ItemRegistry.WRATH_PADLOCK_BOUND);
                        entries.add(ItemRegistry.GLUTTONY_PADLOCK);
                        entries.add(ItemRegistry.GLUTTONY_PADLOCK_BOUND);
                        entries.add(ItemRegistry.SLOTH_PADLOCK);
                        entries.add(ItemRegistry.SLOTH_PADLOCK_BOUND);
                        entries.add(ItemRegistry.LUST_PADLOCK);
                        entries.add(ItemRegistry.LUST_PADLOCK_BOUND);
                        entries.add(ItemRegistry.ENVY_PADLOCK);
                        entries.add(ItemRegistry.ENVY_PADLOCK_BOUND);
                        entries.add(ItemRegistry.GREED_PADLOCK);
                        entries.add(ItemRegistry.GREED_PADLOCK_BOUND);

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.RING);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.GLUTTONOUS_RING);
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.ADV_GLUTTONOUS_RING);

                        entries.add(BlockRegistry.CONJURATION_ALTAR.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE_LANTERN.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE_LANTERN.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE_HERB_BARREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE_HERB_BARREL.asItem());

                        entries.add(BlockRegistry.MYQUESTE_LEAF_PILE.asItem());
                        entries.add(BlockRegistry.CALENDULA_HERB_PILE.asItem());
                        entries.add(BlockRegistry.ROSEMARY_HERB_PILE.asItem());
                        entries.add(BlockRegistry.THYME_HERB_PILE.asItem());
                        entries.add(BlockRegistry.TARRAGON_HERB_PILE.asItem());
                        entries.add(BlockRegistry.CHAMOMILE_HERB_PILE.asItem());
                        entries.add(BlockRegistry.CHIVES_HERB_PILE.asItem());
                        entries.add(BlockRegistry.VERBENA_HERB_PILE.asItem());
                        entries.add(BlockRegistry.SORREL_HERB_PILE.asItem());
                        entries.add(BlockRegistry.MARJORAM_HERB_PILE.asItem());
                        entries.add(BlockRegistry.CHERVIL_HERB_PILE.asItem());
                        entries.add(BlockRegistry.FENNSEL_HERB_PILE.asItem());
                        entries.add(BlockRegistry.CEILLIS_HERB_PILE.asItem());
                        entries.add(BlockRegistry.PUNUEL_HERB_PILE.asItem());
                        entries.add(BlockRegistry.ESSITTE_HERB_PILE.asItem());
                        entries.add(BlockRegistry.FENNKYSTRAL_HERB_PILE.asItem());
                        entries.add(BlockRegistry.THYOCIELLE_HERB_PILE.asItem());
                        entries.add(BlockRegistry.SAGE_HERB_PILE.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_LOG.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_WOOD.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_LOG.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_WOOD.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_PLANKS.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_STAIRS.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_SLAB.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_FENCE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_FENCE_GATE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_DOOR.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_TRAPDOOR.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_PRESSURE_PLATE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_BUTTON.asItem());
                        entries.add(BoatTypeRegistry.MYQUESTE_TYPE.getItem());
                        entries.add(BoatTypeRegistry.MYQUESTE_TYPE.getChestItem());
                        entries.add(BlockRegistry.MYQUESTE_SIGN_ITEM.asItem());
                        entries.add(BlockRegistry.MYQUESTE_HANGING_SIGN_ITEM.asItem());


                    }).build());
    public static final ItemGroup POUNDED_HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HibernalHerbsCommon.MOD_ID, "pounded_herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.pounded_herbs"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_TARRAGON)).entries(((displayContext, entries) -> {
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CALENDULA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ROSEMARY.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYME.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_TARRAGON.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHAMOMILE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHIVES.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_VERBENA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SORREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_MARJORAM.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHERVIL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNSEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CEILLIS.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_PUNUEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ESSITTE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNKYSTRAL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYOCIELLE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SAGE.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CALENDULA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ROSEMARY.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYME.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_TARRAGON.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHAMOMILE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHIVES.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_VERBENA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SORREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_MARJORAM.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHERVIL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNSEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CEILLIS.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_PUNUEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ESSITTE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNKYSTRAL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYOCIELLE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SAGE.asItem());
                    })).build());
    public static final ItemGroup HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HibernalHerbsCommon.MOD_ID, "herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.herbs"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.asItem())).entries(((displayContext, entries) -> {
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.PRIDE_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.WRATH_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.GLUTTONY_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.SLOTH_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.LUST_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.ENVY_HERB);
                        entries.add(net.dakotapride.hibernalherbs.registry.BlockRegistry.GREED_HERB);
                    })).build());
    public static final ItemGroup AUTOMATION_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(HibernalHerbsCommon.MOD_ID, "reproduction"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.reproduction"))
                    .icon(() -> new ItemStack(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER)).entries(((displayContext, entries) -> {
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_OAK.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_DARK_OAK.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_ACACIA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_SPRUCE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_BIRCH.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_JUNGLE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_MANGROVE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_CHERRY.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_FERTILIZER_MYQUESTE.asItem());

                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_OAK.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_DARK_OAK.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_ACACIA.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_SPRUCE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_BIRCH.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_JUNGLE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_MANGROVE.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_CHERRY.asItem());
                        entries.add(net.dakotapride.hibernalherbs.registry.ItemRegistry.HERB_HUMUS_MYQUESTE.asItem());
                    })).build());

    public static void register() {}
}
