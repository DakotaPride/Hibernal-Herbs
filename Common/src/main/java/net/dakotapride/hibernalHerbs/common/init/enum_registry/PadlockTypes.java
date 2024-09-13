package net.dakotapride.hibernalHerbs.common.init.enum_registry;

import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.item.HerbalPadlockItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused"})
public enum PadlockTypes {
    NONE("text.nothing_to_see_here.null_registry"),
    PRIDE(),
    SLOTH(),
    WRATH(),
    LUST(),
    GREED(),
    GLUTTONY(),
    ENVY();

    public final String padlock_id;


    public RegistrySupplier<Item> unbound_padlock;
    public RegistrySupplier<Item> bound_padlock;

    PadlockTypes() {
        this.padlock_id = name().toLowerCase(Locale.ROOT);

        this.unbound_padlock = ItemInit.register("unbound_" + padlock_id + "_padlock", new HerbalPadlockItem(new Item.Properties().stacksTo(1)));
        this.bound_padlock = ItemInit.register("bound_" + padlock_id + "_padlock", new HerbalPadlockItem(new Item.Properties().stacksTo(1)));
    }

    PadlockTypes(String nothing) {
        this.padlock_id = name().toLowerCase(Locale.ROOT);
    }

    public RegistrySupplier<Item> getUnboundPadlockItem() {
        return unbound_padlock;
    }

    public RegistrySupplier<Item> getBoundPadlockItem() {
        return bound_padlock;
    }

    public String getPadlockId() {
        return padlock_id;
    }

    public static void register() {}

    public static boolean checkPadlockType(ItemStack stack, PadlockTypes type) {
        return stack.getItem() == type.getUnboundPadlockItem().get() || stack.getItem() == type.getBoundPadlockItem().get();
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

        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.abilities.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.abilities.help.two").withStyle(ChatFormatting.DARK_PURPLE));
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
