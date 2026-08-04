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
            world.setBlockState(pos, state.with(POWERED, powered), Block.NOTIFY_LISTENERS);
            world.updateNeighbors(pos, this);
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
}
