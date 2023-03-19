package net.dakotapride.hibernalHerbs.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class MyquesteBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    private final boolean hasChest;
    private Boat.Type type;
    boolean isSafe = false;

    public MyquesteBoatItem(boolean hasChest, Properties properties) {
        super(properties);
        this.hasChest = hasChest;
    }

    public MyquesteBoatItem(boolean hasChest, Properties properties, Boat.Type type) {
        super(properties);
        this.hasChest = hasChest;
        this.type = type;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        if (!isSafe) {
            componentList.add(Component.literal("Item is Currently Disabled Due To Known Issues"));
            componentList.add(Component.literal("Apologies For The Inconvenience!"));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (isSafe) {
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            HitResult hitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.ANY);
            if (hitresult.getType() == HitResult.Type.MISS) {
                return InteractionResultHolder.pass(itemstack);
            } else {
                Vec3 vec3 = pPlayer.getViewVector(1.0F);
                double d0 = 5.0D;
                List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
                if (!list.isEmpty()) {
                    Vec3 vec31 = pPlayer.getEyePosition();

                    for (Entity entity : list) {
                        AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
                        if (aabb.contains(vec31)) {
                            return InteractionResultHolder.pass(itemstack);
                        }
                    }
                }

                if (hitresult.getType() == HitResult.Type.BLOCK) {
                    Boat boat = this.getBoat(pLevel, hitresult);
                    boat.setType(this.type);
                    boat.setYRot(pPlayer.getYRot());
                    if (!pLevel.noCollision(boat, boat.getBoundingBox())) {
                        return InteractionResultHolder.fail(itemstack);
                    } else {
                        if (!pLevel.isClientSide) {
                            pLevel.addFreshEntity(boat);
                            pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                            if (!pPlayer.getAbilities().instabuild) {
                                itemstack.shrink(1);
                            }
                        }

                        pPlayer.awardStat(Stats.ITEM_USED.get(this));
                        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                    }
                } else {
                    return InteractionResultHolder.pass(itemstack);
                }
            }
        } else {
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pHand));
        }
    }

    private Boat getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new ChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new Boat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}