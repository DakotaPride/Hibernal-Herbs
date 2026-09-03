package net.dakotapride.hibernalherbs.item;

import com.mojang.blaze3d.vertex.PoseStack;
import io.wispforest.accessories.api.AccessoriesAPI;
import io.wispforest.accessories.api.Accessory;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.client.AccessoryRenderer;
import io.wispforest.accessories.api.client.SimpleAccessoryRenderer;
import io.wispforest.accessories.api.slot.SlotReference;
import net.dakotapride.hibernalherbs.HibernalHerbsClientMod;
import net.dakotapride.hibernalherbs.init.enum_registry.PadlockTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
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
import net.minecraft.world.level.Level;
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
                    "e462aac2-b1d8-4007-b0e8-9b2295782ecc",
                    10.0d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.SLOTH)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "7cf67d31-f8e0-46d2-b6a5-488cabfe85cd",
                    8.0d,
                    AttributeModifier.Operation.ADDITION));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    "42c5c615-fcf3-4d6f-8c51-535b01cdc30f",
                    -0.04d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.WRATH)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "d543b553-0ec2-4652-8cab-a9343d5136bd",
                    8.0d,
                    AttributeModifier.Operation.ADDITION));
            builder.addExclusive(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                    "3c0aeb2e-81dd-48b4-8bfa-77d5eace8d7f",
                    4.0d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.LUST)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "0b97b64a-1930-4c9f-abfa-ba20cefefbb1",
                    10.0d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GREED)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "fc384e9a-32e0-49c1-b801-c260a3e6dbe3",
                    8.0d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.GLUTTONY)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "c87ee3da-fb81-4140-a830-3e6f9a43fc18",
                    8.0d,
                    AttributeModifier.Operation.ADDITION));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    "3a1aab48-0bef-411d-bf52-dfb0190a4fa7",
                    -0.02d,
                    AttributeModifier.Operation.ADDITION));
        } else if (PadlockTypes.checkPadlockType(stack, PadlockTypes.ENVY)) {
            builder.addExclusive(Attributes.MAX_HEALTH, new AttributeModifier(
                    "0577de8b-24b6-46ab-b9e4-301ddaf7cae2",
                    6.0d,
                    AttributeModifier.Operation.ADDITION));
            builder.addExclusive(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                    "c20907b0-93c7-4388-af72-bce87a95e6c3",
                    0.04d,
                    AttributeModifier.Operation.ADDITION));
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

    @Environment(EnvType.CLIENT)
    public static void clientInit() {
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.PRIDE.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.SLOTH.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.WRATH.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.LUST.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.GREED.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.GLUTTONY.getBoundPadlockItem(), Renderer::new);
        AccessoriesRendererRegistry.registerRenderer(PadlockTypes.ENVY.getBoundPadlockItem(), Renderer::new);
    }

    @Environment(EnvType.CLIENT)
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
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (itemStack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
            tooltip.add(Component.literal(""));
        }

        if (!HibernalHerbsClientMod.hasShiftDown()) {
            tooltip.add(Component.translatable("text.hibernalherbs.controls.shift").withStyle(ChatFormatting.DARK_GRAY));
            //tooltip.add(Component.literal(""));
        } else if (HibernalHerbsClientMod.hasShiftDown()) {
            PadlockTypes.applyPadlockTypeTooltip(itemStack, tooltip);
            //tooltip.add(Component.literal(""));

            if (!HibernalHerbsClientMod.hasAltDown()) {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("text.hibernalherbs.controls.left_alt").withStyle(ChatFormatting.DARK_GRAY));
            } else if (HibernalHerbsClientMod.hasAltDown()) {

                if (itemStack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
                    tooltip.add(Component.literal(""));
                    PadlockTypes.getBoundPadlockAssistance(itemStack, tooltip);
                }

                if (itemStack.is(Tags.Items.UNBOUND_PADLOCKS.getTag())) {
                    tooltip.add(Component.literal(""));
                    PadlockTypes.applyUnboundPadlockAssistanceTooltip(itemStack, tooltip);
                }
            }

//            if (stack.is(Tags.Items.BOUND_PADLOCKS.getTag())) {
//                tooltip.add(Component.literal(""));
//            }

        }

        super.appendHoverText(itemStack, level, tooltip, tooltipFlag);
    }
}