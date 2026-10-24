package net.korean.culture.item.custom;

import com.mojang.authlib.GameProfile;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class MugwortGarlicAdvancedItem extends Item {
    public MugwortGarlicAdvancedItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof PlayerEntity)) {
            BlockPos pos = BlockPos.ofFloored(entity.getPos());

            if (entity.getWorld() instanceof ServerWorld world) {
                VillagerEntity newEntity = EntityType.VILLAGER.spawn(
                        world,
                        pos,
                        SpawnReason.CONVERSION
                );

                if (newEntity != null) {
                    entity.discard();
                    ExperienceOrbEntity exp = new ExperienceOrbEntity(world, pos.getX(), pos.getY(), pos.getX(), 1000);
                    world.spawnEntity(exp);
                    user.setStackInHand(hand, ItemStack.EMPTY);
                    user.addExperience(1000);
                    world.playSound(
                            null,
                            pos,
                            SoundEvents.ENTITY_GENERIC_EAT,
                            SoundCategory.NEUTRAL,
                            1.0f,
                            1.0f
                    );
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }
}