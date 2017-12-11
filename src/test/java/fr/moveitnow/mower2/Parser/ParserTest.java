package fr.moveitnow.mower2.Parser;

import fr.moveitnow.mower2.mower.CardinalPoint;
import fr.moveitnow.mower2.mower.Garden;
import fr.moveitnow.mower2.mower.Mower;
import fr.moveitnow.mower2.parser.Parser;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ParserTest {

    @Test
    public void parseGarden_shoud_initiate_garden_from_text_line() throws Exception {
        // Given
        String gardenLine = "57";

        // When
        Garden garden = Parser.parseGarden(gardenLine);

        // Then
        assertEquals(5, garden.getBoundRight());
        assertEquals(7, garden.getBoundUp());
    }

    @Test
    public void parseMower_shoud_initiate_mower_from_text_line() throws Exception {
        // Given
        String mowerLine = "39 S";

        // When
        Mower mower = Parser.parseMower(mowerLine, new Garden(9, 9));

        // Then
        assertEquals(3, mower.getX());
        assertEquals(9, mower.getY());
        assertEquals(CardinalPoint.SOUTH, mower.getDirection());
    }

    @Test
    public void parseCommands_shoud_do_nothing_if_commands_line_is_empty() throws Exception {
        // Given
        String commandsLine = "";
        Mower mower = new Mower(1, 1, CardinalPoint.NORTH, new Garden(9, 9));

        // When
        Parser.parseCommands(commandsLine, mower);

        // Then
        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(CardinalPoint.NORTH, mower.getDirection());
    }

    @Test
    public void parseCommands_shoud_execute_all_commands_of_line() throws Exception {
        // Given
        String commandsLine = "GAAAAAAAAAAADAADD";
        Mower mower = new Mower(1, 1, CardinalPoint.NORTH, new Garden(9, 9));

        // When
        Parser.parseCommands(commandsLine, mower);

        // Then
        assertEquals(0, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals(CardinalPoint.SOUTH, mower.getDirection());
    }

    @Test
    public void parseFile_should_read_and_simulate_TEST_file() throws Exception {
        // Given
        File file = new File("src/test/java/resources/TEST");

        // When
        ArrayList<String> result = Parser.parseLines(file.getAbsolutePath());

        // Then
        assertEquals("13 N", result.get(0));
        assertEquals("51 E", result.get(1));
    }

    @Test
    public void parseFile_should_display_that_file_doesnt_exist() throws Exception {
        // Given
        File file = new File("src/test/java/resources/no_file");

        // When
        assertThatThrownBy(() -> Parser.parseLines(file.getAbsolutePath()))
        // Then
                .isInstanceOf(FileNotFoundException.class)
                .hasMessage("Le fichier n'a pas été trouvé.");
    }
}
