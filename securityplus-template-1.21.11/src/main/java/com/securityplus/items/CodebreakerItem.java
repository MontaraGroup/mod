package com.securityplus.items;

import com.securityplus.blockentity.KeypadBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CodebreakerItem extends Item {

    public CodebreakerItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (!world.isClient() && player != null) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof KeypadBlockEntity keypad) {
                player.sendMessage(Text.literal("Passcode: " + keypad.getPasscode()), false);
                stack.damage(1, player);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
