package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.item.HerbalPadlockItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused"})
public enum PadlockTypes {
    NONE("text.nothing_to_see_here.null_registry"),
    PRIDE(HerbalSigilTypes.PRIDE),
    SLOTH(HerbalSigilTypes.SLOTH),
    WRATH(HerbalSigilTypes.WRATH),
    LUST(HerbalSigilTypes.LUST),
    GREED(HerbalSigilTypes.GREED),
    GLUTTONY(HerbalSigilTypes.GLUTTONY),
    ENVY(HerbalSigilTypes.ENVY);

    public final String padlock_id;


    public Item unbound_padlock;
    public Item bound_padlock;
    public Item herbal_sigil;

    PadlockTypes(HerbalSigilTypes sigil) {
        this.padlock_id = name().toLowerCase(Locale.ROOT);

        this.herbal_sigil = sigil.getHerbalSigilItem();

        this.unbound_padlock = ItemInit.register("unbound_" + padlock_id + "_padlock", new HerbalPadlockItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
        this.bound_padlock = ItemInit.register("bound_" + padlock_id + "_padlock", new HerbalPadlockItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    }

    PadlockTypes(String nothing) {
        this.padlock_id = name().toLowerCase(Locale.ROOT);
    }

    public Item getUnboundPadlockItem() {
        return unbound_padlock;
    }

    public Item getBoundPadlockItem() {
        return bound_padlock;
    }

    public Item getHerbalSigilItem() {
        return herbal_sigil;
    }

    public String getPadlockId() {
        return padlock_id;
    }

    public static void register() {}

    public static boolean checkPadlockType(ItemStack stack, PadlockTypes type) {
        return stack.getItem() == type.getUnboundPadlockItem() || stack.getItem() == type.getBoundPadlockItem();
    }

    // Tooltips

    public static void getUnboundPadlockAssistance(ItemStack stack, List<Component> tooltip, PadlockTypes type) {
        String prince;

        if (PadlockTypes.checkPadlockType(stack, type)) {
            prince = type.getPadlockId();
        } else if (type == PadlockTypes.NONE) {
            prince = PadlockTypes.NONE.getPadlockId();
        } else {
            prince = PadlockTypes.NONE.getPadlockId();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.two", Component.translatable("text.hibernalherbs.padlock.prince." + prince)).withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.three").withStyle(ChatFormatting.DARK_PURPLE));
    }

    public static void applyUnboundPadlockAssistanceTooltip(ItemStack stack, List<Component> tooltip) {
        if (checkPadlockType(stack, PadlockTypes.PRIDE)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.PRIDE);
        } else if (checkPadlockType(stack, PadlockTypes.SLOTH)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.SLOTH);
        } else if (checkPadlockType(stack, PadlockTypes.WRATH)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.WRATH);
        } else if (checkPadlockType(stack, PadlockTypes.LUST)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.LUST);
        } else if (checkPadlockType(stack, PadlockTypes.GREED)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.GREED);
        } else if (checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.GLUTTONY);
        } else if (checkPadlockType(stack, PadlockTypes.ENVY)) {
            PadlockTypes.getUnboundPadlockAssistance(stack, tooltip, PadlockTypes.ENVY);
        }
    }

    public static void getBoundPadlockAssistance(ItemStack stack, List<Component> tooltip) {

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.two").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.three").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.four").withStyle(ChatFormatting.DARK_PURPLE));
    }

    public static void getBoundPrinceFromTooltip(ItemStack stack, List<Component> tooltip, PadlockTypes type) {
        String prince;

        if (PadlockTypes.checkPadlockType(stack, type)) {
            prince = type.getPadlockId();
        } else if (type == PadlockTypes.NONE) {
            prince = PadlockTypes.NONE.getPadlockId();
        } else {
            prince = PadlockTypes.NONE.getPadlockId();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.get_prince", Component.translatable("text.hibernalherbs.padlock.sin." + prince)).withStyle(ChatFormatting.GRAY));
    }

    public static void applyPadlockTypeTooltip(ItemStack stack, List<Component> tooltip) {
        if (checkPadlockType(stack, PadlockTypes.PRIDE)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.PRIDE);
        } else if (checkPadlockType(stack, PadlockTypes.SLOTH)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.SLOTH);
        } else if (checkPadlockType(stack, PadlockTypes.WRATH)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.WRATH);
        } else if (checkPadlockType(stack, PadlockTypes.LUST)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.LUST);
        } else if (checkPadlockType(stack, PadlockTypes.GREED)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.GREED);
        } else if (checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.GLUTTONY);
        } else if (checkPadlockType(stack, PadlockTypes.ENVY)) {
            PadlockTypes.getBoundPrinceFromTooltip(stack, tooltip, PadlockTypes.ENVY);
        }
    }

    public static void getUnholyBlessingFromPrince(ItemStack stack, LivingEntity entity, PadlockTypes type) {
        String prince;

        if (PadlockTypes.checkPadlockType(stack, type)) {
            prince = type.getPadlockId();
        } else if (type == PadlockTypes.NONE) {
            prince = PadlockTypes.NONE.getPadlockId();
        } else {
            prince = PadlockTypes.NONE.getPadlockId();
        }

        if (entity instanceof ServerPlayer player) {
            player.displayClientMessage(Component.translatable("text.hibernalherbs.padlock.unholy_blessing", Component.translatable("text.hibernalherbs.padlock.sin." + prince)).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC), false);
        }
    }

    public static void applyPopupText(ItemStack stack, LivingEntity entity) {
        if (checkPadlockType(stack, PadlockTypes.PRIDE)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.PRIDE);
        } else if (checkPadlockType(stack, PadlockTypes.SLOTH)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.SLOTH);
        } else if (checkPadlockType(stack, PadlockTypes.WRATH)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.WRATH);
        } else if (checkPadlockType(stack, PadlockTypes.LUST)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.LUST);
        } else if (checkPadlockType(stack, PadlockTypes.GREED)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.GREED);
        } else if (checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.GLUTTONY);
        } else if (checkPadlockType(stack, PadlockTypes.ENVY)) {
            PadlockTypes.getUnholyBlessingFromPrince(stack, entity, PadlockTypes.ENVY);
        }
    }
}
