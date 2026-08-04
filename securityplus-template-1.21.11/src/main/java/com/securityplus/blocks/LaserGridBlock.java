package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class LaserGridBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public LaserGridBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 4);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        boolean targetDetected = false;

        for (Direction dir : Direction.values()) {
            for (int i = 1; i <= 10; ++i) {
                BlockPos targetPos = pos.offset(dir, i);
                if (world.getBlockState(targetPos).isOf(this)) {
                    double minX = Math.min(pos.getX(), targetPos.getX());
                    double minY = Math.min(pos.getY(), targetPos.getY());
                    double minZ = Math.min(pos.getZ(), targetPos.getZ());
                    double maxX = Math.max(pos.getX(), targetPos.getX()) + 1.0;
                    double maxY = Math.max(pos.getY(), targetPos.getY()) + 1.0;
                    double maxZ = Math.max(pos.getZ(), targetPos.getZ()) + 1.0;
                    Box box = new Box(minX, minY, minZ, maxX, maxY, maxZ);
                    List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, box, e -> true);
                    if (entities.isEmpty()) {
                        break;
                    }

                    targetDetected = true;

                    for (LivingEntity entity : entities) {
                        entity.serverDamage(world.getDamageSources().inFire(), 3.0F);
                    }
                    break;
                }
            }
        }

        if (state.get(POWERED) != targetDetected) {
            world.setBlockState(pos, state.with(POWERED, targetDetected), Block.NOTIFY_LISTENERS);
            world.updateNeighbors(pos, this);
        }

        world.scheduleBlockTick(pos, this, 4);
    }
}
