package net.korean.culture.item;

import com.mojang.serialization.Codec;
import net.korean.culture.KoreanCulture;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModDataComponents {
    public static final ComponentType<Boolean> OPEN = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(KoreanCulture.MOD_ID, "open"),
            ComponentType.<Boolean>builder()
                    .codec(Codec.BOOL)
                    .build()
    );
}
