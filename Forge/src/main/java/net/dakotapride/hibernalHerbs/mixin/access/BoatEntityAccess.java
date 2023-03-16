package net.dakotapride.hibernalHerbs.mixin.access;

import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Boat.class)
public interface BoatEntityAccess {

    @Accessor("lastYd")
    void hibernal_setLastYd(double lastYd);

    @Accessor("status")
    Boat.Status hibernal_getStatusField();
}
