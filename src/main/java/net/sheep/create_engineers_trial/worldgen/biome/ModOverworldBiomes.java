package net.sheep.create_engineers_trial.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModOverworldBiomes {

    private static void addFeature(
            BiomeGenerationSettings.Builder builder,
            GenerationStep.Decoration step,
            ResourceKey<PlacedFeature> feature
    ) {
        builder.addFeature(step, feature);
    }

    public static Biome rubberForest(
            HolderGetter<PlacedFeature> placedFeatureGetter,
            HolderGetter<ConfiguredWorldCarver<?>> carverGetter
    ) {

        // Keine Mobs
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        // Biome Features
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(
                        placedFeatureGetter,
                        carverGetter
                );

        // Höhlen und normale Untergrund-Features
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);

        // Savannen-ähnliches Gras
        BiomeDefaultFeatures.addSavannaGrass(biomeBuilder);

        // Zuckerrohr
        addFeature(
                biomeBuilder,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_SUGAR_CANE
        );

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(1.0F)
                .downfall(0.0F)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(0x3F76E4)
                                .waterFogColor(0x050533)
                                .fogColor(0xC0D8FF)
                                .skyColor(calculateSkyColor(1.0F))
                                .ambientParticle(
                                        new AmbientParticleSettings(
                                                ParticleTypes.GLOW,
                                                0.00725f
                                        )
                                )
                                .build()
                )
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    protected static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);

        return Mth.hsvToRgb(
                0.62222224F - $$1 * 0.05F,
                0.5F + $$1 * 0.1F,
                1.0F
        );
    }
}