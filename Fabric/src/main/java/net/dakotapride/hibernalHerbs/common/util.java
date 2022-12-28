package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class util {
    public static final TagKey<Item> HERBS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "herbs"));
    public static final TagKey<Item> POUNDED_HERBS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "pounded_herbs"));
    public static final TagKey<Item> BLENDS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "herb_blends"));

    public static final TagKey<Biome> HAS_HERBS = TagKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "has_herbs"));

    public static void utilsInit() {
        StrippableBlockRegistry.register(BlockInit.MYQUESTE_LOG, BlockInit.STRIPPED_MYQUESTE_LOG);
        StrippableBlockRegistry.register(BlockInit.MYQUESTE_WOOD, BlockInit.STRIPPED_MYQUESTE_WOOD);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_CEILLIS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_CHAMOMILE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_CHERVIL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_CHIVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_ESSITTE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_FENNSEL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_MARJORAM, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_PUNUEL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_ROSEMARY, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_SORREL, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_TARRAGON, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_THYME, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_VERBENA, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_THYOCIELLE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.POUNDED_FENNKYSTRAL, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.CEILLIS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.CHAMOMILE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.CHERVIL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.CHIVES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.ESSITTE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.FENNSEL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.MARJORAM.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.PUNUEL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.ROSEMARY.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.SORREL.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.TARRAGON.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.THYME.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.VERBENA.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.THYOCIELLE.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.FENNKYSTRAL.asItem(), 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.MYQUESTE_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.MYQUESTE_LEAVES.asItem(), 0.3f);


        FabricModelPredicateProviderRegistry.register(ItemInit.CANISTER, new Identifier(MOD_ID, "filled"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));
    }

}
