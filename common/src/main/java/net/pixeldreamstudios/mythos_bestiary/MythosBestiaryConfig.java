package net.pixeldreamstudios.mythos_bestiary;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = MythosBestiary.MOD_ID)
public class MythosBestiaryConfig implements ConfigData {
    @ConfigEntry.Category("satyr")
    public double satyrHealth = 10.0;
    @ConfigEntry.Category("satyr")
    public double satyrAttackDamage = 1.5;
    @ConfigEntry.Category("satyr")
    public int satyrSpawnWeight = 10;
}
