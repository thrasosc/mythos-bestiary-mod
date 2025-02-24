package net.pixeldreamstudios.mythos_bestiary.registry;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Cyclops;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Minotaur;
import net.pixeldreamstudios.mythos_bestiary.world.entity.mythical.Satyr;

import java.util.function.Supplier;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(MythosBestiary.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<Cyclops>> CYCLOPS = registerEntity("cyclops", Cyclops::new, MobCategory.CREATURE, 1.75f, 4.0f);
    public static final RegistrySupplier<EntityType<Minotaur>> MINOTAUR = registerEntity("minotaur", Minotaur::new, MobCategory.CREATURE, 1.5f, 3.2f);
    public static final RegistrySupplier<EntityType<Satyr>> SATYR = registerEntity("satyr", Satyr::new, MobCategory.CREATURE, 0.75f, 1.75f);

    private static void initSpawns() {
        registerSpawnPlacements(EntityRegistry.CYCLOPS, Cyclops::checkMobSpawnRules);
        addBiomeProperties(TagRegistry.CYCLOPS_BIOMES, MobCategory.CREATURE, CYCLOPS.get(), MythosBestiary.config.cyclopsSpawnWeight, 1, 1);

        registerSpawnPlacements(EntityRegistry.MINOTAUR, Minotaur::checkMobSpawnRules);
        addBiomeProperties(TagRegistry.MINOTAUR_BIOMES, MobCategory.CREATURE, MINOTAUR.get(), MythosBestiary.config.minotaurSpawnWeight, 1, 1);

        registerSpawnPlacements(EntityRegistry.SATYR, Satyr::checkMobSpawnRules);
        addBiomeProperties(TagRegistry.SATYR_BIOMES, MobCategory.CREATURE, SATYR.get(), MythosBestiary.config.satyrSpawnWeight, 3, 5);
    }

    public static RegistrySupplier registerEntity(String id, EntityType.EntityFactory entityFactory, MobCategory category, float hitboxWidth, float hitboxHeight) {
        RegistrySupplier registrySupplier = ENTITIES.register(id, () ->
                EntityType.Builder.of(entityFactory, category)
                        .sized(hitboxWidth, hitboxHeight)
                        .build(ResourceLocation.fromNamespaceAndPath(MythosBestiary.MOD_ID, id).toString())
        );
        return registrySupplier;
    }

    private static <T extends Mob> void registerSpawnPlacements(Supplier<? extends EntityType<T>> type, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        SpawnPlacementsRegistry.register(
                type,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                spawnPredicate
        );
    }

    private static void addBiomeProperties(TagKey<Biome> tag, MobCategory category, EntityType<?> entityType, int spawnWeight, int minGroup, int maxGroup) {
        BiomeModifications.addProperties(
                b -> b.hasTag(tag),
                (ctx, b) -> b.getSpawnProperties().addSpawn(category, new MobSpawnSettings.SpawnerData(entityType, spawnWeight, minGroup, maxGroup))
        );
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
