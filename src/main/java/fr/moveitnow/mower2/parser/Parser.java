package fr.moveitnow.mower2.parser;

import fr.moveitnow.mower2.mower.CardinalPoint;
import fr.moveitnow.mower2.mower.Command;
import fr.moveitnow.mower2.mower.Garden;
import fr.moveitnow.mower2.mower.Mower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public static ArrayList<String> parseLines(String filename) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    filename));
            String line = reader.readLine();

            Garden garden = parseGarden(line);

            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Mower mower = parseMower(line, garden);

                line = reader.readLine();
                parseCommands(line, mower);

                result.add(mower.toString());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Le fichier n'a pas été trouvé.");
        } catch (IOException e) {
            throw new IOException("Erreur dans le fichier de données.");
        }

        return result;
    }

    public static Garden parseGarden(String line) {
        return new Garden(
                Character.getNumericValue(line.charAt(0)),
                Character.getNumericValue(line.charAt(1)));
    }

    public static Mower parseMower(String line, Garden garden) throws IOException{
        return new Mower(
                Character.getNumericValue(line.charAt(0)),
                Character.getNumericValue(line.charAt(1)),
                CardinalPoint.letterToCardinalPoint(line.charAt(3)),
                garden);
    }

    public static void parseCommands(String line, Mower mower) throws IOException{
        for(int i = 0; i<line.length(); i++) {
            mower.move(Command.valueOf(Character.toString(line.charAt(i))));
        }
    }
}
