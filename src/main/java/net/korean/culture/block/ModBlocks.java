package net.korean.culture.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.korean.culture.KoreanCulture;
import net.korean.culture.block.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final Block WILD_MUGWORT = registerBlock("wild_mugwort", new WildMugwortAdvancedBlock(Block.Settings.create()
            .burnable()
            .noCollision()
            .nonOpaque()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP)
            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_GARLIC = registerBlock("wild_garlic", new WildGarlicAdvancedBlock(Block.Settings.create()
            .burnable()
            .hardness(0.15f)
            .sounds(BlockSoundGroup.CROP)
            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_PEPPER_CROP = registerBlock("red_pepper_crop",
            new RedPepperCropAdvancedBlock(Block.Settings.copy(WILD_MUGWORT)));
    public static final Block SESAME_CROP = registerBlock("sesame_crop",
            new SesameCropAdvancedBlock(Block.Settings.copy(RED_PEPPER_CROP)));
    public static final Block YUT_STICK = registerBlock("yut_stick",
            new YutStickAdvancedBlock(Block.Settings.create()
                    .hardness(0.5f)
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.PUSH_ONLY)
                    .nonOpaque()));
    public static final Block NAPA_CABBAGE_CROP = registerBlock("napa_cabbage_crop",
            new NapaCabbageCropAdvancedBlock(Block.Settings.copy(RED_PEPPER_CROP)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, KoreanCulture.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, KoreanCulture.id(name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        KoreanCulture.LOGGER.info("Registering mod blocks for " + KoreanCulture.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(YUT_STICK);
        });
    }
}
