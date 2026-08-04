package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class LockdownWallBlock extends Block implements LockdownControllable {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public LockdownWallBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient()) {
            boolean hasSignal = world.isReceivingRedstonePower(pos);
            if (state.get(POWERED) != hasSignal) {
                setLockdownState(world, pos, state, hasSignal);
            }
        }
    }

    @Override
    public void setLockdownState(World world, BlockPos pos, BlockState state, boolean active) {
        if (state.get(POWERED) != active) {
            world.setBlockState(pos, state.with(POWERED, active), Block.NOTIFY_LISTENERS);
            world.playSound(null, pos, SoundEvents.BLOCK_NETHERITE_BLOCK_HIT, SoundCategory.BLOCKS, 0.8F, 0.6F);
        }
    }
}
