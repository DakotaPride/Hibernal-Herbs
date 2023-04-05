package net.dakotapride.hibernalHerbs.common.item.curse.grimoire;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HerbalGrimoireItem extends Item {
    public HerbalGrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!FabricLoader.getInstance().isModLoaded("patchouli")) {
            tooltip.add(Text.translatable("text.hibernalherbs.patchouli"));
            tooltip.add(Text.literal(" "));
        }

        if (stack.isOf(ItemInit.HERBAL_GRIMOIRE)) {
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.isOf(ItemInit.SINGED_GRIMOIRE)) {
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire.singed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (user instanceof ServerPlayerEntity && FabricLoader.getInstance().isModLoaded("patchouli")) {
            ServerPlayerEntity player = (ServerPlayerEntity) user;

            PatchouliAPI.get().openBookGUI(player, new Identifier(MOD_ID, "grimoire"));

            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.fail(itemStack);
    }
}
