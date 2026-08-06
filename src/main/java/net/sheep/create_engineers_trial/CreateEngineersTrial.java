package net.sheep.create_engineers_trial;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.sheep.create_engineers_trial.block.ModBlocks;
import net.sheep.create_engineers_trial.fluid.ModFluidTypes;
import net.sheep.create_engineers_trial.fluid.ModFluids;
import net.sheep.create_engineers_trial.item.ModCreativeModeTabs;
import net.sheep.create_engineers_trial.item.ModItems;
import org.slf4j.Logger;

@Mod(CreateEngineersTrial.MOD_ID)
public class CreateEngineersTrial {

    public static final String MOD_ID = "create_engineers_trial";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateEngineersTrial(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluidTypes.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}