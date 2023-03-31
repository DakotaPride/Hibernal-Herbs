package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.init.EffectInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CursedConfigurationRingItem extends Item {
    public CursedConfigurationRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.hasStatusEffect(EffectInit.SCENTED_HERBAL_CURSE)) {
            user.sendMessage(Text.translatable("text.hibernalherbs.herbal_curse.scented.warning"), true);
        } else if (user.hasStatusEffect(EffectInit.BITTER_HERBAL_CURSE)) {
            user.sendMessage(Text.translatable("text.hibernalherbs.herbal_curse.bitter.warning"), true);
        } else if (user.hasStatusEffect(EffectInit.SOUR_HERBAL_CURSE)) {
            user.sendMessage(Text.translatable("text.hibernalherbs.herbal_curse.sour.warning"), true);
        } else if (user.hasStatusEffect(EffectInit.WARDED_HERBAL_CURSE)) {
            user.sendMessage(Text.translatable("text.hibernalherbs.herbal_curse.warded.warning"), true);
        }

        return super.use(world, user, hand);
    }
}
