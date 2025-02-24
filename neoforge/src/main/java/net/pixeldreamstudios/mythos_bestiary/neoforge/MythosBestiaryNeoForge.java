package net.pixeldreamstudios.mythos_bestiary.neoforge;

import dev.architectury.utils.EnvExecutor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

@Mod(MythosBestiary.MOD_ID)
public final class MythosBestiaryNeoForge {
    public MythosBestiaryNeoForge() {
        // Run our common setup.
        MythosBestiary.init();
        EnvExecutor.runInEnv(Dist.CLIENT, () -> MythosBestiary::initClient);
    }
}
