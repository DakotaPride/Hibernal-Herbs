package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.item.HerbalSigilItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused"})
public enum HerbalSigilTypes {
    NONE("text.nothing_to_see_here.empty_registry"),
    CONFIGURATION(),
    MASTERY(),
    ADVANCED_CONFIGURATION(),
    ADVANCED_MASTERY(),
    PRIDE(),
    SLOTH(),
    WRATH(),
    LUST(),
    GREED(),
    GLUTTONY(),
    ENVY();

    public final String sigil_id;


    public Item herbal_sigil;

    HerbalSigilTypes() {
        this.sigil_id = name().toLowerCase(Locale.ROOT);

        this.herbal_sigil = ItemInit.register(sigil_id + "_herbal_sigil", new HerbalSigilItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).durability(10)));
    }

    HerbalSigilTypes(String nothing) {
        this.sigil_id = name().toLowerCase(Locale.ROOT);
    }

    public Item getHerbalSigilItem() {
        return herbal_sigil;
    }

    public String getSigilId() {
        return sigil_id;
    }

    public static void register() {}

    public static boolean checkSigilType(ItemStack stack, HerbalSigilTypes type) {
        return stack.getItem() == type.getHerbalSigilItem();
    }

    // Tooltips

    public static void getHerbalSigilAssistance(ItemStack stack, List<Component> tooltip, HerbalSigilTypes type) {
        String alignment;

        if (HerbalSigilTypes.checkSigilType(stack, type)) {
            alignment = type.getSigilId();
        } else if (type == HerbalSigilTypes.NONE) {
            alignment = HerbalSigilTypes.NONE.getSigilId();
        } else {
            alignment = HerbalSigilTypes.NONE.getSigilId();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.sigil.alignment", Component.translatable("text.hibernalherbs.sigil.alignment." + alignment)).withStyle(ChatFormatting.GRAY));
    }

    public static void applyHerbalSigilAssistanceTooltip(ItemStack stack, List<Component> tooltip) {
        if (checkSigilType(stack, HerbalSigilTypes.CONFIGURATION)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.CONFIGURATION);
        } else if (checkSigilType(stack, HerbalSigilTypes.MASTERY)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.MASTERY);
        } else if (checkSigilType(stack, HerbalSigilTypes.ADVANCED_CONFIGURATION)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.ADVANCED_CONFIGURATION);
        } else if (checkSigilType(stack, HerbalSigilTypes.ADVANCED_MASTERY)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.ADVANCED_MASTERY);
        } else if (checkSigilType(stack, HerbalSigilTypes.PRIDE)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.PRIDE);
        } else if (checkSigilType(stack, HerbalSigilTypes.SLOTH)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.SLOTH);
        } else if (checkSigilType(stack, HerbalSigilTypes.WRATH)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.WRATH);
        } else if (checkSigilType(stack, HerbalSigilTypes.LUST)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.LUST);
        } else if (checkSigilType(stack, HerbalSigilTypes.GREED)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.GREED);
        } else if (checkSigilType(stack, HerbalSigilTypes.GLUTTONY)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.GLUTTONY);
        } else if (checkSigilType(stack, HerbalSigilTypes.ENVY)) {
            HerbalSigilTypes.getHerbalSigilAssistance(stack, tooltip, HerbalSigilTypes.ENVY);
        }
    }
}
