package ua.lazydev418.what_remains;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import ua.lazydev418.what_remains.registry.CreativeTab;
import ua.lazydev418.what_remains.block.ModBlocks;
import ua.lazydev418.what_remains.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.datagen.ModDatagen;
import ua.lazydev418.what_remains.entity.ModEntities;
import ua.lazydev418.what_remains.item.ModItems;
import ua.lazydev418.what_remains.particle.ModParticles;
import ua.lazydev418.what_remains.util.Constants;

@Mod(Constants.MOD_ID)
public class WhatRemains {
    public WhatRemains(IEventBus eventBus) {
        CreativeTab.register(eventBus);

        ModItems.register(eventBus);

        ModBlocks.register(eventBus);

        ModParticles.register(eventBus);

        ModBlockEntities.register(eventBus);

        ModEntities.register(eventBus);

        eventBus.addListener(ModDatagen::gatherData);
    }
}