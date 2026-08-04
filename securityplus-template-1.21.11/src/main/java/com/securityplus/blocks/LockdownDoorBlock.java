package com.securityplus.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LockdownDoorBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty OPEN = Properties.OPEN;

    public LockdownDoorBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false).with(OPEN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED, OPEN);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            boolean isPowered = world.isReceivingRedstonePower(pos);
            if (isPowered != state.get(POWERED)) {
                world.setBlockState(pos, state.with(POWERED, isPowered).with(OPEN, isPowered), Block.NOTIFY_ALL);
            }
        }
    }
}
