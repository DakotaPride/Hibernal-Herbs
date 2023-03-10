package net.dakotapride.hibernalHerbs.common.registry;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.block.FlammableRotatedPillarBlock;
import net.dakotapride.hibernalHerbs.common.gen.grower.MyquesteTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class blockRegistry {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

    public static final RegistryObject<Block> ROSEMARY = registerBlock("rosemary",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> THYME = registerBlock("thyme",
            () -> new FlowerBlock(MobEffects.POISON, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> TARRAGON = registerBlock("tarragon",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> CHAMOMILE = registerBlock("chamomile",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> CHIVES = registerBlock("chives",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> VERBENA = registerBlock("verbena",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> SORREL = registerBlock("sorrel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> MARJORAM = registerBlock("marjoram",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> CHERVIL = registerBlock("chervil",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> FENNSEL = registerBlock("fennsel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> CEILLIS = registerBlock("ceillis",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> PUNUEL = registerBlock("punuel",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> ESSITTE = registerBlock("essitte",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);

    // Resource Dependant Herbs (Forge)

    public static final RegistryObject<Block> THYOCIELLE = registerBlock("thyocielle",
            () -> new FlowerBlock(MobEffects.REGENERATION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);
    public static final RegistryObject<Block> FENNKYSTRAL = registerBlock("fennkystral",
            () -> new FlowerBlock(MobEffects.REGENERATION, 240,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);

    // Spring Herbs (Forge)

    public static final RegistryObject<Block> CALENDULA = registerBlock("calendula",
            () -> new FlowerBlock(MobEffects.GLOWING, 240,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);

    public static final RegistryObject<Block> CALENDULA_LANTERN = registerBlock("calendula_lantern",
        () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)), HibernalHerbsForge.HIBERNAL_HERBS);

    // Compat Herbs (Forge)
    public static final RegistryObject<Block> BLOFORIA = registerBlock("bloforia",
            () -> new FlowerBlock(MobEffects.NIGHT_VISION, 180,
                    BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)), HibernalHerbsForge.HERBS);

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

    public static final RegistryObject<Block> MYQUESTE_LOG = registerBlock("myqueste_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_WOOD = registerBlock("myqueste_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_LOG = registerBlock("stripped_myqueste_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> STRIPPED_MYQUESTE_WOOD = registerBlock("stripped_myqueste_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)), HibernalHerbsForge.HIBERNAL_HERBS);

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
            }, HibernalHerbsForge.HIBERNAL_HERBS);

    public static final RegistryObject<Block> MYQUESTE_SLAB = registerBlock("myqueste_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_STAIRS = registerBlock("myqueste_stairs",
            () -> new StairBlock(MYQUESTE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_DOOR = registerBlock("myqueste_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_TRAPDOOR = registerBlock("myqueste_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_FENCE = registerBlock("myqueste_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)), HibernalHerbsForge.HIBERNAL_HERBS);
    public static final RegistryObject<Block> MYQUESTE_FENCE_GATE = registerBlock("myqueste_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE)), HibernalHerbsForge.HIBERNAL_HERBS);

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
            }, HibernalHerbsForge.HIBERNAL_HERBS);

    public static final RegistryObject<Block> MYQUESTE_SAPLING = registerBlock("myqueste_sapling",
            () -> new SaplingBlock(new MyquesteTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)), HibernalHerbsForge.HIBERNAL_HERBS);

    public static final RegistryObject<Block> POTTED_MYQUESTE_SAPLING = BLOCKS.register("potted_myqueste_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), blockRegistry.MYQUESTE_SAPLING,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_SPRUCE_SAPLING)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return itemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
