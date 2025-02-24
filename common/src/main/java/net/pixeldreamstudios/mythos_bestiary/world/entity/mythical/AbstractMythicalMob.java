package net.pixeldreamstudios.mythos_bestiary.world.entity.mythical;

import mod.azure.azurelib.rewrite.util.MoveAnalysis;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.mythos_bestiary.world.entity.helper.AnimationDispatcher;

public abstract class AbstractMythicalMob extends PathfinderMob {
    public final AnimationDispatcher animationDispatcher;
    public final MoveAnalysis moveAnalysis;

    protected AbstractMythicalMob(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.animationDispatcher = new AnimationDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
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
