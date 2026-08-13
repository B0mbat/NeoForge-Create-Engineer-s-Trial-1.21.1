package net.sheep.create_engineers_trial.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerator {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(DataGenerator::gatherData);
    }

    private static void gatherData(GatherDataEvent event) {

        PackOutput packOutput = event.getGenerator().getPackOutput();

        event.getGenerator().addProvider(
                event.includeServer(),
                new ModWorldGenProvider(
                        packOutput,
                        event.getLookupProvider()
                )
        );
    }
}