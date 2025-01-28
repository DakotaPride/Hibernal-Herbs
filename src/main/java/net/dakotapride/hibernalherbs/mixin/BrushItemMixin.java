package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.block.ModBrushableBlock;
import net.dakotapride.hibernalherbs.block.ModBrushableBlockEntity;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrushItem.class)
public abstract class BrushItemMixin extends Item {
    @Shadow protected abstract HitResult calculateHitResult(Player player);

    @Shadow protected abstract void spawnDustParticles(Level level, BlockHitResult blockHitResult, BlockState blockState, Vec3 vec3, HumanoidArm humanoidArm);

    public BrushItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "onUseTick", at = @At("RETURN"))
    private void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int i, CallbackInfo ci) {
        if (i >= 0 && livingEntity instanceof Player player) {
            HitResult hitResult = this.calculateHitResult(player);
            if (hitResult instanceof BlockHitResult blockHitResult && hitResult.getType() == HitResult.Type.BLOCK) {
                int j = this.getUseDuration(itemStack, livingEntity) - i + 1;
                boolean bl = j % 10 == 5;
                if (bl) {
                    BlockPos blockPos = blockHitResult.getBlockPos();
                    BlockState blockState = level.getBlockState(blockPos);
                    HumanoidArm humanoidArm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
                    if (blockState.shouldSpawnTerrainParticles() && blockState.getRenderShape() != RenderShape.INVISIBLE) {
                        this.spawnDustParticles(level, blockHitResult, blockState, livingEntity.getViewVector(0.0F), humanoidArm);
                    }

                    SoundEvent soundEvent;

                    if (blockState.getBlock() instanceof ModBrushableBlock brushableBlock && !blockState.is(Tags.Blocks.REQUIRES_HIGH_TIER_BRUSH.getTag())) {
                        soundEvent = brushableBlock.getBrushSound();
                    } else {
                        soundEvent = SoundEvents.BRUSH_GENERIC;
                    }

                    level.playSound(player, blockPos, soundEvent, SoundSource.BLOCKS);
                    if (!level.isClientSide() && level.getBlockEntity(blockPos) instanceof ModBrushableBlockEntity brushableBlockEntity && !blockState.is(Tags.Blocks.REQUIRES_HIGH_TIER_BRUSH.getTag())) {
                        boolean bl2 = brushableBlockEntity.brush(level.getGameTime(), player, blockHitResult.getDirection());
                        if (bl2) {
                            EquipmentSlot equipmentSlot = itemStack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                            itemStack.hurtAndBreak(1, livingEntity, equipmentSlot);
                        }
                    }
                }

                return;
            }

            livingEntity.releaseUsingItem();
        } else {
            livingEntity.releaseUsingItem();
        }
    }

}
