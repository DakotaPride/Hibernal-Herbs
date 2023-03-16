package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoat;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteChestBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class MyquesteBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    private final boolean hasChest;
    private final MyquesteBoat.MyquesteType type;

    public MyquesteBoatItem(boolean hasChest, MyquesteBoat.MyquesteType typeIn, Properties properties) {
        super(properties);
        this.hasChest = hasChest;
        this.type = typeIn;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        boolean isSafe = false;
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
                    MyquesteBoat boat = this.getBoat(pLevel, hitresult);
                    boat.setMyquesteBoatType(this.type);
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

    private MyquesteBoat getBoat(Level level, HitResult hitResult) {
        return this.hasChest ? new MyquesteChestBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z) : new MyquesteBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}