package net.dakotapride.hibernalherbs.criteria;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class BlockInteractionTrigger extends ItemUsedOnLocationTrigger {
    public BlockInteractionTrigger(String id) {
        super(HibernalHerbsMod.asResource(id));
    }

    @Override
    public void trigger(ServerPlayer serverPlayer, BlockPos blockPos, ItemStack itemStack) {
        ServerLevel serverLevel = serverPlayer.serverLevel();
        BlockState blockState = serverLevel.getBlockState(blockPos);
        LootParams lootParams = (new LootParams.Builder(serverLevel)).withParameter(LootContextParams.ORIGIN, blockPos.getCenter()).withParameter(LootContextParams.THIS_ENTITY, serverPlayer).withParameter(LootContextParams.BLOCK_STATE, blockState).withParameter(LootContextParams.TOOL, itemStack).create(LootContextParamSets.ADVANCEMENT_LOCATION);
        LootContext lootContext = (new LootContext.Builder(lootParams)).create(null);
        this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches(lootContext));
    }
}
