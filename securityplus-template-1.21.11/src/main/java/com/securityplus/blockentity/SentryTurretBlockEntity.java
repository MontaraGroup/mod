package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import java.util.List;
import net.minecraft.class_1309;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_7923;

public class SentryTurretBlockEntity extends OwnableBlockEntity {
   private int cooldown = 0;

   public SentryTurretBlockEntity(class_2338 var1, class_2680 var2) {
      super(ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY, var1, var2);
   }

   public static void tick(class_1937 var0, class_2338 var1, class_2680 var2, SentryTurretBlockEntity var3) {
      if (!var0.isClientSide()) {
         if (var3.cooldown > 0) {
            --var3.cooldown;
         } else {
            double var4 = (double)10.0F;
            class_238 var6 = (new class_238(var1)).inflate(var4);
            List var7 = var0.getEntitiesOfClass(class_1309.class, var6, (var1x) -> {
               if (!var1x.isSpectator() && var1x.isAlive()) {
                  if (var1x instanceof class_1657) {
                     class_1657 var2 = (class_1657)var1x;
                     return !var3.isOwnedBy(var2);
                  } else {
                     return var1x instanceof class_1588;
                  }
               } else {
                  return false;
               }
            });
            if (!var7.isEmpty()) {
               class_1309 var8 = (class_1309)var7.get(0);
               var3.fireArrow((class_3218)var0, var1, var8);
               var3.cooldown = 10;
            }

         }
      }
   }

   private void fireArrow(class_3218 var1, class_2338 var2, class_1309 var3) {
      class_1792 var4 = (class_1792)class_7923.ITEM.get(new class_2960("minecraft", "arrow"));
      class_1665 var5 = new class_1665(var1, (double)var2.getX() + (double)0.5F, (double)var2.getY() + 1.2, (double)var2.getZ() + (double)0.5F, new class_1799(var4));
      double var6 = var3.getX() - ((double)var2.getX() + (double)0.5F);
      double var8 = var3.getY((double)0.5F) - ((double)var2.getY() + 1.2);
      double var10 = var3.getZ() - ((double)var2.getZ() + (double)0.5F);
      var5.shoot(var6, var8, var10, 1.6F, 12.0F);
      var1.addFreshEntity(var5);
      var1.playSound((class_1657)null, var2, class_3417.ARROW_SHOOT, class_3419.BLOCKS, 1.0F, 1.2F);
   }
}
