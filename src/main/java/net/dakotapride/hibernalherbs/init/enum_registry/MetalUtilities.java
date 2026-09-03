package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.item.AttributeArmourItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;

public class MetalUtilities {

    public enum Armour {
        ARKONIUM(Archaeology.Metals.ARKONIUM, ModArmourTiers.ARKONIUM, Rarity.UNCOMMON, Attributes.MOVEMENT_SPEED, 0.02F),
        SYRUM(Archaeology.Metals.SYRUM, ModArmourTiers.SYRUM, Rarity.UNCOMMON),;
        //DALUM(Archaeology.Metals.DALUM, ModArmourTiers.DALUM, Rarity.EPIC, Attributes.MAX_HEALTH, 2.0F);

        public final Item helmet;
        public final Item chestplate;
        public final Item leggings;
        public final Item boots;

        public final ArmorMaterial armorMaterial;
        public final Archaeology.Metals metal;

        Armour(Archaeology.Metals metals, ArmorMaterial material) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", new ArmorItem(material, ArmorItem.Type.HELMET,
                    new Item.Properties()));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", new ArmorItem(material, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", new ArmorItem(material, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", new ArmorItem(material, ArmorItem.Type.BOOTS,
                    new Item.Properties()));
        }

        Armour(Archaeology.Metals metals, ArmorMaterial material, Rarity rarity) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", new ArmorItem(material, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(rarity)));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", new ArmorItem(material, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().rarity(rarity)));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", new ArmorItem(material, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().rarity(rarity)));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", new ArmorItem(material, ArmorItem.Type.BOOTS,
                    new Item.Properties().rarity(rarity)));
        }

        Armour(Archaeology.Metals metals, ArmorMaterial material, Rarity rarity, Attribute attributeHolder, float value) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", new AttributeArmourItem(material, ArmorItem.Type.HELMET, attributeHolder, value,
                    new Item.Properties().rarity(rarity)));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", new AttributeArmourItem(material, ArmorItem.Type.CHESTPLATE, attributeHolder, value,
                    new Item.Properties().rarity(rarity)));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", new AttributeArmourItem(material, ArmorItem.Type.LEGGINGS, attributeHolder, value,
                    new Item.Properties().rarity(rarity)));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", new AttributeArmourItem(material, ArmorItem.Type.BOOTS, attributeHolder, value,
                    new Item.Properties().rarity(rarity)));
        }

        public ArmorMaterial getArmorMaterial() {
            return armorMaterial;
        }

        public Archaeology.Metals getMetal() {
            return metal;
        }

        public ArmorItem getHelmetItem() {
            return (ArmorItem) helmet;
        }

        public ArmorItem getChestplateItem() {
            return (ArmorItem) chestplate;
        }

        public ArmorItem getLeggingsItem() {
            return (ArmorItem) leggings;
        }

        public ArmorItem getBootsItem() {
            return (ArmorItem) boots;
        }

        public static void register() {}
    }

    public enum Tools {
        ARKONIUM(Archaeology.Metals.ARKONIUM, Sickles.ARKONIUM, ModTiers.ARKONIUM, Rarity.UNCOMMON),
        SYRUM(Archaeology.Metals.SYRUM, Sickles.SYRUM, ModTiers.SYRUM, Rarity.UNCOMMON),;
        //DALUM(Archaeology.Metals.DALUM, Sickles.DALUM, ModTiers.DALUM, Rarity.EPIC),;

        public final Item sword;
        public final Item pickaxe;
        public final Item axe;
        public final Item shovel;
        public final Item hoe;
        public final Item sickle;

        public final Tier tier;
        public final Archaeology.Metals metal;

        Tools(Archaeology.Metals metals, Sickles sickle, Tier tier) {
            this.tier = tier;
            this.metal = metals;
            this.sickle = sickle.getSickleItem();

            this.sword = ItemInit.register(metals.getMetalId() + "_sword", new SwordItem(tier, 3, -2.4F, new Item.Properties()));
            this.pickaxe = ItemInit.register(metals.getMetalId() + "_pickaxe", new PickaxeItem(tier, 1, -2.8F, new Item.Properties()));
            this.axe = ItemInit.register(metals.getMetalId() + "_axe", new AxeItem(tier, 6, -3.1F, new Item.Properties()));
            this.shovel = ItemInit.register(metals.getMetalId() + "_shovel", new ShovelItem(tier, 1.5F, -3.0F, new Item.Properties()));
            this.hoe = ItemInit.register(metals.getMetalId() + "_hoe", new HoeItem(tier, 2, -1.0F, new Item.Properties()));
        }

        Tools(Archaeology.Metals metals, Sickles sickle, Tier tier, Rarity rarity) {
            this.tier = tier;
            this.metal = metals;
            this.sickle = sickle.getSickleItem();

            this.sword = ItemInit.register(metals.getMetalId() + "_sword", new SwordItem(tier, 3, -2.4F, new Item.Properties().rarity(rarity)));
            this.pickaxe = ItemInit.register(metals.getMetalId() + "_pickaxe", new PickaxeItem(tier, 1, -2.8F, new Item.Properties().rarity(rarity)));
            this.axe = ItemInit.register(metals.getMetalId() + "_axe", new AxeItem(tier, 6, -3.1F, new Item.Properties().rarity(rarity)));
            this.shovel = ItemInit.register(metals.getMetalId() + "_shovel", new ShovelItem(tier, 1.5F, -3.0F, new Item.Properties().rarity(rarity)));
            this.hoe = ItemInit.register(metals.getMetalId() + "_hoe", new HoeItem(tier, 2, -1.0F, new Item.Properties().rarity(rarity)));
        }

        public Tier getToolTier() {
            return tier;
        }

        public Archaeology.Metals getMetal() {
            return metal;
        }

        public Item getSwordItem() {
            return sword;
        }

        public Item getPickaxeItem() {
            return pickaxe;
        }

        public Item getAxeItem() {
            return axe;
        }

        public Item getShovelItem() {
            return shovel;
        }

        public Item getHoeItem() {
            return hoe;
        }

        public Item getSickleItem() {
            return sickle;
        }

        public static void register() {}
    }

    public static void register() {
        Armour.register();
        Tools.register();
    }

}
