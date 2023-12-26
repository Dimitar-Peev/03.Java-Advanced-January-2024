package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "input.txt";
        String outputPath = "04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        PrintWriter printer = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.println(scanner.next());
            }
            scanner.next();
        }

        printer.close();
    }
}
