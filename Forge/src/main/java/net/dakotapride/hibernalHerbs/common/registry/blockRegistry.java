package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.block.*;
import net.dakotapride.hibernalHerbs.common.block.leaf.LeafPileBlock;
import net.dakotapride.hibernalHerbs.common.block.leaf.hibernal.HibernalLeafPileBlock;
import net.dakotapride.hibernalHerbs.common.gen.grower.MyquesteTreeGrower;
import net.dakotapride.hibernalHerbs.common.registry.wood.MyquesteType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class blockRegistry {

    public static final BlockSetType MYQUESTE_SET = BlockSetType.register(new BlockSetType("myqueste"));
    public static final WoodType MYQUESTE_TYPE = WoodType.register(new WoodType("myqueste", MYQUESTE_SET));

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

    public static RegistryObject<Block> CONJURATION_ALTAR = registerBlock("conjuration_altar",
            () -> new ConjurationAltarBlock(BlockBehaviour.Properties.copy(Blocks.LECTERN).noOcclusion()));

    // TODO: v0.9 Herbs For Princes Of Sin (Required in Bound Padlock Recipes + Additional Uses)
    public static RegistryObject<Block> PRIDE_HERB = registerBlock("pride_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> ENVY_HERB = registerBlock("envy_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> WRATH_HERB = registerBlock("wrath_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> GLUTTONY_HERB = registerBlock("gluttony_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> GREED_HERB = registerBlock("greed_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> LUST_HERB = registerBlock("lust_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));
    public static RegistryObject<Block> SLOTH_HERB = registerBlock("sloth_herb",
            () -> new SinHerbBlock(200, BlockBehaviour.Properties.copy(Blocks.WITHER_ROSE)));

    // "Leaf" (Herb) Piles
    public static RegistryObject<Block> MYQUESTE_LEAF_PILE = registerBlock("myqueste_leaf_pile",
            () -> new LeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));

    public static final RegistryObject<Block> ROSEMARY_HERB_PILE = registerBlock("rosemary_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> THYME_HERB_PILE = registerBlock("thyme_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> TARRAGON_HERB_PILE = registerBlock("tarragon_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> CHAMOMILE_HERB_PILE = registerBlock("chamomile_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> CHIVES_HERB_PILE = registerBlock("chives_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> VERBENA_HERB_PILE = registerBlock("verbena_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> SORREL_HERB_PILE = registerBlock("sorrel_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> MARJORAM_HERB_PILE = registerBlock("marjoram_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> CHERVIL_HERB_PILE = registerBlock("chervil_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> FENNSEL_HERB_PILE = registerBlock("fennsel_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> CEILLIS_HERB_PILE = registerBlock("ceillis_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> PUNUEL_HERB_PILE = registerBlock("punuel_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> ESSITTE_HERB_PILE = registerBlock("essitte_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));

    public static RegistryObject<Block> THYOCIELLE_HERB_PILE = registerBlock("thyocielle_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));
    public static RegistryObject<Block> FENNKYSTRAL_HERB_PILE = registerBlock("fennkystral_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));

    public static RegistryObject<Block> CALENDULA_HERB_PILE = registerBlock("calendula_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));

    public static RegistryObject<Block> SAGE_HERB_PILE = registerBlock("sage_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));

    public static RegistryObject<Block> BLOFORIA_HERB_PILE = registerBlock("bloforia_herb_pile",
            () -> new HibernalLeafPileBlock(BlockBehaviour.Properties.of().sound(SoundType.GRASS).noOcclusion()));


    public static final RegistryObject<Block> ROSEMARY = registerBlock("rosemary",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> THYME = registerBlock("thyme",
            () -> new FlowerBlock(MobEffects.POISON, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> TARRAGON = registerBlock("tarragon",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHAMOMILE = registerBlock("chamomile",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHIVES = registerBlock("chives",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> VERBENA = registerBlock("verbena",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> SORREL = registerBlock("sorrel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> MARJORAM = registerBlock("marjoram",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CHERVIL = registerBlock("chervil",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> FENNSEL = registerBlock("fennsel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> CEILLIS = registerBlock("ceillis",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> PUNUEL = registerBlock("punuel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> ESSITTE = registerBlock("essitte",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));

    // Resource Dependant Herbs (Forge)

    public static final RegistryObject<Block> THYOCIELLE = registerBlock("thyocielle",
            () -> new FlowerBlock(MobEffects.REGENERATION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> FENNKYSTRAL = registerBlock("fennkystral",
            () -> new FlowerBlock(MobEffects.REGENERATION, 240,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));

    // Spring Herbs (Forge)

    public static final RegistryObject<Block> CALENDULA = registerBlock("calendula",
            () -> new FlowerBlock(MobEffects.GLOWING, 200,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> SAGE = registerBlock("sage",
            () -> new SageHerbBlock(180, BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> CALENDULA_LANTERN = registerBlock("calendula_lantern",
        () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> ROSEMARY_LANTERN = registerBlock("rosemary_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> THYME_LANTERN = registerBlock("thyme_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> TARRAGON_LANTERN = registerBlock("tarragon_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHAMOMILE_LANTERN = registerBlock("chamomile_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHIVES_LANTERN = registerBlock("chives_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> VERBENA_LANTERN = registerBlock("verbena_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> SORREL_LANTERN = registerBlock("sorrel_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> MARJORAM_LANTERN = registerBlock("marjoram_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CHERVIL_LANTERN = registerBlock("chervil_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> FENNSEL_LANTERN = registerBlock("fennsel_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> CEILLIS_LANTERN = registerBlock("ceillis_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> PUNUEL_LANTERN = registerBlock("punuel_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> ESSITTE_LANTERN = registerBlock("essitte_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> THYOCIELLE_LANTERN = registerBlock("thyocielle_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> FENNKYSTRAL_LANTERN = registerBlock("fennkystral_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));
    public static final RegistryObject<Block> SAGE_LANTERN = registerBlock("sage_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));

    public static final RegistryObject<Block> BLOFORIA_LANTERN = registerBlock("bloforia_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));


    public static final RegistryObject<Block> CALENDULA_BARREL = registerBlock("calendula_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> ROSEMARY_BARREL = registerBlock("rosemary_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> THYME_BARREL = registerBlock("thyme_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> TARRAGON_BARREL = registerBlock("tarragon_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHAMOMILE_BARREL = registerBlock("chamomile_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHIVES_BARREL = registerBlock("chives_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> VERBENA_BARREL = registerBlock("verbena_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> SORREL_BARREL = registerBlock("sorrel_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> MARJORAM_BARREL = registerBlock("marjoram_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CHERVIL_BARREL = registerBlock("chervil_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> FENNSEL_BARREL = registerBlock("fennsel_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> CEILLIS_BARREL = registerBlock("ceillis_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> PUNUEL_BARREL = registerBlock("punuel_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> ESSITTE_BARREL = registerBlock("essitte_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> THYOCIELLE_BARREL = registerBlock("thyocielle_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> FENNKYSTRAL_BARREL = registerBlock("fennkystral_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> BLOFORIA_BARREL = registerBlock("bloforia_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> SAGE_BARREL = registerBlock("sage_herb_barrel",
            () -> new HerbBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BARREL)));


    // Compat Herbs (Forge)
    public static final RegistryObject<Block> BLOFORIA = registerBlock("bloforia",
            () -> new FlowerBlock(MobEffects.NIGHT_VISION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> POTTED_ROSEMARY = BLOCKS.register("potted_rosemary",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.ROSEMARY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_THYME = BLOCKS.register("potted_thyme",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.THYME,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_TARRAGON = BLOCKS.register("potted_tarragon",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.TARRAGON,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHAMOMILE = BLOCKS.register("potted_chamomile",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.CHAMOMILE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHIVES = BLOCKS.register("potted_chives",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.CHIVES,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_VERBENA = BLOCKS.register("potted_verbena",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.VERBENA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_SORREL = BLOCKS.register("potted_sorrel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.SORREL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_MARJORAM = BLOCKS.register("potted_marjoram",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.MARJORAM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CHERVIL = BLOCKS.register("potted_chervil",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.CHERVIL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_FENNSEL = BLOCKS.register("potted_fennsel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.FENNSEL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_CEILLIS = BLOCKS.register("potted_ceillis",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.CEILLIS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_PUNUEL = BLOCKS.register("potted_punuel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.PUNUEL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_ESSITTE = BLOCKS.register("potted_essitte",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.ESSITTE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    // Resource Dependant (Potted) Herbs (Forge)

    public static final RegistryObject<Block> POTTED_THYOCIELLE = BLOCKS.register("potted_thyocielle",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.THYOCIELLE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));
    public static final RegistryObject<Block> POTTED_FENNKYSTRAL = BLOCKS.register("potted_fennkystral",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.FENNKYSTRAL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    // Compat (Potted) Herbs (Forge)
    public static final RegistryObject<Block> POTTED_BLOFORIA = BLOCKS.register("potted_bloforia",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.BLOFORIA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    // Spring (Potted) Herbs (Forge)

    public static final RegistryObject<Block> POTTED_CALENDULA = BLOCKS.register("potted_calendula",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.CALENDULA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> POTTED_SAGE = BLOCKS.register("potted_sage",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.SAGE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)));

    public static final RegistryObject<Block> MYQUESTE_LOG = registerBlock("myqueste_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> MYQUESTE_WOOD = registerBlock("myqueste_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_LOG = registerBlock("stripped_myqueste_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_WOOD = registerBlock("stripped_myqueste_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final RegistryObject<Block> MYQUESTE_PLANKS = registerBlock("myqueste_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    public static final RegistryObject<Block> MYQUESTE_SLAB = registerBlock("myqueste_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<Block> MYQUESTE_STAIRS = registerBlock("myqueste_stairs",
            () -> new StairBlock(MYQUESTE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> MYQUESTE_DOOR = registerBlock("myqueste_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR), MYQUESTE_SET));
    public static final RegistryObject<Block> MYQUESTE_TRAPDOOR = registerBlock("myqueste_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR), MYQUESTE_SET));
    public static final RegistryObject<Block> MYQUESTE_FENCE = registerBlock("myqueste_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> MYQUESTE_FENCE_GATE = registerBlock("myqueste_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE), MYQUESTE_TYPE));

    public static final RegistryObject<Block> MYQUESTE_PRESSURE_PLATE = registerBlock("myqueste_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.SPRUCE_PRESSURE_PLATE), MYQUESTE_SET));
    public static final RegistryObject<Block> MYQUESTE_BUTTON = registerBlock("myqueste_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_BUTTON), MYQUESTE_SET, 30, true));

    public static final RegistryObject<Block> MYQUESTE_SIGN = registerBlockWithoutTab("myqueste_sign", () ->
            new MyquesteSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SIGN), MyquesteType.MYQUESTE));
    public static final RegistryObject<Block> MYQUESTE_WALL_SIGN = registerBlockWithoutTab("myqueste_wall_sign", () ->
            new MyquesteWallSignBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WALL_SIGN).lootFrom(MYQUESTE_SIGN),
                    MyquesteType.MYQUESTE));

    public static final RegistryObject<Block> MYQUESTE_LEAVES = registerBlock("myqueste_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> MYQUESTE_SAPLING = registerBlock("myqueste_sapling",
            () -> new SaplingBlock(new MyquesteTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));

    public static final RegistryObject<Block> POTTED_MYQUESTE_SAPLING = BLOCKS.register("potted_myqueste_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.MYQUESTE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_SPRUCE_SAPLING)));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutTab(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return itemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
