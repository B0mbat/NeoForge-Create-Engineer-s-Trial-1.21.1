package net.sheep.create_engineers_trial.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheep.create_engineers_trial.CreateEngineersTrial;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateEngineersTrial.MOD_ID);

    public static final Supplier<CreativeModeTab> CAA_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("create_engineers_trial_items_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.EMPTY_ELECTRON_TUBE.get()))
                            .title(Component.translatable("creativetab.create_engineers_trial.items"))
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.EMPTY_ELECTRON_TUBE.get());
                                output.accept(ModItems.BLUE_ELECTRON_TUBE.get());
                                output.accept(ModItems.GREEN_ELECTRON_TUBE.get());
                                output.accept(ModItems.EMPTY_SUPER_GLUE.get());
                                output.accept(ModItems.DESTROYED_PRECISION_MECHANISM.get());
                                output.accept(ModItems.BROWN_PAPER.get());
                                output.accept(ModItems.IRON_SCREW.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}