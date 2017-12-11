package fr.moveitnow.mower2.mower;

import java.awt.*;

public class Garden {
    private Point upRightPoint;

    public Garden(int x, int y) {
        this.upRightPoint = new Point(x, y);
    }

    public int getBoundUp() {
        return upRightPoint.y;
    }

    public int getBoundRight() {
        return upRightPoint.x;
    }
}
