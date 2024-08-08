package net.dakotapride.hibernalherbs.registry;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class Utilities {
    public static final TagKey<Item> HERBS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "herbs"));
    public static final TagKey<Item> POUNDED_HERBS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "pounded_herbs"));
    public static final TagKey<Item> BLENDS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "herb_blends"));
    public static final TagKey<Item> ARTIFICIAL_BLENDS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "herbs/artificial/blends"));
    public static final TagKey<Item> HUMUS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "humus"));
    public static final TagKey<Item> FERTILIZER_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "fertilizer"));
    public static final TagKey<Item> POUCHES_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "pouches"));
    public static final TagKey<Item> CANISTERS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "canisters"));
    public static final TagKey<Item> BOUND_PADLOCKS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "padlocks/bound"));
    public static final TagKey<Item> PADLOCKS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "padlocks/unbound"));
    public static final TagKey<Item> SIGILS_ITEM_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "sigil/sigils"));
    public static final TagKey<Item> GRIMOIRES = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "grimoires"));
    public static final TagKey<Biome> HAS_HERBS_BIOME_TAG = TagKey.of(RegistryKeys.BIOME, new Identifier(MOD_ID, "has_herbs"));


    public static void register() {
        // Strippable Blocks

        //StrippableBlockRegistry.register(BlockRegistry.MYQUESTE_LOG, BlockRegistry.STRIPPED_MYQUESTE_LOG);
        //StrippableBlockRegistry.register(BlockRegistry.MYQUESTE_WOOD, BlockRegistry.STRIPPED_MYQUESTE_WOOD);

        // Compostable Chance

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CEILLIS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHAMOMILE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHERVIL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CHIVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_ESSITTE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_FENNSEL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_MARJORAM, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_PUNUEL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_ROSEMARY, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_SORREL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_TARRAGON, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_THYME, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_VERBENA, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_THYOCIELLE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_FENNKYSTRAL, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.POUNDED_CALENDULA, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemRegistry.DRIED_CALENDULA, 0.15f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CEILLIS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHAMOMILE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHERVIL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CHIVES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.ESSITTE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.FENNSEL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MARJORAM.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.PUNUEL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.ROSEMARY.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.SORREL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.TARRAGON.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.THYME.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.VERBENA.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.THYOCIELLE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.FENNKYSTRAL.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.CALENDULA.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MYQUESTE_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockRegistry.MYQUESTE_LEAVES.asItem(), 0.3f);

    }

}
