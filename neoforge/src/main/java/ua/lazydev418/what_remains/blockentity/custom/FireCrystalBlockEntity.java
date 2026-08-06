package ua.lazydev418.what_remains.blockentity.custom;

import com.geckolib.animatable.GeoBlockEntity;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.constant.dataticket.DataTicket;
import com.google.common.reflect.TypeToken;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import ua.lazydev418.what_remains.entity.custom.FireDemonMediumEntity;
import ua.lazydev418.what_remains.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.entity.ModEntities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FireCrystalBlockEntity extends BlockEntity implements GeoBlockEntity {

    private final float maxHealth = 150.0F;
    private float health = maxHealth;

    private boolean hasSpawnedGuard = false;

    public static final DataTicket<FireCrystalBlockEntity> BLOCK_ENTITY_TICKET =
            DataTicket.create("block_entity_ticket", FireCrystalBlockEntity.class);


    private final ServerBossEvent bossEvent = new ServerBossEvent(
            UUID.randomUUID(),
            Component.literal("Кристал Вогню"),
            BossEvent.BossBarColor.RED,
            BossEvent.BossBarOverlay.PROGRESS
    );

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

    public static void tick(Level level, BlockPos pos, BlockState state, FireCrystalBlockEntity crystal) {
        if (level.isClientSide()) return;

        if (!crystal.hasSpawnedGuard && level instanceof ServerLevel serverLevel) {
            FireDemonMediumEntity guard = ModEntities.FIRE_DEMON_MEDIUM.get().spawn(serverLevel, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), EntitySpawnReason.MOB_SUMMONED);
            if (guard != null) {
                guard.bindToCrystal(pos);
                serverLevel.addFreshEntity(guard);

                crystal.hasSpawnedGuard = true;
                crystal.setChanged();
            }
        }

        crystal.bossEvent.setProgress(crystal.health / crystal.maxHealth);

        AABB searchArea = new AABB(pos).inflate(24.0);
        List<ServerPlayer> playersInRange = level.getEntitiesOfClass(ServerPlayer.class, searchArea);

        Set<ServerPlayer> currentPlayers = new HashSet<>(crystal.bossEvent.getPlayers());

        for (ServerPlayer player : playersInRange) {
            if (!currentPlayers.contains(player)) {
                crystal.bossEvent.addPlayer(player);
            }
        }

        for (ServerPlayer player : currentPlayers) {
            if (!playersInRange.contains(player)) {
                crystal.bossEvent.removePlayer(player);
            }
        }
    }

    public void dealDamage(float amount) {
        this.health -= amount;
        this.setChanged();

        if (this.level instanceof ServerLevel serverLevel) {
            double x = this.worldPosition.getX() + 0.5;
            double y = this.worldPosition.getY() + 0.5;
            double z = this.worldPosition.getZ() + 0.5;

            float randomPitch = 0.8F + serverLevel.getRandom().nextFloat() * 0.4F;
            serverLevel.playSound(
                    null,
                    this.worldPosition,
                    SoundEvents.AMETHYST_BLOCK_HIT,
                    SoundSource.BLOCKS,
                    1.0F,
                    randomPitch
            );

            serverLevel.playSound(
                    null,
                    this.worldPosition,
                    SoundEvents.FIRECHARGE_USE,
                    SoundSource.BLOCKS,
                    0.5F,
                    1.2F
            );

            serverLevel.sendParticles(ParticleTypes.FLAME, x, y, z, 12, 0.25, 0.25, 0.25, 0.05);
            serverLevel.sendParticles(ParticleTypes.LAVA, x, y, z, 4, 0.2, 0.2, 0.2, 0.0);

        }

        if (this.health <= 0) {
            this.destroyCrystal();
        }
    }

    private void destroyCrystal() {
        this.bossEvent.removeAllPlayers();

        if (this.level instanceof ServerLevel serverLevel) {
            double x = this.worldPosition.getX() + 0.5;
            double y = this.worldPosition.getY() + 0.5;
            double z = this.worldPosition.getZ() + 0.5;

            serverLevel.playSound(null, this.worldPosition, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 0.1F, 0.4F);
            serverLevel.playSound(null, this.worldPosition, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.BLOCKS, 0.8F, 1.2F);

            serverLevel.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 1, 0, 0, 0, 0);
            serverLevel.sendParticles(ParticleTypes.LAVA, x, y, z, 25, 0.5, 0.5, 0.5, 0.15);
            serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 15, 0.3, 0.4, 0.3, 0.05);

            this.level.removeBlock(this.worldPosition, false);

            // Next logic for Boss..

        }
    }

    @Override
    public void setRemoved() {
        this.bossEvent.removeAllPlayers();
        super.setRemoved();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putFloat("Health", this.health);
        output.putBoolean("HasSpawnedGuard", this.hasSpawnedGuard);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.health = input.getFloatOr("Health", this.health);
        this.hasSpawnedGuard = input.getBooleanOr("HasSpawnedGuard", false);
    }

    public float getHealth() {
        return this.health;
    }

    public float getMaxHealth() {
        return this.maxHealth;
    }
}
