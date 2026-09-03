package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.HibernalHerbsClientMod;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbalSigilTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalSigilItem extends Item {
    public HerbalSigilItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (!HibernalHerbsClientMod.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
        } else if (HibernalHerbsClientMod.hasShiftDown()) {
            HerbalSigilTypes.applyHerbalSigilAssistanceTooltip(itemStack, tooltip);

            if (!HibernalHerbsClientMod.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
            } else {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.three").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.padlock.four").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.sigil.help.herbs.three").withStyle(ChatFormatting.DARK_PURPLE));
            }
        }
    }

}
