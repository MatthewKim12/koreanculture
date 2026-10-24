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
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
