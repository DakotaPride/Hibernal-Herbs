package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.client.PackLoader;
import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.entity.HibernalEntityTypes;
import net.dakotapride.hibernalHerbs.common.entity.render.MyquesteBoatRenderer;
import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsConfigured;
import net.dakotapride.hibernalHerbs.common.gen.HibernalHerbsPlaced;
import net.dakotapride.hibernalHerbs.common.recipe.HibernalRecipes;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.dakotapride.hibernalHerbs.common.registry.wood.MyquesteType;
import net.dakotapride.hibernalHerbs.common.screen.HerbalConjurationScreen;
import net.dakotapride.hibernalHerbs.common.screen.menu.HibernalHerbsMenues;
import net.dakotapride.hibernalHerbs.platform.Services;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod(MOD_ID)
public class HibernalHerbsForge {

    public static final TagKey<Item> HERBS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "herbs"));
    public static final TagKey<Item> POUNDED_HERBS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "pounded_herbs"));
    public static final TagKey<Item> BLENDS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "herb_blends"));
    public static final TagKey<Item> ARTIFICIAL_BLENDS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "herbs/artificial/blends"));

    public static final TagKey<Item> HUMUS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "humus"));
    public static final TagKey<Item> FERTILIZER_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "fertilizer"));

    public static final TagKey<Item> POUCHES_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "pouches"));
    public static final TagKey<Item> CANISTERS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "canisters"));

    public static final TagKey<Item> SIGILS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "sigil/sigils"));

    public static final TagKey<Item> BOUND_PADLOCKS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "padlocks/bound"));
    public static final TagKey<Item> PADLOCKS_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "padlocks/unbound"));

    public static final TagKey<Item> GRIMOIRES_TAG = ItemTags.create(new ResourceLocation(MOD_ID, "grimoires"));
    
    public HibernalHerbsForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        itemRegistry.register(eventBus);
        blockRegistry.register(eventBus);

        // Entities
        HibernalEntityTypes.ENTITIES.register(eventBus);

        HibernalBlockEntities.BLOCK_ENTITIES.register(eventBus);
        HibernalHerbsMenues.register(eventBus);

        HibernalRecipes.register(eventBus);

        // Resource Pack Registration
        eventBus.addListener(PackLoader::onAddPackFinders);

        eventBus.addListener(this::commonSetup);
        // eventBus.addListener(this::clientSetup);

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

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(blockRegistry.SAGE.getId(), blockRegistry.POTTED_SAGE);

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

            ComposterBlock.COMPOSTABLES.put(itemRegistry.POUNDED_SAGE.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CALENDULA.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CEILLIS.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CHAMOMILE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CHERVIL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_CHIVES.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_ESSITTE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_FENNSEL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_MARJORAM.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_PUNUEL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_ROSEMARY.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_SORREL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_TARRAGON.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_THYME.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_VERBENA.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_THYOCIELLE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_FENNKYSTRAL.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(itemRegistry.DRIED_SAGE.get(), 0.15f);

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

            ComposterBlock.COMPOSTABLES.put(blockRegistry.SAGE.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(blockRegistry.MYQUESTE_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(blockRegistry.MYQUESTE_LEAVES.get().asItem(), 0.3f);
        });

        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
        });
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class HibernalHerbsClientEvents {
        @SubscribeEvent
        public void clientSetup(final FMLClientSetupEvent event) {
            ItemProperties.register(itemRegistry.CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                    ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));

            MenuScreens.register(HibernalHerbsMenues.CONJURATION_ALTAR_MENU.get(), HerbalConjurationScreen::new);

            EntityRenderers.register(HibernalEntityTypes.MYQUESTE_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, false));
            EntityRenderers.register(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, true));

            event.enqueueWork(MyquesteType::init);
        }
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

}