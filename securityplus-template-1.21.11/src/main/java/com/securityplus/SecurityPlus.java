package com.securityplus;

import com.securityplus.init.ModBlockEntities;
import com.securityplus.init.ModBlocks;
import com.securityplus.init.ModCreativeTabs;
import com.securityplus.init.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityPlus implements ModInitializer {
    public static final String MOD_ID = "securityplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModBlockEntities.registerBlockEntities();
        ModCreativeTabs.registerCreativeTabs();

        LOGGER.info("SecurityPlus initialized successfully!");
    }
}
