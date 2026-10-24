package net.korean.culture.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class WildGarlicAdvancedBlock extends Block {
    private final VoxelShape SHAPE = Block.createCuboidShape(
            4, 0, 4,
            12, 4, 12
    );
    private final VoxelShape SHAPE2 = Block.createCuboidShape(
            8, 0, 8,
            9, 8, 9
    );

    public WildGarlicAdvancedBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState under = world.getBlockState(pos.down());
        return under.isOf(Blocks.GRASS_BLOCK) ||
                under.isOf(Blocks.DIRT) ||
                under.isOf(Blocks.MUD);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                SHAPE,
                SHAPE2
        );
    }
}
