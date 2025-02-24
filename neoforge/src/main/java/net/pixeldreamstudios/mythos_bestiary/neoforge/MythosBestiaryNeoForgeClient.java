package net.pixeldreamstudios.mythos_bestiary.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiaryConfig;

@Mod(value = MythosBestiary.MOD_ID, dist = Dist.CLIENT)
public class MythosBestiaryNeoForgeClient {
        public MythosBestiaryNeoForgeClient() {
            MythosBestiary.initClient();
            ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (modContainer, screen) -> AutoConfig.getConfigScreen(MythosBestiaryConfig.class, screen).get());
        }
}
