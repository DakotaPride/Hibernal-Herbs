package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.registry.effectRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CursedConfigurationRingItem extends Item {
    public CursedConfigurationRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        if (user.hasEffect(effectRegistry.SCENTED_HERBAL_CURSE.get())) {
            user.displayClientMessage(Component.translatable("text.hibernalherbs.herbal_curse.scented.warning"), true);
        } else if (user.hasEffect(effectRegistry.BITTER_HERBAL_CURSE.get())) {
            user.displayClientMessage(Component.translatable("text.hibernalherbs.herbal_curse.bitter.warning"), true);
        } else if (user.hasEffect(effectRegistry.SOUR_HERBAL_CURSE.get())) {
            user.displayClientMessage(Component.translatable("text.hibernalherbs.herbal_curse.sour.warning"), true);
        } else if (user.hasEffect(effectRegistry.WARDED_HERBAL_CURSE.get())) {
            user.displayClientMessage(Component.translatable("text.hibernalherbs.herbal_curse.warded.warning"), true);
        }

        return super.use(level, user, hand);
    }
}
