package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class _02_WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("02.WriteToFileOutput.txt");

        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('!');
        punctuations.add('?');

        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            char symbol = (char) singleByte;

            if (!punctuations.contains(symbol)) {
                 outputStream.write(symbol);
            }

            singleByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
