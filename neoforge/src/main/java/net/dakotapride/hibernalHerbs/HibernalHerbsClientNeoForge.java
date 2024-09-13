package net.dakotapride.hibernalHerbs;

import net.dakotapride.hibernalHerbs.client.HibernalHerbsClientMod;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.item.HerbalPadlockItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = HibernalHerbsCommonMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class HibernalHerbsClientNeoForge {

    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        HerbalPadlockItem.clientInit();

        HibernalHerbsClientMod.clientInit();
    }
}