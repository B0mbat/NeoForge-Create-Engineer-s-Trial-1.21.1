package net.sheep.create_engineers_trial.block;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheep.create_engineers_trial.CreateEngineersTrial;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateEngineersTrial.MOD_ID);


    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}
