package ua.lazydev418.what_remains.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.util.Constants;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Constants.MOD_ID);

    public static final Supplier<SimpleParticleType> RUINS_FIRE_BIG =
            PARTICLE_TYPES.register("ruins_fire_big", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> RUINS_FIRE_MEDIUM =
            PARTICLE_TYPES.register("ruins_fire_medium", () -> new SimpleParticleType(true));

    public static final Supplier<SimpleParticleType> RUINS_FIRE_SMALL =
            PARTICLE_TYPES.register("ruins_fire_small", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}