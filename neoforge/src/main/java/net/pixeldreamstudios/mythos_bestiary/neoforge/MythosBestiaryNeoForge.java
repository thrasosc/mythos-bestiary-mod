package net.pixeldreamstudios.mythos_bestiary.neoforge;

import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.neoforged.fml.common.Mod;

@Mod(MythosBestiary.MOD_ID)
public final class MythosBestiaryNeoForge {
    public MythosBestiaryNeoForge() {
        // Run our common setup.
        MythosBestiary.init();
    }
}
