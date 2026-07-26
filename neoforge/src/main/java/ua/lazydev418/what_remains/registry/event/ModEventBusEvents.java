package ua.lazydev418.what_remains.registry.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import ua.lazydev418.what_remains.registry.particle.ModParticles;
import ua.lazydev418.what_remains.registry.particle.custom.RuinFireBigParticle;
import ua.lazydev418.what_remains.registry.particle.custom.RuinFireMediumParticle;
import ua.lazydev418.what_remains.registry.particle.custom.RuinFireSmallParticle;
import ua.lazydev418.what_remains.util.Constants;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        //event.put(ModEntities.BUTTERFLY.get(), ButterflyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(
                ModParticles.RUINS_FIRE_BIG.get(),
                RuinFireBigParticle.Provider::new
        );

        event.registerSpriteSet(
                ModParticles.RUINS_FIRE_MEDIUM.get(),
                RuinFireMediumParticle.Provider::new
        );

        event.registerSpriteSet(
                ModParticles.RUINS_FIRE_SMALL.get(),
                RuinFireSmallParticle.Provider::new
        );
    }
}
