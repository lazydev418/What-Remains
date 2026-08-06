package ua.lazydev418.what_remains.blockentity.models;

import com.geckolib.constant.DataTickets;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.LevelStem;
import net.neoforged.neoforge.attachment.AttachmentHolder;
import ua.lazydev418.what_remains.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.blockentity.models.datatickets.ModDataTickets;
import ua.lazydev418.what_remains.util.Constants;

import java.util.logging.Level;

public class FireCrystalModel extends GeoModel<FireCrystalBlockEntity> {

    private final Identifier modelPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_crystal");
    private final Identifier animationsPath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fire_crystal");

    private final Identifier texturePath = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/blockentity/fire_crystal.png");

    private final Identifier texturePathCracked1 = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/blockentity/fire_crystal_1.png");
    private final Identifier texturePathCracked2 = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/blockentity/fire_crystal_2.png");
    private final Identifier texturePathCracked3 = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/blockentity/fire_crystal_3.png");

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
        BlockEntity blockEntity = renderState.getGeckolibData(FireCrystalBlockEntity.BLOCK_ENTITY_TICKET);

        if (!(blockEntity instanceof FireCrystalBlockEntity fireCrystal)) {
            Constants.LOGGER.info("Entity not matching! {}", blockEntity);
            return this.texturePath;
        }

        float healthMax = fireCrystal.getMaxHealth();
        float health = fireCrystal.getHealth();

        //Constants.LOGGER.info("Max HP {} HP {}", healthMax, health);

        if (health >= healthMax) {
            //Constants.LOGGER.info("HP is full! {}", blockEntity);
            return this.texturePath;
        } else if (health >= healthMax * 0.6f) {
            Constants.LOGGER.info("Cracked is returned! {}", blockEntity);
            return this.texturePathCracked1;
        } else if (health >= healthMax * 0.3f) {
            Constants.LOGGER.info("Cracked is returned! {}", blockEntity);
            return this.texturePathCracked2;
        } else {
            Constants.LOGGER.info("Cracked is returned! {}", blockEntity);
            return this.texturePathCracked3;
        }
    }
}
