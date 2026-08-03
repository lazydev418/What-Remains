package ua.lazydev418.what_remains.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import java.util.EnumSet;

public class StayNearCrystalGoal extends Goal {
    private final PathfinderMob mob;
    private final BlockPos crystalPos;
    private final double speedModifier;
    private final float maxDistance;

    public StayNearCrystalGoal(PathfinderMob mob, BlockPos crystalPos, double speedModifier, float maxDistance) {
        this.mob = mob;
        this.crystalPos = crystalPos;
        this.speedModifier = speedModifier;
        this.maxDistance = maxDistance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return this.mob.blockPosition().distSqr(this.crystalPos) > (this.maxDistance * this.maxDistance);
    }

    @Override
    public void start() {
        this.mob.setTarget(null);
        this.mob.getNavigation().moveTo(
                this.crystalPos.getX() + 0.5,
                this.crystalPos.getY(),
                this.crystalPos.getZ() + 0.5,
                this.speedModifier
        );
    }

    @Override
    public void tick() {
        this.mob.getLookControl().setLookAt(
                this.crystalPos.getX() + 0.5,
                this.crystalPos.getY(),
                this.crystalPos.getZ() + 0.5
        );

        if (this.mob.getNavigation().isDone()) {
            this.mob.getNavigation().moveTo(
                    this.crystalPos.getX() + 0.5,
                    this.crystalPos.getY(),
                    this.crystalPos.getZ() + 0.5,
                    this.speedModifier
            );
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.mob.blockPosition().distSqr(this.crystalPos) > 12.0;
    }
}
