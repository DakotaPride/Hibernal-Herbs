package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsConfigured;
import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsPlaced;
import net.dakotapride.hibernalHerbs.common.init.blockRegistry;
import net.dakotapride.hibernalHerbs.common.init.itemRegistry;
import net.dakotapride.hibernalHerbs.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(Constants.MOD_ID)
public class HibernalHerbsForge {

    public static final CreativeModeTab HIBERNAL_HERBS = new CreativeModeTab("hibernal_herbs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(blockRegistry.MYQUESTE_LOG.get());
        }
    };

    public static final CreativeModeTab POUNDED_HERBS = new CreativeModeTab("pounded_herbs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(itemRegistry.POUNDED_TARRAGON.get());
        }
    };

    public static final CreativeModeTab HERBS = new CreativeModeTab("herbs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(blockRegistry.TARRAGON.get());
        }
    };
    
    public HibernalHerbsForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        itemRegistry.register(eventBus);
        blockRegistry.register(eventBus);
        HibernalHerbsConfigured.register(eventBus);
        HibernalHerbsPlaced.register(eventBus);

        eventBus.addListener(this::commonSetup);

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
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

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.MYQUESTE_SAPLING.getId(), blockRegistry.POTTED_MYQUESTE_SAPLING);

        });
    }

    public static void init() {

        Constants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
        Constants.LOG.info("Diamond Item >> {}", Registry.ITEM.getKey(Items.DIAMOND));
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
}