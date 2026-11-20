package net.korean.culture;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.korean.culture.armor.ModArmorMaterials;
import net.korean.culture.block.ModBlocks;
import net.korean.culture.item.ModItems;
import net.korean.culture.worldgen.WildGarlicWorldGen;
import net.korean.culture.worldgen.WildMugwortWorldGen;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KoreanCulture implements ModInitializer {
	public static final String MOD_ID = "koreanculture";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        WildMugwortWorldGen.init();
        WildGarlicWorldGen.init();

        ModArmorMaterials.init();

        CompostingChanceRegistry.INSTANCE.add(ModItems.MUGWORT, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GARLIC, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.RED_PEPPER, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.RED_PEPPER_SEEDS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SESAME, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.RED_PEPPER_PASTE, 0.4f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.YEOT_STICK, 0.9f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.DOENJANG, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.NAPA_CABBAGE_SEEDS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.NAPA_CABBAGE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.KIMCHI, 0.9f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.RICE_CAKE, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BIBIMBAP, 0.9f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BULGOGI, 0.7f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.TRIPLE_LAYER_MEAT, 1f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.UNFLAVORED_HEATED_RICE_CAKE, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SPICY_HEATED_RICE_CAKE, 0.5f);
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
