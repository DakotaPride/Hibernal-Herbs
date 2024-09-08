package net.dakotapride.hibernalHerbs.common.init.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.block.LeafPileBlock;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Locale;

@SuppressWarnings({"unused"})
public enum HerbTypes {
    ROSEMARY(),
    THYME(),
    TARRAGON(),
    CHAMOMILE(),
    CHIVES(),
    VERBENA(),
    SORREL(),
    MARJORAM(),
    CHERVIL(),
    FENNSEL(),
    CEILLIS(),
    PUNUEL(),
    ESSITTE(),
    THYOCIELLE(),
    FENNKYSTRAL(),
    CALENDULA(),
    SAGE();

    public final String herb_id;


    public final RegistrySupplier<Block> base_block;

    public final RegistrySupplier<Item> pounded_herb;
    public final RegistrySupplier<Item> dried_herb;

    public final RegistrySupplier<Block> lantern_block;

    public final RegistrySupplier<Block> herb_pile_block;
    public final RegistrySupplier<Block> herb_barrel_block;

    HerbTypes() {
        this.herb_id = name().toLowerCase(Locale.ROOT);
        this.base_block = BlockInit.register(herb_id, new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));

        this.pounded_herb = ItemInit.register("pounded_" + herb_id, new Item(new Item.Properties()));
        this.dried_herb = ItemInit.register("dried_" + herb_id, new Item(new Item.Properties()));

        this.lantern_block = BlockInit.register(herb_id + "_lantern", new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));
        this.herb_pile_block = BlockInit.register(herb_id + "_herb_pile", new LeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).sound(SoundType.GRASS)));
        this.herb_barrel_block = BlockInit.register(herb_id + "_herb_barrel", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));

    }

    public static void register() {}
}
