package ua.lazydev418.what_remains;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import ua.lazydev418.what_remains.registry.CreativeTab;
import ua.lazydev418.what_remains.util.Constants;

@Mod(Constants.MOD_ID)
public class WhatRemains {
    public WhatRemains(IEventBus eventBus) {
        CreativeTab.register(eventBus);
        Constants.LOGGER.info("Йо, Святе.");
    }
}