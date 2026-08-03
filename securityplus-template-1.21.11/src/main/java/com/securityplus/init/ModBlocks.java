package com.securityplus.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // Block Definitions
    public static final Block SENTRY_TURRET = register("sentry_turret",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block DISRUPTABLE_REDSTONE = register("disruptable_redstone",
            new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_WIRE)));

    public static final Block MOTION_SENSOR = register("motion_sensor",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSERVER)));

    public static final Block ELECTRIC_FENCE = register("electric_fence",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));

    public static final Block ALARM_SIREN = register("alarm_siren",
            new Block(AbstractBlock.Settings.copy(Blocks.NOTE_BLOCK)));

    public static final Block LASER_GRID = register("laser_grid",
            new Block(AbstractBlock.Settings.copy(Blocks.GLASS)));

    public static final Block SPIKE_TRAP = register("spike_trap",
            new Block(AbstractBlock.Settings.copy(Blocks.POINTED_DRIPSTONE)));

    public static final Block KEYPAD = register("keypad",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)));

    public static final Block RETINAL_SCANNER = register("retinal_scanner",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSERVER)));

    public static final Block LOCKDOWN_LEVER = register("lockdown_lever",
            new Block(AbstractBlock.Settings.copy(Blocks.LEVER)));

    public static final Block PANIC_BUTTON = register("panic_button",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)));

    public static final Block LOCKDOWN_DOOR = register("lockdown_door",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

    public static final Block LOCKDOWN_SHUTTER = register("lockdown_shutter",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));

    public static final Block LOCKDOWN_WALL = register("lockdown_wall",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));

    public static final Block REINFORCED_STONE = register("reinforced_stone",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block REINFORCED_OBSIDIAN = register("reinforced_obsidian",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));

    public static final Block REINFORCED_IRON_BARS = register("reinforced_iron_bars",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));

    /**
     * Helper method to register blocks with Fabric's registry.
     */
    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of("securityplus", name), block);
    }

    /**
     * Call this method in your ModInitializer (e.g., SecurityPlus.onInitialize()) 
     * to trigger static class loading and register all blocks.
     */
    public static void registerModBlocks() {
        // Triggers static initialization
    }
}
