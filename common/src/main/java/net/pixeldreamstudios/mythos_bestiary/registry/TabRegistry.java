package net.pixeldreamstudios.mythos_bestiary.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

public class TabRegistry {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MythosBestiary.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MYTHOS_BESTIARY_TAB = TABS.register(
            MythosBestiary.MOD_ID + "_tab",
            () -> CreativeTabRegistry.create(
                    Component.translatable("category." + MythosBestiary.MOD_ID),
                    () -> new ItemStack(Items.APPLE)
            )
    );

    public static void init() {
        TABS.register();
    }
}
