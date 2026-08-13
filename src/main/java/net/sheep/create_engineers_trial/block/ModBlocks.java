package net.sheep.create_engineers_trial.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateEngineersTrial.MOD_ID);

    public static final DeferredBlock<Block> PLASTIC_BLOCK = registerBlock("plastic_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RUBBER_PLANKS = registerBlock("rubber_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RUBBER_LOG = registerBlock("rubber_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RUBBER_WOOD = registerBlock("rubber_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RUBBER_LOG = registerBlock("stripped_rubber_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_RUBBER_WOOD = registerBlock("stripped_rubber_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RUBBER_WINDOW_PANE = registerBlock("rubber_window_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.GLASS).noOcclusion()));

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