package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.HibernalHerbsBoatTypes;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@SuppressWarnings({"unused"})
public class HibernalItemTabs {
    public static final ItemGroup HIBERNAL_HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "hibernal_herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.hibernal_herbs"))
                    .icon(() -> new ItemStack(BlockInit.CONJURATION_ALTAR.asItem())).entries((displayContext, entries) -> {
                        entries.add(ItemInit.GROUND_HERBS);
                        entries.add(ItemInit.HERB_FERTILIZER);
                        entries.add(ItemInit.HERB_HUMUS);
                        entries.add(ItemInit.SCRATCHED_POUCH);
                        entries.add(ItemInit.IRON_CANISTER);
                        entries.add(ItemInit.AMETHYST_CANISTER);
                        entries.add(ItemInit.DIAMOND_CANISTER);

                        entries.add(ItemInit.REGENERATION_BLEND);
                        entries.add(ItemInit.SMOKED_REGENERATION_BLEND);
                        entries.add(ItemInit.POISON_BLEND);
                        entries.add(ItemInit.SMOKED_POISON_BLEND);
                        entries.add(ItemInit.SLOWNESS_BLEND);
                        entries.add(ItemInit.SMOKED_SLOWNESS_BLEND);
                        entries.add(ItemInit.MINING_FATIGUE_BLEND);
                        entries.add(ItemInit.SMOKED_MINING_FATIGUE_BLEND);
                        entries.add(ItemInit.HASTE_BLEND);
                        entries.add(ItemInit.SMOKED_HASTE_BLEND);
                        entries.add(ItemInit.SPEED_BLEND);
                        entries.add(ItemInit.SMOKED_SPEED_BLEND);
                        entries.add(ItemInit.FIRE_BLEND);
                        entries.add(ItemInit.SMOKED_FIRE_BLEND);
                        entries.add(ItemInit.WITHER_BLEND);
                        entries.add(ItemInit.SMOKED_WITHER_BLEND);
                        entries.add(ItemInit.NIGHT_VISION_BLEND);
                        entries.add(ItemInit.SMOKED_NIGHT_VISION_BLEND);
                        entries.add(ItemInit.WEAKNESS_BLEND);
                        entries.add(ItemInit.SMOKED_WEAKNESS_BLEND);
                        entries.add(ItemInit.BLINDNESS_BLEND);
                        entries.add(ItemInit.SMOKED_BLINDNESS_BLEND);
                        entries.add(ItemInit.REGENERATION_SLOWNESS_BLEND);
                        entries.add(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND);
                        entries.add(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND);
                        entries.add(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND);

                        entries.add(ItemInit.HERBAL_GRIMOIRE);
                        entries.add(ItemInit.SINGED_GRIMOIRE);

                        entries.add(ItemInit.SILIPTIUM_PETAL);
                        entries.add(ItemInit.LUMBINETRIK_PETAL);

                        entries.add(ItemInit.SIGIL);
                        entries.add(ItemInit.SIGIL_PRIDE);
                        entries.add(ItemInit.SIGIL_WRATH);
                        entries.add(ItemInit.SIGIL_GLUTTONY);
                        entries.add(ItemInit.SIGIL_SLOTH);
                        entries.add(ItemInit.SIGIL_LUST);
                        entries.add(ItemInit.SIGIL_ENVY);
                        entries.add(ItemInit.SIGIL_GREED);
                        entries.add(ItemInit.SIGIL_CONFIGURATION);
                        entries.add(ItemInit.SIGIL_CONFIGURATION_ADVANCED);
                        entries.add(ItemInit.SIGIL_MASTERY);
                        entries.add(ItemInit.SIGIL_MASTERY_ADVANCED);

                        entries.add(ItemInit.PIQUE_PADLOCK);
                        entries.add(ItemInit.PIQUE_PADLOCK_BOUND);
                        entries.add(ItemInit.VEXATION_PADLOCK);
                        entries.add(ItemInit.VEXATION_PADLOCK_BOUND);
                        entries.add(ItemInit.GOURMANDIZING_PADLOCK);
                        entries.add(ItemInit.GOURMANDIZING_PADLOCK_BOUND);
                        entries.add(ItemInit.APATHY_PADLOCK);
                        entries.add(ItemInit.APATHY_PADLOCK_BOUND);
                        entries.add(ItemInit.SALACIOUS_PADLOCK);
                        entries.add(ItemInit.SALACIOUS_PADLOCK_BOUND);
                        entries.add(ItemInit.SPITEFUL_PADLOCK);
                        entries.add(ItemInit.SPITEFUL_PADLOCK_BOUND);
                        entries.add(ItemInit.AVARICE_PADLOCK);
                        entries.add(ItemInit.AVARICE_PADLOCK_BOUND);

                        entries.add(BlockInit.CONJURATION_ALTAR.asItem());

                        entries.add(BlockInit.CALENDULA_LANTERN.asItem());
                        entries.add(BlockInit.ROSEMARY_LANTERN.asItem());
                        entries.add(BlockInit.THYME_LANTERN.asItem());
                        entries.add(BlockInit.TARRAGON_LANTERN.asItem());
                        entries.add(BlockInit.CHAMOMILE_LANTERN.asItem());
                        entries.add(BlockInit.CHIVES_LANTERN.asItem());
                        entries.add(BlockInit.VERBENA_LANTERN.asItem());
                        entries.add(BlockInit.SORREL_LANTERN.asItem());
                        entries.add(BlockInit.MARJORAM_LANTERN.asItem());
                        entries.add(BlockInit.CHERVIL_LANTERN.asItem());
                        entries.add(BlockInit.FENNSEL_LANTERN.asItem());
                        entries.add(BlockInit.CEILLIS_LANTERN.asItem());
                        entries.add(BlockInit.PUNUEL_LANTERN.asItem());
                        entries.add(BlockInit.ESSITTE_LANTERN.asItem());
                        entries.add(BlockInit.FENNKYSTRAL_LANTERN.asItem());
                        entries.add(BlockInit.THYOCIELLE_LANTERN.asItem());
                        entries.add(BlockInit.SAGE_LANTERN.asItem());

                        entries.add(BlockInit.CALENDULA_HERB_BARREL.asItem());
                        entries.add(BlockInit.ROSEMARY_HERB_BARREL.asItem());
                        entries.add(BlockInit.THYME_HERB_BARREL.asItem());
                        entries.add(BlockInit.TARRAGON_HERB_BARREL.asItem());
                        entries.add(BlockInit.CHAMOMILE_HERB_BARREL.asItem());
                        entries.add(BlockInit.CHIVES_HERB_BARREL.asItem());
                        entries.add(BlockInit.VERBENA_HERB_BARREL.asItem());
                        entries.add(BlockInit.SORREL_HERB_BARREL.asItem());
                        entries.add(BlockInit.MARJORAM_HERB_BARREL.asItem());
                        entries.add(BlockInit.CHERVIL_HERB_BARREL.asItem());
                        entries.add(BlockInit.FENNSEL_HERB_BARREL.asItem());
                        entries.add(BlockInit.CEILLIS_HERB_BARREL.asItem());
                        entries.add(BlockInit.PUNUEL_HERB_BARREL.asItem());
                        entries.add(BlockInit.ESSITTE_HERB_BARREL.asItem());
                        entries.add(BlockInit.FENNKYSTRAL_HERB_BARREL.asItem());
                        entries.add(BlockInit.THYOCIELLE_HERB_BARREL.asItem());
                        entries.add(BlockInit.SAGE_HERB_BARREL.asItem());

                        entries.add(BlockInit.MYQUESTE_LEAF_PILE.asItem());
                        entries.add(BlockInit.CALENDULA_HERB_PILE.asItem());
                        entries.add(BlockInit.ROSEMARY_HERB_PILE.asItem());
                        entries.add(BlockInit.THYME_HERB_PILE.asItem());
                        entries.add(BlockInit.TARRAGON_HERB_PILE.asItem());
                        entries.add(BlockInit.CHAMOMILE_HERB_PILE.asItem());
                        entries.add(BlockInit.CHIVES_HERB_PILE.asItem());
                        entries.add(BlockInit.VERBENA_HERB_PILE.asItem());
                        entries.add(BlockInit.SORREL_HERB_PILE.asItem());
                        entries.add(BlockInit.MARJORAM_HERB_PILE.asItem());
                        entries.add(BlockInit.CHERVIL_HERB_PILE.asItem());
                        entries.add(BlockInit.FENNSEL_HERB_PILE.asItem());
                        entries.add(BlockInit.CEILLIS_HERB_PILE.asItem());
                        entries.add(BlockInit.PUNUEL_HERB_PILE.asItem());
                        entries.add(BlockInit.ESSITTE_HERB_PILE.asItem());
                        entries.add(BlockInit.FENNKYSTRAL_HERB_PILE.asItem());
                        entries.add(BlockInit.THYOCIELLE_HERB_PILE.asItem());
                        entries.add(BlockInit.SAGE_HERB_PILE.asItem());

                        entries.add(BlockInit.MYQUESTE_LOG.asItem());
                        entries.add(BlockInit.MYQUESTE_WOOD.asItem());
                        entries.add(BlockInit.STRIPPED_MYQUESTE_LOG.asItem());
                        entries.add(BlockInit.STRIPPED_MYQUESTE_WOOD.asItem());
                        entries.add(BlockInit.MYQUESTE_PLANKS.asItem());
                        entries.add(BlockInit.MYQUESTE_STAIRS.asItem());
                        entries.add(BlockInit.MYQUESTE_SLAB.asItem());
                        entries.add(BlockInit.MYQUESTE_FENCE.asItem());
                        entries.add(BlockInit.MYQUESTE_FENCE_GATE.asItem());
                        entries.add(BlockInit.MYQUESTE_DOOR.asItem());
                        entries.add(BlockInit.MYQUESTE_TRAPDOOR.asItem());
                        entries.add(BlockInit.MYQUESTE_PRESSURE_PLATE.asItem());
                        entries.add(BlockInit.MYQUESTE_BUTTON.asItem());
                        entries.add(HibernalHerbsBoatTypes.myqueste.getItem());
                        entries.add(HibernalHerbsBoatTypes.myqueste.getChestItem());
                        entries.add(BlockInit.MYQUESTE_SIGN_ITEM.asItem());
                        entries.add(BlockInit.MYQUESTE_HANGING_SIGN_ITEM.asItem());


                    }).build());
    public static final ItemGroup POUNDED_HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "pounded_herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.pounded_herbs"))
                    .icon(() -> new ItemStack(ItemInit.POUNDED_TARRAGON)).entries(((displayContext, entries) -> {
                        entries.add(ItemInit.POUNDED_CALENDULA.asItem());
                        entries.add(ItemInit.POUNDED_ROSEMARY.asItem());
                        entries.add(ItemInit.POUNDED_THYME.asItem());
                        entries.add(ItemInit.POUNDED_TARRAGON.asItem());
                        entries.add(ItemInit.POUNDED_CHAMOMILE.asItem());
                        entries.add(ItemInit.POUNDED_CHIVES.asItem());
                        entries.add(ItemInit.POUNDED_VERBENA.asItem());
                        entries.add(ItemInit.POUNDED_SORREL.asItem());
                        entries.add(ItemInit.POUNDED_MARJORAM.asItem());
                        entries.add(ItemInit.POUNDED_CHERVIL.asItem());
                        entries.add(ItemInit.POUNDED_FENNSEL.asItem());
                        entries.add(ItemInit.POUNDED_CEILLIS.asItem());
                        entries.add(ItemInit.POUNDED_PUNUEL.asItem());
                        entries.add(ItemInit.POUNDED_ESSITTE.asItem());
                        entries.add(ItemInit.POUNDED_FENNKYSTRAL.asItem());
                        entries.add(ItemInit.POUNDED_THYOCIELLE.asItem());
                        entries.add(ItemInit.POUNDED_SAGE.asItem());

                        entries.add(ItemInit.DRIED_CALENDULA.asItem());
                        entries.add(ItemInit.DRIED_ROSEMARY.asItem());
                        entries.add(ItemInit.DRIED_THYME.asItem());
                        entries.add(ItemInit.DRIED_TARRAGON.asItem());
                        entries.add(ItemInit.DRIED_CHAMOMILE.asItem());
                        entries.add(ItemInit.DRIED_CHIVES.asItem());
                        entries.add(ItemInit.DRIED_VERBENA.asItem());
                        entries.add(ItemInit.DRIED_SORREL.asItem());
                        entries.add(ItemInit.DRIED_MARJORAM.asItem());
                        entries.add(ItemInit.DRIED_CHERVIL.asItem());
                        entries.add(ItemInit.DRIED_FENNSEL.asItem());
                        entries.add(ItemInit.DRIED_CEILLIS.asItem());
                        entries.add(ItemInit.DRIED_PUNUEL.asItem());
                        entries.add(ItemInit.DRIED_ESSITTE.asItem());
                        entries.add(ItemInit.DRIED_FENNKYSTRAL.asItem());
                        entries.add(ItemInit.DRIED_THYOCIELLE.asItem());
                        entries.add(ItemInit.DRIED_SAGE.asItem());
                    })).build());
    public static final ItemGroup HERBS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "herbs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.hibernalherbs.herbs"))
                    .icon(() -> new ItemStack(BlockInit.TARRAGON.asItem())).entries(((displayContext, entries) -> {
                        entries.add(BlockInit.CALENDULA.asItem());
                        entries.add(BlockInit.ROSEMARY.asItem());
                        entries.add(BlockInit.THYME.asItem());
                        entries.add(BlockInit.TARRAGON.asItem());
                        entries.add(BlockInit.CHAMOMILE.asItem());
                        entries.add(BlockInit.CHIVES.asItem());
                        entries.add(BlockInit.VERBENA.asItem());
                        entries.add(BlockInit.SORREL.asItem());
                        entries.add(BlockInit.MARJORAM.asItem());
                        entries.add(BlockInit.CHERVIL.asItem());
                        entries.add(BlockInit.FENNSEL.asItem());
                        entries.add(BlockInit.CEILLIS.asItem());
                        entries.add(BlockInit.PUNUEL.asItem());
                        entries.add(BlockInit.ESSITTE.asItem());
                        entries.add(BlockInit.FENNKYSTRAL.asItem());
                        entries.add(BlockInit.THYOCIELLE.asItem());
                        entries.add(BlockInit.SAGE.asItem());

                        entries.add(BlockInit.PRIDE_HERB);
                        entries.add(BlockInit.WRATH_HERB);
                        entries.add(BlockInit.GLUTTONY_HERB);
                        entries.add(BlockInit.SLOTH_HERB);
                        entries.add(BlockInit.LUST_HERB);
                        entries.add(BlockInit.ENVY_HERB);
                        entries.add(BlockInit.GREED_HERB);
                    })).build());

    public static void init() {}
}
