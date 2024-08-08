package net.dakotapride.hibernalherbs.item.curse.grimoire;

import net.dakotapride.hibernalherbs.client.ITooltipProvider;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalGrimoireItem extends Item implements ITooltipProvider {
    public HerbalGrimoireItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!FabricLoader.getInstance().isModLoaded("patchouli")) {
            tooltip.add(Text.translatable("text.hibernalherbs.required_mod.patchouli"));
            tooltip.add(Text.literal(""));
        }

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire.integration.one").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
            tooltip.add(Text.translatable("text.hibernalherbs.grimoire.integration.two").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        }
    }
}
