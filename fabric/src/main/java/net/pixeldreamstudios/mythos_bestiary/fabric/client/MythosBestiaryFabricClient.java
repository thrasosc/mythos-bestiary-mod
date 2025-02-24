package net.pixeldreamstudios.mythos_bestiary.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

public final class MythosBestiaryFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MythosBestiary.initClient();
    }
}
