package net.korean.culture.mixin;

import net.korean.culture.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class BlockUsageItemMixin {
    @Inject(method = "onUseWithItem", at = @At("HEAD"), cancellable = true)
    private void onUseWithItem(ItemStack stack, World world, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ItemActionResult> cir) {
        BlockState state = (BlockState)(Object)this;
        BlockPos pos = hit.getBlockPos();

        if (stack.isOf(Items.HONEYCOMB)) {
            if (state.isOf(Blocks.CAKE)) {
                cir.setReturnValue(ItemActionResult.SUCCESS);
                if (!world.isClient) {
                    stack.decrementUnlessCreative(1, player);
                    int amount = CakeBlock.BITES.getValues().stream().mapToInt(Integer::intValue).max().orElseThrow() - state.get(CakeBlock.BITES);
                    int count = world.getRandom().nextBetween(amount * 4, amount * 6);
                    while (count > 0) {
                        int amountToDrop = Math.min(count, 64);
                        ItemScatterer.spawn(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.RICE_CAKE, amountToDrop));
                        count -= amountToDrop;
                    }
                    world.breakBlock(pos, false);
                }
            } else if (state.isOf(Blocks.CANDLE_CAKE)) {
                cir.setReturnValue(ItemActionResult.SUCCESS);
                if (!world.isClient) {
                    player.sendMessage(Text.literal("that candle cannot be a part of the rice cake..."), true);
                }
            }
        }
    }
}