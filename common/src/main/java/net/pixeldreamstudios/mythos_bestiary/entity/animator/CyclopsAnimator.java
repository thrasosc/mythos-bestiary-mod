package net.pixeldreamstudios.mythos_bestiary.entity.animator;

import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.controller.keyframe.AzKeyframeCallbacks;
import mod.azure.azurelib.rewrite.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Cyclops;
import org.jetbrains.annotations.NotNull;

public class CyclopsAnimator extends AzEntityAnimator<Cyclops> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID,
            "animations/entity/cyclops.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<Cyclops> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .setKeyframeCallbacks(
                                AzKeyframeCallbacks.<Cyclops>builder()
                                        .setSoundKeyframeHandler(
                                                event -> {
                                                    if (event.getKeyframeData().getSound().equals("step")) {
                                                        event.getAnimatable()
                                                                .level()
                                                                .playLocalSound(
                                                                        event.getAnimatable().getX(),
                                                                        event.getAnimatable().getY(),
                                                                        event.getAnimatable().getZ(),
                                                                        SoundEvents.RAVAGER_STEP,
                                                                        SoundSource.HOSTILE,
                                                                        1.0F, //volume
                                                                        0.5F, //pitch
                                                                        true //should have distance delay
                                                                );
                                                    }
                                                }
                                        )
                                        .build()
                        )
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(Cyclops animatable) {
        return ANIMATIONS;
    }
}
