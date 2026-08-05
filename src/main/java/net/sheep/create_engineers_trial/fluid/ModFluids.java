package net.sheep.create_engineers_trial.fluid;

import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.block.ModBlocks;
import net.sheep.create_engineers_trial.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, CreateEngineersTrial.MOD_ID);

    public static final BaseFlowingFluid.Properties MOLTEN_PLASTIC_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_PLASTIC_FLUID_TYPE,
            () -> ModFluids.SOURCE_MOLTEN_PLASTIC.get(),
            () -> ModFluids.FLOWING_MOLTEN_PLASTIC.get())
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(() -> ModFluids.MOLTEN_PLASTIC_BLOCK.get())
            .bucket(() -> ModFluids.MOLTEN_PLASTIC_BUCKET.get());

    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_PLASTIC = FLUIDS.register("source_molten_plastic",
            () -> new BaseFlowingFluid.Source(ModFluids.MOLTEN_PLASTIC_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_PLASTIC = FLUIDS.register("flowing_molten_plastic",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MOLTEN_PLASTIC_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> MOLTEN_PLASTIC_BLOCK = ModBlocks.BLOCKS.register("molten_plastic_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_PLASTIC.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable().noOcclusion()));

    public static final DeferredItem<Item> MOLTEN_PLASTIC_BUCKET = ModItems.ITEMS.registerItem("molten_plastic_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_PLASTIC.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final BaseFlowingFluid.Properties LIQUID_GLUE_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.LIQUID_GLUE_FLUID_TYPE,
            () -> ModFluids.SOURCE_LIQUID_GLUE.get(),
            () -> ModFluids.FLOWING_LIQUID_GLUE.get())
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(() -> ModFluids.LIQUID_GLUE_BLOCK.get())
            .bucket(() -> ModFluids.LIQUID_GLUE_BUCKET.get());

    public static final Supplier<FlowingFluid> SOURCE_LIQUID_GLUE = FLUIDS.register("source_liquid_glue",
            () -> new BaseFlowingFluid.Source(ModFluids.LIQUID_GLUE_PROPERTIES));

    public static final Supplier<FlowingFluid> FLOWING_LIQUID_GLUE = FLUIDS.register("flowing_liquid_glue",
            () -> new BaseFlowingFluid.Flowing(ModFluids.LIQUID_GLUE_PROPERTIES));

    public static final DeferredBlock<LiquidBlock> LIQUID_GLUE_BLOCK = ModBlocks.BLOCKS.register("liquid_glue_block",
            () -> new LiquidBlock(ModFluids.SOURCE_LIQUID_GLUE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable().noOcclusion()));

    public static final DeferredItem<Item> LIQUID_GLUE_BUCKET = ModItems.ITEMS.registerItem("liquid_glue_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_LIQUID_GLUE.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}