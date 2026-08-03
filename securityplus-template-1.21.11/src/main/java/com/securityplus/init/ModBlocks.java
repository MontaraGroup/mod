package com.securityplus.init;

import com.securityplus.blocks.AlarmSirenBlock;
import com.securityplus.blocks.DisruptableRedstoneBlock;
import com.securityplus.blocks.ElectricFenceBlock;
import com.securityplus.blocks.KeypadBlock;
import com.securityplus.blocks.LaserGridBlock;
import com.securityplus.blocks.LockdownDoorBlock;
import com.securityplus.blocks.LockdownLeverBlock;
import com.securityplus.blocks.LockdownShutterBlock;
import com.securityplus.blocks.LockdownWallBlock;
import com.securityplus.blocks.MotionSensorBlock;
import com.securityplus.blocks.PanicButtonBlock;
import com.securityplus.blocks.ReinforcedBlock;
import com.securityplus.blocks.RetinalScannerBlock;
import com.securityplus.blocks.SentryTurretBlock;
import com.securityplus.blocks.SpikeTrapBlock;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_4970.class_2251;

public class ModBlocks {
   public static final class_2248 SENTRY_TURRET;
   public static final class_2248 DISRUPTABLE_REDSTONE;
   public static final class_2248 MOTION_SENSOR;
   public static final class_2248 ELECTRIC_FENCE;
   public static final class_2248 ALARM_SIREN;
   public static final class_2248 LASER_GRID;
   public static final class_2248 SPIKE_TRAP;
   public static final class_2248 KEYPAD;
   public static final class_2248 RETINAL_SCANNER;
   public static final class_2248 LOCKDOWN_LEVER;
   public static final class_2248 PANIC_BUTTON;
   public static final class_2248 LOCKDOWN_DOOR;
   public static final class_2248 LOCKDOWN_SHUTTER;
   public static final class_2248 LOCKDOWN_WALL;
   public static final class_2248 REINFORCED_STONE;
   public static final class_2248 REINFORCED_OBSIDIAN;
   public static final class_2248 REINFORCED_IRON_BARS;

   private static class_2248 register(String var0, class_2248 var1) {
      return (class_2248)class_2378.register(class_7923.BLOCK, new class_2960("securityplus", var0), var1);
   }

   public static void registerModBlocks() {
   }

   static {
      SENTRY_TURRET = register("sentry_turret", new SentryTurretBlock(class_2251.ofFullCopy(class_2246.field_10540).method_9628(6.0F)));
      DISRUPTABLE_REDSTONE = register("disruptable_redstone", new DisruptableRedstoneBlock(class_2251.ofFullCopy(class_2246.field_10382).method_9618().method_9624()));
      MOTION_SENSOR = register("motion_sensor", new MotionSensorBlock(class_2251.ofFullCopy(class_2246.field_10526).method_9628(3.5F)));
      ELECTRIC_FENCE = register("electric_fence", new ElectricFenceBlock(class_2251.ofFullCopy(class_2246.field_10418).method_9628(4.0F).method_22488()));
      ALARM_SIREN = register("alarm_siren", new AlarmSirenBlock(class_2251.ofFullCopy(class_2246.field_10571).method_9628(3.0F)));
      LASER_GRID = register("laser_grid", new LaserGridBlock(class_2251.ofFullCopy(class_2246.field_10540).method_9628(5.0F).method_22488()));
      SPIKE_TRAP = register("spike_trap", new SpikeTrapBlock(class_2251.ofFullCopy(class_2246.field_10340).method_9628(3.5F)));
      KEYPAD = register("keypad", new KeypadBlock(class_2251.ofFullCopy(class_2246.field_10540).method_9628(4.0F)));
      RETINAL_SCANNER = register("retinal_scanner", new RetinalScannerBlock(class_2251.ofFullCopy(class_2246.field_10526).method_9628(4.5F)));
      LOCKDOWN_LEVER = register("lockdown_lever", new LockdownLeverBlock(class_2251.ofFullCopy(class_2246.field_10084).method_9628(5.0F)));
      PANIC_BUTTON = register("panic_button", new PanicButtonBlock(class_2251.ofFullCopy(class_2246.field_10204).method_9628(4.0F)));
      LOCKDOWN_DOOR = register("lockdown_door", new LockdownDoorBlock(class_2251.ofFullCopy(class_2246.field_10539).method_9629(50.0F, 1200.0F)));
      LOCKDOWN_SHUTTER = register("lockdown_shutter", new LockdownShutterBlock(class_2251.ofFullCopy(class_2246.field_10418).method_9629(50.0F, 1200.0F).method_22488()));
      LOCKDOWN_WALL = register("lockdown_wall", new LockdownWallBlock(class_2251.ofFullCopy(class_2246.field_10526).method_9629(50.0F, 1200.0F)));
      REINFORCED_STONE = register("reinforced_stone", new ReinforcedBlock(class_2251.ofFullCopy(class_2246.field_10340).method_9629(50.0F, 1200.0F)));
      REINFORCED_OBSIDIAN = register("reinforced_obsidian", new ReinforcedBlock(class_2251.ofFullCopy(class_2246.field_10526).method_9629(100.0F, 1200.0F)));
      REINFORCED_IRON_BARS = register("reinforced_iron_bars", new ReinforcedBlock(class_2251.ofFullCopy(class_2246.field_10418).method_9629(50.0F, 1200.0F).method_22488()));
   }
}
