package _02_MultidimensionalArrays._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nXm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[nXm[0]][nXm[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int[] start = new int[]{row, col};
                if (findSum(start, matrix) > maxSum) {
                    maxSum = findSum(start, matrix);
                    bestVector = start;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(bestVector, matrix);
    }

    private static int findSum(int[] start, int[][] matrix) {
        int sum = 0;
        for (int row = start[0]; row < start[0] + 3; row++) {
            for (int col = start[1]; col < start[1] + 3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[] bestVector, int[][] matrix) {
        for (int row = bestVector[0]; row < bestVector[0] + 3; row++) {
            for (int col = bestVector[1]; col < bestVector[1] + 3; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
