package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2680;

public class KeypadBlockEntity extends OwnableBlockEntity {
   private String passcode = "1234";

   public KeypadBlockEntity(class_2338 var1, class_2680 var2) {
      super(ModBlockEntities.KEYPAD_BLOCK_ENTITY, var1, var2);
   }

   public void setPasscode(String var1) {
      this.passcode = var1 != null ? var1 : "";
      this.setChanged();
   }

   public String getPasscode() {
      return this.passcode;
   }

   public boolean verifyPasscode(String var1) {
      return this.passcode.equals(var1);
   }

   public void load(class_2487 var1) {
      super.load(var1);
      if (var1.contains("Passcode")) {
         this.passcode = var1.getString("Passcode");
      }

   }

   protected void saveAdditional(class_2487 var1) {
      super.saveAdditional(var1);
      var1.putString("Passcode", this.passcode);
   }
}
