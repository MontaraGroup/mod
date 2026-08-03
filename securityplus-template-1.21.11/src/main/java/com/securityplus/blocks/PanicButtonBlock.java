package com.securityplus.blocks;

import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class PanicButtonBlock extends class_2248 {
   public static final class_2746 POWERED;

   public PanicButtonBlock(class_4970.class_2251 var1) {
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

   public class_1269 use(class_2680 var1, class_1937 var2, class_2338 var3, class_1657 var4, class_1268 var5, class_3965 var6) {
      if (!var2.isClientSide() && !(Boolean)var1.getValue(POWERED)) {
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, true), 3);
         var2.updateNeighborsAt(var3, this);
         var2.playSound((class_1657)null, var3, (class_3414)class_3417.NOTE_BLOCK_BELL.value(), class_3419.BLOCKS, 2.0F, 2.0F);
         var4.displayClientMessage(class_2561.literal("§c§lPANIC BUTTON PRESSED!"), true);
         var2.scheduleTick(var3, this, 30);
      }

      return class_1269.SUCCESS;
   }

   public void tick(class_2680 var1, class_3218 var2, class_2338 var3, class_5819 var4) {
      if ((Boolean)var1.getValue(POWERED)) {
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, false), 3);
         var2.updateNeighborsAt(var3, this);
      }

   }

   static {
      POWERED = class_2741.field_12521;
   }
}
