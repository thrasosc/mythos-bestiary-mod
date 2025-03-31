package net.pixeldreamstudios.mythos_bestiary.entity.animator;

import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Minotaur;
import org.jetbrains.annotations.NotNull;

public class MinotaurAnimator extends AzEntityAnimator<Minotaur> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID,
            "animations/entity/minotaur.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<Minotaur> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Minotaur animatable) {
        return ANIMATIONS;
    }
}
