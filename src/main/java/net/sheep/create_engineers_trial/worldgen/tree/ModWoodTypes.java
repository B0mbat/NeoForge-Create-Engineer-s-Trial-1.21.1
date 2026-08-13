package net.sheep.create_engineers_trial.worldgen.tree;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType RUBBER_SET_TYPE = BlockSetType.register(new BlockSetType("rubber"));
    public static final WoodType RUBBER_WOOD_TYPE = WoodType.register(new WoodType("rubber", RUBBER_SET_TYPE));
}