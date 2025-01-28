package net.dakotapride.hibernalherbs.item;

import com.mojang.blaze3d.vertex.PoseStack;
import io.wispforest.accessories.api.AccessoriesAPI;
import io.wispforest.accessories.api.Accessory;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.client.AccessoryRenderer;
import io.wispforest.accessories.api.client.SimpleAccessoryRenderer;
import io.wispforest.accessories.api.slot.SlotReference;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.PadlockTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbalPadlockItem extends Item implements Accessory {
    public HerbalPadlockItem(Properties properties) {
        super(properties);

        AccessoriesAPI.registerAccessory(this, this);
    }

    @Override
    public void tick(ItemStack stack, SlotReference reference) {
        LivingEntity entity = reference.entity();

        if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GREED) /* && !entity.hasEffect(MobEffects.LUCK) */) {
            entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 400, 1));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            entity.removeEffect(MobEffects.HUNGER);
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.PRIDE) /* && !entity.hasEffect(MobEffects.REGENERATION) */) {
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.SLOTH) /* && !entity.hasEffect(MobEffects.SLOW_FALLING) */) {
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 1));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.LUST)) {
            if (entity.hasEffect(MobEffects.POISON) || entity.hasEffect(MobEffects.WITHER)) {
                entity.removeEffect(MobEffects.POISON);
                entity.removeEffect(MobEffects.WITHER);
            }
        }

        Accessory.super.tick(stack, reference);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        if (PadlockTypes.checkPadlockType(stack, PadlockTypes.PRIDE)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.pride.health"),
                    10.0d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.SLOTH)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.sloth.health"),
                    8.0d,
                    AttributeModifier.Operation.ADD_VALUE));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.sloth.movement_speed"),
                    -0.04d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.WRATH)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.wrath.health"),
                    8.0d,
                    AttributeModifier.Operation.ADD_VALUE));
            builder.addExclusive(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.wrath.attack_damage"),
                    4.0d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.LUST)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.lust.health"),
                    10.0d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GREED)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.greed.health"),
                    8.0d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.gluttony.health"),
                    8.0d,
                    AttributeModifier.Operation.ADD_VALUE));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.gluttony.movement_speed"),
                    -0.02d,
                    AttributeModifier.Operation.ADD_VALUE));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.ENVY)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.envy.health"),
                    6.0d,
                    AttributeModifier.Operation.ADD_VALUE));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    HibernalHerbsMod.asResource("sin.envy.movement_speed"),
                    0.04d,
                    AttributeModifier.Operation.ADD_VALUE));
        }

        Accessory.super.getDynamicModifiers(stack, reference, builder);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference reference) {
        if (reference.entity() instanceof ServerPlayer player) {
            PadlockTypes.applyPopupText(stack, player);
        }

        Accessory.super.onEquip(stack, reference);
    }

    // Rendering

    public static void clientInit() {
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.PRIDE.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.SLOTH.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.WRATH.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.LUST.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.GREED.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.GLUTTONY.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.ENVY.getBoundPadlockItem(), Renderer::new);
    }

    //@EventBusSubscriber(Dist.CLIENT)
    public static class Renderer implements SimpleAccessoryRenderer {

        @Override
        public <M extends LivingEntity> void align(ItemStack stack, SlotReference reference, EntityModel<M> model, PoseStack matrices) {
            if (!(model instanceof HumanoidModel<? extends LivingEntity> humanoidModel)) return;

            AccessoryRenderer.transformToModelPart(matrices, humanoidModel.body, 0, 0.7, 1);
            matrices.scale(.75f, .75f, .75f);
            matrices.translate(0, 0, 0.025);
        }

        @Override
        public <M extends LivingEntity> void render(ItemStack stack, SlotReference reference, PoseStack matrices, EntityModel<M> model, MultiBufferSource multiBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!(model instanceof HumanoidModel<M>)) return;

            SimpleAccessoryRenderer.super.render(stack, reference, matrices, model, multiBufferSource, light, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
        }
    }

    // End of rendering, continue on adventurer

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable TooltipContext tooltipContext, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (stack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
            tooltip.add(Component.literal(""));
        }

        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
            //tooltip.add(Component.literal(""));
        } else if (Screen.hasShiftDown()) {
            PadlockTypes.applyPadlockTypeTooltip(stack, tooltip);
            //tooltip.add(Component.literal(""));

            if (!Screen.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
            } else if (Screen.hasAltDown()) {

                if (stack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
                    tooltip.add(Component.literal(""));
                    PadlockTypes.getBoundPadlockAssistance(stack, tooltip);
                }

                if (stack.is(Tags.Items.UNBOUND_PADLOCKS.getTag())) {
                    tooltip.add(Component.literal(""));
                    PadlockTypes.applyUnboundPadlockAssistanceTooltip(stack, tooltip);
                }
            }

//            if (stack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
//                tooltip.add(Component.literal(""));
//            }

        }

        super.appendHoverText(stack, tooltipContext, tooltip, tooltipFlag);
    }
}