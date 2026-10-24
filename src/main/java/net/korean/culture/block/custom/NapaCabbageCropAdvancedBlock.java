package net.korean.culture.block.custom;

import net.korean.culture.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class NapaCabbageCropAdvancedBlock extends CropBlock {
    public NapaCabbageCropAdvancedBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.NAPA_CABBAGE_SEEDS;
    }
}
