package ua.lazydev418.what_remains.registry.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import ua.lazydev418.what_remains.WhatRemains;
import ua.lazydev418.what_remains.util.Constants;

import java.util.concurrent.CompletableFuture;

public class ModDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModModelProvider::new);
    }
}