package ua.lazydev418.what_remains.blockentity.models;

import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;
import ua.lazydev418.what_remains.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.util.Constants;

public class FireCrystalModel extends GeoModel<FireCrystalBlockEntity> {
    private final Identifier modelPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_crystal");
    private final Identifier animationsPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_crystal");
    private final Identifier texturePath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/blockentity/fire_crystal.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return this.modelPath;
    }

    @Override
    public Identifier getAnimationResource(FireCrystalBlockEntity animatable) {
        return this.animationsPath;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return this.texturePath;
    }
}
