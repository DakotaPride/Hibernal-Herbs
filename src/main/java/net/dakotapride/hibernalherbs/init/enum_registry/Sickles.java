package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.SickleItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Locale;

public enum Sickles {
    WOODEN(Tiers.WOOD, "planks"),
    STONE(Tiers.STONE,"stone"),
    IRON(Tiers.IRON),
    GOLDEN(Tiers.GOLD),
    DIAMOND(Tiers.DIAMOND),
    NETHERITE(Tiers.NETHERITE),

    ARKONIUM(ModTiers.ARKONIUM, Rarity.UNCOMMON),
    SYRUM(ModTiers.SYRUM, Rarity.UNCOMMON),;

    public final String material_id;


    public final DeferredItem<SickleItem> sickle;
    public final Tier tier;
//    public DeferredItem<Item> repair0;
//    public Item repair1;
//    public TagKey<Item> repair_tag;
    public String recipe_name;

    Sickles(Tier tier) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        //this.repair1 = repair;
        this.sickle = ItemInit.sickle(material_id + "_sickle", () -> new SickleItem(tier, new Item.Properties()
                .stacksTo(1).attributes((SickleItem.createAttributes(tier, 3, -2.4F, -0.4F
                //        (tier_mod * (0.30F / 2))
                )))
                .component(DataComponents.TOOL, tier.createToolProperties(Tags.Blocks.MINEABLE_WITH_SICKLE.getTag()))));
    }

    Sickles(Tier tier, Rarity rarity) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        //this.repair0 = repair;
        this.sickle = ItemInit.sickle(material_id + "_sickle", () -> new SickleItem(tier, new Item.Properties().rarity(rarity)
                .stacksTo(1).attributes((SickleItem.createAttributes(tier, 3, -2.4F, -0.4F
                //        (tier_mod * (0.30F / 2))
                )))
                .component(DataComponents.TOOL, tier.createToolProperties(Tags.Blocks.MINEABLE_WITH_SICKLE.getTag()))));
    }

    Sickles(Tier tier, String recipe_name) {
        this.material_id = name().toLowerCase(Locale.ROOT);
        this.tier = tier;
        //this.repair_tag = repair;
        this.recipe_name = recipe_name;
        this.sickle = ItemInit.sickle(material_id + "_sickle", () -> new SickleItem(tier, new Item.Properties()
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

//    public Item getRepairItem() {
//        return repair;
//    }

//    public TagKey<Item> getRepairTag() {
//        return repair_tag;
//    }

    public SickleItem getSickleItem() {
        return sickle.get();
    }

    public static void register() {}
}
