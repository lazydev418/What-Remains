package ua.lazydev418.what_remains.entity.models;

import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;
import com.geckolib.renderer.layer.builtin.ItemInHandGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import ua.lazydev418.what_remains.entity.custom.FireDemonChainHandsEntity;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;

public class FireDemonChainsHandsRender<R extends LivingEntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<FireDemonChainHandsEntity, R> {

    public FireDemonChainsHandsRender(EntityRendererProvider.Context context) {
        super(context, new FireDemonChainHandsModel());
        this.withRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
 

