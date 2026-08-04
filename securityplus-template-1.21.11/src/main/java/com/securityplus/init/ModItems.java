package com.securityplus.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // Standard Items
    public static final Item KEYCARD = register("keycard", Item::new, new Item.Settings());
    public static final Item KEYCARD_HOLDER = register("keycard_holder", Item::new, new Item.Settings());

    // Block Items
    public static final Item REINFORCED_BLOCK = register("reinforced_block", 
            settings -> new BlockItem(ModBlocks.REINFORCED_BLOCK, settings), new Item.Settings());
    public static final Item KEYPAD_BLOCK = register("keypad_block", 
            settings -> new BlockItem(ModBlocks.KEYPAD_BLOCK, settings), new Item.Settings());
    public static final Item LOCKDOWN_LEVER_BLOCK = register("lockdown_lever_block", 
            settings -> new BlockItem(ModBlocks.LOCKDOWN_LEVER_BLOCK, settings), new Item.Settings());
    public static final Item SENTRY_TURRET_BLOCK = register("sentry_turret_block", 
            settings -> new BlockItem(ModBlocks.SENTRY_TURRET_BLOCK, settings), new Item.Settings());
    public static final Item LOCKDOWN_WALL = register("lockdown_wall", 
            settings -> new BlockItem(ModBlocks.LOCKDOWN_WALL, settings), new Item.Settings());
    public static final Item LOCKDOWN_DOOR = register("lockdown_door", 
            settings -> new BlockItem(ModBlocks.LOCKDOWN_DOOR, settings), new Item.Settings());
    public static final Item ALARM_SIREN = register("alarm_siren", 
            settings -> new BlockItem(ModBlocks.ALARM_SIREN, settings), new Item.Settings());
    public static final Item LASER_GRID = register("laser_grid", 
            settings -> new BlockItem(ModBlocks.LASER_GRID, settings), new Item.Settings());
    public static final Item RETINAL_SCANNER = register("retinal_scanner", 
            settings -> new BlockItem(ModBlocks.RETINAL_SCANNER, settings), new Item.Settings());
    public static final Item MOTION_SENSOR = register("motion_sensor", 
            settings -> new BlockItem(ModBlocks.MOTION_SENSOR, settings), new Item.Settings());
    public static final Item ELECTRIC_FENCE = register("electric_fence", 
            settings -> new BlockItem(ModBlocks.ELECTRIC_FENCE, settings), new Item.Settings());
    public static final Item LOCKDOWN_SHUTTER = register("lockdown_shutter", 
            settings -> new BlockItem(ModBlocks.LOCKDOWN_SHUTTER, settings), new Item.Settings());
    public static final Item PANIC_BUTTON = register("panic_button", 
            settings -> new BlockItem(ModBlocks.PANIC_BUTTON, settings), new Item.Settings());

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("securityplus", name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static void registerModItems() {}
}
