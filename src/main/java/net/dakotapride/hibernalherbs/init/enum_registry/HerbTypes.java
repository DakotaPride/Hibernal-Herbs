package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.block.LeafPileBlock;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Locale;

@SuppressWarnings({"unused"})
public enum HerbTypes {
    ROSEMARY(),
    THYME(MobEffects.DAMAGE_RESISTANCE),
    TARRAGON(MobEffects.HEALTH_BOOST),
    CHAMOMILE(MobEffects.REGENERATION),
    CHIVES(MobEffects.DAMAGE_RESISTANCE),
    VERBENA(MobEffects.MOVEMENT_SPEED),
    SORREL(MobEffects.LUCK),
    MARJORAM(MobEffects.DAMAGE_RESISTANCE),
    CHERVIL(MobEffects.LUCK),
    FENNEL(MobEffects.DAMAGE_BOOST),
    CEILLIS(MobEffects.NIGHT_VISION),
    PUNUEL(MobEffects.DIG_SPEED),
    ESSITTE(MobEffects.MOVEMENT_SPEED),
    THYOCIELLE(MobEffects.FIRE_RESISTANCE),
    FENNKYSTRAL(StatusEffectInit.FROST_RESISTANCE),
    CALENDULA(),
    SAGE(MobEffects.LEVITATION);

    public final String herb_id;


    public final Block base_block;
    public final Block potted_block;

    public final Item pounded_herb;
    public final Block pounded_herb_block;
    public final Item dried_herb;
    public final Block dried_herb_block;

    public final Block lantern_block;

    public final Block herb_pile_block;
    public final Block herb_barrel_block;

    public Holder<MobEffect> incense_effect;

    HerbTypes(Holder<MobEffect> incense_effect) {
        this.herb_id = name().toLowerCase(Locale.ROOT);

        this.incense_effect = incense_effect;

        this.base_block = BlockInit.register(herb_id, new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
        this.pounded_herb_block = BlockInit.register("pounded_" + herb_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
        this.dried_herb_block = BlockInit.register("dried_" + herb_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

        this.potted_block = BlockInit.registerWithoutBlockItem("potted_" + herb_id, new FlowerPotBlock(base_block, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));

        this.pounded_herb = ItemInit.register("pounded_" + herb_id, new Item(new Item.Properties()));
        this.dried_herb = ItemInit.register("dried_" + herb_id, new Item(new Item.Properties()));

        this.lantern_block = BlockInit.register(herb_id + "_lantern", new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));
        this.herb_pile_block = BlockInit.register(herb_id + "_herb_pile", new LeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).noOcclusion().sound(SoundType.GRASS)));
        this.herb_barrel_block = BlockInit.register(herb_id + "_herb_barrel", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));

    }

    HerbTypes() {
        this.herb_id = name().toLowerCase(Locale.ROOT);

        //this.incense_effect = incense_effect;

        this.base_block = BlockInit.register(herb_id, new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
        this.pounded_herb_block = BlockInit.register("pounded_" + herb_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
        this.dried_herb_block = BlockInit.register("dried_" + herb_id + "_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

        this.potted_block = BlockInit.registerWithoutBlockItem("potted_" + herb_id, new FlowerPotBlock(base_block, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));

        this.pounded_herb = ItemInit.register("pounded_" + herb_id, new Item(new Item.Properties()));
        this.dried_herb = ItemInit.register("dried_" + herb_id, new Item(new Item.Properties()));

        this.lantern_block = BlockInit.register(herb_id + "_lantern", new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));
        this.herb_pile_block = BlockInit.register(herb_id + "_herb_pile", new LeafPileBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).noOcclusion().sound(SoundType.GRASS)));
        this.herb_barrel_block = BlockInit.register(herb_id + "_herb_barrel", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL)));

    }

    public String getHerbId() {
        return herb_id;
    }

    public Holder<MobEffect> getIncenseEffect() {
        return incense_effect;
    }

    public Block getBaseBlock() {
        return base_block;
    }

    public Block getPottedPlantBlock() {
        return potted_block;
    }

    public Item getPoundedHerb() {
        return pounded_herb;
    }

    public Item getDriedHerb() {
        return dried_herb;
    }

    public Block getLanternBlock() {
        return lantern_block;
    }

    public Block getHerbPileBlock() {
        return herb_pile_block;
    }

    public Block getHerbBarrelBlock() {
        return herb_barrel_block;
    }

    public Block getPoundedHerbBlock() {
        return pounded_herb_block;
    }

    public Block getDriedHerbBlock() {
        return dried_herb_block;
    }

    public static void register() {}
}
