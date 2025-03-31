package net.pixeldreamstudios.mythos_bestiary.entity.mythical;

import mod.azure.azurelib.common.api.common.ai.pathing.AzureNavigation;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

public class Cyclops extends AbstractMythicalMob{
    public Cyclops(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.navigation = new AzureNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, MythosBestiary.config.cyclopsHealth)
                .add(Attributes.ATTACK_DAMAGE, MythosBestiary.config.cyclopsAttackDamage)
                .add(Attributes.ATTACK_SPEED, 2)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.VILLAGER_AMBIENT, 1.0F, 0.2F);
        return null;
    }
}
