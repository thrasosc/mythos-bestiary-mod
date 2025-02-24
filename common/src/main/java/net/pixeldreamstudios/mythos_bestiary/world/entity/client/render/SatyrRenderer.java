package net.pixeldreamstudios.mythos_bestiary.world.entity.client.render;

import com.google.common.collect.Maps;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRenderer;
import mod.azure.azurelib.rewrite.render.entity.AzEntityRendererConfig;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.world.entity.animator.SatyrAnimator;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Satyr;
import net.pixeldreamstudios.mythos_bestiary.world.entity.variant.SatyrVariant;

import java.util.Map;

public class SatyrRenderer extends AzEntityRenderer<Satyr> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            MythosBestiary.MOD_ID, "geo/entity/satyr.geo.json"
    );
    public static final Map<SatyrVariant, ResourceLocation> TEXTURE_VARIANTS =
            Util.make(Maps.newEnumMap(SatyrVariant.class), (map) -> {
                map.put(SatyrVariant.SATYR_1, ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "textures/entity/satyr/satyr_1.png"));
                map.put(SatyrVariant.SATYR_2, ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "textures/entity/satyr/satyr_2.png"));
                map.put(SatyrVariant.SATYR_3, ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "textures/entity/satyr/satyr_3.png"));
            });

    public SatyrRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<Satyr>builder(satyr -> MODEL, satyr -> TEXTURE_VARIANTS.get(satyr.getVariant()))
                        .setAnimatorProvider(SatyrAnimator::new)
                        .setDeathMaxRotation(0.0F)
                        .build(),
                context
        );
        this.shadowRadius = 0.5f;
    }
}
