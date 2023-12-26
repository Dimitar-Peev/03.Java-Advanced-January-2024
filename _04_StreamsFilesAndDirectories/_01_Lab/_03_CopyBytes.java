package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {

        String inputPath = "input.txt";
        String outputPath = "03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);

        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 10) {
                outputStream.write('\n');
            } else {
                String message = String.valueOf(oneByte);

                for (char c : message.toCharArray()) {
                    outputStream.write(c);
                }

            }
            oneByte = inputStream.read();
        }
    }
}
