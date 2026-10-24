package net.korean.culture.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class WildMugwortAdvancedBlock extends Block {
    public WildMugwortAdvancedBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState under = world.getBlockState(pos.down());
        return under.isOf(Blocks.GRASS_BLOCK) ||
                under.isOf(Blocks.DIRT) ||
                under.isOf(Blocks.MUD);
    }
}
