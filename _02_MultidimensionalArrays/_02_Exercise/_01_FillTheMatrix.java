package _02_MultidimensionalArrays._02_Exercise;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(", ");
        int n = Integer.parseInt(inputArr[0]);
        String patternType = inputArr[1];

        int[][] matrix = fillMatrix(n, patternType);

        printMatrix(matrix);
    }


    private static int[][] fillMatrix(int n, String type) {
        int[][] matrix = new int[n][n];
        if ("A".equals(type)) {
            fillPatternA(matrix);
        } else if ("B".equals(type)) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = number++;
            }
        }
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = number++;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = number++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
}
