package fr.moveitnow.mower2.mower;

import static java.util.Arrays.asList;

public class Direction {
    private static CardinalPoint[] cardinalPoints = { CardinalPoint.NORTH, CardinalPoint.EST, CardinalPoint.SOUTH, CardinalPoint.WEST };
    private static int NB_CARDINAL_POINT = cardinalPoints.length;

    private int indexDirection;

    public Direction(CardinalPoint cardinalPoint) {
        this.indexDirection = asList(cardinalPoints).indexOf(cardinalPoint);
    }

    public CardinalPoint turn(Command command) {
        if(Command.D.equals(command)) {
            indexDirection = (indexDirection + 1) % NB_CARDINAL_POINT;
        } else if(Command.G.equals(command)) {
            indexDirection = (indexDirection - 1 < 0) ? NB_CARDINAL_POINT - 1 : indexDirection - 1;
        }
         return cardinalPoints[indexDirection];
    }
}
