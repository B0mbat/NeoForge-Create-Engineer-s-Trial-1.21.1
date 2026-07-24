package net.sheep.create_engineers_trial.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheep.create_engineers_trial.CreateEngineersTrial;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateEngineersTrial.MOD_ID);

    public static final DeferredItem<Item> EMPTY_SUPER_GLUE =
            ITEMS.register("empty_super_glue",
                    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_ELECTRON_TUBE =
            ITEMS.register("green_electron_tube",
                    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EMPTY_ELECTRON_TUBE =
            ITEMS.register("empty_electron_tube",
                    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROWN_PAPER =
            ITEMS.register("brown_paper",
                    () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}