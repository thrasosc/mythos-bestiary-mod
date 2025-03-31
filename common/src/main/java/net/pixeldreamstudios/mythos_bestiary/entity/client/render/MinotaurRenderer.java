package net.pixeldreamstudios.mythos_bestiary.entity.client.render;

import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.entity.animator.MinotaurAnimator;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Minotaur;

public class MinotaurRenderer extends AzEntityRenderer<Minotaur> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "geo/entity/minotaur.geo.json"
    );
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "textures/entity/minotaur.png"
    );

    public MinotaurRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<Minotaur>builder(MODEL, TEXTURE)
                        .setAnimatorProvider(MinotaurAnimator::new)
                        .setDeathMaxRotation(0.0F)
                        .build(),
                context
        );
        this.shadowRadius = 1.0F;
    }
}
