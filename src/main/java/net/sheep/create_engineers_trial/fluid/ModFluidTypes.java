package net.sheep.create_engineers_trial.fluid;

import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CreateEngineersTrial.MOD_ID);

    public static final Supplier<FluidType> MOLTEN_PLASTIC_FLUID_TYPE = FLUID_TYPES.register("molten_plastic_fluid",
            () -> new BaseFluidType(
                    FluidType.Properties.create()
                            .density(2500)
                            .viscosity(10500)
                            .pathType(PathType.LAVA)
                            .adjacentPathType(null)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/molten_plastic_still"),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/molten_plastic_flow"),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/molten_plastic_overlay"),
                    0xDDFFFFFF,
                    new Vector3f(0.9f, 0.9f, 0.9f)
            )
    );

    public static final Supplier<FluidType> LIQUID_GLUE_FLUID_TYPE = FLUID_TYPES.register("liquid_glue_fluid",
            () -> new BaseFluidType(
                    FluidType.Properties.create()
                            .density(2500)
                            .viscosity(10500)
                            .pathType(PathType.LAVA)
                            .adjacentPathType(null)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/liquid_glue_still"),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/liquid_glue_flow"),
                    ResourceLocation.fromNamespaceAndPath(CreateEngineersTrial.MOD_ID, "block/liquid_glue_overlay"),
                    0xDD60C81C,
                    new Vector3f(0.376f, 0.784f, 0.110f)
            )
    );
}