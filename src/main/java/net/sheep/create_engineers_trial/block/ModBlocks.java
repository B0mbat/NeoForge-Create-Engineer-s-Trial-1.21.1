package net.sheep.create_engineers_trial.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.item.ModItems;
import net.sheep.create_engineers_trial.worldgen.tree.ModWoodTypes;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateEngineersTrial.MOD_ID);

    public static final DeferredBlock<Block> PLASTIC_BLOCK = registerBlock("plastic_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RUBBER_PLANKS = registerBlock("rubber_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> RUBBER_LOG = registerBlock("rubber_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> RUBBER_WOOD = registerBlock("rubber_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RUBBER_LOG = registerBlock("stripped_rubber_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_RUBBER_WOOD = registerBlock("stripped_rubber_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> RUBBER_WINDOW_PANE = registerBlock("rubber_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.GLASS).noOcclusion()));

    // Wood Variants
    public static final DeferredBlock<Block> RUBBER_STAIRS = registerBlock("rubber_stairs",
            () -> new StairBlock(RUBBER_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));
    public static final DeferredBlock<Block> RUBBER_SLAB = registerBlock("rubber_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));
    public static final DeferredBlock<Block> RUBBER_FENCE = registerBlock("rubber_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));
    public static final DeferredBlock<Block> RUBBER_FENCE_GATE = registerBlock("rubber_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.RUBBER_WOOD_TYPE, BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));
    public static final DeferredBlock<Block> RUBBER_DOOR = registerBlock("rubber_door",
            () -> new DoorBlock(ModWoodTypes.RUBBER_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<Block> RUBBER_TRAPDOOR = registerBlock("rubber_trapdoor",
            () -> new TrapDoorBlock(ModWoodTypes.RUBBER_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get()).noOcclusion()));
    public static final DeferredBlock<Block> RUBBER_BUTTON = registerBlock("rubber_button",
            () -> new ButtonBlock(ModWoodTypes.RUBBER_SET_TYPE, 30, BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));
    public static final DeferredBlock<Block> RUBBER_PRESSURE_PLATE = registerBlock("rubber_pressure_plate",
            () -> new PressurePlateBlock(ModWoodTypes.RUBBER_SET_TYPE, BlockBehaviour.Properties.ofFullCopy(RUBBER_PLANKS.get())));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}