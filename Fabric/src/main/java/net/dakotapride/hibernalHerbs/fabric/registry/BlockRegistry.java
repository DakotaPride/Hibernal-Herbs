package net.dakotapride.hibernalherbs.fabric.registry;

import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.fabric.block.HerbConjurationAltarBlock;
import net.dakotapride.hibernalherbs.fabric.block.HibernalLeafPileBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
    public static LeafPileBlock MYQUESTE_LEAF_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock ROSEMARY_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock THYME_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock TARRAGON_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock CHAMOMILE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock CHIVES_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock VERBENA_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock SORREL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock MARJORAM_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock CHERVIL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock FENNSEL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock CEILLIS_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock PUNUEL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock ESSITTE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock THYOCIELLE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock FENNKYSTRAL_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock CALENDULA_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());
    public static LeafPileBlock SAGE_HERB_PILE = new HibernalLeafPileBlock(AbstractBlock.Settings.create());

    // Terraform
    public static final Identifier MYQUESTE_SIGN_TEXTURE = new Identifier(HibernalHerbsCommon.MOD_ID, "entity/signs/myqueste");
    public static final Identifier MYQUESTE_HANGING_SIGN_TEXTURE = new Identifier(HibernalHerbsCommon.MOD_ID, "entity/signs/hanging/myqueste");
    public static final Identifier MYQUESTE_HANGING_GUI_SIGN_TEXTURE = new Identifier(HibernalHerbsCommon.MOD_ID, "textures/gui/hanging_signs/myqueste");

    public static final Block MYQUESTE_SIGN = new TerraformSignBlock(MYQUESTE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
    public static final Block MYQUESTE_WALL_SIGN = new TerraformWallSignBlock(MYQUESTE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN));
    public static final Block MYQUESTE_HANGING_SIGN = new TerraformHangingSignBlock(MYQUESTE_HANGING_SIGN_TEXTURE, MYQUESTE_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
    public static final Block MYQUESTE_WALL_HANGING_SIGN = new TerraformWallHangingSignBlock(MYQUESTE_HANGING_SIGN_TEXTURE, MYQUESTE_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN));

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
