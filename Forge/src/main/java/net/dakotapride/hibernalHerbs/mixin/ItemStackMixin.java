package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodComponentList {

    @Shadow public abstract Item getItem();

    @Shadow public abstract int getCount();

    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void finishUsingItem(Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (livingEntity.getMainHandItem().is(itemRegistry.FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(secondsOnFire);
        }

        if (livingEntity.getMainHandItem().is(itemRegistry.SMOKED_FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(smokedSecondsOnFire);
        }

        if (livingEntity instanceof Player player) {
            ItemStack advGluttonousRingStack = itemRegistry.ADV_GLUTTONOUS_RING.get().getDefaultInstance();

            if (player.getInventory().contains(advGluttonousRingStack) && !(player.getAbilities().instabuild)) {

                if (this.getItem().getDefaultInstance().is(HibernalHerbsForge.BLENDS_TAG)) {
                    cir.setReturnValue(((Player)livingEntity).getAbilities().instabuild
                            ? this.getItem().getDefaultInstance() : new ItemStack(this.getItem().asItem()));
                }

                if (this.getItem().isEdible()) {
                    ((Player) livingEntity).getFoodData().eat(this.getItem().getFoodProperties().getNutrition(),
                            this.getItem().getFoodProperties().getSaturationModifier());
                }

                cir.setReturnValue(((Player)livingEntity).getAbilities().instabuild
                        ? this.getItem().getDefaultInstance() : new ItemStack(this.getItem().asItem(), this.getCount()));
            }
        }

    }

    @Inject(method = "interactLivingEntity", at = @At("HEAD"))
    private void interactLivingEntity(Player player, LivingEntity livingEntity, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.getMainHandItem().is(itemRegistry.FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(secondsOnFire);
        }

        if (player.getMainHandItem().is(itemRegistry.SMOKED_FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(smokedSecondsOnFire);
        }
    }

}
