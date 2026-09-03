package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public class ItemGroupInit {
    public static final CreativeModeTab HIBERNAL_HERBS_TAB = register("hibernal_herbs",
            FabricItemGroup.builder().icon(() -> new ItemStack(Sickles.ARKONIUM.getSickleItem()))
                    .title(Component.translatable("creativetab.hibernalherbs.hibernal_herbs"))
                    .displayItems((displayContext, entries) -> {
//                        for (Item item : ItemInit.ITEMS.stream().toList()) {
//                            entries.accept(item);
//                        }

                        entries.accept(ItemInit.GROUND_HERBS);
                        entries.accept(ItemInit.LIFE_FORCE_BOTTLE);
                        entries.accept(ItemInit.INSCRIPTION_SMITHING_TEMPLATE);
                        entries.accept(ItemInit.BLANK_HERBAL_SIGIL);
                        entries.accept(ItemInit.CRACKED_HERBAL_SIGIL);
                        entries.accept(ItemInit.SILIPTIUM_PETALS);
                        entries.accept(ItemInit.LUMBINETRIK_PETALS);
                        entries.accept(ItemInit.JULISIUM_PETALS);
                        entries.accept(ItemInit.GRIMOIRE);
                        entries.accept(ItemInit.SINGED_GRIMOIRE);
                        entries.accept(ItemInit.SORCERER_AGGLOMERATION);
                        entries.accept(ItemInit.SORCERER_TOME);
                        entries.accept(ItemInit.MYSTICAL_ASHES);
                        entries.accept(ItemInit.VILE_ASHES);
                        entries.accept(ItemInit.VIRTUOUS_ASHES);
                        entries.accept(BlockInit.SACRIFICIAL_RUNE_BLOCK);
                        entries.accept(BlockInit.FROZE_STATE_SACRIFICIAL_RUNE_BLOCK);
                        entries.accept(BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK);
                        entries.accept(BlockInit.MYSTICAL_CAMPFIRE);
                        entries.accept(BlockInit.INCENSE_PROVIDER);

                        for (HerbTypes types : HerbTypes.values()) {
                            entries.accept(types.getBaseBlock());
                            entries.accept(types.getPoundedHerbBlock());
                            entries.accept(types.getDriedHerbBlock());
                            entries.accept(types.getPoundedHerb());
                            entries.accept(types.getDriedHerb());
                            entries.accept(types.getLanternBlock());
                            entries.accept(types.getHerbPileBlock());
                            entries.accept(types.getHerbBarrelBlock());
                        }

                        for (HerbalBlendTypes types : HerbalBlendTypes.values()) {
                            if (types != HerbalBlendTypes.NONE) {
                                entries.accept(types.getHerbalBlend());
                            }
                        }

                        for (HerbalSigilTypes types : HerbalSigilTypes.values()) {
                            if (types != HerbalSigilTypes.NONE) {
                                entries.accept(types.getHerbalSigilItem());
                            }
                        }

                        for (PadlockTypes types : PadlockTypes.values()) {
                            if (types != PadlockTypes.NONE) {
                                entries.accept(types.getUnboundPadlockItem());
                                entries.accept(types.getBoundPadlockItem());
                            }
                        }

                        for (WoodTypes types : WoodTypes.values()) {
                            entries.accept(types.getLeavesBlock());
                            entries.accept(types.getLogBlock());
                            entries.accept(types.getStrippedLogBlock());
                            entries.accept(types.getWoodBlock());
                            entries.accept(types.getStrippedWoodBlock());
                            entries.accept(types.getPlanksBlock());
                            entries.accept(types.getSlabBlock());
                            entries.accept(types.getStairsBlock());
                            entries.accept(types.getFenceBlock());
                            entries.accept(types.getFenceGateBlock());
                            entries.accept(types.getButtonBlock());
                            entries.accept(types.getPressurePlateBlock());
                            entries.accept(types.getDoorBlock());
                            entries.accept(types.getTrapdoorBlock());
                            entries.accept(types.getSignBlock());
                            entries.accept(types.getHangingSignBlock());
                            entries.accept(types.getBoatItem());
                            entries.accept(types.getChestBoatItem());
                            entries.accept(types.getSaplingBlock());
                        }

                        for (StoneTypes types : StoneTypes.values()) {
                            entries.accept(types.getBaseBlock());
                            entries.accept(types.getCobbledBlock());
                            entries.accept(types.getPolishedBlock());
                            entries.accept(types.getBricksBlock());
                            entries.accept(types.getSlabBlock());
                            entries.accept(types.getCobbledSlabBlock());
                            entries.accept(types.getPolishedSlabBlock());
                            entries.accept(types.getBrickSlabBlock());
                            entries.accept(types.getStairsBlock());
                            entries.accept(types.getCobbledStairsBlock());
                            entries.accept(types.getPolishedStairsBlock());
                            entries.accept(types.getBrickStairsBlock());
                            entries.accept(types.getWallBlock());
                            entries.accept(types.getCobbledWallBlock());
                            entries.accept(types.getPolishedWallBlock());
                            entries.accept(types.getBrickWallBlock());
                            entries.accept(types.getButtonBlock());
                            entries.accept(types.getPressurePlateBlock());
                        }

                        for (Archaeology.Metals metals : Archaeology.Metals.values()) {
                            if (metals.isAlloy()) {
                                entries.accept(metals.getScrapItem());
                            }
                            entries.accept(metals.getIngotItem());
                            entries.accept(metals.getNuggetItem());
                            entries.accept(metals.getBlock());
                        }

                        for (Archaeology.Brushes brushes : Archaeology.Brushes.values()) {
                            entries.accept(brushes.getBrushItem());
                        }

                        for (Archaeology.SuspiciousBlocks suspiciousBlocks : Archaeology.SuspiciousBlocks.values()) {
                            entries.accept(suspiciousBlocks.getBlock());
                        }

                        for (Archaeology.Ashes ashes : Archaeology.Ashes.values()) {
                            entries.accept(ashes.getAshesItem());
                        }

                        for (MetalUtilities.Armour armour : MetalUtilities.Armour.values()) {
                            entries.accept(armour.getHelmetItem());
                            entries.accept(armour.getChestplateItem());
                            entries.accept(armour.getLeggingsItem());
                            entries.accept(armour.getBootsItem());
                        }

                        for (MetalUtilities.Tools tools : MetalUtilities.Tools.values()) {
                            entries.accept(tools.getSwordItem());
                            entries.accept(tools.getPickaxeItem());
                            entries.accept(tools.getAxeItem());
                            entries.accept(tools.getShovelItem());
                            entries.accept(tools.getHoeItem());
                        }

                        for (FertilizerTypes types : FertilizerTypes.values()) {
                            entries.accept(types.getHerbHumusItem());
                            if (types != FertilizerTypes.NONE) {
                                entries.accept(types.getFertilizerItem());
                            }
                        }

                        for (Sickles sickles : Sickles.values()) {
                            entries.accept(sickles.getSickleItem());
                        }

                        displayContext.holders().lookup(Registries.POTION).ifPresent(
                                registryLookup -> generatePotionEffectTypes(
                                        entries, registryLookup, ItemInit.ENIGMATIC_POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                                )
                        );
                        displayContext.holders().lookup(Registries.POTION).ifPresent(
                                registryLookup -> generatePotionEffectTypes(
                                        entries, registryLookup, ItemInit.SOLAR_POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                                )
                        );
                        displayContext.holders().lookup(Registries.POTION).ifPresent(
                                registryLookup -> generatePotionEffectTypes(
                                        entries, registryLookup, ItemInit.LUNAR_POTION, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                                )
                        );

                    }).build());

    private static void generatePotionEffectTypes(
            CreativeModeTab.Output output, HolderLookup<Potion> holderLookup, Item item, CreativeModeTab.TabVisibility tabVisibility
    ) {
        holderLookup.listElements()
                .filter(reference -> !reference.is(Potions.EMPTY_ID))
                .map(reference -> PotionUtils.setPotion(new ItemStack(item), reference.value()))
                .forEach(itemStack -> output.accept(itemStack, tabVisibility));
    }

    public static CreativeModeTab register(String name, CreativeModeTab item) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HibernalHerbsMod.asResource(name), item);
    }

    public static void register() {}
}
