package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;

public class HerbalGrimoireItem extends Item {
    public HerbalGrimoireItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (player instanceof ServerPlayer serverPlayer) {

            PatchouliAPI.get().openBookGUI(serverPlayer, HibernalHerbsCommonMod.asResource("grimoire"));

            return InteractionResultHolder.success(itemStack);
        } else return InteractionResultHolder.fail(itemStack);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            list.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            list.add(Component.translatable("text.hibernalherbs.grimoire.integration.one").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
            list.add(Component.translatable("text.hibernalherbs.grimoire.integration.two").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}
