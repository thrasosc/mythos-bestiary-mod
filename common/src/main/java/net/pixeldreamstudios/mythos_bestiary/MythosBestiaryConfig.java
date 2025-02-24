package net.pixeldreamstudios.mythos_bestiary;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = MythosBestiary.MOD_ID)
public class MythosBestiaryConfig implements ConfigData {
    // Cyclops
    @ConfigEntry.Category("cyclops")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int cyclopsHealth = 10;
    @ConfigEntry.Category("cyclops")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int cyclopsAttackDamage = 2;
    @ConfigEntry.Category("cyclops")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(max = 100)
    public int cyclopsSpawnWeight = 10;
    // Satyr
    @ConfigEntry.Category("satyr")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int satyrHealth = 10;
    @ConfigEntry.Category("satyr")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int satyrAttackDamage = 2;
    @ConfigEntry.Category("satyr")
    @ConfigEntry.Gui.NoTooltip
    @ConfigEntry.BoundedDiscrete(max = 100)
    public int satyrSpawnWeight = 10;
}
