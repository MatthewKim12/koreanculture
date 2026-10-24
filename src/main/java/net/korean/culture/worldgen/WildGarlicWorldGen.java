package net.korean.culture.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.korean.culture.KoreanCulture;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

class WildGarlicPlacedFeatures {
    public static final RegistryKey<PlacedFeature> WILD_GARLIC = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE,
            KoreanCulture.id("wild_garlic")
    );
}

public class WildGarlicWorldGen {
    public static void init() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                WildGarlicPlacedFeatures.WILD_GARLIC
        );
    }
}
