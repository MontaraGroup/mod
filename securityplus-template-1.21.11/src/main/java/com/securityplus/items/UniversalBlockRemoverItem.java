package com.securityplus.items;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UniversalBlockRemoverItem extends Item {
    public UniversalBlockRemoverItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (player == null) {
            return ActionResult.PASS;
        }

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof OwnableBlockEntity ownable) {
            if (world.isClient()) {
                return ActionResult.SUCCESS;
            }

            boolean canRemove = ownable.isOwnedBy(player) || player.isCreative();

            if (canRemove) {
                world.breakBlock(pos, true, player);
                player.sendMessage(
                    Text.literal("[SECURITY] Block removed.").formatted(Formatting.GREEN),
                    true
                );
                return ActionResult.SUCCESS;
            } else {
                player.sendMessage(
                    Text.literal("[SECURITY] Access Denied: You do not own this block.").formatted(Formatting.RED),
                    true
                );
                return ActionResult.FAIL;
            }
        }

        return ActionResult.PASS;
    }
}
