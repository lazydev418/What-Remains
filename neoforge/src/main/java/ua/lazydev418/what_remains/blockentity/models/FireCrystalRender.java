package ua.lazydev418.what_remains.blockentity.models;

import com.geckolib.renderer.GeoBlockRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import ua.lazydev418.what_remains.blockentity.custom.FireCrystalBlockEntity;

public class FireCrystalRender<R extends BlockEntityRenderState & GeoRenderState>
        extends GeoBlockRenderer<FireCrystalBlockEntity, R> {
    public FireCrystalRender(BlockEntityRendererProvider.Context context) {
        super(context, new FireCrystalModel());
    }
}


