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

public class MotionSensorBlock extends class_2248 {
   public static final class_2746 POWERED;

   public MotionSensorBlock(class_4970.class_2251 var1) {
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

   public int getDirectSignal(class_2680 var1, class_1922 var2, class_2338 var3, class_2350 var4) {
      return (Boolean)var1.getValue(POWERED) ? 15 : 0;
   }

   public void onPlace(class_2680 var1, class_1937 var2, class_2338 var3, class_2680 var4, boolean var5) {
      if (!var2.isClientSide()) {
         var2.scheduleTick(var3, this, 5);
      }

   }

   public void tick(class_2680 var1, class_3218 var2, class_2338 var3, class_5819 var4) {
      class_238 var5 = (new class_238(var3)).inflate((double)5.0F);
      List var6 = var2.getEntitiesOfClass(class_1309.class, var5);
      boolean var7 = !var6.isEmpty();
      if ((Boolean)var1.getValue(POWERED) != var7) {
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var7), 3);
         var2.updateNeighborsAt(var3, this);
      }

      var2.scheduleTick(var3, this, 5);
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
