package net.sheep.create_engineers_trial.datagen;

import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER =
            new RegistrySetBuilder()
                    .add(
                            Registries.BIOME,
                            ModBiomes::bootstrap
                    );

    public ModWorldGenProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> registries
    ) {
        super(
                output,
                registries,
                BUILDER,
                Set.of(CreateEngineersTrial.MOD_ID)
        );
    }
}