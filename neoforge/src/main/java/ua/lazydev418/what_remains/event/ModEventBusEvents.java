package ua.lazydev418.what_remains.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import ua.lazydev418.what_remains.entity.ModEntities;
import ua.lazydev418.what_remains.entity.custom.FireDemonChainHandsEntity;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.entity.custom.FireDemonSmallEntity;
import ua.lazydev418.what_remains.particle.ModParticles;
import ua.lazydev418.what_remains.particle.custom.RuinFireBigParticle;
import ua.lazydev418.what_remains.particle.custom.RuinFireMediumParticle;
import ua.lazydev418.what_remains.particle.custom.RuinFireSmallParticle;
import ua.lazydev418.what_remains.util.Constants;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FIRE_DEMON_SMALL.get(), FireDemonSmallEntity.createAttributes().build());

        event.put(ModEntities.FIRE_DEMON_MEDIUM.get(), FireDemonMediumEntity.createAttributes().build());

        event.put(ModEntities.FIRE_DEMON_CHAIN_HANDS.get(), FireDemonChainHandsEntity.createAttributes().build());
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
