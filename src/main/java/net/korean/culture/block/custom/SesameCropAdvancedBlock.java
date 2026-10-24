package net.korean.culture.block.custom;

import net.korean.culture.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class SesameCropAdvancedBlock extends CropBlock {
    public SesameCropAdvancedBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.SESAME;
    }
}
