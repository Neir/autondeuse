package fr.moveitnow.mower2.mower;

import java.awt.*;

public class Mower {
    private Point location;
    private CardinalPoint direction;
    private Garden garden;

    public Mower(int x, int y, CardinalPoint cardinalPoint, Garden garden) {
        this.location = new Point(x, y);
        this.direction = cardinalPoint;
        this.garden = garden;
    }

    public void move(Command commande) {
        direction = new Direction(direction).turn(commande);
        if(Command.A.equals(commande)) {
            moveForward();
        }
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                if (location.y + 1 <= garden.getBoundUp()) {
                    location.y++;
                }
                break;
            case SOUTH:
                if (location.y - 1 >= 0) {
                    location.y--;
                }
                break;
            case EST:
                if (location.x + 1 <= garden.getBoundRight()) {
                    location.x++;
                }
                break;
            case WEST:
                if (location.x - 1 >= 0) {
                    location.x--;
                }
                break;
        }
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public CardinalPoint getDirection() {
        return direction;
    }

    public String toString() {
        return "" + getX() + getY() + " " + getDirection().getLetter();
    }
}
