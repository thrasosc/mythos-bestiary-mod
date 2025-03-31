package net.pixeldreamstudios.mythos_bestiary.registry;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Cyclops;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Minotaur;
import net.pixeldreamstudios.mythos_bestiary.entity.mythical.Satyr;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(MythosBestiary.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<Cyclops>> CYCLOPS = ENTITIES.register("cyclops", () ->
            EntityType.Builder.of(Cyclops::new, MobCategory.CREATURE)
                    .sized(1.75f, 4.0f)
                    .build(ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "cyclops").toString()));

    public static final RegistrySupplier<EntityType<Minotaur>> MINOTAUR = ENTITIES.register("minotaur", () ->
            EntityType.Builder.of(Minotaur::new, MobCategory.CREATURE)
                    .sized(1.5f, 3.2f)
                    .build(ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "minotaur").toString()));

    public static final RegistrySupplier<EntityType<Satyr>> SATYR = ENTITIES.register("satyr", () ->
            EntityType.Builder.of(Satyr::new, MobCategory.CREATURE)
                    .sized(0.75f, 1.75f)
                    .build(ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, "satyr").toString()));

    private static void initSpawns() {
        SpawnPlacementsRegistry.register(EntityRegistry.CYCLOPS, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cyclops::checkMobSpawnRules);
        BiomeModifications.addProperties(b -> b.hasTag(TagRegistry.CYCLOPS_BIOMES), (ctx, b) -> b.getSpawnProperties().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(CYCLOPS.get(), MythosBestiary.config.cyclopsSpawnWeight, 1, 1)));

        SpawnPlacementsRegistry.register(EntityRegistry.MINOTAUR, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Minotaur::checkMobSpawnRules);
        BiomeModifications.addProperties(b -> b.hasTag(TagRegistry.MINOTAUR_BIOMES), (ctx, b) -> b.getSpawnProperties().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MINOTAUR.get(), MythosBestiary.config.minotaurSpawnWeight, 1, 1)));

        SpawnPlacementsRegistry.register(EntityRegistry.SATYR, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Satyr::checkMobSpawnRules);
        BiomeModifications.addProperties(b -> b.hasTag(TagRegistry.SATYR_BIOMES), (ctx, b) -> b.getSpawnProperties().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(SATYR.get(), MythosBestiary.config.satyrSpawnWeight, 3, 5)));
    }

    private static void initAttributes() {
        EntityAttributeRegistry.register(CYCLOPS, Cyclops::createAttributes);
        EntityAttributeRegistry.register(MINOTAUR, Minotaur::createAttributes);
        EntityAttributeRegistry.register(SATYR, Satyr::createAttributes);
    }

    public static void init() {
        ENTITIES.register();
        initAttributes();
        initSpawns();
    }
}

