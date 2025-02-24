package net.pixeldreamstudios.mythos_bestiary.world.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum SatyrVariant {
    SATYR_1(0), SATYR_2(1), SATYR_3(2);

    private static final SatyrVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(SatyrVariant::getId)).toArray(SatyrVariant[]::new);
    private final int id;

    SatyrVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SatyrVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
