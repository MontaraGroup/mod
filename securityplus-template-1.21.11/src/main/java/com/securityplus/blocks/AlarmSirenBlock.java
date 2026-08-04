package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AlarmSirenBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public AlarmSirenBlock(Settings settings) {
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
                if (hasSignal) {
                    world.scheduleBlockTick(pos, this, 10);
                }
            }
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWERED)) {
            world.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.BLOCKS, 2.0F, 1.5F);
            world.spawnParticles(ParticleTypes.LAVA, (double)pos.getX() + 0.5, (double)pos.getY() + 1.1, (double)pos.getZ() + 0.5, 5, 0.2, 0.2, 0.2, 0.05);
            world.scheduleBlockTick(pos, this, 10);
        }
    }
}
