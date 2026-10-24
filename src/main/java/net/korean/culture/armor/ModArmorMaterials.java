package net.korean.culture.armor;

import net.korean.culture.KoreanCulture;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class ModArmorMaterials {
    public static final RegistryKey<ArmorMaterial> HANBOK_KEY =
            RegistryKey.of(
                    RegistryKeys.ARMOR_MATERIAL,
                    Identifier.of(KoreanCulture.MOD_ID, "hanbok")
            );

    public static final RegistryEntry<ArmorMaterial> HANBOK =
            Registry.registerReference(
                    Registries.ARMOR_MATERIAL,
                    HANBOK_KEY,
                    new ArmorMaterial(
                            Map.of(
                                    ArmorItem.Type.HELMET, 0,
                                    ArmorItem.Type.CHESTPLATE, 0,
                                    ArmorItem.Type.LEGGINGS, 0,
                                    ArmorItem.Type.BOOTS, 0,
                                    ArmorItem.Type.BODY, 0
                            ),
                            15,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            () -> Ingredient.ofItems(Items.STRING),
                            List.of(
                                    new ArmorMaterial.Layer(
                                            Identifier.of(KoreanCulture.MOD_ID, "hanbok")
                                    )
                            ),
                            0.0F,
                            0.0F
                    )
            );

    public static void init() {
    }
}