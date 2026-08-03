package ua.lazydev418.what_remains.entity.models;

import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.util.Constants;

public class FireDemonMediumModel extends GeoModel<FireDemonMediumEntity> {
    private final Identifier modelPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_demon_medium");
    private final Identifier animationsPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_demon_medium");
    private final Identifier texturePath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/entity/fire_demon_medium.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return this.modelPath;
    }

    @Override
    public Identifier getAnimationResource(FireDemonMediumEntity animatable) {
        return this.animationsPath;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return this.texturePath;
    }
}
