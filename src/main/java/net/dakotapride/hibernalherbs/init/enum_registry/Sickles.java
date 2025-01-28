package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.SickleItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;

import java.util.Locale;

public enum Sickles {
    WOODEN(Tiers.WOOD, ItemTags.PLANKS, "planks"),
    STONE(Tiers.STONE, ItemTags.STONE_TOOL_MATERIALS, "stone"),
    IRON(Tiers.IRON, Items.IRON_INGOT),
    GOLDEN(Tiers.GOLD, Items.GOLD_INGOT),
    DIAMOND(Tiers.DIAMOND, Items.DIAMOND),
    NETHERITE(Tiers.NETHERITE, Items.NETHERITE_INGOT),

    ARKONIUM(ModTiers.ARKONIUM, Archaeology.Metals.ARKONIUM.getIngotItem(), Rarity.UNCOMMON),
    SYRUM(ModTiers.SYRUM, Archaeology.Metals.SYRUM.getIngotItem(), Rarity.UNCOMMON),;

    public final String material_id;


    public final SickleItem sickle;
    public final Tier tier;
    public Item repair;
    public TagKey<Item> repair_tag;
    public String recipe_name;

    Sickles(Tier tier, Item repair) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        this.repair = repair;
        this.sickle = (SickleItem) ItemInit.register(material_id + "_sickle", new SickleItem(tier, new Item.Properties()
                .stacksTo(1).attributes((SickleItem.createAttributes(tier, 3, -2.4F, -0.4F
                //        (tier_mod * (0.30F / 2))
                )))
                .component(DataComponents.TOOL, tier.createToolProperties(Tags.Blocks.MINEABLE_WITH_SICKLE.getTag()))));
    }

    Sickles(Tier tier, Item repair, Rarity rarity) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        this.repair = repair;
        this.sickle = (SickleItem) ItemInit.register(material_id + "_sickle", new SickleItem(tier, new Item.Properties().rarity(rarity)
                .stacksTo(1).attributes((SickleItem.createAttributes(tier, 3, -2.4F, -0.4F
                //        (tier_mod * (0.30F / 2))
                )))
                .component(DataComponents.TOOL, tier.createToolProperties(Tags.Blocks.MINEABLE_WITH_SICKLE.getTag()))));
    }

    Sickles(Tier tier, TagKey<Item> repair, String recipe_name) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        this.repair_tag = repair;
        this.recipe_name = recipe_name;
        this.sickle = (SickleItem) ItemInit.register(material_id + "_sickle", new SickleItem(tier, new Item.Properties()
                .stacksTo(1).attributes((SickleItem.createAttributes(tier, 3, -2.4F, -0.4F
                //        (tier_mod * (0.30F / 2))
                )))
                .component(DataComponents.TOOL, tier.createToolProperties(Tags.Blocks.MINEABLE_WITH_SICKLE.getTag()))));
    }

    public String getMaterialId() {
        return material_id;
    }

    public String getRecipeName() {
        return recipe_name;
    }

    public Tier getTier() {
        return tier;
    }

    public Item getRepairItem() {
        return repair;
    }

    public TagKey<Item> getRepairTag() {
        return repair_tag;
    }

    public SickleItem getSickleItem() {
        return sickle;
    }

    public static void register() {}
}
