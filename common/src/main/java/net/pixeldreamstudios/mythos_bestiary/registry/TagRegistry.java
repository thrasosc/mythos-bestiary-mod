package net.pixeldreamstudios.mythos_bestiary.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

public class TagRegistry {
    // MOB BIOME SPAWN TAGS
    public static TagKey<Biome> SATYR_BIOMES = TagKey.create(
            Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "satyrs_spawn_in")
    );
    public static TagKey<Biome> CYCLOPS_BIOMES = TagKey.create(
            Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "cyclopes_spawn_in")
    );
}
