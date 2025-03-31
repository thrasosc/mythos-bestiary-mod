package net.pixeldreamstudios.mythos_bestiary.entity.mythical;

import mod.azure.azurelib.rewrite.util.MoveAnalysis;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.mythos_bestiary.entity.helper.AnimationDispatcher;

public abstract class AbstractMythicalMob extends PathfinderMob {
    public final AnimationDispatcher animationDispatcher;
    public final MoveAnalysis moveAnalysis;

    protected AbstractMythicalMob(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.animationDispatcher = new AnimationDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.5));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        moveAnalysis.update();

        if (this.level().isClientSide) {
            var isMovingOnGround = moveAnalysis.isMovingHorizontally() && onGround();
            Runnable animationRunner;
            if (isMovingOnGround) {
                if (this.isAggressive()) {
                    animationRunner = animationDispatcher::run;
                } else {
                    animationRunner = animationDispatcher::walk;
                }
            } else {
                animationRunner = animationDispatcher::idle;
            }
            animationRunner.run();
        }
    }
}
