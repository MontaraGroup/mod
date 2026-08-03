package com.securityplus.blocks;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4970;

public class SpikeTrapBlock extends class_2248 {
   public static final class_2746 POWERED;

   public SpikeTrapBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public void stepOn(class_1937 var1, class_2338 var2, class_2680 var3, class_1297 var4) {
      if (!var1.isClientSide() && var4 instanceof class_1309 var5) {
         var5.hurt(var1.damageSources().cactus(), 6.0F);
         var5.addEffect(new class_1293(class_1294.MOVEMENT_SLOWDOWN, 100, 3));
         var1.playSound((class_1657)null, var2, class_3417.ITEM_BREAK, class_3419.BLOCKS, 1.0F, 0.8F);
      }

      super.stepOn(var1, var2, var3, var4);
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
