package net.pixeldreamstudios.mythos_bestiary.world.entity.client.render;

import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.world.entity.animator.CyclopsAnimator;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Cyclops;

public class CyclopsRenderer extends AzEntityRenderer<Cyclops> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "geo/entity/cyclops.geo.json"
    );
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "textures/entity/cyclops.png"
    );

    public CyclopsRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<Cyclops>builder(MODEL, TEXTURE)
                        .setAnimatorProvider(CyclopsAnimator::new)
                        .setDeathMaxRotation(0.0F)
                        .build(),
                context
        );
        this.shadowRadius = 0.5f;
    }
}
