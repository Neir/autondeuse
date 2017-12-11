package fr.moveitnow.mower2.mower;

import fr.moveitnow.mower2.mower.CardinalPoint;
import fr.moveitnow.mower2.mower.Command;
import fr.moveitnow.mower2.mower.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void turn_to_right_from_north_change_direction_to_est() throws Exception {
        // Given
        Direction direction = new Direction(CardinalPoint.NORTH);

        // When
        CardinalPoint actualDirection = direction.turn(Command.D);

        // Then
        assertEquals(actualDirection, CardinalPoint.EST);
    }

    @Test
    public void turn_to_right_from_west_change_direction_to_north() throws Exception {
        // Given
        Direction direction = new Direction(CardinalPoint.WEST);

        // When
        CardinalPoint actualDirection = direction.turn(Command.D);

        // Then
        assertEquals(actualDirection, CardinalPoint.NORTH);
    }

    @Test
    public void turn_to_left_from_north_change_direction_to_west() throws Exception {
        // Given
        Direction direction = new Direction(CardinalPoint.NORTH);

        // When
        CardinalPoint actualDirection = direction.turn(Command.G);

        // Then
        assertEquals(actualDirection, CardinalPoint.WEST);
    }
}
