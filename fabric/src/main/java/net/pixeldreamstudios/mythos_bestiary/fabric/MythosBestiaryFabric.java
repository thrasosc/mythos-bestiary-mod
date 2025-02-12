package net.pixeldreamstudios.mythos_bestiary.fabric;

import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.fabricmc.api.ModInitializer;

public final class MythosBestiaryFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        MythosBestiary.init();
    }
}
