package ua.lazydev418.what_remains.registry.blockentity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.registry.block.ModBlocks;
import ua.lazydev418.what_remains.registry.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.registry.blockentity.custom.RuinsFireBlockEntity;
import ua.lazydev418.what_remains.util.Constants;

import java.awt.*;
import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);

    public static final Supplier<BlockEntityType<FireCrystalBlockEntity>> FIRE_CRYSTAL_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "fire_crystal_block_entity",
            () -> new BlockEntityType<>(
                    FireCrystalBlockEntity::new,
                    false,
                    ModBlocks.FIRE_CRYSTAL.get()
            ));
    public static final Supplier<BlockEntityType<RuinsFireBlockEntity>> RUINS_FIRE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "ruins_fire_block_entity",
            () -> new BlockEntityType<>(
                    RuinsFireBlockEntity::new,
                    false,
                    ModBlocks.RUINS_FIRE.get()
            ));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
