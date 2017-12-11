package fr.moveitnow.mower2.mower;

public enum CardinalPoint {
    NORTH('N'), SOUTH('S'), EST('E'), WEST('W');

    private final char letter;

    CardinalPoint(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public static CardinalPoint letterToCardinalPoint(char letter) {
        switch (letter) {
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
            case 'E':
                return EST;
            case 'W':
                return WEST;
            default:
                return null;
        }
    }
}
