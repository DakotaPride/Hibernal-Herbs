package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.forge.block.HerbConjurationAltarBlock;
import net.dakotapride.hibernalherbs.forge.block.HibernalLeafPileBlock;
import net.dakotapride.hibernalherbs.registry.TypeRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class BlockRegistry {
    public static Block CONJURATION_ALTAR = new HerbConjurationAltarBlock(AbstractBlock.Settings.copy(Blocks.LECTERN).nonOpaque());
    public static HibernalLeafPileBlock MYQUESTE_LEAF_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock ROSEMARY_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock THYME_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock TARRAGON_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock CHAMOMILE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock CHIVES_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock VERBENA_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock SORREL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock MARJORAM_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock CHERVIL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock FENNSEL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock CEILLIS_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock PUNUEL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock ESSITTE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock THYOCIELLE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock FENNKYSTRAL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock CALENDULA_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static HibernalLeafPileBlock SAGE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());

    public static final Block MYQUESTE_SIGN = new SignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN), TypeRegistry.WoodType.MYQUESTE);
    public static final Block MYQUESTE_WALL_SIGN = new WallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN), TypeRegistry.WoodType.MYQUESTE);
    public static final Block MYQUESTE_HANGING_SIGN = new HangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN), TypeRegistry.WoodType.MYQUESTE);
    public static final Block MYQUESTE_WALL_HANGING_SIGN = new WallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN), TypeRegistry.WoodType.MYQUESTE);

    public static final Item MYQUESTE_SIGN_ITEM = new SignItem(new Item.Settings().maxCount(16), BlockRegistry.MYQUESTE_SIGN, BlockRegistry.MYQUESTE_WALL_SIGN);
    public static final Item MYQUESTE_HANGING_SIGN_ITEM = new HangingSignItem(BlockRegistry.MYQUESTE_HANGING_SIGN, BlockRegistry.MYQUESTE_WALL_HANGING_SIGN, new Item.Settings().maxCount(16));

    public static void register() {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "conjuration_altar"), CONJURATION_ALTAR);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "conjuration_altar"), new BlockItem(CONJURATION_ALTAR, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "myqueste_leaf_pile"), MYQUESTE_LEAF_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "myqueste_leaf_pile"), new BlockItem(MYQUESTE_LEAF_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "rosemary_herb_pile"), ROSEMARY_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "rosemary_herb_pile"), new BlockItem(ROSEMARY_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "thyme_herb_pile"), THYME_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "thyme_herb_pile"), new BlockItem(THYME_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tarragon_herb_pile"), TARRAGON_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "tarragon_herb_pile"), new BlockItem(TARRAGON_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "chamomile_herb_pile"), CHAMOMILE_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chamomile_herb_pile"), new BlockItem(CHAMOMILE_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "chives_herb_pile"), CHIVES_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chives_herb_pile"), new BlockItem(CHIVES_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "verbena_herb_pile"), VERBENA_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "verbena_herb_pile"), new BlockItem(VERBENA_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sorrel_herb_pile"), SORREL_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sorrel_herb_pile"), new BlockItem(SORREL_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "marjoram_herb_pile"), MARJORAM_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "marjoram_herb_pile"), new BlockItem(MARJORAM_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "chervil_herb_pile"), CHERVIL_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chervil_herb_pile"), new BlockItem(CHERVIL_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "fennsel_herb_pile"), FENNSEL_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "fennsel_herb_pile"), new BlockItem(FENNSEL_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ceillis_herb_pile"), CEILLIS_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ceillis_herb_pile"), new BlockItem(CEILLIS_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "punuel_herb_pile"), PUNUEL_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "punuel_herb_pile"), new BlockItem(PUNUEL_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "essitte_herb_pile"), ESSITTE_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "essitte_herb_pile"), new BlockItem(ESSITTE_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "thyocielle_herb_pile"), THYOCIELLE_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "thyocielle_herb_pile"), new BlockItem(THYOCIELLE_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "fennkystral_herb_pile"), FENNKYSTRAL_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "fennkystral_herb_pile"), new BlockItem(FENNKYSTRAL_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "calendula_herb_pile"), CALENDULA_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "calendula_herb_pile"), new BlockItem(CALENDULA_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sage_herb_pile"), SAGE_HERB_PILE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sage_herb_pile"), new BlockItem(SAGE_HERB_PILE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "myqueste_sign"), MYQUESTE_SIGN);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "myqueste_wall_sign"), MYQUESTE_WALL_SIGN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "myqueste_sign"), MYQUESTE_SIGN_ITEM);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "myqueste_hanging_sign"), MYQUESTE_HANGING_SIGN);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "myqueste_wall_hanging_sign"), MYQUESTE_WALL_HANGING_SIGN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "myqueste_hanging_sign"), MYQUESTE_HANGING_SIGN_ITEM);
    }
}
