package net.sheep.create_engineers_trial.event;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;
import net.sheep.create_engineers_trial.CreateEngineersTrial;
import net.sheep.create_engineers_trial.block.ModBlocks;

@EventBusSubscriber(modid = CreateEngineersTrial.MOD_ID)
public class ModBlockEvents {

    @SubscribeEvent
    public static void onUseItemOnBlock(UseItemOnBlockEvent event) {
        if (event.getItemStack().getItem() instanceof AxeItem) {
            Level level = event.getLevel();
            BlockState state = level.getBlockState(event.getPos());

            BlockState strippedState = null;

            if (state.is(ModBlocks.RUBBER_LOG.get())) {
                strippedState = ModBlocks.STRIPPED_RUBBER_LOG.get().defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            } else if (state.is(ModBlocks.RUBBER_WOOD.get())) {
                strippedState = ModBlocks.STRIPPED_RUBBER_WOOD.get().defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
            }

            if (strippedState != null) {
                Player player = event.getPlayer();
                level.playSound(player, event.getPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);

                if (!level.isClientSide) {
                    level.setBlock(event.getPos(), strippedState, 11);
                    if (player != null) {
                        EquipmentSlot slot = event.getHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        event.getItemStack().hurtAndBreak(1, player, slot);
                    }
                }

                event.cancelWithResult(ItemInteractionResult.sidedSuccess(level.isClientSide));
            }
        }
    }
}