package net.dakotapride.hibernalherbs.forge.item;

import net.dakotapride.hibernalherbs.forge.entity.MyquesteBoatEntity;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteChestBoatEntity;
import net.minecraft.block.WoodType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("NullableProblems")
public class MyquesteBoatItem extends BoatItem {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final String WOOD_TYPE;
    private final boolean HAS_CHEST;

    public MyquesteBoatItem(boolean pHasChest, Settings pProperties, WoodType pType) {
        super(pHasChest, BoatEntity.Type.MANGROVE, pProperties);
        this.WOOD_TYPE = pType.name();
        this.HAS_CHEST = pHasChest;
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        HitResult hitresult = raycast(level, player, RaycastContext.FluidHandling.ANY);
        if(hitresult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemstack);
        } else {
            Vec3d vec3 = player.getRotationVec(1);
            List<Entity> list = level.getEntitiesByType((TypeFilter<Entity, Entity>) player, player.getBoundingBox().expand(vec3.squaredDistanceTo(5.0D, 5.0D, 5.0D)).expand(1.0D), ENTITY_PREDICATE);
            if(!list.isEmpty()) {
                Vec3d vec31 = player.getEyePos();

                for(Entity entity : list) {
                    Box aabb = entity.getBoundingBox().expand(entity.getTargetingMargin());
                    if(aabb.contains(vec31)) {
                        return TypedActionResult.pass(itemstack);
                    }
                }
            }

            if(hitresult.getType() == HitResult.Type.BLOCK) {
                BoatEntity boat = getBoat(level, hitresult);
                boat.setYaw(player.getYaw());
                if(!level.isSpaceEmpty(boat, boat.getBoundingBox())) {
                    return TypedActionResult.fail(itemstack);
                } else {
                    if(!level.isClient) {
                        level.spawnEntity(boat);
                        level.emitGameEvent(player, GameEvent.ENTITY_PLACE, hitresult.getPos());
                        if(!player.getAbilities().creativeMode) {
                            itemstack.decrement(1);
                        }
                    }

                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemstack, level.isClient());
                }
            } else {
                return TypedActionResult.pass(itemstack);
            }
        }
    }

    private BoatEntity getBoat(World level, HitResult hitResult) {
        return HAS_CHEST ? new MyquesteChestBoatEntity(level, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, WOOD_TYPE) : new MyquesteBoatEntity(level, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, WOOD_TYPE);
    }
}