package net.sheep.create_engineers_trial.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    public static final ResourceKey<Biome> RUBBER_FOREST = ResourceKey.create(
            Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(
                    "create_engineers_trial",
                    "rubber_forest"
            )
    );
}