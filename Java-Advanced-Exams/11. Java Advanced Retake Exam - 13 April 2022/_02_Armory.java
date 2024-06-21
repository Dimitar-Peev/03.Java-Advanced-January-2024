package _14_Exams._11_JavaAdvancedRetakeExam_13April2022;

import java.util.Scanner;

public class _02_Armory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        char[][] field = fillMatrix(scanner, n);

        int[] positions = findLocation(field);
        int row = positions[0];
        int col = positions[1];
//----------------------------------------------------------------------------------------------------------------------
        int sumOfCoins = 0;
        boolean isOut = false;

        while (sumOfCoins < 65 && !isOut) {
            String direction = scanner.nextLine();

            int lastRow = row;
            int lastCol = col;

            field[row][col] = '-';
            switch (direction) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (isOutOfBounds(row, col, field)) {
                System.out.println("I do not need more swords!");
                row = lastRow; col = lastCol;
                isOut = true;
            }

            char symbol = field[row][col];

            if (Character.isDigit(symbol)) {
                sumOfCoins += Character.getNumericValue(field[row][col]);
            } else if (symbol == 'M') {
                field[row][col] = '-';
                int[] mirrors = findMirror(field);
                row = mirrors[0];
                col = mirrors[1];
            }

        }
//----------------------------------------------------------------------------------------------------------------------
        if (sumOfCoins > 65) {
            field[row][col] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", sumOfCoins);
        printMatrix(field);
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] findLocation(char[][] field) {
        int[] positions = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'A') {
                    positions[0] = row;
                    positions[1] = col;
                }
            }
        }
        return positions;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    private static int[] findMirror(char[][] matrix) {
        int[] mirror = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    mirror[0] = row;
                    mirror[1] = col;
                }
            }
        }
        return mirror;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }
}
