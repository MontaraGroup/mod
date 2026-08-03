package com.securityplus.client;

import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_4185;
import net.minecraft.class_437;

public class SecurityConfigScreen extends class_437 {
   private final class_437 parent;
   private int lockdownRadius = 15;
   private int turretRange = 10;
   private int sirenVolume = 100;
   private float laserDamage = 3.0F;

   public SecurityConfigScreen(class_437 var1) {
      super(class_2561.literal("§bSecurityPlus Configuration"));
      this.parent = var1;
   }

   protected void init() {
      int var1 = this.width / 2;
      byte var2 = 60;
      this.addRenderableWidget(class_4185.builder(class_2561.literal("Lockdown Radius: " + this.lockdownRadius + " Blocks"), (var1x) -> {
         this.lockdownRadius = this.lockdownRadius == 15 ? 25 : (this.lockdownRadius == 25 ? 35 : 15);
         var1x.setMessage(class_2561.literal("Lockdown Radius: " + this.lockdownRadius + " Blocks"));
      }).bounds(var1 - 100, var2, 200, 20).build());
      this.addRenderableWidget(class_4185.builder(class_2561.literal("Sentry Turret Range: " + this.turretRange + " Blocks"), (var1x) -> {
         this.turretRange = this.turretRange == 10 ? 15 : (this.turretRange == 15 ? 20 : 10);
         var1x.setMessage(class_2561.literal("Sentry Turret Range: " + this.turretRange + " Blocks"));
      }).bounds(var1 - 100, var2 + 30, 200, 20).build());
      this.addRenderableWidget(class_4185.builder(class_2561.literal("Siren Volume: " + this.sirenVolume + "%"), (var1x) -> {
         this.sirenVolume = this.sirenVolume == 100 ? 50 : (this.sirenVolume == 50 ? 0 : 100);
         String var10001 = this.sirenVolume == 0 ? "MUTED" : this.sirenVolume + "%";
         var1x.setMessage(class_2561.literal("Siren Volume: " + var10001));
      }).bounds(var1 - 100, var2 + 60, 200, 20).build());
      this.addRenderableWidget(class_4185.builder(class_2561.literal("Laser Damage: " + this.laserDamage + " HP"), (var1x) -> {
         this.laserDamage = this.laserDamage == 3.0F ? 5.0F : (this.laserDamage == 5.0F ? 10.0F : 3.0F);
         var1x.setMessage(class_2561.literal("Laser Damage: " + this.laserDamage + " HP"));
      }).bounds(var1 - 100, var2 + 90, 200, 20).build());
      this.addRenderableWidget(class_4185.builder(class_2561.literal("Done"), (var1x) -> {
         if (this.minecraft != null) {
            this.minecraft.setScreen(this.parent);
         }

      }).bounds(var1 - 100, var2 + 140, 200, 20).build());
   }

   public void render(class_332 var1, int var2, int var3, float var4) {
      this.renderBackground(var1, var2, var3, var4);
      var1.drawCenteredString(this.font, this.title, this.width / 2, 25, 16777215);
      super.render(var1, var2, var3, var4);
   }
}
