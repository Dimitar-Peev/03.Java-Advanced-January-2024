package _02_MultidimensionalArrays._02_Exercise;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        fillPalindromeMatrix(matrix);
        printMatrix(matrix);
    }

    public static String[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        return new String[rows][cols];
    }
    private static void fillPalindromeMatrix(String[][]matrix){
        char startLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String palindrome = "" + startLetter + (char)(startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char)(startLetter + 1);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }
}

