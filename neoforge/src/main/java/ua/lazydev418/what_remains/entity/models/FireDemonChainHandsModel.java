package ua.lazydev418.what_remains.entity.models;


import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;
import ua.lazydev418.what_remains.entity.custom.FireDemonChainHandsEntity;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.util.Constants;

public class FireDemonChainHandsModel extends GeoModel<FireDemonChainHandsEntity> {
    private final Identifier modelPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_demon_chain_hands");
    // Looks for an animations file at '/assets/examplemod/geckolib/animations/example_entity.animation.json'
    private final Identifier animationsPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_demon_chain_hands");
    // Looks for a texture file at '/assets/examplemod/textures/example_entity.png'
    private final Identifier texturePath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/entity/fire_demon_chain_hands.png");

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return this.modelPath;
    }

    @Override
    public Identifier getAnimationResource(FireDemonChainHandsEntity animatable) {
        return this.animationsPath;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return this.texturePath;
    }
}
