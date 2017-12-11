package fr.moveitnow.mower2;

import fr.moveitnow.mower2.parser.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.util.Arrays.stream;

public class Application {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Il manque le chemin absolu du fichier en argument.");
            return;
        }

        String filename = args[0];
        try {
            stream(Parser.parseLines(filename).toArray()).forEach(resultLine -> System.out.println(resultLine));
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier est introuvable");
        } catch (IOException e) {
            System.err.println("Erreur dans la lecture du fichier");
        }
    }
}
