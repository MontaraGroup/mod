package com.securityplus.blocks;

import java.util.List;
import net.minecraft.class_1309;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class LaserGridBlock extends class_2248 {
   public static final class_2746 POWERED;

   public LaserGridBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public boolean isSignalSource(class_2680 var1) {
      return true;
   }

   public int getSignal(class_2680 var1, class_1922 var2, class_2338 var3, class_2350 var4) {
      return (Boolean)var1.getValue(POWERED) ? 15 : 0;
   }

   public void onPlace(class_2680 var1, class_1937 var2, class_2338 var3, class_2680 var4, boolean var5) {
      if (!var2.isClientSide()) {
         var2.scheduleTick(var3, this, 4);
      }

   }

   public void tick(class_2680 var1, class_3218 var2, class_2338 var3, class_5819 var4) {
      boolean var5 = false;

      for(class_2350 var9 : class_2350.values()) {
         for(int var10 = 1; var10 <= 10; ++var10) {
            class_2338 var11 = var3.relative(var9, var10);
            if (var2.getBlockState(var11).is(this)) {
               double var12 = (double)Math.min(var3.getX(), var11.getX());
               double var14 = (double)Math.min(var3.getY(), var11.getY());
               double var16 = (double)Math.min(var3.getZ(), var11.getZ());
               double var18 = (double)Math.max(var3.getX(), var11.getX()) + (double)1.0F;
               double var20 = (double)Math.max(var3.getY(), var11.getY()) + (double)1.0F;
               double var22 = (double)Math.max(var3.getZ(), var11.getZ()) + (double)1.0F;
               class_238 var24 = new class_238(var12, var14, var16, var18, var20, var22);
               List var25 = var2.getEntitiesOfClass(class_1309.class, var24);
               if (var25.isEmpty()) {
                  break;
               }

               var5 = true;

               for(class_1309 var27 : var25) {
                  var27.hurt(var2.damageSources().inFire(), 3.0F);
               }
               break;
            }
         }
      }

      if ((Boolean)var1.getValue(POWERED) != var5) {
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var5), 3);
         var2.updateNeighborsAt(var3, this);
      }

      var2.scheduleTick(var3, this, 4);
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
