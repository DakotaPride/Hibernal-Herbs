package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.item.HerbTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod.MOD_ID;

@Mod(MOD_ID)
public class HibernalHerbsNeoForge {

    public static final TagKey<Item> HERBS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "herbs"));
    public static final TagKey<Item> POUNDED_HERBS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "pounded_herbs"));
    public static final TagKey<Item> BLENDS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "herb_blends"));
    public static final TagKey<Item> ARTIFICIAL_BLENDS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "herbs/artificial/blends"));

    public static final TagKey<Item> HUMUS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "humus"));
    public static final TagKey<Item> FERTILIZER_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "fertilizer"));

    public static final TagKey<Item> POUCHES_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "pouches"));
    public static final TagKey<Item> CANISTERS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "canisters"));

    public static final TagKey<Item> SIGILS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "sigil/sigils"));

    public static final TagKey<Item> BOUND_PADLOCKS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "padlocks/bound"));
    public static final TagKey<Item> PADLOCKS_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "padlocks/unbound"));

    public static final TagKey<Item> GRIMOIRES_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "grimoires"));


    public static final TagKey<Item> AXES_OR_SIMILAR_TAG = ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "tools/axes"));
    
    public HibernalHerbsNeoForge(IEventBus eventBus, ModContainer modContainer) {

        HibernalHerbsCommonMod.init();
        
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

}