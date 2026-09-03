package net.dakotapride.hibernalherbs.block;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.CriteriaTriggersInit;
import net.dakotapride.hibernalherbs.init.StatsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class SacrificialRuneBlock extends Block {
    public SacrificialRuneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.isClientSide) return;

        if ((serverLevel.getRandom().nextFloat() * 2) <= 1) {
            serverLevel.setBlock(blockPos, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK.defaultBlockState(), 3);

            Vec3 vec3 = blockPos.getCenter().add(0.0, 0.5, 0.0);
            int i = (int)Mth.clamp(50.0F * 0.5F, 0.0F, 200.0F);
            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState), vec3.x, vec3.y, vec3.z, i, 0.3F, 0.3F, 0.3F, 0.15F);

            for (ServerPlayer player : serverLevel.players()) {
                CriteriaTriggersInit.DETERIORATED_RUNE_BLOCK.trigger(player, blockPos, player.getMainHandItem());
                player.awardStat(StatsInit.DETERIORATED_RUNE_BLOCK.get(BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK));
            }
        }
    }
}
