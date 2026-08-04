package com.securityplus.init;

import com.securityplus.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block REINFORCED_BLOCK = register("reinforced_block", ReinforcedBlock::new, AbstractBlock.Settings.copy(Blocks.OBSIDIAN));
    public static final Block KEYPAD_BLOCK = register("keypad_block", KeypadBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block LOCKDOWN_LEVER_BLOCK = register("lockdown_lever_block", LockdownLeverBlock::new, AbstractBlock.Settings.copy(Blocks.LEVER));
    public static final Block SENTRY_TURRET_BLOCK = register("sentry_turret_block", SentryTurretBlock::new, AbstractBlock.Settings.copy(Blocks.DISPENSER));
    public static final Block LOCKDOWN_DOOR = register("lockdown_door", LockdownDoorBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_DOOR));
    public static final Block ALARM_SIREN = register("alarm_siren", AlarmSirenBlock::new, AbstractBlock.Settings.copy(Blocks.NOTE_BLOCK));
    public static final Block LASER_GRID = register("laser_grid", LaserGridBlock::new, AbstractBlock.Settings.copy(Blocks.GLASS));
    public static final Block RETINAL_SCANNER = register("retinal_scanner", RetinalScannerBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block MOTION_SENSOR = register("motion_sensor", MotionSensorBlock::new, AbstractBlock.Settings.copy(Blocks.DAYLIGHT_DETECTOR));
    public static final Block ELECTRIC_FENCE = register("electric_fence", ElectricFenceBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BARS));
    public static final Block LOCKDOWN_WALL = register("lockdown_wall", LockdownWallBlock::new, AbstractBlock.Settings.copy(Blocks.OBSIDIAN));
    public static final Block LOCKDOWN_SHUTTER = register("lockdown_shutter", LockdownShutterBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_DOOR));
    public static final Block PANIC_BUTTON = register("panic_button", PanicButtonBlock::new, AbstractBlock.Settings.copy(Blocks.STONE_BUTTON));

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("securityplus", name));
        return Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
    }

    public static void registerModBlocks() {}
}
