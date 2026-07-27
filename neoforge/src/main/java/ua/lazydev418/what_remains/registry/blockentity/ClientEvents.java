package ua.lazydev418.what_remains.registry.blockentity;

import com.geckolib.renderer.GeoBlockRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import ua.lazydev418.what_remains.registry.blockentity.models.FireCrystalRender;
import ua.lazydev418.what_remains.registry.entity.ModEntities;
import ua.lazydev418.what_remains.registry.entity.models.FireDemonMediumRender;
import ua.lazydev418.what_remains.registry.entity.models.FireDemonSmallRender;
import ua.lazydev418.what_remains.util.Constants;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.FIRE_CRYSTAL_BLOCK_ENTITY.get(),
                FireCrystalRender::new);

        event.registerEntityRenderer(ModEntities.FIRE_DEMON_SMALL.get(),
                FireDemonSmallRender::new);

        event.registerEntityRenderer(ModEntities.FIRE_DEMON_MEDIUM.get(),
                FireDemonMediumRender::new);
    }
}
