package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.item.AttributeArmourItem;
import net.dakotapride.hibernalherbs.item.SickleItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;

public class MetalUtilities {

    public enum Armour {
        ARKONIUM(Archaeology.Metals.ARKONIUM, ModArmourTiers.ARKONIUM, Rarity.UNCOMMON, Attributes.MOVEMENT_SPEED, 0.02F),
        SYRUM(Archaeology.Metals.SYRUM, ModArmourTiers.SYRUM, Rarity.UNCOMMON),;

        public final DeferredItem<Item> helmet;
        public final DeferredItem<Item> chestplate;
        public final DeferredItem<Item> leggings;
        public final DeferredItem<Item> boots;

        public final Holder<ArmorMaterial> armorMaterial;
        public final Archaeology.Metals metal;

        Armour(Archaeology.Metals metals, Holder<ArmorMaterial> material) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", () -> new ArmorItem(material, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", () -> new ArmorItem(material, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", () -> new ArmorItem(material, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", () -> new ArmorItem(material, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))));
        }

        Armour(Archaeology.Metals metals, Holder<ArmorMaterial> material, Rarity rarity) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", () -> new ArmorItem(material, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33)).rarity(rarity)));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", () -> new ArmorItem(material, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33)).rarity(rarity)));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", () -> new ArmorItem(material, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33)).rarity(rarity)));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", () -> new ArmorItem(material, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33)).rarity(rarity)));
        }

        Armour(Archaeology.Metals metals, Holder<ArmorMaterial> material, Rarity rarity, Holder<Attribute> attributeHolder, float value) {
            this.armorMaterial = material;
            this.metal = metals;

            this.helmet = ItemInit.register(metals.getMetalId() + "_helmet", () -> new AttributeArmourItem(material, ArmorItem.Type.HELMET, attributeHolder, value,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33)).rarity(rarity)));
            this.chestplate = ItemInit.register(metals.getMetalId() + "_chestplate", () -> new AttributeArmourItem(material, ArmorItem.Type.CHESTPLATE, attributeHolder, value,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33)).rarity(rarity)));
            this.leggings = ItemInit.register(metals.getMetalId() + "_leggings", () -> new AttributeArmourItem(material, ArmorItem.Type.LEGGINGS, attributeHolder, value,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33)).rarity(rarity)));
            this.boots = ItemInit.register(metals.getMetalId() + "_boots", () -> new AttributeArmourItem(material, ArmorItem.Type.BOOTS, attributeHolder, value,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33)).rarity(rarity)));
        }

        public Holder<ArmorMaterial> getArmorMaterial() {
            return armorMaterial;
        }

        public Archaeology.Metals getMetal() {
            return metal;
        }

        public ArmorItem getHelmetItem() {
            return (ArmorItem) helmet.get();
        }

        public ArmorItem getChestplateItem() {
            return (ArmorItem) chestplate.get();
        }

        public ArmorItem getLeggingsItem() {
            return (ArmorItem) leggings.get();
        }

        public ArmorItem getBootsItem() {
            return (ArmorItem) boots.get();
        }

        public static void register() {}
    }

    public enum Tools {
        ARKONIUM(Archaeology.Metals.ARKONIUM, ModTiers.ARKONIUM, Rarity.UNCOMMON),
        SYRUM(Archaeology.Metals.SYRUM, ModTiers.SYRUM, Rarity.UNCOMMON),;

        public final DeferredItem<Item> sword;
        public final DeferredItem<Item> pickaxe;
        public final DeferredItem<Item> axe;
        public final DeferredItem<Item> shovel;
        public final DeferredItem<Item> hoe;
        //public final SickleItem sickle;

        public final Tier tier;
        public final Archaeology.Metals metal;

        Tools(Archaeology.Metals metals, Tier tier) {
            this.tier = tier;
            this.metal = metals;
            //this.sickle = sickle.getSickleItem();

            this.sword = ItemInit.register(metals.getMetalId() + "_sword", () -> new SwordItem(tier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(tier, 3, -2.4F))));
            this.pickaxe = ItemInit.register(metals.getMetalId() + "_pickaxe", () -> new PickaxeItem(tier, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(tier, 1.0F, -2.8F))));
            this.axe = ItemInit.register(metals.getMetalId() + "_axe", () -> new AxeItem(tier, new Item.Properties()
                    .attributes(AxeItem.createAttributes(tier, 6.0F, -3.1F))));
            this.shovel = ItemInit.register(metals.getMetalId() + "_shovel", () -> new ShovelItem(tier, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(tier, 1.5F, -3.0F))));
            this.hoe = ItemInit.register(metals.getMetalId() + "_hoe", () -> new HoeItem(tier, new Item.Properties()
                    .attributes(HoeItem.createAttributes(tier, 2.0F, -1.0F))));
        }

        Tools(Archaeology.Metals metals, Tier tier, Rarity rarity) {
            this.tier = tier;
            this.metal = metals;
            //this.sickle = sickle.getSickleItem();

            this.sword = ItemInit.register(metals.getMetalId() + "_sword", () -> new SwordItem(tier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(tier, 3, -2.4F)).rarity(rarity)));
            this.pickaxe = ItemInit.register(metals.getMetalId() + "_pickaxe", () -> new PickaxeItem(tier, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(tier, 1.0F, -2.8F)).rarity(rarity)));
            this.axe = ItemInit.register(metals.getMetalId() + "_axe", () -> new AxeItem(tier, new Item.Properties()
                    .attributes(AxeItem.createAttributes(tier, 6.0F, -3.1F)).rarity(rarity)));
            this.shovel = ItemInit.register(metals.getMetalId() + "_shovel", () -> new ShovelItem(tier, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(tier, 1.5F, -3.0F)).rarity(rarity)));
            this.hoe = ItemInit.register(metals.getMetalId() + "_hoe", () -> new HoeItem(tier, new Item.Properties()
                    .attributes(HoeItem.createAttributes(tier, 2.0F, -1.0F)).rarity(rarity)));
        }

        public Tier getToolTier() {
            return tier;
        }

        public Archaeology.Metals getMetal() {
            return metal;
        }

        public Item getSwordItem() {
            return sword.get();
        }

        public Item getPickaxeItem() {
            return pickaxe.get();
        }

        public Item getAxeItem() {
            return axe.get();
        }

        public Item getShovelItem() {
            return shovel.get();
        }

        public Item getHoeItem() {
            return hoe.get();
        }

//        public Item getSickleItem() {
//            return sickle;
//        }

        public static void register() {}
    }

    public static void register() {
        Armour.register();
        Tools.register();
    }

}
