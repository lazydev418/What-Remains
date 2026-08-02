package ua.lazydev418.what_remains.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.entity.custom.FireDemonSmallEntity;
import ua.lazydev418.what_remains.util.Constants;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(Constants.MOD_ID);

    public static final Supplier<EntityType<FireDemonSmallEntity>> FIRE_DEMON_SMALL =
            ENTITY_TYPES.registerEntityType("fire_demon_small", FireDemonSmallEntity::new, MobCategory.MONSTER);

    public static final Supplier<EntityType<FireDemonMediumEntity>> FIRE_DEMON_MEDIUM =
            ENTITY_TYPES.registerEntityType("fire_demon_medium", FireDemonMediumEntity::new, MobCategory.MONSTER);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}