package com.securityplus.init;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item UNIVERSAL_BLOCK_REMOVER = register("universal_block_remover",
            new Item(new Item.Settings().maxCount(1)));

    public static final Item UNIVERSAL_OWNER_CHANGER = register("universal_owner_changer",
            new Item(new Item.Settings().maxCount(1)));

    public static final Item CODEBREAKER = register("codebreaker",
            new Item(new Item.Settings().maxCount(5)));

    public static final Item SENTRY_TURRET = register("sentry_turret",
            new Item(new Item.Settings()));

    public static final Item DISRUPTABLE_REDSTONE = register("disruptable_redstone",
            new Item(new Item.Settings()));

    public static final Item LOCKDOWN_LEVER = register("lockdown_lever",
            new Item(new Item.Settings()));

    public static final Item PANIC_BUTTON = register("panic_button",
            new Item(new Item.Settings()));

    public static final Item LOCKDOWN_DOOR = register("lockdown_door",
            new Item(new Item.Settings()));

    public static final Item LOCKDOWN_SHUTTER = register("lockdown_shutter",
            new Item(new Item.Settings()));

    public static final Item LOCKDOWN_WALL = register("lockdown_wall",
            new Item(new Item.Settings()));

    public static final Item MOTION_SENSOR = register("motion_sensor",
            new Item(new Item.Settings()));

    public static final Item ELECTRIC_FENCE = register("electric_fence",
            new Item(new Item.Settings()));

    public static final Item ALARM_SIREN = register("alarm_siren",
            new Item(new Item.Settings()));

    public static final Item LASER_GRID = register("laser_grid",
            new Item(new Item.Settings()));

    public static final Item SPIKE_TRAP = register("spike_trap",
            new Item(new Item.Settings()));

    public static final Item KEYPAD = register("keypad",
            new Item(new Item.Settings()));

    public static final Item RETINAL_SCANNER = register("retinal_scanner",
            new Item(new Item.Settings()));

    public static final Item REINFORCED_STONE = register("reinforced_stone",
            new Item(new Item.Settings()));

    public static final Item REINFORCED_OBSIDIAN = register("reinforced_obsidian",
            new Item(new Item.Settings()));

    public static final Item REINFORCED_IRON_BARS = register("reinforced_iron_bars",
            new Item(new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of("securityplus", name), item);
    }

    public static void registerModItems() {
        // Triggers static initialization
    }
}
