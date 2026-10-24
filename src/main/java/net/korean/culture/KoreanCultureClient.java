package net.korean.culture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.korean.culture.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class KoreanCultureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.WILD_MUGWORT,
                RenderLayer.getCutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.RED_PEPPER_CROP,
                RenderLayer.getCutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.SESAME_CROP,
                RenderLayer.getCutout()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.NAPA_CABBAGE_CROP,
                RenderLayer.getCutout()
        );
    }
}