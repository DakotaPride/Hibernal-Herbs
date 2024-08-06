package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.HibernalHerbsBoatTypes;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@SuppressWarnings({"unused"})
public class HibernalItemTabs {
    public static ItemGroup HIBERNAL_HERBS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "hibernal_herbs"))
            .icon(() -> new ItemStack(BlockInit.CONJURATION_ALTAR.asItem()))
            .appendItems(itemStacks -> {
                itemStacks.add(ItemInit.GROUND_HERBS.getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER.getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS.getDefaultStack());
                itemStacks.add(ItemInit.SCRATCHED_POUCH.getDefaultStack());
                itemStacks.add(ItemInit.STITCHED_POUCH.getDefaultStack());
                itemStacks.add(ItemInit.PROPER_POUCH.getDefaultStack());
                itemStacks.add(ItemInit.IRON_CANISTER.getDefaultStack());
                itemStacks.add(ItemInit.AMETHYST_CANISTER.getDefaultStack());
                itemStacks.add(ItemInit.DIAMOND_CANISTER.getDefaultStack());

                itemStacks.add(ItemInit.REGENERATION_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_REGENERATION_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.POISON_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_POISON_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SLOWNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_SLOWNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.MINING_FATIGUE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_MINING_FATIGUE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.HASTE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_HASTE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SPEED_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_SPEED_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.FIRE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_FIRE_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.WITHER_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_WITHER_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.NIGHT_VISION_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_NIGHT_VISION_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.WEAKNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_WEAKNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.BLINDNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_BLINDNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.REGENERATION_SLOWNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND.getDefaultStack());
                itemStacks.add(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.getDefaultStack());

                itemStacks.add(ItemInit.HERBAL_GRIMOIRE.getDefaultStack());
                itemStacks.add(ItemInit.SINGED_GRIMOIRE.getDefaultStack());

                itemStacks.add(ItemInit.SILIPTIUM_PETAL.getDefaultStack());
                itemStacks.add(ItemInit.LUMBINETRIK_PETAL.getDefaultStack());

                itemStacks.add(ItemInit.SIGIL.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_PRIDE.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_WRATH.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_GLUTTONY.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_SLOTH.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_LUST.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_ENVY.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_GREED.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_CONFIGURATION.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_CONFIGURATION_ADVANCED.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_MASTERY.getDefaultStack());
                itemStacks.add(ItemInit.SIGIL_MASTERY_ADVANCED.getDefaultStack());

                itemStacks.add(ItemInit.PIQUE_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.PIQUE_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.VEXATION_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.VEXATION_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.GOURMANDIZING_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.GOURMANDIZING_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.APATHY_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.APATHY_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.SALACIOUS_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.SALACIOUS_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.SPITEFUL_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.SPITEFUL_PADLOCK_BOUND.getDefaultStack());
                itemStacks.add(ItemInit.AVARICE_PADLOCK.getDefaultStack());
                itemStacks.add(ItemInit.AVARICE_PADLOCK_BOUND.getDefaultStack());

                itemStacks.add(ItemInit.RING.getDefaultStack());
                itemStacks.add(ItemInit.GLUTTONOUS_RING.getDefaultStack());
                itemStacks.add(ItemInit.ADV_GLUTTONOUS_RING.getDefaultStack());

                itemStacks.add(BlockInit.CONJURATION_ALTAR.asItem().getDefaultStack());

                itemStacks.add(BlockInit.CALENDULA_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ROSEMARY_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYME_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.TARRAGON_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHAMOMILE_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHIVES_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.VERBENA_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SORREL_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MARJORAM_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHERVIL_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNSEL_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CEILLIS_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.PUNUEL_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ESSITTE_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNKYSTRAL_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYOCIELLE_LANTERN.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SAGE_LANTERN.asItem().getDefaultStack());

                itemStacks.add(BlockInit.CALENDULA_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ROSEMARY_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYME_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.TARRAGON_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHAMOMILE_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHIVES_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.VERBENA_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SORREL_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MARJORAM_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHERVIL_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNSEL_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CEILLIS_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.PUNUEL_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ESSITTE_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNKYSTRAL_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYOCIELLE_HERB_BARREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SAGE_HERB_BARREL.asItem().getDefaultStack());

                itemStacks.add(BlockInit.MYQUESTE_LEAF_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CALENDULA_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ROSEMARY_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYME_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.TARRAGON_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHAMOMILE_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHIVES_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.VERBENA_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SORREL_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MARJORAM_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHERVIL_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNSEL_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CEILLIS_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.PUNUEL_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ESSITTE_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNKYSTRAL_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYOCIELLE_HERB_PILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SAGE_HERB_PILE.asItem().getDefaultStack());

                itemStacks.add(BlockInit.MYQUESTE_LOG.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_WOOD.asItem().getDefaultStack());
                itemStacks.add(BlockInit.STRIPPED_MYQUESTE_LOG.asItem().getDefaultStack());
                itemStacks.add(BlockInit.STRIPPED_MYQUESTE_WOOD.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_PLANKS.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_STAIRS.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_SLAB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_FENCE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_FENCE_GATE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_DOOR.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_TRAPDOOR.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_PRESSURE_PLATE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_BUTTON.asItem().getDefaultStack());
                itemStacks.add(HibernalHerbsBoatTypes.myqueste.getItem().getDefaultStack());
                itemStacks.add(HibernalHerbsBoatTypes.myqueste.getChestItem().getDefaultStack());
                itemStacks.add(BlockInit.MYQUESTE_SIGN_ITEM.asItem().getDefaultStack());
            }).build();
    public static ItemGroup POUNDED_HERBS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "pounded_herbs"))
            .icon(() -> new ItemStack(ItemInit.POUNDED_TARRAGON))
            .appendItems(itemStacks -> {
                itemStacks.add(ItemInit.POUNDED_CALENDULA.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_ROSEMARY.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_THYME.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_TARRAGON.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_CHAMOMILE.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_CHIVES.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_VERBENA.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_SORREL.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_MARJORAM.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_CHERVIL.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_FENNSEL.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_CEILLIS.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_PUNUEL.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_ESSITTE.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_FENNKYSTRAL.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_THYOCIELLE.getDefaultStack());
                itemStacks.add(ItemInit.POUNDED_SAGE.getDefaultStack());

                itemStacks.add(ItemInit.DRIED_CALENDULA.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_ROSEMARY.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_THYME.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_TARRAGON.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_CHAMOMILE.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_CHIVES.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_VERBENA.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_SORREL.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_MARJORAM.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_CHERVIL.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_FENNSEL.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_CEILLIS.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_PUNUEL.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_ESSITTE.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_FENNKYSTRAL.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_THYOCIELLE.getDefaultStack());
                itemStacks.add(ItemInit.DRIED_SAGE.getDefaultStack());
            }).build();
    public static ItemGroup HERBS = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "herbs"))
            .icon(() -> new ItemStack(BlockInit.TARRAGON.asItem()))
            .appendItems(itemStacks -> {
                itemStacks.add(BlockInit.CALENDULA.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ROSEMARY.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYME.asItem().getDefaultStack());
                itemStacks.add(BlockInit.TARRAGON.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHAMOMILE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHIVES.asItem().getDefaultStack());
                itemStacks.add(BlockInit.VERBENA.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SORREL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.MARJORAM.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CHERVIL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNSEL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.CEILLIS.asItem().getDefaultStack());
                itemStacks.add(BlockInit.PUNUEL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ESSITTE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.FENNKYSTRAL.asItem().getDefaultStack());
                itemStacks.add(BlockInit.THYOCIELLE.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SAGE.asItem().getDefaultStack());

                itemStacks.add(BlockInit.PRIDE_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.WRATH_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.GLUTTONY_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.SLOTH_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.LUST_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.ENVY_HERB.asItem().getDefaultStack());
                itemStacks.add(BlockInit.GREED_HERB.asItem().getDefaultStack());
            }).build();
    public static ItemGroup AUTOMATION = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "reproduction"))
            .icon(() -> new ItemStack(ItemInit.HERB_FERTILIZER))
            .appendItems(itemStacks -> {
                itemStacks.add(ItemInit.HERB_FERTILIZER_OAK.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_DARK_OAK.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_ACACIA.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_SPRUCE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_BIRCH.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_JUNGLE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_MANGROVE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_FERTILIZER_MYQUESTE.asItem().getDefaultStack());

                itemStacks.add(ItemInit.HERB_HUMUS_OAK.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_DARK_OAK.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_ACACIA.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_SPRUCE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_BIRCH.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_JUNGLE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_MANGROVE.asItem().getDefaultStack());
                itemStacks.add(ItemInit.HERB_HUMUS_MYQUESTE.asItem().getDefaultStack());
            }).build();


    public static void init() {}
}
