package net.korean.culture.item.bases;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeedItem extends Item {
    private final Block whenPlaced;

    public SeedItem(Block whenPlaced, Settings settings) {
        super(settings);
        this.whenPlaced = whenPlaced;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemPlacementContext place = new ItemPlacementContext(context);
        BlockPos pos = place.getBlockPos();
        World world = context.getWorld();
        if (world.isClient()) {
            return ActionResult.CONSUME;
        }
        BlockPos soilPos = pos.down();
        BlockState soil = world.getBlockState(soilPos);
        if (!soil.isOf(Blocks.FARMLAND)) {
            return ActionResult.FAIL;
        }
        if (!world.canPlace(whenPlaced.getDefaultState(), pos, ShapeContext.of(context.getPlayer()))) {
            return ActionResult.FAIL;
        }
        world.setBlockState(pos, whenPlaced.getDefaultState());
        return ActionResult.SUCCESS;
    }
}
