package ua.lazydev418.what_remains.blockentity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ua.lazydev418.what_remains.block.custom.RuinsFire;
import ua.lazydev418.what_remains.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.particle.ModParticles;

public class RuinsFireBlockEntity extends BlockEntity {

    public RuinsFireBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUINS_FIRE_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, RuinsFireBlockEntity blockEntity) {
        if (level.getGameTime() % 2 != 0) {
            return;
        }

        SimpleParticleType particle = switch (state.getValue(RuinsFire.STATE)) {
            case 0 -> ModParticles.RUINS_FIRE_SMALL.get();
            case 1 -> ModParticles.RUINS_FIRE_MEDIUM.get();
            default -> ModParticles.RUINS_FIRE_BIG.get();
        };

        level.addParticle(
                particle,
                pos.getX() + 0.5,
                pos.getY() + 0.2,
                pos.getZ() + 0.5,
                0,
                0,
                0
        );
    }
}
