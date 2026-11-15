package net.korean.culture.item.custom;

import net.korean.culture.item.ModDataComponents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class KoreanFoldingFanAdvancedItem extends Item {
    public KoreanFoldingFanAdvancedItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        boolean open = stack.getOrDefault(ModDataComponents.OPEN, false);
        if (!user.isSneaking()) {
            stack.set(ModDataComponents.OPEN, !open);
            return TypedActionResult.success(stack, false);
        }
        else if (open) {
            WindChargeEntity charge = EntityType.WIND_CHARGE.create(world);
            if (charge != null) {
                charge.setOwner(user);
                charge.setPosition(user.getEyePos());
                charge.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
                world.spawnEntity(charge);
                return TypedActionResult.success(stack);
            }
        }
        return TypedActionResult.pass(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        boolean open = stack.getOrDefault(ModDataComponents.OPEN, false);
        tooltip.add(Text.translatable(open ? "tooltip.koreanculture.korean_folding_fan_open" : "tooltip.koreanculture.korean_folding_fan_closed"));
    }
}
