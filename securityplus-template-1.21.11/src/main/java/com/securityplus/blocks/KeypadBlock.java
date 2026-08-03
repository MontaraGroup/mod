package com.securityplus.blocks;

import com.securityplus.blockentity.KeypadBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;

public class KeypadBlock extends class_2248 implements class_2343 {
   public static final class_2746 POWERED;

   public KeypadBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public class_2586 newBlockEntity(class_2338 var1, class_2680 var2) {
      return new KeypadBlockEntity(var1, var2);
   }

   public boolean isSignalSource(class_2680 var1) {
      return true;
   }

   public int getSignal(class_2680 var1, class_1922 var2, class_2338 var3, class_2350 var4) {
      return (Boolean)var1.getValue(POWERED) ? 15 : 0;
   }

   public void setPlacedBy(class_1937 var1, class_2338 var2, class_2680 var3, class_1309 var4, class_1799 var5) {
      super.setPlacedBy(var1, var2, var3, var4, var5);
      if (!var1.isClientSide() && var4 instanceof class_1657 var6) {
         class_2586 var7 = var1.getBlockEntity(var2);
         if (var7 instanceof KeypadBlockEntity var8) {
            var8.setOwner(var6.getUUID().toString(), var6.getName().getString());
            var6.displayClientMessage(class_2561.literal("§8[§bSECURITYKEYPAD§8] §aKeypad active. Owner registered: " + var6.getName().getString()), false);
         }
      }

   }

   public class_1269 use(class_2680 var1, class_1937 var2, class_2338 var3, class_1657 var4, class_1268 var5, class_3965 var6) {
      if (!var2.isClientSide()) {
         class_2586 var7 = var2.getBlockEntity(var3);
         if (var7 instanceof KeypadBlockEntity) {
            KeypadBlockEntity var8 = (KeypadBlockEntity)var7;
            if (!var8.isOwnedBy(var4) && !var4.isCreative()) {
               var2.playSound((class_1657)null, var3, (class_3414)class_3417.NOTE_BLOCK_BASS.value(), class_3419.BLOCKS, 1.0F, 0.5F);
               var4.displayClientMessage(class_2561.literal("§8[§cKEYPAD: ACCESS DENIED§8] §cUnauthorized User!"), true);
               return class_1269.FAIL;
            }

            boolean var9 = !(Boolean)var1.getValue(POWERED);
            var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var9), 3);
            var2.updateNeighborsAt(var3, this);
            var2.playSound((class_1657)null, var3, var9 ? (class_3414)class_3417.NOTE_BLOCK_PLING.value() : (class_3414)class_3417.NOTE_BLOCK_BASS.value(), class_3419.BLOCKS, 1.0F, 1.5F);
            var4.displayClientMessage(class_2561.literal(var9 ? "§8[§bKEYPAD: VERIFIED§8] §aAccess Granted - Power ON" : "§8[§bKEYPAD: VERIFIED§8] §cAccess Terminated - Power OFF"), true);
         }
      }

      return class_1269.SUCCESS;
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
