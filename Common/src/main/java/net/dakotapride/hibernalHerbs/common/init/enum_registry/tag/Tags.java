package net.dakotapride.hibernalHerbs.common.init.enum_registry.tag;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class Tags {

    public enum Items {
        HERBS(HibernalHerbsCommonMod.MOD_ID, "herbs"),
        POUNDED_HERBS(HibernalHerbsCommonMod.MOD_ID, "pounded_herbs"),
        BLENDS(HibernalHerbsCommonMod.MOD_ID, "herbal_blends"),
        SMOKED_BLENDS(HibernalHerbsCommonMod.MOD_ID, "smoked_herbal_blends"),
        ARTIFICIAL_BLENDS(HibernalHerbsCommonMod.MOD_ID, "artificial_herbal_blends"),
        HUMUS(HibernalHerbsCommonMod.MOD_ID, "humus"),
        FERTILIZER(HibernalHerbsCommonMod.MOD_ID, "fertilizer"),
        POUCHES(HibernalHerbsCommonMod.MOD_ID, "pouches"),
        CANISTERS(HibernalHerbsCommonMod.MOD_ID, "canisters"),
        SIGILS(HibernalHerbsCommonMod.MOD_ID, "sigil/sigils"),
        BOUND_PADLOCKS(HibernalHerbsCommonMod.MOD_ID, "bound_herbal_padlocks"),
        PADLOCKS(HibernalHerbsCommonMod.MOD_ID, "unbound_herbal_padlocks"),
        GRIMOIRES(HibernalHerbsCommonMod.MOD_ID, "grimoires"),
        AXES_OR_SIMILAR_TAG("forge", "tools/axes");

        public final String mod_id;
        public final String id;

        public final TagKey<Item> tag;

        Items(String mod_id, String id) {
            this.mod_id = mod_id;
            this.id = id;
            this.tag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id, id));
        }

        public TagKey<Item> getTag() {
            return tag;
        }

        public static void load() {}
    }

}
