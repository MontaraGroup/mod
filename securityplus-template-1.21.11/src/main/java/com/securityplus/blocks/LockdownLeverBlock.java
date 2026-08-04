package com.securityplus.blocks;

import com.securityplus.blockentity.LockdownLeverBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LockdownLeverBlock extends Block implements BlockEntityProvider {
    public static final BooleanProperty POWERED = Properties.POWERED;
    private static final int RADIUS = 32; // Wireless search radius (32 blocks in all directions)

    public LockdownLeverBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LockdownLeverBlockEntity(pos, state);
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
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            boolean powered = !state.get(POWERED);
            
            // 1. Update lever BlockState & redstone neighbors
            world.setBlockState(pos, state.with(POWERED, powered), Block.NOTIFY_LISTENERS);
            world.updateNeighbors(pos, this);

            // 2. Trigger wireless scan for all LockdownControllable blocks within range
            triggerNetwork(world, pos, powered);

            // 3. Block Entity logic, sounds, and player notifications
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof LockdownLeverBlockEntity lever) {
                if (powered) {
                    lever.triggerLockdownOn(world, pos);
                    world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 1.0F, 0.5F);
                    player.sendMessage(Text.literal("§c§l[FACILITY LOCKDOWN ACTIVATED] §rRedstone self-broken!"), false);
                } else {
                    lever.triggerLockdownOff(world, pos);
                    world.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.BLOCKS, 1.0F, 1.2F);
                    player.sendMessage(Text.literal("§a[Lockdown Deactivated] §rRedstone wires restored!"), false);
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    /**
     * Scans surrounding 32x32x32 area and updates any LockdownControllable blocks.
     */
    private void triggerNetwork(World world, BlockPos center, boolean lockdownActive) {
        BlockPos.iterate(
            center.add(-RADIUS, -RADIUS, -RADIUS),
            center.add(RADIUS, RADIUS, RADIUS)
        ).forEach(targetPos -> {
            BlockState targetState = world.getBlockState(targetPos);
            
            if (targetState.getBlock() instanceof LockdownControllable controllable) {
                controllable.setLockdownState(world, targetPos, targetState, lockdownActive);
            }
        });
    }
}
