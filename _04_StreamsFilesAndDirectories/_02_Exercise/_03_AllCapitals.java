package _04_StreamsFilesAndDirectories._02_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class _03_AllCapitals {
    private static final String INPUT_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/input.txt";
    private static final String OUTPUT_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/03.output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
