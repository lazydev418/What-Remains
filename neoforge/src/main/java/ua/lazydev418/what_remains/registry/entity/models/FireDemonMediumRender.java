package ua.lazydev418.what_remains.registry.entity.models;

import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;
import com.geckolib.renderer.layer.builtin.ItemInHandGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import ua.lazydev418.what_remains.registry.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.registry.entity.custom.FireDemonSmallEntity;

public class FireDemonMediumRender<R extends LivingEntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<FireDemonMediumEntity, R> {

    public FireDemonMediumRender(EntityRendererProvider.Context context) {
        super(context, new FireDemonMediumModel());
        this.withRenderLayer(new AutoGlowingGeoLayer<>(this));
        this.withRenderLayer(new ItemInHandGeoLayer<>(context, this));
    }
}


