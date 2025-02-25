package net.dakotapride.hibernalherbs.item;

import dev.emi.emi.api.EmiRegistry;
import net.dakotapride.hibernalherbs.emi.AbstractTomeUsageRecipe;
import net.dakotapride.hibernalherbs.emi.HibernalHerbsEmiPlugin;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbalSigilTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.PadlockTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class SorcererTomeItem extends Item {
    public SorcererTomeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        if (!isNotActive(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.tome.is_active"));
            list.add(Component.literal(""));
            list.add(Component.translatable("text.hibernalherbs.tome.cannot_utilise"));
        } else if (isNotActive(itemStack)) {
            list.add(Component.translatable("text.hibernalherbs.not_active").withStyle(ChatFormatting.GRAY));
        }
    }

    public static boolean isNotActive(ItemStack itemStack) {
        return Boolean.FALSE.equals(itemStack.get(DataComponentInit.IS_BEING_USED)) || !(itemStack.has(DataComponentInit.IS_BEING_USED));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack0 = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStack1 = player.getItemInHand(InteractionHand.OFF_HAND);

        if (!itemStack0.is(this))
            return InteractionResultHolder.fail(this.getDefaultInstance());

        if (itemStack1.is(Tags.Items.CAN_USE_WITH_TOME.getTag()) && !player.getCooldowns().isOnCooldown(itemStack0.getItem()) && isNotActive(itemStack0)) {
            itemStack0.set(DataComponentInit.IS_BEING_USED, true);

            return ItemUtils.startUsingInstantly(level, player, interactionHand);
        } else {
            return InteractionResultHolder.fail(itemStack0);
        }
    }

    private int getDuration(ItemStack stack) {
        if (stack.is(Tags.Items.SHORT_AGGLOMERATION_DURATION.getTag())) {
            return 60;
        }

        if (stack.is(Tags.Items.LONG_AGGLOMERATION_DURATION.getTag())) {
            return 80;
        }

        return 60;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(itemStack, level, livingEntity);

        //ItemStack itemStack0 = livingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack itemStack1 = livingEntity.getOffhandItem();

        if (itemStack1.is(Tags.Items.SIGILS.getTag())) {
            //duration = 60;

            if (itemStack1.is(HerbalSigilTypes.PRIDE.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.SANGUINE, (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.SLOTH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.LETHARGY, (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.WRATH.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.BARBARIC, (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.LUST.getHerbalSigilItem())) {
                MobEffectInstance instance = new MobEffectInstance(StatusEffectInit.DEVOTION, (20 * 10), 1);
                livingEntity.addEffect(instance);

                final List<Animal> animalList = level.getEntitiesOfClass(Animal.class, livingEntity.getBoundingBox().inflate(8F * instance.getAmplifier()), Objects::nonNull);
                animalList.forEach(animal -> {
                    if (livingEntity instanceof Player player)
                        animal.setInLove(player);
                });
            }

            if (itemStack1.is(HerbalSigilTypes.GREED.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.RAPACITY, (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.GLUTTONY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.ESURIENT, (20 * 10), 1));
            }

            if (itemStack1.is(HerbalSigilTypes.ENVY.getHerbalSigilItem())) {
                livingEntity.addEffect(new MobEffectInstance(StatusEffectInit.MIMICRY, (20 * 10), 1));
            }


            if (!level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel)level;

                BlockPos blockPos = livingEntity.getOnPosLegacy();

                BlockState blockState = Blocks.HAY_BLOCK.defaultBlockState();

                Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
                int i = (int) Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);
                serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState), vec3.x, vec3.y, vec3.z, i, 0.3F, 0.3F, 0.3F, 0.15F);
                //this.spawnExtraParticlesOnFall = false;
//                for(int i = 0; i < 360; i++) {
//                    if(i % 20 == 0) {
//                        level.addParticle(ParticleTypes.HEART,
//                                livingEntity.getX() + 0.5d, livingEntity.getY() + 1, livingEntity.getZ() + 0.5d,
//                                Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
//                    }
//                }

                if (livingEntity instanceof ServerPlayer player) {
                    //player.getAdvancements().award(ModAdvancementProvider.AdvancementHolders.sorcerer_agglomeration, "testing");
                    //CriteriaTriggers.CONSUME_ITEM.trigger(player, itemStack);
                    CriteriaTriggersInit.USED_TOME.get().trigger(player, itemStack);
                    CriteriaTriggersInit.SACRIFICED_HUNGER_FROM_TOME.get().trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL.get().trigger(player, itemStack);
                    CriteriaTriggersInit.USED_SIGIL_WITH_TOME.get().trigger(player, itemStack);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.awardStat(StatsInit.USED_TOME.get().get(this));
                    player.awardStat(StatsInit.SACRIFICED_HUNGER_FROM_TOME.get().get(this));
                    player.awardStat(StatsInit.USED_SIGIL.get().get(this));
                    player.awardStat(StatsInit.USED_SIGIL_WITH_TOME.get().get(this));

                    player.getCooldowns().addCooldown(this, (20 * 12));

                    player.hurt(player.damageSources().source(DamageSourceKeysInit.TOME_HUNGER_SACRIFICE), 1.0F);
                    player.causeFoodExhaustion(0.20F);

                    itemStack.set(DataComponentInit.IS_BEING_USED, false);
                }

            }
        }


        // Fake recipes!
        if (livingEntity instanceof ServerPlayer player) {
            for (PadlockTypes types : PadlockTypes.values()) {
                createItemConversion(level, player, types.getUnboundPadlockItem(), types.getBoundPadlockItem(), itemStack, itemStack1);
            }
        }

        return itemStack;
    }

    private void createItemConversion(Level level, ServerPlayer player, Item base, Item result, ItemStack itemStack, ItemStack itemStack1) {
        if (!level.isClientSide) {
            if (itemStack1.is(base)) {
                itemStack1.shrink(1);
                player.addItem(new ItemStack(result, 1));

                CriteriaTriggers.CONSUME_ITEM.trigger(player, itemStack1);
                CriteriaTriggersInit.USED_TOME.get().trigger(player, itemStack);
                CriteriaTriggersInit.CONJURED_ITEMS_FROM_TOME.get().trigger(player, itemStack);

                player.awardStat(Stats.ITEM_USED.get(this));
                player.awardStat(StatsInit.USED_TOME.get().get(this));
                player.awardStat(StatsInit.CONJURED_ITEMS_FROM_TOME.get().get(this));
                player.awardStat(Stats.ITEM_CRAFTED.get(result));

                player.getCooldowns().addCooldown(this, (20 * 12));

                itemStack.set(DataComponentInit.IS_BEING_USED, false);
            }
        }
    }

    public static void createEmiRecipe(EmiRegistry registry, Item item0, Item item1) {
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.CustomTomeUsageRecipe(item0.getDefaultInstance(), item1.getDefaultInstance(), false));
    }

    public static void createBoundPadlockRecipe(EmiRegistry registry, PadlockTypes types) {
        createEmiRecipe(registry, types.getUnboundPadlockItem(), types.getBoundPadlockItem());
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            ItemStack itemStack1 = player.getOffhandItem();
            return getDuration(itemStack1);
        }
        return 60;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }
}
