package net.pixeldreamstudios.mythos_bestiary.world.entity.mythical;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public abstract class AbstractMythicalMob extends PathfinderMob {
    protected AbstractMythicalMob(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }
}
