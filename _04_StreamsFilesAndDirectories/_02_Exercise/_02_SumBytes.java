package _04_StreamsFilesAndDirectories._02_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02_SumBytes {
    private static final String PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();

            long sum = 0;
            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
