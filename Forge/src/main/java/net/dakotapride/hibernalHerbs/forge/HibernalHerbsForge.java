package net.dakotapride.hibernalherbs.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.client.MyquesteBoatRenderer;
import net.dakotapride.hibernalherbs.forge.client.PackLoader;
import net.dakotapride.hibernalherbs.forge.registry.*;
import net.dakotapride.hibernalherbs.forge.screen.HerbConjurationAltarScreen;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(HibernalHerbsCommon.MOD_ID)
public final class HibernalHerbsForge {

    public HibernalHerbsForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(HibernalHerbsCommon.MOD_ID, bus);

        // Run our common setup.
        // No you're not
        //HibernalHerbsCommon.init();

        // Forge item register
        ItemRegistry.register(bus);
        // Forge Block register
        BlockRegistry.register(bus);
        // Forge Item Group register
        ItemGroupsRegistry.register();

        // Forge Feature register - not required, can be handled by forge/biome_modifier
        // FeaturesRegistry.register();
        // Terraform Boat Type register - only on fabric
        //BoatTypeRegistry.register();

        // Mod Event Bus required for Screen Handler/Menu registry
        ScreenHandlersRegistry.register(bus);

        BlockEntityRegistry.register(bus);
        EntityTypeRegistry.register(bus);

        RecipeRegistry.register(bus);

        // Resource Pack Registration
        bus.addListener(PackLoader::onAddPackFinders);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_ROSEMARY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_THYME);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_TARRAGON);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHAMOMILE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHIVES);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_VERBENA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_SORREL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_MARJORAM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHERVIL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_FENNSEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CEILLIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_PUNUEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_ESSITTE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_THYOCIELLE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_FENNKYSTRAL);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CALENDULA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_SAGE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_SAPLING.getLootTableId(), () -> net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_MYQUESTE_SAPLING);

        });

        event.enqueueWork(() -> {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CEILLIS, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHAMOMILE, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHERVIL, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CHIVES, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ESSITTE, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNSEL, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_MARJORAM, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_PUNUEL, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_ROSEMARY, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SORREL, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_TARRAGON, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYME, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_VERBENA, 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_THYOCIELLE, 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_FENNKYSTRAL, 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_CALENDULA, 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.POUNDED_SAGE, 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CALENDULA, 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CEILLIS, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHAMOMILE, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHERVIL, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_CHIVES, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ESSITTE, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNSEL, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_MARJORAM, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_PUNUEL, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_ROSEMARY, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SORREL, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_TARRAGON, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYME, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_VERBENA, 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_THYOCIELLE, 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_FENNKYSTRAL, 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.ItemRegistry.DRIED_SAGE, 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA.asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL.asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA.asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE.asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_SAPLING.asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_LEAVES.asItem(), 0.3f);
        });

        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemPropertiesRegistry.register(net.dakotapride.hibernalherbs.registry.ItemRegistry.CANISTER, new Identifier(HibernalHerbsCommon.MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasNbt() ? 1f : 0f));

        HandledScreens.register(ScreenHandlersRegistry.CONJURATION_ALTAR_SCREEN_HANDLER.get(), HerbConjurationAltarScreen::new);

        EntityRenderers.register(EntityTypeRegistry.MYQUESTE_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, false));
        EntityRenderers.register(EntityTypeRegistry.MYQUESTE_CHEST_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, true));
    }
}
