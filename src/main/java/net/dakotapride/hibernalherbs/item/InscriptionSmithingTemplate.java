package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class InscriptionSmithingTemplate extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", HibernalHerbsMod.asResource("sigil_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", HibernalHerbsMod.asResource("smithing_template.sigil_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", HibernalHerbsMod.asResource("smithing_template.sigil_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", HibernalHerbsMod.asResource("smithing_template.sigil_upgrade.base_slot_description")));
    private static final Component UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", HibernalHerbsMod.asResource("smithing_template.sigil_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_SIGIL = HibernalHerbsMod.asResource("item/empty_slot_sigil");
    private static final ResourceLocation EMPTY_SLOT_ASHES = HibernalHerbsMod.asResource("item/empty_slot_ashes");
    // private static final List<ResourceLocation> SLOT_LIST_0 = List.of(EMPTY_SLOT_SIGIL);
    // private static final List<ResourceLocation> SLOT_LIST_1 = List.of(EMPTY_SLOT_CATALYST);

    public InscriptionSmithingTemplate(Component applies_to, Component ingredients, Component upgrade, Component base_slot_description, Component additions_slot_description, List<ResourceLocation> icon_list, List<ResourceLocation> material_list, FeatureFlag... featureFlags) {
        super(applies_to, ingredients, upgrade, base_slot_description, additions_slot_description, icon_list, material_list, featureFlags);
    }

    public static SmithingTemplateItem createInscriptionSmithingTemplateItem() {
        return new InscriptionSmithingTemplate(UPGRADE_APPLIES_TO, UPGRADE_INGREDIENTS, UPGRADE, UPGRADE_BASE_SLOT_DESCRIPTION, UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createUpgradeIconList(), createSigilUpgradeMaterialList());
    }

    private static List<ResourceLocation> createUpgradeIconList() {
        return List.of(EMPTY_SLOT_SIGIL);
    }

    private static List<ResourceLocation> createSigilUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_ASHES);
    }
}
