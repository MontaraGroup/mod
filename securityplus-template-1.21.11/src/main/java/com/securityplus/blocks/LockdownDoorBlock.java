package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class LockdownDoorBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty OPEN = Properties.OPEN;

    public LockdownDoorBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false).with(OPEN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED, OPEN);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient()) {
            boolean hasSignal = world.isReceivingRedstonePower(pos);
            if (state.get(POWERED) != hasSignal) {
                if (hasSignal) {
                    world.setBlockState(pos, state.with(POWERED, true).with(OPEN, false), Block.NOTIFY_LISTENERS);
                    world.playSound(null, pos, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 0.8F);
                } else {
                    world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            if (state.get(POWERED)) {
                player.sendMessage(Text.literal("§c[SEALED] Lockdown Door cannot be opened while Lockdown is active!"), true);
                return ActionResult.FAIL;
            }

            boolean open = !state.get(OPEN);
            world.setBlockState(pos, state.with(OPEN, open), Block.NOTIFY_LISTENERS);
            world.playSound(null, pos, open ? SoundEvents.BLOCK_IRON_DOOR_OPEN : SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return ActionResult.SUCCESS;
    }
}
