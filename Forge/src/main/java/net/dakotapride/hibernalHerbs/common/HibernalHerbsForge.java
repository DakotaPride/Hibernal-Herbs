package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.client.PackLoader;
import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.entity.HibernalEntityTypes;
import net.dakotapride.hibernalHerbs.common.entity.render.MyquesteBoatRenderer;
import net.dakotapride.hibernalHerbs.common.recipe.HibernalRecipes;
import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.dakotapride.hibernalHerbs.common.screen.HerbalConjurationScreen;
import net.dakotapride.hibernalHerbs.common.screen.menu.HibernalHerbsMenues;
import net.dakotapride.hibernalHerbs.platform.Services;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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

        ItemRegistry.register(eventBus);
        BlockRegistry.register(eventBus);

        // Entities
        HibernalEntityTypes.ENTITY_TYPES.register(eventBus);

        HibernalBlockEntities.BLOCK_ENTITIES.register(eventBus);
        HibernalHerbsMenues.register(eventBus);

        HibernalRecipes.register(eventBus);

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

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.BLOFORIA.getId(), BlockRegistry.POTTED_BLOFORIA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.CALENDULA.getId(), BlockRegistry.POTTED_CALENDULA);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.SAGE.getId(), BlockRegistry.POTTED_SAGE);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegistry.MYQUESTE_SAPLING.getId(), BlockRegistry.POTTED_MYQUESTE_SAPLING);

        });

        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_CEILLIS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_CHAMOMILE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_CHERVIL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_CHIVES.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_ESSITTE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_FENNSEL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_MARJORAM.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_PUNUEL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_ROSEMARY.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_SORREL.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_TARRAGON.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_THYME.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_VERBENA.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_THYOCIELLE.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_FENNKYSTRAL.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_CALENDULA.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.POUNDED_SAGE.get(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_CALENDULA.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_CEILLIS.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_CHAMOMILE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_CHERVIL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_CHIVES.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_ESSITTE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_FENNSEL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_MARJORAM.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_PUNUEL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_ROSEMARY.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_SORREL.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_TARRAGON.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_THYME.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_VERBENA.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_THYOCIELLE.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_FENNKYSTRAL.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(ItemRegistry.DRIED_SAGE.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(BlockRegistry.CEILLIS.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.CHAMOMILE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.CHERVIL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.CHIVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.ESSITTE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.FENNSEL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.MARJORAM.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.PUNUEL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.ROSEMARY.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.SORREL.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.TARRAGON.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.THYME.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.VERBENA.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(BlockRegistry.THYOCIELLE.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.FENNKYSTRAL.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(BlockRegistry.CALENDULA.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(BlockRegistry.SAGE.get().asItem(), 0.3f);

            ComposterBlock.COMPOSTABLES.put(BlockRegistry.MYQUESTE_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(BlockRegistry.MYQUESTE_LEAVES.get().asItem(), 0.3f);
        });

        event.enqueueWork(() -> {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemProperties.register(ItemRegistry.CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));

        MenuScreens.register(HibernalHerbsMenues.CONJURATION_ALTAR_MENU.get(), HerbalConjurationScreen::new);

        EntityRenderers.register(HibernalEntityTypes.MYQUESTE_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, false));
        EntityRenderers.register(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, true));
    }

    public static void init() {

        Constants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
    }

    // This method exists as a wrapper for the code in the Common project.
    // It takes Forge's event object and passes the parameters along to
    // the Common listener.
    private void onItemTooltip(ItemTooltipEvent event) {

        // Common$onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
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