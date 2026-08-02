package ua.lazydev418.what_remains.entity.models;

import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import ua.lazydev418.what_remains.entity.custom.FireDemonSmallEntity;

public class FireDemonSmallRender<R extends EntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<FireDemonSmallEntity, R> {

    public FireDemonSmallRender(EntityRendererProvider.Context context) {
        super(context, new FireDemonSmallModel());
        this.withRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}


