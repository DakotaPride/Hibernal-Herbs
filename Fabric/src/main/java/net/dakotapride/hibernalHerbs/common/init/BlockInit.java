package net.dakotapride.hibernalHerbs.common.init;

import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsMod;
import net.dakotapride.hibernalHerbs.common.block.HibernalLeafPileBlock;
import net.dakotapride.hibernalHerbs.common.gen.saplingGenerator.MyquesteSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class BlockInit {

    // "Leaf" (Herb) Piles
    public static LeafPileBlock MYQUESTE_LEAF_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());

    public static LeafPileBlock ROSEMARY_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock THYME_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock TARRAGON_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock CHAMOMILE_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock CHIVES_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock VERBENA_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock SORREL_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock MARJORAM_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock CHERVIL_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock FENNSEL_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock CEILLIS_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock PUNUEL_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock ESSITTE_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());

    public static LeafPileBlock THYOCIELLE_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static LeafPileBlock FENNKYSTRAL_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());

    public static LeafPileBlock CALENDULA_HERB_PILE = new LeafPileBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque());

    public static FlowerBlock ROSEMARY =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock THYME =
            new FlowerBlock(StatusEffects.POISON, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock TARRAGON =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock CHAMOMILE =
            new FlowerBlock(StatusEffects.ABSORPTION, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock CHIVES =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock VERBENA =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock SORREL =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock MARJORAM =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock CHERVIL =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock FENNSEL =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock CEILLIS =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock PUNUEL =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock ESSITTE =
            new FlowerBlock(StatusEffects.SLOWNESS, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));

    // Resource Dependant Herbs

    public static FlowerBlock THYOCIELLE =
            new FlowerBlock(StatusEffects.REGENERATION, 180, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));
    public static FlowerBlock FENNKYSTRAL =
            new FlowerBlock(StatusEffects.REGENERATION, 240, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY));

    // Spring Herb(s)

    public static FlowerBlock CALENDULA =
            new FlowerBlock(StatusEffects.GLOWING, 200, FabricBlockSettings.copy(Blocks.LILY_OF_THE_VALLEY).luminance((state) -> {
                return 6;
            }));

    public static FlowerPotBlock POTTED_ROSEMARY =
            new FlowerPotBlock(ROSEMARY, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_THYME =
            new FlowerPotBlock(THYME, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_TARRAGON =
            new FlowerPotBlock(TARRAGON, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_CHAMOMILE =
            new FlowerPotBlock(CHAMOMILE, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_CHIVES =
            new FlowerPotBlock(CHIVES, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_VERBENA =
            new FlowerPotBlock(VERBENA, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_SORREL =
            new FlowerPotBlock(SORREL, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_MARJORAM =
            new FlowerPotBlock(MARJORAM, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_CHERVIL =
            new FlowerPotBlock(CHERVIL, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_FENNSEL =
            new FlowerPotBlock(FENNSEL, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_CEILLIS =
            new FlowerPotBlock(CEILLIS, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_PUNUEL =
            new FlowerPotBlock(PUNUEL, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_ESSITTE =
            new FlowerPotBlock(ESSITTE, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));

    // Resource Dependant (Potted) Herbs

    public static FlowerPotBlock POTTED_THYOCIELLE =
            new FlowerPotBlock(THYOCIELLE, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));
    public static FlowerPotBlock POTTED_FENNKYSTRAL =
            new FlowerPotBlock(FENNKYSTRAL, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY));

    // Spring (Potted) Herb(s)

    public static FlowerPotBlock POTTED_CALENDULA =
            new FlowerPotBlock(CALENDULA, FabricBlockSettings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY).luminance((state) -> {
                return 4;
            }));

    public static LanternBlock CALENDULA_LANTERN =
            new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN));

    public static SaplingBlock MYQUESTE_SAPLING = new SaplingBlock(new MyquesteSaplingGenerator(),
            FabricBlockSettings.copy(Blocks.SPRUCE_SAPLING).ticksRandomly().nonOpaque());
    public static PillarBlock MYQUESTE_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.SPRUCE_LOG));
    public static PillarBlock STRIPPED_MYQUESTE_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_SPRUCE_LOG));
    public static PillarBlock MYQUESTE_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.SPRUCE_WOOD));
    public static PillarBlock STRIPPED_MYQUESTE_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_SPRUCE_WOOD));
    public static Block MYQUESTE_PLANKS = new Block(FabricBlockSettings.copy(Blocks.SPRUCE_PLANKS));
    public static LeavesBlock MYQUESTE_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.SPRUCE_LEAVES).ticksRandomly().nonOpaque());
    public static DoorBlock MYQUESTE_DOOR = new DoorBlock(FabricBlockSettings.copy(Blocks.SPRUCE_DOOR));
    public static TrapdoorBlock MYQUESTE_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.copy(Blocks.SPRUCE_TRAPDOOR));
    public static SlabBlock MYQUESTE_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.SPRUCE_SLAB));
    public static StairsBlock MYQUESTE_STAIRS = new StairsBlock(MYQUESTE_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.SPRUCE_STAIRS));
    public static FenceBlock MYQUESTE_FENCE = new FenceBlock(FabricBlockSettings.copy(Blocks.SPRUCE_FENCE));
    public static FenceGateBlock MYQUESTE_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.copy(Blocks.SPRUCE_FENCE_GATE));
    public static FlowerPotBlock POTTED_MYQUESTE_SAPLING =
            new FlowerPotBlock(MYQUESTE_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_SPRUCE_SAPLING));
    public static WoodenButtonBlock MYQUESTE_BUTTON = new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.SPRUCE_BUTTON));
    public static PressurePlateBlock MYQUESTE_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.copy(Blocks.SPRUCE_PRESSURE_PLATE));

    public static final Identifier MYQUESTE_SIGN_TEXTURE = new Identifier(MOD_ID, "entity/sign/myqueste");
    public static final TerraformSignBlock MYQUESTE_SIGN = new TerraformSignBlock(MYQUESTE_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.SPRUCE_SIGN));
    public static final Block MYQUESTE_WALL_SIGN = new TerraformWallSignBlock(MYQUESTE_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.SPRUCE_WALL_SIGN));
    public static final Item MYQUESTE_SIGN_ITEM = new SignItem(new Item.Settings().maxCount(16).group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS), MYQUESTE_SIGN, MYQUESTE_WALL_SIGN);

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rosemary"), ROSEMARY);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rosemary"), new BlockItem(ROSEMARY, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "thyme"), THYME);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "thyme"), new BlockItem(THYME, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tarragon"), TARRAGON);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tarragon"), new BlockItem(TARRAGON, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chamomile"), CHAMOMILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chamomile"), new BlockItem(CHAMOMILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chives"), CHIVES);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chives"), new BlockItem(CHIVES, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "verbena"), VERBENA);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "verbena"), new BlockItem(VERBENA, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "sorrel"), SORREL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sorrel"), new BlockItem(SORREL, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "marjoram"), MARJORAM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "marjoram"), new BlockItem(MARJORAM, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chervil"), CHERVIL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chervil"), new BlockItem(CHERVIL, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "fennsel"), FENNSEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fennsel"), new BlockItem(FENNSEL, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ceillis"), CEILLIS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ceillis"), new BlockItem(CEILLIS, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "punuel"), PUNUEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "punuel"), new BlockItem(PUNUEL, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "essitte"), ESSITTE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "essitte"), new BlockItem(ESSITTE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "thyocielle"), THYOCIELLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "thyocielle"), new BlockItem(THYOCIELLE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "fennkystral"), FENNKYSTRAL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fennkystral"), new BlockItem(FENNKYSTRAL, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "calendula"), CALENDULA);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "calendula"), new BlockItem(CALENDULA, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_rosemary"), POTTED_ROSEMARY);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_thyme"), POTTED_THYME);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_tarragon"), POTTED_TARRAGON);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_chamomile"), POTTED_CHAMOMILE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_chives"), POTTED_CHIVES);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_verbena"), POTTED_VERBENA);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_sorrel"), POTTED_SORREL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_marjoram"), POTTED_MARJORAM);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_chervil"), POTTED_CHERVIL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_fennsel"), POTTED_FENNSEL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_ceillis"), POTTED_CEILLIS);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_punuel"), POTTED_PUNUEL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_essitte"), POTTED_ESSITTE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_thyocielle"), POTTED_THYOCIELLE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_fennkystral"), POTTED_FENNKYSTRAL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_calendula"), POTTED_CALENDULA);

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "potted_myqueste_sapling"), POTTED_MYQUESTE_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_sapling"), MYQUESTE_SAPLING);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_sapling"), new BlockItem(MYQUESTE_SAPLING, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_log"), MYQUESTE_LOG);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_log"), new BlockItem(MYQUESTE_LOG, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_leaves"), MYQUESTE_LEAVES);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_leaves"), new BlockItem(MYQUESTE_LEAVES, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_myqueste_log"), STRIPPED_MYQUESTE_LOG);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_myqueste_log"), new BlockItem(STRIPPED_MYQUESTE_LOG, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_wood"), MYQUESTE_WOOD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_wood"), new BlockItem(MYQUESTE_WOOD, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_myqueste_wood"), STRIPPED_MYQUESTE_WOOD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_myqueste_wood"), new BlockItem(STRIPPED_MYQUESTE_WOOD, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_planks"), MYQUESTE_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_planks"), new BlockItem(MYQUESTE_PLANKS, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_stairs"), MYQUESTE_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_stairs"), new BlockItem(MYQUESTE_STAIRS, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_slab"), MYQUESTE_SLAB);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_slab"), new BlockItem(MYQUESTE_SLAB, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_door"), MYQUESTE_DOOR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_door"), new BlockItem(MYQUESTE_DOOR, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_trapdoor"), MYQUESTE_TRAPDOOR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_trapdoor"), new BlockItem(MYQUESTE_TRAPDOOR, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_fence"), MYQUESTE_FENCE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_fence"), new BlockItem(MYQUESTE_FENCE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_fence_gate"), MYQUESTE_FENCE_GATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_fence_gate"), new BlockItem(MYQUESTE_FENCE_GATE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_button"), MYQUESTE_BUTTON);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_button"), new BlockItem(MYQUESTE_BUTTON, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_pressure_plate"), MYQUESTE_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_pressure_plate"), new BlockItem(MYQUESTE_PRESSURE_PLATE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_sign"), MYQUESTE_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_wall_sign"), MYQUESTE_WALL_SIGN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_sign"), MYQUESTE_SIGN_ITEM);

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "myqueste_leaf_pile"), MYQUESTE_LEAF_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "myqueste_leaf_pile"), new BlockItem(MYQUESTE_LEAF_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rosemary_herb_pile"), ROSEMARY_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rosemary_herb_pile"), new BlockItem(ROSEMARY_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "thyme_herb_pile"), THYME_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "thyme_herb_pile"), new BlockItem(THYME_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "tarragon_herb_pile"), TARRAGON_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "tarragon_herb_pile"), new BlockItem(TARRAGON_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chamomile_herb_pile"), CHAMOMILE_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chamomile_herb_pile"), new BlockItem(CHAMOMILE_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chives_herb_pile"), CHIVES_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chives_herb_pile"), new BlockItem(CHIVES_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "verbena_herb_pile"), VERBENA_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "verbena_herb_pile"), new BlockItem(VERBENA_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "sorrel_herb_pile"), SORREL_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sorrel_herb_pile"), new BlockItem(SORREL_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "marjoram_herb_pile"), MARJORAM_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "marjoram_herb_pile"), new BlockItem(MARJORAM_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chervil_herb_pile"), CHERVIL_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chervil_herb_pile"), new BlockItem(CHERVIL_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "fennsel_herb_pile"), FENNSEL_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fennsel_herb_pile"), new BlockItem(FENNSEL_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ceillis_herb_pile"), CEILLIS_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ceillis_herb_pile"), new BlockItem(CEILLIS_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "punuel_herb_pile"), PUNUEL_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "punuel_herb_pile"), new BlockItem(PUNUEL_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "essitte_herb_pile"), ESSITTE_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "essitte_herb_pile"), new BlockItem(ESSITTE_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "thyocielle_herb_pile"), THYOCIELLE_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "thyocielle_herb_pile"), new BlockItem(THYOCIELLE_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "fennkystral_herb_pile"), FENNKYSTRAL_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fennkystral_herb_pile"), new BlockItem(FENNKYSTRAL_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "calendula_herb_pile"), CALENDULA_HERB_PILE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "calendula_herb_pile"), new BlockItem(CALENDULA_HERB_PILE, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "calendula_lantern"), CALENDULA_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "calendula_lantern"), new BlockItem(CALENDULA_LANTERN, new FabricItemSettings().group(HibernalHerbsMod.groupManager.HIBERNAL_HERBS)));
    }

}
