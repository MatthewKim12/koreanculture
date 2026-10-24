package net.korean.culture.mixin;

import net.korean.culture.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.RuleStructureProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RuleStructureProcessor.class)
public abstract class VillagerFarmMixin {
    @Inject(method = "process", at = @At("RETURN"), cancellable = true)
    private void addKoreanCultureCrop(
            WorldView world,
            BlockPos pos,
            BlockPos pivot,
            StructureTemplate.StructureBlockInfo originalBlockInfo,
            StructureTemplate.StructureBlockInfo currentBlockInfo,
            StructurePlacementData data,
            CallbackInfoReturnable<StructureTemplate.StructureBlockInfo> cir
    ) {
        StructureTemplate.StructureBlockInfo info = cir.getReturnValue();

        if (info == null) {
            return;
        }

        BlockState state = info.state();

        if (state.isOf(Blocks.WHEAT) && world instanceof ServerWorldAccess serverWorld) {
            Random random = serverWorld.getRandom();
            float nextFloat = random.nextFloat();

            if (nextFloat < 0.1f) {
                BlockState crop = ModBlocks.RED_PEPPER_CROP
                        .getDefaultState()
                        .with(CropBlock.AGE, 7);

                cir.setReturnValue(new StructureTemplate.StructureBlockInfo(
                        info.pos(),
                        crop,
                        info.nbt()
                ));
            } else if (nextFloat < 0.2f) {
                BlockState crop = ModBlocks.SESAME_CROP
                        .getDefaultState()
                        .with(CropBlock.AGE, 7);

                cir.setReturnValue(new StructureTemplate.StructureBlockInfo(
                        info.pos(),
                        crop,
                        info.nbt()
                ));
            } else if (nextFloat < 0.4f) {
                BlockState crop = ModBlocks.NAPA_CABBAGE_CROP
                        .getDefaultState()
                        .with(CropBlock.AGE, 7);
                cir.setReturnValue(new StructureTemplate.StructureBlockInfo(
                        info.pos(),
                        crop,
                        info.nbt()
                ));
            }
        }
    }
}