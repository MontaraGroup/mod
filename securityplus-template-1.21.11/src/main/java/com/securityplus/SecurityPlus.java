package com.securityplus;

import com.securityplus.init.ModBlockEntities;
import com.securityplus.init.ModBlocks;
import com.securityplus.init.ModCreativeTabs;
import com.securityplus.init.ModItems;
import net.fabricmc.api.ModInitializer;

public class SecurityPlus implements ModInitializer {
    public static final String MOD_ID = "securityplus";

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModBlockEntities.registerBlockEntities();
        ModCreativeTabs.registerCreativeTabs();
    }
}
