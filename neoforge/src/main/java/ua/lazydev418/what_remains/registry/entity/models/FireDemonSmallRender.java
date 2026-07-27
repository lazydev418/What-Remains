package ua.lazydev418.what_remains.registry.entity.models;

import com.geckolib.renderer.GeoBlockRenderer;
import com.geckolib.renderer.GeoEntityRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.layer.builtin.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import ua.lazydev418.what_remains.registry.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.registry.entity.custom.FireDemonSmallEntity;

public class FireDemonSmallRender<R extends EntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<FireDemonSmallEntity, R> {

    public FireDemonSmallRender(EntityRendererProvider.Context context) {
        super(context, new FireDemonSmallModel());
        this.withRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}


