package net.pixeldreamstudios.mythos_bestiary.world.entity.helper;

import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;

public class AnimationDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand WALK_COMMAND = AzCommand.create(
            "base_controller",
            "walk",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand RUN_COMMAND = AzCommand.create(
            "base_controller",
            "run",
            AzPlayBehaviors.LOOP
    );

    private final Entity animatedEntity;

    public AnimationDispatcher(Entity animatable) {
        this.animatedEntity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(animatedEntity);
    }

    public void walk() {
        WALK_COMMAND.sendForEntity(animatedEntity);
    }

    public void run() {
        RUN_COMMAND.sendForEntity(animatedEntity);
    }
}
