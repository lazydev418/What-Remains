package ua.lazydev418.what_remains.registry.blockentity.custom;

import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.GeoBlockEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.animation.object.PlayState;
import com.geckolib.constant.DefaultAnimations;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ua.lazydev418.what_remains.registry.blockentity.ModBlockEntities;

public class FireCrystalBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public FireCrystalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FIRE_CRYSTAL_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(DefaultAnimations.genericWalkIdleController());
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
