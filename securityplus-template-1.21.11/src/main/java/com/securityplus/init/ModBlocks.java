package com.securityplus.init;

import com.securityplus.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block REINFORCED_BLOCK = register("reinforced_block", new ReinforcedBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block KEYPAD_BLOCK = register("keypad_block", new KeypadBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block LOCKDOWN_LEVER_BLOCK = register("lockdown_lever_block", new LockdownLeverBlock(AbstractBlock.Settings.copy(Blocks.LEVER)));
    public static final Block SENTRY_TURRET_BLOCK = register("sentry_turret_block", new SentryTurretBlock(AbstractBlock.Settings.copy(Blocks.DISPENSER)));
    public static final Block LOCKDOWN_DOOR = register("lockdown_door", new LockdownDoorBlock(AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block ALARM_SIREN = register("alarm_siren", new AlarmSirenBlock(AbstractBlock.Settings.copy(Blocks.NOTE_BLOCK)));
    public static final Block LASER_GRID = register("laser_grid", new LaserGridBlock(AbstractBlock.Settings.copy(Blocks.GLASS)));
    public static final Block RETINAL_SCANNER = register("retinal_scanner", new RetinalScannerBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block MOTION_SENSOR = register("motion_sensor", new MotionSensorBlock(AbstractBlock.Settings.copy(Blocks.DAYLIGHT_DETECTOR)));
    public static final Block ELECTRIC_FENCE = register("electric_fence", new ElectricFenceBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));
    public static final Block LOCKDOWN_WALL = register("lockdown_wall", new LockdownWallBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));
    public static final Block LOCKDOWN_SHUTTER = register("lockdown_shutter", new LockdownShutterBlock(AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block PANIC_BUTTON = register("panic_button", new PanicButtonBlock(AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)));

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of("securityplus", name), block);
    }

    public static void registerModBlocks() {}
}
