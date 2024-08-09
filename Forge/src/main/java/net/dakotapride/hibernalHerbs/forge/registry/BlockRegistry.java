package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.block.SageHerbBlock;
import net.dakotapride.hibernalherbs.block.SinHerbBlock;
import net.dakotapride.hibernalherbs.forge.block.*;
import net.dakotapride.hibernalherbs.forge.block.grower.MyquesteTreeGrower;
import net.dakotapride.hibernalherbs.registry.TypeRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HibernalHerbsCommon.MOD_ID);

    public static RegistryObject<Block> CONJURATION_ALTAR = registerBlock("conjuration_altar",
            () -> new HerbConjurationAltarBlock(AbstractBlock.Settings.copy(Blocks.LECTERN).nonOpaque()));

    public static RegistryObject<Block> PRIDE_HERB = registerBlock("pride_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> ENVY_HERB = registerBlock("envy_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> WRATH_HERB = registerBlock("wrath_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> GLUTTONY_HERB = registerBlock("gluttony_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> GREED_HERB = registerBlock("greed_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> LUST_HERB = registerBlock("lust_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> SLOTH_HERB = registerBlock("sloth_herb",
            () -> new SinHerbBlock(200, AbstractBlock.Settings.copy(Blocks.WITHER_ROSE)));

    // "Leaf" (Herb) Piles
    public static RegistryObject<Block> MYQUESTE_LEAF_PILE = registerBlock("myqueste_leaf_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));

    public static final RegistryObject<Block> ROSEMARY_HERB_PILE = registerBlock("rosemary_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> THYME_HERB_PILE = registerBlock("thyme_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> TARRAGON_HERB_PILE = registerBlock("tarragon_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> CHAMOMILE_HERB_PILE = registerBlock("chamomile_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> CHIVES_HERB_PILE = registerBlock("chives_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> VERBENA_HERB_PILE = registerBlock("verbena_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> SORREL_HERB_PILE = registerBlock("sorrel_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> MARJORAM_HERB_PILE = registerBlock("marjoram_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> CHERVIL_HERB_PILE = registerBlock("chervil_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> FENNSEL_HERB_PILE = registerBlock("fennsel_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> CEILLIS_HERB_PILE = registerBlock("ceillis_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> PUNUEL_HERB_PILE = registerBlock("punuel_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> ESSITTE_HERB_PILE = registerBlock("essitte_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));

    public static RegistryObject<Block> THYOCIELLE_HERB_PILE = registerBlock("thyocielle_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));
    public static RegistryObject<Block> FENNKYSTRAL_HERB_PILE = registerBlock("fennkystral_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));

    public static RegistryObject<Block> CALENDULA_HERB_PILE = registerBlock("calendula_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));

    public static RegistryObject<Block> SAGE_HERB_PILE = registerBlock("sage_herb_pile",
            () -> new HibernalLeafPileBlock(AbstractBlock.Settings.create()));


    public static final RegistryObject<Block> ROSEMARY = registerBlock("rosemary",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> THYME = registerBlock("thyme",
            () -> new FlowerBlock(StatusEffects.POISON, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> TARRAGON = registerBlock("tarragon",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHAMOMILE = registerBlock("chamomile",
            () -> new FlowerBlock(StatusEffects.ABSORPTION, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHIVES = registerBlock("chives",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> VERBENA = registerBlock("verbena",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> SORREL = registerBlock("sorrel",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> MARJORAM = registerBlock("marjoram",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHERVIL = registerBlock("chervil",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> FENNSEL = registerBlock("fennsel",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CEILLIS = registerBlock("ceillis",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> PUNUEL = registerBlock("punuel",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> ESSITTE = registerBlock("essitte",
            () -> new FlowerBlock(StatusEffects.SLOWNESS, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));

    // Resource Dependant Herbs (Forge)

    public static final RegistryObject<Block> THYOCIELLE = registerBlock("thyocielle",
            () -> new FlowerBlock(StatusEffects.REGENERATION, 180,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> FENNKYSTRAL = registerBlock("fennkystral",
            () -> new FlowerBlock(StatusEffects.REGENERATION, 240,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));

    // Spring Herbs (Forge)

    public static final RegistryObject<Block> CALENDULA = registerBlock("calendula",
            () -> new FlowerBlock(StatusEffects.GLOWING, 200,
                    AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> SAGE = registerBlock("sage",
            () -> new SageHerbBlock(StatusEffects.LEVITATION, 180, AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> CALENDULA_LANTERN = registerBlock("calendula_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> ROSEMARY_LANTERN = registerBlock("rosemary_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> THYME_LANTERN = registerBlock("thyme_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> TARRAGON_LANTERN = registerBlock("tarragon_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHAMOMILE_LANTERN = registerBlock("chamomile_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHIVES_LANTERN = registerBlock("chives_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> VERBENA_LANTERN = registerBlock("verbena_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> SORREL_LANTERN = registerBlock("sorrel_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> MARJORAM_LANTERN = registerBlock("marjoram_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHERVIL_LANTERN = registerBlock("chervil_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> FENNSEL_LANTERN = registerBlock("fennsel_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CEILLIS_LANTERN = registerBlock("ceillis_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> PUNUEL_LANTERN = registerBlock("punuel_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> ESSITTE_LANTERN = registerBlock("essitte_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> THYOCIELLE_LANTERN = registerBlock("thyocielle_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> FENNKYSTRAL_LANTERN = registerBlock("fennkystral_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> SAGE_LANTERN = registerBlock("sage_lantern",
            () -> new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)));


    public static final RegistryObject<Block> CALENDULA_HERB_BARREL = registerBlock("calendula_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> ROSEMARY_HERB_BARREL = registerBlock("rosemary_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> THYME_HERB_BARREL = registerBlock("thyme_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> TARRAGON_HERB_BARREL = registerBlock("tarragon_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHAMOMILE_HERB_BARREL = registerBlock("chamomile_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHIVES_HERB_BARREL = registerBlock("chives_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> VERBENA_HERB_BARREL = registerBlock("verbena_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> SORREL_HERB_BARREL = registerBlock("sorrel_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> MARJORAM_HERB_BARREL = registerBlock("marjoram_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHERVIL_HERB_BARREL = registerBlock("chervil_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> FENNSEL_HERB_BARREL = registerBlock("fennsel_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CEILLIS_HERB_BARREL = registerBlock("ceillis_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> PUNUEL_HERB_BARREL = registerBlock("punuel_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> ESSITTE_HERB_BARREL = registerBlock("essitte_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> THYOCIELLE_HERB_BARREL = registerBlock("thyocielle_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> FENNKYSTRAL_HERB_BARREL = registerBlock("fennkystral_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> SAGE_HERB_BARREL = registerBlock("sage_herb_barrel",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.BARREL)));

    public static final RegistryObject<Block> POTTED_ROSEMARY = BLOCKS.register("potted_rosemary",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.ROSEMARY,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_THYME = BLOCKS.register("potted_thyme",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.THYME,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_TARRAGON = BLOCKS.register("potted_tarragon",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.TARRAGON,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHAMOMILE = BLOCKS.register("potted_chamomile",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.CHAMOMILE,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHIVES = BLOCKS.register("potted_chives",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.CHIVES,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_VERBENA = BLOCKS.register("potted_verbena",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.VERBENA,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_SORREL = BLOCKS.register("potted_sorrel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.SORREL,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_MARJORAM = BLOCKS.register("potted_marjoram",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.MARJORAM,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHERVIL = BLOCKS.register("potted_chervil",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.CHERVIL,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_FENNSEL = BLOCKS.register("potted_fennsel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.FENNSEL,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CEILLIS = BLOCKS.register("potted_ceillis",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.CEILLIS,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_PUNUEL = BLOCKS.register("potted_punuel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.PUNUEL,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_ESSITTE = BLOCKS.register("potted_essitte",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.ESSITTE,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    // Resource Dependant (Potted) Herbs (Forge)

    public static final RegistryObject<Block> POTTED_THYOCIELLE = BLOCKS.register("potted_thyocielle",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.THYOCIELLE,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_FENNKYSTRAL = BLOCKS.register("potted_fennkystral",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.FENNKYSTRAL,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    // Spring (Potted) Herbs (Forge)

    public static final RegistryObject<Block> POTTED_CALENDULA = BLOCKS.register("potted_calendula",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.CALENDULA,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> POTTED_SAGE = BLOCKS.register("potted_sage",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.SAGE,
                    AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> MYQUESTE_LOG = registerBlock("myqueste_log",
            () -> new FlammableRotatedPillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> MYQUESTE_WOOD = registerBlock("myqueste_wood",
            () -> new FlammableRotatedPillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_LOG = registerBlock("stripped_myqueste_log",
            () -> new FlammableRotatedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_WOOD = registerBlock("stripped_myqueste_wood",
            () -> new FlammableRotatedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final RegistryObject<Block> MYQUESTE_PLANKS = registerBlock("myqueste_planks",
            () -> new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> MYQUESTE_SLAB = registerBlock("myqueste_slab",
            () -> new SlabBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<Block> MYQUESTE_STAIRS = registerBlock("myqueste_stairs",
            () -> new StairsBlock(MYQUESTE_PLANKS.get().getDefaultState(), AbstractBlock.Settings.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> MYQUESTE_DOOR = registerBlock("myqueste_door",
            () -> new DoorBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_DOOR), TypeRegistry.SetType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_TRAPDOOR = registerBlock("myqueste_trapdoor",
            () -> new TrapdoorBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_TRAPDOOR), TypeRegistry.SetType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_FENCE = registerBlock("myqueste_fence",
            () -> new FenceBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> MYQUESTE_FENCE_GATE = registerBlock("myqueste_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE_GATE), TypeRegistry.WoodType.MYQUESTE));

    public static final RegistryObject<Block> MYQUESTE_PRESSURE_PLATE = registerBlock("myqueste_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    AbstractBlock.Settings.copy(Blocks.SPRUCE_PRESSURE_PLATE), TypeRegistry.SetType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_BUTTON = registerBlock("myqueste_button",
            () -> new ButtonBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_BUTTON), TypeRegistry.SetType.MYQUESTE, 30, true));

    public static final RegistryObject<Block> MYQUESTE_SIGN = registerBlockWithoutItem("myqueste_sign", () ->
            new MyquesteSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_SIGN), TypeRegistry.WoodType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_WALL_SIGN = registerBlockWithoutItem("myqueste_wall_sign", () ->
            new MyquesteWallSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WALL_SIGN).lootFrom(MYQUESTE_SIGN), TypeRegistry.WoodType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_HANGING_SIGN = registerBlockWithoutItem("myqueste_hanging_sign", () ->
            new MyquesteHangingSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_HANGING_SIGN), TypeRegistry.WoodType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_WALL_HANGING_SIGN = registerBlockWithoutItem("myqueste_wall_hanging_sign", () ->
            new MyquesteHangingSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WALL_HANGING_SIGN).lootFrom(MYQUESTE_HANGING_SIGN), TypeRegistry.WoodType.MYQUESTE));

    public static final RegistryObject<Block> MYQUESTE_LEAVES = registerBlock("myqueste_leaves",
            () -> new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockView level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> MYQUESTE_SAPLING = registerBlock("myqueste_sapling",
            () -> new SaplingBlock(new MyquesteTreeGrower(),
                    AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING)));

    public static final RegistryObject<Block> POTTED_MYQUESTE_SAPLING = BLOCKS.register("potted_myqueste_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockRegistry.MYQUESTE_SAPLING,
                    AbstractBlock.Settings.copy(Blocks.POTTED_SPRUCE_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Settings()));
    }
    
    
    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
