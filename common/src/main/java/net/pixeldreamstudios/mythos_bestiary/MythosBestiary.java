package net.pixeldreamstudios.mythos_bestiary;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import mod.azure.azurelib.common.internal.common.AzureLib;
import net.pixeldreamstudios.mythos_bestiary.registry.EntityRegistry;
import net.pixeldreamstudios.mythos_bestiary.registry.TabRegistry;
import net.pixeldreamstudios.mythos_bestiary.entity.client.render.CyclopsRenderer;
import net.pixeldreamstudios.mythos_bestiary.entity.client.render.MinotaurRenderer;
import net.pixeldreamstudios.mythos_bestiary.entity.client.render.SatyrRenderer;

public final class MythosBestiary {
    public static final String MOD_ID = "mythos_bestiary";
    public static MythosBestiaryConfig config;

    public static void init() {
        AutoConfig.register(MythosBestiaryConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(MythosBestiaryConfig.class).getConfig();

        AzureLib.initialize();

        EntityRegistry.init();
        TabRegistry.init();
    }

    public static void initClient() {
        EntityRendererRegistry.register(EntityRegistry.CYCLOPS, CyclopsRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.MINOTAUR, MinotaurRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.SATYR, SatyrRenderer::new);
    }
}
