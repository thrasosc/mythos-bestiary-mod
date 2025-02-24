package net.pixeldreamstudios.mythos_bestiary.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiaryConfig;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(MythosBestiaryConfig.class, parent).get();
    }
}
