package ua.lazydev418.what_remains.blockentity.models.datatickets;

import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.state.ControllerState;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.constant.dataticket.OverridingDataTicket;
import com.geckolib.object.VanillaModelModifier;
import com.google.common.reflect.TypeToken;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ModDataTickets {

    public static final DataTicket<BlockEntity> BLOCK_ENTITY = DataTicket.create("block_entity", new TypeToken<BlockEntity>() {
    });

    public ModDataTickets() {
    }

    public static <D> DataTicket<D> create(String id, Class<? extends D> objectType) {
        return DataTicket.create(id, objectType);
    }

    public static <D> DataTicket<D> create(String id, TypeToken<D> token) {
        return DataTicket.create(id, token);
    }
}
