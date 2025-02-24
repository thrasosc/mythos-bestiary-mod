package net.pixeldreamstudios.mythos_bestiary.world.entity.client.render;

import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.world.entity.animator.SatyrAnimator;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Satyr;

public class SatyrRenderer extends AzEntityRenderer<Satyr> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "geo/entity/satyr.geo.json"
    );
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "textures/entity/satyr/satyr_1.png"
    );

    public SatyrRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<Satyr>builder(MODEL, TEXTURE)
                        .setAnimatorProvider(SatyrAnimator::new)
                        .setDeathMaxRotation(0.0F)
                        .build(),
                context
        );
        this.shadowRadius = 0.5f;
    }
}
