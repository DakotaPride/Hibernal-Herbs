package net.dakotapride.hibernalHerbs.common.item.curse.grimoire;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HerbalGrimoireItem extends Item implements ITooltipProvider {
    public HerbalGrimoireItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (player instanceof ServerPlayer serverPlayer && ModList.get().isLoaded("patchouli")) {

            PatchouliAPI.get().openBookGUI(serverPlayer, new ResourceLocation(MOD_ID, "grimoire"));

            return InteractionResultHolder.success(itemStack);
        }

        return InteractionResultHolder.fail(itemStack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (!ModList.get().isLoaded("patchouli")) {
            tooltip.add(Component.translatable("text.hibernalherbs.required_mod.patchouli"));
            tooltip.add(Component.literal(" "));
        }

        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.grimoire.integration.one").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
            tooltip.add(Component.translatable("text.hibernalherbs.grimoire.integration.two").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}
