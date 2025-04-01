package net.dakotapride.hibernalherbs.init.enum_registry.tag;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class Tags {

    public enum Items {
        HERBS("herbs"),
        POUNDED_HERBS("pounded_herbs"),
        DRIED_HERBS("dried_herbs"),
        BLENDS("herbal_blends"),
        //SMOKED_BLENDS("smoked_herbal_blends"),
        //ARTIFICIAL_BLENDS("artificial_herbal_blends"),
        HUMUS("herbal_humus"),
        FERTILIZER("herbal_fertilizer"),
        POUCHES("pouches"),
        CANISTERS("canisters"),
        SIGILS("herbal_sigils"),
        USABLE_HERBAL_SIGILS("usable_herbal_sigils"),
        BOUND_PADLOCKS("bound_herbal_padlocks"),
        UNBOUND_PADLOCKS("unbound_herbal_padlocks"),
        GRIMOIRES("herbal_grimoires"),
        NECROMANTIC_STONE_TYPE("stone_types/necromantic_stone"),
        IDIOSYNCRATIC_STONE_TYPE("stone_types/idiosyncratic_stone"),
        //EMBLEMATIC_RELICS("relics"),
        ASHES("ashes"),
        SICKLES("c", "tools/sickles"),
        AXES_OR_SIMILAR_TAG("c", "tools/axes"),
        SHORT_AGGLOMERATION_DURATION("agglomeration_duration/short"),
        LONG_AGGLOMERATION_DURATION("agglomeration_duration/long"),
        CAN_USE_WITH_AGGLOMERATION("can_use_with_agglomeration"),
        CAN_USE_WITH_TOME("can_use_with_tome"),
        CAN_BE_CONVERTED_WITH_AGGLOMERATION("can_be_converted_with_agglomeration"),
        IS_ACCEPTABLE_IN_BREWING_STAND("c", "acceptable_potions_for_brewing");
        // Added for recipe functionality, do NOT add your own agglomeration-like items to this tag, it may cause compatibility issues
        //AGGLOMERATION("agglomerations");

        public String mod_id;
        public final String id;

        public final TagKey<Item> tag;

        Items(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.ITEM, HibernalHerbsMod.fromModId(mod_id, id));
        }

        Items(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.ITEM, HibernalHerbsMod.asResource(id));
        }

        public TagKey<Item> getTag() {
            return tag;
        }

        public static TagKey<Item> create(String id) {
            return TagKey.create(Registries.ITEM, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<Item> create(String mod_id, String id) {
            return TagKey.create(Registries.ITEM, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public enum Blocks {
        DRIED_HERB_BLOCKS("dried_herb_blocks"),
        POUNDED_HERB_BLOCKS("pounded_herb_blocks"),
        HERBS("herbs"),
        NECROMANTIC_STONE_TYPE("stone_types/necromantic_stone"),
        IDIOSYNCRATIC_STONE_TYPE("stone_types/idiosyncratic_stone"),
        MINEABLE_WITH_SICKLE("c", "mineable/sickle"),
        ACCEPTABLE_HERB_HUMUS_BLOCKS("acceptable_herb_humus_blocks"),
        REQUIRES_HIGH_TIER_BRUSH("c", "brushable/high_tier"),;

        public String mod_id;
        public final String id;

        public final TagKey<Block> tag;

        Blocks(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.BLOCK, HibernalHerbsMod.fromModId(mod_id, id));
        }

        Blocks(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.BLOCK, HibernalHerbsMod.asResource(id));
        }

        public TagKey<Block> getTag() {
            return tag;
        }

        public static TagKey<Block> create(String id) {
            return TagKey.create(Registries.BLOCK, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<Block> create(String mod_id, String id) {
            return TagKey.create(Registries.BLOCK, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public enum Enchantments {
        HARVESTS_LIFE_FORCE("harvests_life_force"),
        SIPHONS_LIVESTOCK("siphons_livestock"),;

        public String mod_id;
        public final String id;

        public final TagKey<Enchantment> tag;

        Enchantments(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.ENCHANTMENT, HibernalHerbsMod.fromModId(mod_id, id));
        }

        Enchantments(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.ENCHANTMENT, HibernalHerbsMod.asResource(id));
        }

        public TagKey<Enchantment> getTag() {
            return tag;
        }

        public static TagKey<Enchantment> create(String id) {
            return TagKey.create(Registries.ENCHANTMENT, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<Enchantment> create(String mod_id, String id) {
            return TagKey.create(Registries.ENCHANTMENT, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public enum EntityTypes {
        LIVESTOCK("livestock");

        public String mod_id;
        public final String id;

        public final TagKey<EntityType<?>> tag;

        EntityTypes(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.ENTITY_TYPE, HibernalHerbsMod.fromModId(mod_id, id));
        }

        EntityTypes(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.ENTITY_TYPE, HibernalHerbsMod.asResource(id));
        }

        public TagKey<EntityType<?>> getTag() {
            return tag;
        }

        public static TagKey<EntityType<?>> create(String id) {
            return TagKey.create(Registries.ENTITY_TYPE, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<EntityType<?>> create(String mod_id, String id) {
            return TagKey.create(Registries.ENTITY_TYPE, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public enum DamageTypes {
        //IS_FROST("is_frost");
        ;

        public String mod_id;
        public final String id;

        public final TagKey<DamageType> tag;

        DamageTypes(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.fromModId(mod_id, id));
        }

        DamageTypes(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource(id));
        }

        public TagKey<DamageType> getTag() {
            return tag;
        }

        public static TagKey<DamageType> create(String id) {
            return TagKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<DamageType> create(String mod_id, String id) {
            return TagKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public enum Biomes {
        HAS_HERBS("has_herbs");
        ;

        public String mod_id;
        public final String id;

        public final TagKey<Biome> tag;

        Biomes(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.BIOME, HibernalHerbsMod.fromModId(mod_id, id));
        }

        Biomes(String id) {
            this.id = id;
            this.tag = TagKey.create(Registries.BIOME, HibernalHerbsMod.asResource(id));
        }

        public TagKey<Biome> getTag() {
            return tag;
        }

        public static TagKey<Biome> create(String id) {
            return TagKey.create(Registries.BIOME, HibernalHerbsMod.asResource(id));
        }

        public static TagKey<Biome> create(String mod_id, String id) {
            return TagKey.create(Registries.BIOME, HibernalHerbsMod.fromModId(mod_id, id));
        }

        private static void load() {}
    }

    public static void load() {
        Items.load();
        Blocks.load();
        Enchantments.load();
        EntityTypes.load();
        DamageTypes.load();
        Biomes.load();
    }

}
