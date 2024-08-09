package net.dakotapride.hibernalherbs.forge;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.client.PackLoader;
import net.dakotapride.hibernalherbs.forge.registry.*;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(HibernalHerbsCommon.MOD_ID)
public final class HibernalHerbsForge {

    public HibernalHerbsForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);

        // Entities
        EntityTypeRegistry.register(eventBus);

        BlockEntityRegistry.register(eventBus);
        ScreenHandlersRegistry.register(eventBus);

        RecipeRegistry.register(eventBus);

        // Resource Pack Registration
        eventBus.addListener(PackLoader::onAddPackFinders);

        eventBus.addListener(this::commonSetup);
        //eventBus.addListener(this::clientSetup);

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        init();

        // Some code like events require special initialization from the
        // loader specific code.
        // MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.ROSEMARY.getId(), BlockRegistry.POTTED_ROSEMARY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.THYME.getId(), BlockRegistry.POTTED_THYME);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.TARRAGON.getId(), BlockRegistry.POTTED_TARRAGON);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CHAMOMILE.getId(), BlockRegistry.POTTED_CHAMOMILE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CHIVES.getId(), BlockRegistry.POTTED_CHIVES);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.VERBENA.getId(), BlockRegistry.POTTED_VERBENA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SORREL.getId(), BlockRegistry.POTTED_SORREL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.MARJORAM.getId(), BlockRegistry.POTTED_MARJORAM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CHERVIL.getId(), BlockRegistry.POTTED_CHERVIL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FENNSEL.getId(), BlockRegistry.POTTED_FENNSEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CEILLIS.getId(), BlockRegistry.POTTED_CEILLIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.PUNUEL.getId(), BlockRegistry.POTTED_PUNUEL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.ESSITTE.getId(), BlockRegistry.POTTED_ESSITTE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.THYOCIELLE.getId(), BlockRegistry.POTTED_THYOCIELLE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.FENNKYSTRAL.getId(), BlockRegistry.POTTED_FENNKYSTRAL);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CALENDULA.getId(), BlockRegistry.POTTED_CALENDULA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAGE.getId(), BlockRegistry.POTTED_SAGE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.MYQUESTE_SAPLING.getId(), BlockRegistry.POTTED_MYQUESTE_SAPLING);

        });

        event.enqueueWork(() -> {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CEILLIS.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHAMOMILE.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHERVIL.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHIVES.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_ESSITTE.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_FENNSEL.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_MARJORAM.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_PUNUEL.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_ROSEMARY.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_SORREL.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_TARRAGON.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_THYME.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_VERBENA.get(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_THYOCIELLE.get(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_FENNKYSTRAL.get(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CALENDULA.get(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_SAGE.get(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CALENDULA.get(), 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CEILLIS.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CHAMOMILE.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CHERVIL.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CHIVES.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_ESSITTE.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_FENNSEL.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_MARJORAM.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_PUNUEL.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_ROSEMARY.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_SORREL.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_TARRAGON.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_THYME.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_VERBENA.get(), 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_THYOCIELLE.get(), 0.15f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_FENNKYSTRAL.get(), 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_SAGE.get(), 0.15f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CEILLIS.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHAMOMILE.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHERVIL.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHIVES.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.ESSITTE.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.FENNSEL.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MARJORAM.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.PUNUEL.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.ROSEMARY.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.SORREL.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.TARRAGON.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.THYME.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.VERBENA.get().asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.THYOCIELLE.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.FENNKYSTRAL.get().asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CALENDULA.get().asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.SAGE.get().asItem(), 0.3f);

            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MYQUESTE_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MYQUESTE_LEAVES.get().asItem(), 0.3f);
        });

        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
        });
    }

    public static void init() {
        HibernalHerbsCommon.LOG.info("If you're seeing this, all registration methods should have been run");
    }
}
