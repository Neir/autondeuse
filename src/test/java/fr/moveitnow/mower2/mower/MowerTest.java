package fr.moveitnow.mower2.mower;

import fr.moveitnow.mower2.mower.CardinalPoint;
import fr.moveitnow.mower2.mower.Command;
import fr.moveitnow.mower2.mower.Garden;
import fr.moveitnow.mower2.mower.Mower;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MowerTest {

    @Test
    public void move_to_right_from_north_change_mower_orientation_to_est() throws Exception {
        // Given
        Mower mower = new Mower(0, 0, CardinalPoint.NORTH, new Garden(3, 3));

        // When
        mower.move(Command.valueOf("D"));

        // Then
        assertEquals(0, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(CardinalPoint.EST, mower.getDirection());
    }

    @Test
    public void move_to_left_from_north_change_mower_orientation_to_west() throws Exception {
        // Given
        Mower mower = new Mower(0, 0, CardinalPoint.NORTH, new Garden(3, 3));

        // When
        mower.move(Command.valueOf("G"));

        // Then
        assertEquals(0, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(CardinalPoint.WEST, mower.getDirection());
    }

    /*************************************************
     * move (forward): when mower stay inside garden *
     *************************************************/

    @Test
    public void moveForward_with_north_direction_shoud_increment_y_when_mower_is_inside_garden_bound() throws Exception {
        // Given
        Mower mower = new Mower(2, 2, CardinalPoint.NORTH, new Garden(3, 3));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(2, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals(CardinalPoint.NORTH, mower.getDirection());
    }

    @Test
    public void moveForward_with_est_direction_shoud_increment_x_when_mower_is_inside_garden_bound() throws Exception {
        // Given
        Mower mower = new Mower(2, 2, CardinalPoint.EST, new Garden(3, 3));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(3, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(CardinalPoint.EST, mower.getDirection());
    }

    /*****************************************************
     * move (forward): when mower could go out of garden *
     *****************************************************/

    @Test
    public void moveForward_with_north_direction_shoud_not_move_mower_when_it_is_at_the_garden_top_bound() throws Exception {
        // Given

        Mower mower = new Mower(2, 2, CardinalPoint.NORTH, new Garden(2, 2));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(2, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(CardinalPoint.NORTH, mower.getDirection());
    }

    @Test
    public void moveForward_with_est_direction_shoud_not_move_mower_when_it_is_at_the_garden_right_bound() throws Exception {
        // Given
        Mower mower = new Mower(2, 2, CardinalPoint.EST, new Garden(2, 2));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(2, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(CardinalPoint.EST, mower.getDirection());
    }

    @Test
    public void moveForward_with_south_direction_shoud_not_move_mower_when_it_is_at_the_garden_bottom_bound() throws Exception {
        // Given
        Mower mower = new Mower(2, 0, CardinalPoint.SOUTH, new Garden(2, 2));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(2, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(CardinalPoint.SOUTH, mower.getDirection());
    }

    @Test
    public void moveForward_with_west_direction_shoud_not_move_mower_when_it_is_at_the_garden_left_bound() throws Exception {
        // Given
        Mower mower = new Mower(0, 2, CardinalPoint.WEST, new Garden(2, 2));

        //When
        mower.move(Command.valueOf("A"));

        //Then
        assertEquals(0, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(CardinalPoint.WEST, mower.getDirection());
    }

}
