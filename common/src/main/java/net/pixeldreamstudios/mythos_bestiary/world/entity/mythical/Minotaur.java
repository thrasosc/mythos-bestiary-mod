package net.pixeldreamstudios.mythos_bestiary.world.entity.mythical;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.mythos_bestiary.MythosBestiary;

public class Minotaur extends AbstractMythicalMob{
    public Minotaur(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, MythosBestiary.config.minotaurHealth)
                .add(Attributes.ATTACK_DAMAGE, MythosBestiary.config.minotaurAttackDamage)
                .add(Attributes.ATTACK_SPEED, 2)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }
}
