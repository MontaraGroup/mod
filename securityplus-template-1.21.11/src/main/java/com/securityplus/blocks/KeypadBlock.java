package com.securityplus.blocks;

import com.securityplus.blockentity.KeypadBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class KeypadBlock extends Block implements BlockEntityProvider {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public KeypadBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KeypadBlockEntity(pos, state);
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
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient() && placer instanceof PlayerEntity player) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof KeypadBlockEntity keypad) {
                keypad.setOwner(player.getUuid().toString(), player.getName().getString());
                player.sendMessage(Text.literal("§8[§bSECURITYKEYPAD§8] §aKeypad active. Owner registered: " + player.getName().getString()), false);
            }
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof KeypadBlockEntity keypad) {
                if (!keypad.isOwnedBy(player) && !player.isCreative()) {
                    world.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), SoundCategory.BLOCKS, 1.0F, 0.5F);
                    player.sendMessage(Text.literal("§8[§cKEYPAD: ACCESS DENIED§8] §cUnauthorized User!"), true);
                    return ActionResult.FAIL;
                }

                boolean powered = !state.get(POWERED);
                world.setBlockState(pos, state.with(POWERED, powered), Block.NOTIFY_LISTENERS);
                world.updateNeighbors(pos, this);
                world.playSound(null, pos, powered ? SoundEvents.BLOCK_NOTE_BLOCK_PLING.value() : SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), SoundCategory.BLOCKS, 1.0F, 1.5F);
                player.sendMessage(Text.literal(powered ? "§8[§bKEYPAD: VERIFIED§8] §aAccess Granted - Power ON" : "§8[§bKEYPAD: VERIFIED§8] §cAccess Terminated - Power OFF"), true);
            }
        }
        return ActionResult.SUCCESS;
    }
}
