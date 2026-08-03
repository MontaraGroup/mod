package com.securityplus.items;

import com.securityplus.blockentity.KeypadBlockEntity;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_5819;

public class CodebreakerItem extends class_1792 {
   public CodebreakerItem(class_1792.class_1793 var1) {
      super(var1);
   }

   public class_1269 useOn(class_1838 var1) {
      class_1937 var2 = var1.getLevel();
      class_2338 var3 = var1.getClickedPos();
      class_1657 var4 = var1.getPlayer();
      class_1799 var5 = var1.getItemInHand();
      if (!var2.isClientSide() && var4 != null) {
         class_2586 var6 = var2.getBlockEntity(var3);
         if (var6 instanceof KeypadBlockEntity) {
            class_5819 var7 = var2.getRandom();
            if (var7.nextFloat() < 0.33F) {
               class_2680 var8 = var2.getBlockState(var3);
               if (var8.hasProperty(class_2741.field_12521)) {
                  boolean var9 = !(Boolean)var8.getValue(class_2741.field_12521);
                  var2.setBlock(var3, (class_2680)var8.setValue(class_2741.field_12521, var9), 3);
                  var4.displayClientMessage(class_2561.literal("§a[Codebreaker] Hack Successful! Keypad bypassed."), true);
               }
            } else {
               var4.displayClientMessage(class_2561.literal("§c[Codebreaker] Hack Failed! Codebreaker damaged."), true);
            }

            var5.hurtAndBreak(1, var4, (var1x) -> var1x.broadcastBreakEvent(var1.getHand()));
            return class_1269.SUCCESS;
         }
      }

      return super.useOn(var1);
   }
}
