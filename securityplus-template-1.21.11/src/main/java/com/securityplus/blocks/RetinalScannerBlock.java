package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RetinalScannerBlock extends Block implements BlockEntityProvider {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public RetinalScannerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OwnableBlockEntity(ModBlockEntities.OWNABLE_BLOCK_ENTITY, pos, state);
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
            if (be instanceof OwnableBlockEntity ownable) {
                ownable.setOwner(player.getUuid().toString(), player.getName().getString());
            }
        }
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 5);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity be = world.getBlockEntity(pos);
        boolean ownerNearby = false;
        PlayerEntity ownerPlayer = null;

        if (be instanceof OwnableBlockEntity ownable) {
            Box box = new Box(pos).expand(3.0);
            for (PlayerEntity player : world.getEntitiesOfClass(PlayerEntity.class, box)) {
                if (ownable.isOwnedBy(player)) {
                    ownerNearby = true;
                    ownerPlayer = player;
                    break;
                }
            }
        }

        if (state.get(POWERED) != ownerNearby) {
            world.setBlockState(pos, state.with(POWERED, ownerNearby), Block.NOTIFY_LISTENERS);
            world.updateNeighbors(pos, this);
            if (ownerNearby && ownerPlayer != null) {
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 0.8F, 1.8F);
                ownerPlayer.sendMessage(Text.literal("§8[§aRETINA: RECOGNIZED§8] §aBiometric Verification Confirmed: " + ownerPlayer.getName().getString()), true);
            }
        }

        world.scheduleBlockTick(pos, this, 5);
    }
}
