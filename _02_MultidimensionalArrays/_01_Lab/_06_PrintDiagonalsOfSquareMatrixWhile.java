package _02_MultidimensionalArrays._01_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrixWhile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        first(matrix);
        second(matrix);

    }

    public static int[][] readMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static void second(int[][] matrix) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
        System.out.println();
    }

    public static void first(int[][] matrix) {
        int row = 0, col = 0;
        while (row < matrix.length && col < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
    }
}
