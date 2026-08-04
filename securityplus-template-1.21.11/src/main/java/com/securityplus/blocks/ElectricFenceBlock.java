package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricFenceBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public ElectricFenceBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            boolean hasSignal = world.isReceivingRedstonePower(pos);
            if (state.get(POWERED) != hasSignal) {
                world.setBlockState(pos, state.with(POWERED, hasSignal), Block.NOTIFY_LISTENERS);
            }
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient() && entity instanceof LivingEntity living) {
            if (state.get(POWERED) || world.isReceivingRedstonePower(pos)) {
                living.serverDamage(world.getDamageSources().lightningBolt(), 4.0F);
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 2));
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 1));
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
