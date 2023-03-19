package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.client.PackLoader;
import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsConfigured;
import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsPlaced;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.dakotapride.hibernalHerbs.platform.Services;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod(MOD_ID)
public class HibernalHerbsForge {
    public static final TagKey<Item> HERBS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "herbs"));
    public static final TagKey<Item> POUNDED_HERBS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "pounded_herbs"));
    public static final TagKey<Item> BLENDS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "herb_blends"));

    public static final TagKey<Item> POUCHES_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "pouches"));
    public static final TagKey<Item> CANISTERS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "canisters"));

    public static final TagKey<Item> SCRATCHED_HERBS = ItemTags.create(new ResourceLocation(MOD_ID, "pouches/scratched"));
    public static final TagKey<Item> STITCHED_HERBS = ItemTags.create(new ResourceLocation(MOD_ID, "pouches/stitched"));
    public static final TagKey<Item> PROPER_HERBS = ItemTags.create(new ResourceLocation(MOD_ID, "pouches/proper"));

    public static final TagKey<Item> IRON_BLENDS = ItemTags.create(new ResourceLocation(MOD_ID, "blends/iron"));
    public static final TagKey<Item> AMETHYST_BLENDS = ItemTags.create(new ResourceLocation(MOD_ID, "blends/amethyst"));
    public static final TagKey<Item> DIAMOND_BLENDS = ItemTags.create(new ResourceLocation(MOD_ID, "blends/diamond"));


    public static final CreativeModeTab HIBERNAL_HERBS = new CreativeModeTab("hibernal_herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(blockRegistry.MYQUESTE_LOG.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> nonNullList) {
            nonNullList.add(0, blockRegistry.MYQUESTE_SAPLING.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MYQUESTE_LEAVES.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.MYQUESTE_STAIRS.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MYQUESTE_SLAB.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.MYQUESTE_FENCE_GATE.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MYQUESTE_FENCE.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.MYQUESTE_TRAPDOOR.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MYQUESTE_DOOR.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.STRIPPED_MYQUESTE_WOOD.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.STRIPPED_MYQUESTE_LOG.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.MYQUESTE_WOOD.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MYQUESTE_LOG.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.MYQUESTE_PLANKS.get().asItem().getDefaultInstance());

            // Smoked
            nonNullList.add(0, itemRegistry.SMOKED_BLOOMING_BLEND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.SMOKED_ALTERNATIVE_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_CONFLICTING_BLEND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.SMOKED_SHADED_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_DIMINISHED_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_OBSERVING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_DECAYING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_INCINERATING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_ACCELERATION_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_DASHING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_HINDERING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_SEDATING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_VIRULENT_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SMOKED_REGENERATIVE_BLEND.get().getDefaultInstance());

            // Non-Smoked
            nonNullList.add(0, itemRegistry.BLOOMING_BLEND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.ALTERNATIVE_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.CONFLICTING_BLEND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.SHADED_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.DIMINISHED_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.OBSERVING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.DECAYING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.INCINERATING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.ACCELERATION_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.DASHING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.HINDERING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.SEDATING_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.VIRULENT_BLEND.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.REGENERATIVE_BLEND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.CANISTER_IRON.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.CANISTER_AMETHYST.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.CANISTER_DIAMOND.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.POUCH_SCRATCHED.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.HERB_HUMUS.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.HERB_FERTILIZER.get().getDefaultInstance());
        }
    };

    public static final CreativeModeTab POUNDED_HERBS = new CreativeModeTab("pounded_herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(itemRegistry.POUNDED_TARRAGON.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> nonNullList) {
            nonNullList.add(0, itemRegistry.POUNDED_BLOFORIA.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.POUNDED_FENNKYSTRAL.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_THYOCIELLE.get().getDefaultInstance());

            nonNullList.add(0, itemRegistry.POUNDED_VERBENA.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_THYME.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_TARRAGON.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_SORREL.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_ROSEMARY.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_PUNUEL.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_MARJORAM.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_FENNSEL.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_ESSITTE.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_CHIVES.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_CHERVIL.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_CHAMOMILE.get().getDefaultInstance());
            nonNullList.add(0, itemRegistry.POUNDED_CEILLIS.get().getDefaultInstance());
        }
    };

    public static final CreativeModeTab HERBS = new CreativeModeTab("herbs") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(blockRegistry.TARRAGON.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> nonNullList) {
            nonNullList.add(0, blockRegistry.BLOFORIA.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.FENNKYSTRAL.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.THYOCIELLE.get().asItem().getDefaultInstance());

            nonNullList.add(0, blockRegistry.VERBENA.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.THYME.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.TARRAGON.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.SORREL.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.ROSEMARY.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.PUNUEL.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.MARJORAM.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.FENNSEL.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.ESSITTE.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.CHIVES.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.CHERVIL.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.CHAMOMILE.get().asItem().getDefaultInstance());
            nonNullList.add(0, blockRegistry.CEILLIS.get().asItem().getDefaultInstance());
        }
    };
    
    public HibernalHerbsForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        itemRegistry.register(eventBus);
        blockRegistry.register(eventBus);
        HibernalHerbsConfigured.register(eventBus);
        HibernalHerbsPlaced.register(eventBus);

        // Resource Pack Registration
        eventBus.addListener(PackLoader::addPackFinders);

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        init();

        // Some code like events require special initialization from the
        // loader specific code.
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
        
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.ROSEMARY.getId(), blockRegistry.POTTED_ROSEMARY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.THYME.getId(), blockRegistry.POTTED_THYME);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.TARRAGON.getId(), blockRegistry.POTTED_TARRAGON);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.CHAMOMILE.getId(), blockRegistry.POTTED_CHAMOMILE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.CHIVES.getId(), blockRegistry.POTTED_CHIVES);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.VERBENA.getId(), blockRegistry.POTTED_VERBENA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.SORREL.getId(), blockRegistry.POTTED_SORREL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.MARJORAM.getId(), blockRegistry.POTTED_MARJORAM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.CHERVIL.getId(), blockRegistry.POTTED_CHERVIL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.FENNSEL.getId(), blockRegistry.POTTED_FENNSEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.CEILLIS.getId(), blockRegistry.POTTED_CEILLIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.PUNUEL.getId(), blockRegistry.POTTED_PUNUEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.ESSITTE.getId(), blockRegistry.POTTED_ESSITTE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.THYOCIELLE.getId(), blockRegistry.POTTED_THYOCIELLE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.FENNKYSTRAL.getId(), blockRegistry.POTTED_FENNKYSTRAL);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.BLOFORIA.getId(), blockRegistry.POTTED_BLOFORIA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.CALENDULA.getId(), blockRegistry.POTTED_CALENDULA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.MYQUESTE_SAPLING.getId(), blockRegistry.POTTED_MYQUESTE_SAPLING);

        });

        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_CEILLIS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_CHAMOMILE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_CHERVIL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_CHIVES.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_ESSITTE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_FENNSEL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_MARJORAM.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_PUNUEL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_ROSEMARY.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_SORREL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_TARRAGON.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_THYME.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_VERBENA.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_THYOCIELLE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_FENNKYSTRAL.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_CALENDULA.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CALENDULA.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(blockRegistry.CEILLIS.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.CHAMOMILE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.CHERVIL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.CHIVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.ESSITTE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.FENNSEL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.MARJORAM.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.PUNUEL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.ROSEMARY.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.SORREL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.TARRAGON.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.THYME.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.VERBENA.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(blockRegistry.THYOCIELLE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.FENNKYSTRAL.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(blockRegistry.CALENDULA.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(blockRegistry.MYQUESTE_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.MYQUESTE_LEAVES.get().asItem(), 0.3f);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemProperties.register(itemRegistry.CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
    }

    public static void init() {

        Constants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
    }

    // This method exists as a wrapper for the code in the Common project.
    // It takes Forge's event object and passes the parameters along to
    // the Common listener.
    private void onItemTooltip(ItemTooltipEvent event) {

        Common$onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }

    public static void Common$onItemTooltip(ItemStack stack, TooltipFlag context, List<Component> tooltip) {

        if (!stack.isEmpty()) {

            final FoodProperties food = stack.getItem().getFoodProperties();

            if (food != null) {

                tooltip.add(Component.literal("Nutrition: " + food.getNutrition()));
                tooltip.add(Component.literal("Saturation: " + food.getSaturationModifier()));
            }
        }
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}