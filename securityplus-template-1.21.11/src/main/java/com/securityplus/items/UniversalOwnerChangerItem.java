package com.securityplus.items;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UniversalOwnerChangerItem extends Item {
    public UniversalOwnerChangerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient() && player != null) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof OwnableBlockEntity ownable) {
                ownable.setOwner(player);
                player.sendMessage(Text.literal("§a[SECURITY] Block ownership transferred to " + player.getName().getString()), true);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
