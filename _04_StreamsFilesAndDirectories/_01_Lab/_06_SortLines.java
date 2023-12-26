package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "src/_04_StreamsFilesAndDirectories/_01_Lab/Resources/input.txt";
        String outputPath = "src/_04_StreamsFilesAndDirectories/_01_Lab/Resources/06.SortLinesOutput.txt";


        List<String> lines = Files.readAllLines(Paths.get(inputPath))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get(outputPath), lines);

    }
}
