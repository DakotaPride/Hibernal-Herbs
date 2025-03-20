package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.HibernalHerbsClientMod;
import net.dakotapride.hibernalherbs.food.FoodComponentList;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbalBlendTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalBlendItem extends Item implements FoodComponentList {
    public HerbalBlendItem(Properties properties) {
        super(properties);
    }

//    @Override
//    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
//        if (entity instanceof Player player) {
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.REGENERATION);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.POISON);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.SLOWNESS);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.MINING_FATIGUE);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.HASTE);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.SPEED);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.FIRE);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.WITHER);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.NIGHT_VISION);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.WEAKNESS);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.BLINDNESS);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.REGENERATION_SLOWNESS);
//            HerbalBlendTypes.applyFromConsumption(stack, player, HerbalBlendTypes.REGENERATION_SPEED_WEAKNESS);
//
//            return player.getAbilities().instabuild ? super.finishUsingItem(stack, level, entity) : new ItemStack(Items.BOWL);
//        } else {
//            return super.finishUsingItem(stack, level, entity);
//        }
//    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity livingEntity, @NotNull InteractionHand hand) {

        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.REGENERATION);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.POISON);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.SLOWNESS);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.MINING_FATIGUE);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.HASTE);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.SPEED);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.FIRE);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.WITHER);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.NIGHT_VISION);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.WEAKNESS);
        HerbalBlendTypes.applyFromConsumption(stack, livingEntity, HerbalBlendTypes.BLINDNESS);
        //HerbalBlendTypes.applyFromInteraction(stack, livingEntity, HerbalBlendTypes.REGENERATION_SLOWNESS);
        //HerbalBlendTypes.applyFromInteraction(stack, livingEntity, HerbalBlendTypes.REGENERATION_SPEED_WEAKNESS);

        if (!player.isCreative()) {
            stack.shrink(1);
            player.addItem(new ItemStack(Items.BOWL, 1));
        }
        
        
        return super.interactLivingEntity(stack, player, livingEntity, hand);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {

        Player player = (Player) target.getLastHurtByMob();
        if (attacker instanceof Player) {

            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.REGENERATION);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.POISON);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.SLOWNESS);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.MINING_FATIGUE);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.HASTE);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.SPEED);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.FIRE);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.WITHER);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.NIGHT_VISION);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.WEAKNESS);
            HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.BLINDNESS);
            //HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.REGENERATION_SLOWNESS);
            //HerbalBlendTypes.applyFromInteraction(stack, target, HerbalBlendTypes.REGENERATION_SPEED_WEAKNESS);

            assert player != null;
            if (!player.isCreative()) {
                stack.shrink(1);
                player.addItem(new ItemStack(Items.BOWL, 1));
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable TooltipContext level, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (!HibernalHerbsClientMod.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
        } else if (HibernalHerbsClientMod.hasShiftDown()) {
            HerbalBlendTypes.applyToTooltip(stack, tooltip);

//                if (stack.is(Tags.Items.SMOKED_BLENDS.getTag())) {
//                    tooltip.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.true").withStyle(ChatFormatting.GRAY));
//                } else {
//                    tooltip.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.false").withStyle(ChatFormatting.GRAY));
//                }

            if (!HibernalHerbsClientMod.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
            } else {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.ability.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.ability.help.two").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_click.player").withStyle(ChatFormatting.DARK_GRAY));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.right_click.player").withStyle(ChatFormatting.DARK_GRAY));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.three").withStyle(ChatFormatting.DARK_PURPLE));
            }
        }
    }
}
