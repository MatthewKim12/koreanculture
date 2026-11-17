package net.korean.culture.block;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.korean.culture.KoreanCulture;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModBlockSetTypes {
    public static final BlockSetType KOREAN_PAPER = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
            .openableByHand(true)
            .doorOpenSound(SoundEvents.ITEM_BOOK_PAGE_TURN)
            .doorCloseSound(SoundEvents.ITEM_BOOK_PAGE_TURN)
            .trapdoorOpenSound(SoundEvents.ITEM_BOOK_PAGE_TURN)
            .trapdoorCloseSound(SoundEvents.ITEM_BOOK_PAGE_TURN)
            .register(Identifier.of(KoreanCulture.MOD_ID, "korean_paper"));
}
