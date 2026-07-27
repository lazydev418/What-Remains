package ua.lazydev418.what_remains.registry.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.WhatRemains;
import ua.lazydev418.what_remains.registry.block.custom.FireCrystal;
import ua.lazydev418.what_remains.registry.block.custom.ModFacing;
import ua.lazydev418.what_remains.registry.block.custom.RuinsFire;
import ua.lazydev418.what_remains.registry.block.custom.TallTorchBlock;
import ua.lazydev418.what_remains.registry.item.ModItems;
import ua.lazydev418.what_remains.util.Constants;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Constants.MOD_ID);

    public static final DeferredBlock<Block> RUINS_BRICKS = registerBlock("ruins_bricks", properties
            -> new Block(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_SLAB = registerBlock("ruins_bricks_slab", properties
            -> new SlabBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_STAIRS = registerBlock("ruins_bricks_stairs",
            properties -> new StairBlock(ModBlocks.RUINS_BRICKS.get().defaultBlockState(),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_WALL = registerBlock("ruins_bricks_wall", properties
            -> new WallBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));



    public static final DeferredBlock<Block> RUINS_BRICKS_CRACKED = registerBlock("ruins_bricks_cracked", properties
            -> new Block(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_CRACKED_SLAB = registerBlock("ruins_bricks_cracked_slab", properties
            -> new SlabBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_CRACKED_STAIRS = registerBlock("ruins_bricks_cracked_stairs",
            properties -> new StairBlock(ModBlocks.RUINS_BRICKS.get().defaultBlockState(),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_CRACKED_WALL = registerBlock("ruins_bricks_cracked_wall", properties
            -> new WallBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));



    public static final DeferredBlock<Block> RUINS_BRICKS_MOSSY = registerBlock("ruins_bricks_mossy", properties
            -> new Block(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_MOSSY_SLAB = registerBlock("ruins_bricks_mossy_slab", properties
            -> new SlabBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_MOSSY_STAIRS = registerBlock("ruins_bricks_mossy_stairs",
            properties -> new StairBlock(ModBlocks.RUINS_BRICKS.get().defaultBlockState(),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> RUINS_BRICKS_MOSSY_WALL = registerBlock("ruins_bricks_mossy_wall", properties
            -> new WallBlock(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));


    public static final DeferredBlock<Block> RUINS_BRICKS_POLISHED = registerBlock("ruins_bricks_polished", properties
            -> new Block(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS)));



    public static final DeferredBlock<Block> RUINS_STATUE = registerBlock("ruins_statue", properties
            -> new ModFacing(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS).noOcclusion()) {
    });

    public static final DeferredBlock<Block> RUINS_FIREPLACE_VASE = registerBlock("ruins_fireplace_vase", properties
            -> new ModFacing(copyPropsWithId(Blocks.STONE_BRICKS.properties(), Blocks.STONE_BRICKS).noOcclusion()) {
    });

    public static final DeferredBlock<Block> TALL_TORCH = registerBlock("tall_torch", properties
            -> new TallTorchBlock(copyPropsWithId(Blocks.TORCH.properties(), Blocks.TORCH).noOcclusion()) {
    });



    public static final DeferredBlock<Block> FIRE_CRYSTAL = registerBlock("fire_crystal", properties
            -> new FireCrystal(copyPropsWithId(Blocks.SEA_LANTERN.properties(), Blocks.SEA_LANTERN).noOcclusion()) {
    });

    public static final DeferredBlock<Block> RUINS_FIRE = registerBlock("ruins_fire", properties
            -> new RuinsFire(copyPropsWithId(Blocks.SEA_LANTERN.properties(), Blocks.SEA_LANTERN).noOcclusion()) {
    });



    public static final DeferredBlock<Block> SMALL_POT = registerBlock("small_pot", properties
            -> new ModFacing(copyPropsWithId(Blocks.FLOWER_POT.properties(), Blocks.FLOWER_POT).noOcclusion()) {
    });

    private static BlockBehaviour.Properties copyPropsWithId(BlockBehaviour.Properties properties, Block from) {
        return properties
                .mapColor(from.defaultMapColor())
                .sound(from.defaultBlockState().getSoundType())
                .requiresCorrectToolForDrops();
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}