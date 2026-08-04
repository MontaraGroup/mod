package com.securityplus.init;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // Register items using item factories (e.g., Item::new or CustomItem::new)
    public static final Item KEYCARD = register("keycard", Item::new, new Item.Settings());
    public static final Item KEYCARD_HOLDER = register("keycard_holder", Item::new, new Item.Settings());
    // (Add any other mod items following this same format)

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("securityplus", name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static void registerModItems() {}
}
