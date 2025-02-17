package net.pixeldreamstudios.mythos_bestiary.world.entity.helper;

import mod.azure.azurelib.rewrite.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.rewrite.animation.play_behavior.AzPlayBehaviors;

public class AnimationDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand WALK_COMMAND = AzCommand.create(
            "base_controller",
            "walking",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand RUN_COMMAND = AzCommand.create(
            "base_controller",
            "running",
            AzPlayBehaviors.LOOP
    );

}
