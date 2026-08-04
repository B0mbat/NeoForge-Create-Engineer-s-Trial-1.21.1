package net.sheep.create_engineers_trial.event;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.fluid.BaseFluidType;
import net.sheep.create_engineers_trial.fluid.ModFluidTypes;
import net.sheep.create_engineers_trial.fluid.ModFluids;
import org.joml.Vector3f;

@EventBusSubscriber(modid = CreateEngineersTrial.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MOLTEN_PLASTIC.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MOLTEN_PLASTIC.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        BaseFluidType fluidType = (BaseFluidType) ModFluidTypes.MOLTEN_PLASTIC_FLUID_TYPE.get();

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return fluidType.getStillTexture();
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return fluidType.getFlowingTexture();
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return fluidType.getOverlayTexture();
            }

            @Override
            public int getTintColor() {
                return fluidType.getTintColor();
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fluidType.getFogColor();
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        }, ModFluidTypes.MOLTEN_PLASTIC_FLUID_TYPE.get());
    }
}