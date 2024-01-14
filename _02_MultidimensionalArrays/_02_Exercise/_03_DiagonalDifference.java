package _02_MultidimensionalArrays._02_Exercise;

import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);

        System.out.println(findDifference(matrix));

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    private static int findDifference(int[][] matrix) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonal += matrix[row][row];
            secondaryDiagonal += matrix[row][matrix.length - row - 1];
        }
        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }
}
