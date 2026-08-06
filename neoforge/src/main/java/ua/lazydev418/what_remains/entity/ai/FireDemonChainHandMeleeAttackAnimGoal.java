package ua.lazydev418.what_remains.entity.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import ua.lazydev418.what_remains.entity.custom.FireDemonChainHandsEntity;
import ua.lazydev418.what_remains.util.Constants;

import java.util.concurrent.ThreadLocalRandom;

public class FireDemonChainHandMeleeAttackAnimGoal extends MeleeAttackGoal {

    private final FireDemonChainHandsEntity mob;

    public FireDemonChainHandMeleeAttackAnimGoal(FireDemonChainHandsEntity mob) {
        super(mob, 1,true);
        this.mob = mob;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.canPerformAttack(target)) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(getServerLevel(this.mob), target);

            if (ThreadLocalRandom.current().nextBoolean()) {
                this.mob.triggerAnim("Actions","attack_left");
            } else {
                this.mob.triggerAnim("Actions","attack_right");
            }
            //TODO додати затримку перед анімацією

            Constants.LOGGER.info("Goal triggered");
        }
    }
}