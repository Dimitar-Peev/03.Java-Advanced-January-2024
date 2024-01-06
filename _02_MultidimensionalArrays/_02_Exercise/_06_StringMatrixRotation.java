package _02_MultidimensionalArrays._02_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(?<degree>\\d+)");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        String degree = "";
        if (matcher.find()) {
            degree = matcher.group("degree");
        }
        int degrees = Integer.parseInt(degree) % 360;

        List<String> words = new ArrayList<>();

        String line = "";
        int longestWord = 0;

        while (!"END".equals(line = scanner.nextLine())) {
            words.add(line);

            if (line.length() > longestWord) {
                longestWord = line.length();
            }
        }

        char[][] matrix = new char[words.size()][longestWord];

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < longestWord; j++) {
                if (words.get(i).length() > j) {
                    matrix[i][j] = words.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        switch (degrees) {
            case 90:
                printMatrix(rotateMatrix90(matrix));
                break;
            case 180:
                printMatrix(rotateMatrix180(matrix));
                break;
            case 270:
                printMatrix(rotateMatrix270(matrix));
                break;
            default:
                printMatrix(matrix);
                break;
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static char[][] rotateMatrix90(char[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;

        char[][] rotated90 = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                rotated90[col][cols - row - 1] = symbol;
            }
        }

        return rotated90;
    }

    public static char[][] rotateMatrix180(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] rotated180 = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                char symbol = matrix[row][col];
                rotated180[rows - row - 1][cols - col - 1] = symbol;
            }
        }

        return rotated180;
    }

    public static char[][] rotateMatrix270(char[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;

        char[][] rotated270 = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                rotated270[rows - col - 1][row] = symbol;
            }
        }

        return rotated270;
    }
}
