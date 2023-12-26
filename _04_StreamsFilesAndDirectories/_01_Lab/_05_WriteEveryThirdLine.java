package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputPath = "src/_04_StreamsFilesAndDirectories/_01_Lab/Resources/input.txt";
        String outputPath = "src/_04_StreamsFilesAndDirectories/_01_Lab/Resources/05.WriteEveryThirdLineOutput.txt";

        List<String> strings = Files.readAllLines(Path.of(inputPath));

        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i += 3) {
            lines.add(strings.get(i) + System.lineSeparator());
        }

        Files.write(Paths.get(outputPath), lines, StandardCharsets.UTF_8);

    }
}
