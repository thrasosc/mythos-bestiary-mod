package net.pixeldreamstudios.mythos_bestiary.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

@Mod(value = MythosBestiary.MOD_ID, dist = Dist.CLIENT)
public class MythosBestiaryNeoForgeClient {
        public MythosBestiaryNeoForgeClient() {
            MythosBestiary.initClient();
        }
}
