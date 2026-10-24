package net.korean.culture.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent MUGWORT_AND_GARLIC =
            new FoodComponent.Builder().nutrition(3).saturationModifier(0.7f).build();
    public static final FoodComponent MUGWORT =
            new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodComponent GARLIC =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();
    public static final FoodComponent RED_PEPPER =
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(0.6f)
                    .statusEffect(
                            new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0),
                            0.2f
                    )
                    .snack()
                    .build();
    public static final FoodComponent SESAME_OIL =
            new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(0.7f)
                    .usingConvertsTo(Items.GLASS_BOTTLE)
                    .build();
    public static final FoodComponent YEOT_STICK =
            new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.5f)
                    .snack()
                    .build();
    public static final FoodComponent DOENJANG =
            new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(2.1f)
                    .usingConvertsTo(Items.BOWL)
                    .statusEffect(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 20, 2),
                            0.2f
                    )
                    .build();
    public static final FoodComponent NAPA =
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .build();
    public static final FoodComponent KIMCHI =
            new FoodComponent.Builder()
                    .nutrition(7)
                    .saturationModifier(1.8f)
                    .statusEffect(
                            new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0),
                            0.2f
                    )
                    .statusEffect(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 20, 2),
                            0.2f
                    )
                    .build();
    public static final FoodComponent RICE_CAKE =
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.6f)
                    .statusEffect(
                            new StatusEffectInstance(StatusEffects.OOZING, 200, 0),
                            0.05f
                    )
                    .build();
    public static final FoodComponent BIBIMBAP =
            new FoodComponent.Builder()
                    .nutrition(10)
                    .saturationModifier(3.0f)
                    .usingConvertsTo(Items.BOWL)
                    .build();
    public static final FoodComponent BULGOGI =
            new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(2.0f)
                    .build();
    public static final FoodComponent TRIPLE_LAYER_MEAT =
           new FoodComponent.Builder()
                    .nutrition(FoodComponents.COOKED_PORKCHOP.nutrition() * 3)
                    .saturationModifier(FoodComponents.COOKED_PORKCHOP.saturation())
                    .build();
}
