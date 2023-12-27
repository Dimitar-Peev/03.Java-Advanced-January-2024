package _04_StreamsFilesAndDirectories._01_Lab;

import java.io.File;
import java.io.IOException;

public class _07_ListFiles {
    public static void main(String[] args) throws IOException {
		
        String fileName = "src/_04_StreamsFilesAndDirectories/_01_Lab/Resources/Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
