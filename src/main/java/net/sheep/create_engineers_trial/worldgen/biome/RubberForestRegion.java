package net.sheep.create_engineers_trial.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class RubberForestRegion extends Region {

    public static final ResourceLocation LOCATION =
            ResourceLocation.fromNamespaceAndPath(
                    "create_engineers_trial",
                    "rubber_forest_region"
            );

    public RubberForestRegion() {
        super(
                LOCATION,
                RegionType.OVERWORLD,
                2
        );
    }

    @Override
    public void addBiomes(
            Registry<Biome> registry,
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper
    ) {
        this.addBiome(
                mapper,
                Climate.Parameter.point(0.8F),
                Climate.Parameter.point(0.8F),
                Climate.Parameter.point(0.2F),
                Climate.Parameter.point(0.0F),
                Climate.Parameter.point(0.0F),
                Climate.Parameter.point(0.0F),
                0.0F,
                ModBiomes.RUBBER_FOREST
        );
    }
}