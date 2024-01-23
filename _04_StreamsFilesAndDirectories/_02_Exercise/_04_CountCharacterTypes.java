package _04_StreamsFilesAndDirectories._02_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class _04_CountCharacterTypes {
    private static final String INPUT_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/input.txt";
    private static final String OUTPUT_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/04.output.txt";

    public static void main(String[] args) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuation.contains(symbol)) {
                        punctuationsCount++;
                    } else if (symbol != ' ') {
                        othersCount++;
                    }
                }
                line = reader.readLine();
            }
			
            writer.println("Vowels: " + vowelsCount);
            writer.println("Other symbols: " + othersCount);
            writer.println("Punctuation: " + punctuationsCount);
            System.out.println();
		
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
