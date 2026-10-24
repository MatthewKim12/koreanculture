package net.korean.culture.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.korean.culture.KoreanCulture;
import net.korean.culture.armor.ModArmorMaterials;
import net.korean.culture.block.ModBlocks;
import net.korean.culture.item.bases.LiquidFoodItem;
import net.korean.culture.item.bases.SeedItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.korean.culture.item.custom.MugwortGarlicAdvancedItem;

public class ModItems {
    public static final Item MUGWORT_AND_GARLIC = registerItem("mugwort_and_garlic",
            new MugwortGarlicAdvancedItem(new Item.Settings().food(ModFoodComponents.MUGWORT_AND_GARLIC).maxCount(1)));
    public static final Item MUGWORT = registerItem("mugwort",
            new Item(new Item.Settings().food(ModFoodComponents.MUGWORT)));
    public static final Item GARLIC = registerItem("garlic",
            new Item(new Item.Settings().food(ModFoodComponents.GARLIC)));
    public static final Item RED_PEPPER = registerItem("red_pepper",
            new Item(new Item.Settings().food(ModFoodComponents.RED_PEPPER)));
    public static final Item RED_PEPPER_SEEDS = registerItem("red_pepper_seeds",
            new SeedItem(ModBlocks.RED_PEPPER_CROP, new Item.Settings()));
    public static final Item SESAME = registerItem("sesame",
            new SeedItem(ModBlocks.SESAME_CROP, new Item.Settings()));
    public static final Item KOREAN_FLAG = registerItem("korean_flag",
            new Item(new Item.Settings()));
    public static final Item SESAME_OIL_BOTTLE = registerItem("sesame_oil_bottle",
            new LiquidFoodItem(new Item.Settings().food(ModFoodComponents.SESAME_OIL)
                    .recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)));
    public static final Item RED_PEPPER_PASTE = registerItem("red_pepper_paste",
            new Item(new Item.Settings().food(ModFoodComponents.RED_PEPPER)));
    public static final Item YEOT_STICK = registerItem("yeot_stick",
            new Item(new Item.Settings().food(ModFoodComponents.YEOT_STICK)));
    public static final Item HANBOK_SHIRT = registerItem("hanbok_shirt",
            new ArmorItem(
                    ModArmorMaterials.HANBOK,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
            )
    );
    public static final Item HANBOK_PANTS = registerItem("hanbok_pants",
            new ArmorItem(
                    ModArmorMaterials.HANBOK,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
            ));
    public static final Item KOREAN_SOCKS = registerItem("korean_socks",
            new ArmorItem(
                    ModArmorMaterials.HANBOK,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
            ));
    public static final Item GAT_HAT = registerItem("gat_hat",
            new ArmorItem(
                    ModArmorMaterials.HANBOK,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
            ));
    public static final Item DOENJANG = registerItem("doenjang",
            new LiquidFoodItem(new Item.Settings().food(ModFoodComponents.DOENJANG)));
    public static final Item NAPA_CABBAGE_SEEDS = registerItem("napa_cabbage_seeds",
            new SeedItem(ModBlocks.NAPA_CABBAGE_CROP, new Item.Settings()));
    public static final Item NAPA_CABBAGE = registerItem("napa_cabbage",
            new Item(new Item.Settings().food(ModFoodComponents.NAPA)));
    public static final Item KIMCHI = registerItem("kimchi",
            new Item(new Item.Settings().food(ModFoodComponents.KIMCHI)));
    public static final Item RICE_CAKE = registerItem("rice_cake",
            new Item(new Item.Settings().food(ModFoodComponents.RICE_CAKE)));
    public static final Item BIBIMBAP = registerItem("bibimbap",
            new Item(new Item.Settings().food(ModFoodComponents.BIBIMBAP)));
    public static final Item BULGOGI = registerItem("bulgogi",
            new Item(new Item.Settings().food(ModFoodComponents.BULGOGI)));
    public static final Item TRIPLE_LAYER_MEAT = registerItem("triple_layer_meat",
            new Item(new Item.Settings().food(ModFoodComponents.TRIPLE_LAYER_MEAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, KoreanCulture.id(name), item);
    }

    public static void registerModItems() {
        KoreanCulture.LOGGER.info("registering mod items for " + KoreanCulture.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(MUGWORT_AND_GARLIC);
            entries.add(MUGWORT);
            entries.add(GARLIC);
            entries.add(RED_PEPPER);
            entries.add(SESAME_OIL_BOTTLE);
            entries.add(RED_PEPPER_PASTE);
            entries.add(YEOT_STICK);
            entries.add(DOENJANG);
            entries.add(NAPA_CABBAGE);
            entries.add(KIMCHI);
            entries.add(RICE_CAKE);
            entries.add(BIBIMBAP);
            entries.add(BULGOGI);
            entries.add(TRIPLE_LAYER_MEAT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(RED_PEPPER_SEEDS);
            entries.add(SESAME);
            entries.add(NAPA_CABBAGE_SEEDS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(KOREAN_FLAG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(HANBOK_SHIRT);
            entries.add(HANBOK_PANTS);
            entries.add(KOREAN_SOCKS);
            entries.add(GAT_HAT);
        });
    }
}
