package net.dakotapride.hibernalherbs.fabric.item;

import net.dakotapride.hibernalherbs.item.curse.grimoire.HerbalGrimoireItem;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import vazkii.patchouli.api.PatchouliAPI;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class GrimoireItem extends HerbalGrimoireItem {
    public GrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (user instanceof ServerPlayerEntity && FabricLoader.getInstance().isModLoaded("patchouli")) {
            ServerPlayerEntity player = (ServerPlayerEntity) user;

            PatchouliAPI.get().openBookGUI(player, new Identifier(MOD_ID, "grimoire"));

            return TypedActionResult.success(itemStack);
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }
}
