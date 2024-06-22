package _14_Exams._13_JavaAdvancedRetakeExam_15December2021;

import java.util.Scanner;

public class _02_ThroneConquering {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        byte n = Byte.parseByte(scanner.nextLine());
        char[][] field = fillMatrix(scanner, n);

        int[] positions = findLocation(field);
        int parisRow = positions[0];
        int parisCol = positions[1];
//----------------------------------------------------------------------------------------------------------------------
        boolean isReachedHelen = false;

        while (energy > 0 && !isReachedHelen) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String direction = inputArr[0];
            int spartanRow = Integer.parseInt(inputArr[1]);
            int spartanCol = Integer.parseInt(inputArr[2]);

            field[spartanRow][spartanCol] = 'S';

            int lastRow = parisRow;
            int lastCol = parisCol;

            field[parisRow][parisCol] = '-';
            switch (direction) {
                case "up": parisRow--; break;
                case "down": parisRow++; break;
                case "left": parisCol--; break;
                case "right": parisCol++; break;
            }

            energy--;

            if (isOutOfBounds(parisRow, parisCol, field)) {
                parisRow = lastRow; parisCol = lastCol;
            }

            if (field[parisRow][parisCol] == 'H') {
                field[parisRow][parisCol] = '-';
                isReachedHelen = true;
            } else if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (energy <= 0){
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
        if (isReachedHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }

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
                if (field[row][col] == 'P') {
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

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }
}
