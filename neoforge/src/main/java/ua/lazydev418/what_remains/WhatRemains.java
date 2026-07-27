package ua.lazydev418.what_remains;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import ua.lazydev418.what_remains.registry.CreativeTab;
import ua.lazydev418.what_remains.registry.block.ModBlocks;
import ua.lazydev418.what_remains.registry.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.registry.datagen.ModDatagen;
import ua.lazydev418.what_remains.registry.entity.ModEntities;
import ua.lazydev418.what_remains.registry.item.ModItems;
import ua.lazydev418.what_remains.registry.particle.ModParticles;
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