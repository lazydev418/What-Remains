package ua.lazydev418.what_remains.blockentity.models;

import com.geckolib.renderer.GeoBlockRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import ua.lazydev418.what_remains.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.util.Constants;

import javax.annotation.Nullable;

public class FireCrystalRender<R extends BlockEntityRenderState & GeoRenderState>
        extends GeoBlockRenderer<FireCrystalBlockEntity, R> {
    public FireCrystalRender(BlockEntityRendererProvider.Context context) {
        super(context, new FireCrystalModel());
    }

    @Override
    public void addRenderData(FireCrystalBlockEntity animatable, @Nullable Void relatedObject, R renderState, float partialTick) {
        super.addRenderData(animatable, relatedObject, renderState, partialTick);

        renderState.addGeckolibData(FireCrystalBlockEntity.BLOCK_ENTITY_TICKET, animatable);

        Constants.LOGGER.info("Entity updated! {}", animatable.getHealth());
    }
}


