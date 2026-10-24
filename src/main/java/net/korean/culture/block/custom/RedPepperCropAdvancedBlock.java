package net.korean.culture.block.custom;

import net.korean.culture.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class RedPepperCropAdvancedBlock extends CropBlock {
    public RedPepperCropAdvancedBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.RED_PEPPER_SEEDS;
    }
}
