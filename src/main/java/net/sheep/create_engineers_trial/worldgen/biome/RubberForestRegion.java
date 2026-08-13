package net.sheep.create_engineers_trial.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

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
                20
        );
    }

    @Override
    public void addBiomes(
            Registry<Biome> registry,
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper
    ) {
        VanillaParameterOverlayBuilder builder =
                new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.ARID, Humidity.DRY)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(
                        Weirdness.MID_SLICE_NORMAL_ASCENDING,
                        Weirdness.MID_SLICE_NORMAL_DESCENDING
                )
                .build()
                .forEach(point ->
                        builder.add(
                                point,
                                ModBiomes.RUBBER_FOREST
                        )
                );

        builder.build().forEach(mapper);
    }
}
