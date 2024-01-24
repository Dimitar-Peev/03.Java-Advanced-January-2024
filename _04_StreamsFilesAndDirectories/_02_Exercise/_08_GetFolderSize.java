package _04_StreamsFilesAndDirectories._02_Exercise;

import java.io.*;

public class _08_GetFolderSize {
    private static final String FOLDER_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src/_04_StreamsFilesAndDirectories/_02_Exercise/Resources/08.results.txt";

    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(FOLDER_PATH);
            int size = 0;
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.isDirectory()) {
                            size += file.length();
                        }
                    }
                }
            }
			
            writer.println("Folder size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
