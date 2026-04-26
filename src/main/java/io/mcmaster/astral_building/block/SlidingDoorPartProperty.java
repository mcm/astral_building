package io.mcmaster.astral_building.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum SlidingDoorPartProperty implements StringRepresentable {
    BOTTOM_LEFT(-1, 0),
    BOTTOM(0, 0),
    BOTTOM_RIGHT(1, 0),
    LEFT(-1, 1),
    CENTER(0, 1),
    RIGHT(1, 1),
    TOP_LEFT(-1, 2),
    TOP(0, 2),
    TOP_RIGHT(1, 2);

    private final int xOffset;
    private final int yOffset;

    SlidingDoorPartProperty(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int xOffset() {
        return xOffset;
    }

    public int yOffset() {
        return yOffset;
    }

    public boolean isController() {
        return this == BOTTOM;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name().toLowerCase();
    }
}
