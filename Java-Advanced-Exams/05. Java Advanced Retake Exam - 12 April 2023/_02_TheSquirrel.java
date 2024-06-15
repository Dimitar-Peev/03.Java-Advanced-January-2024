package _14_Exams._05_JavaAdvancedRetakeExam_12April2023;

import java.util.Scanner;

public class _02_TheSquirrel {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] field = fillMatrix(scanner, n);

        int[] squirrelPosition = locateSquirrel(field);
        int row = squirrelPosition[0];
        int col = squirrelPosition[1];
//----------------------------------------------------------------------------------------------------------------------
        int hazelnutCount = 0;
        boolean theGameEnds  = false;

        for (String command : commands) {
            field[row][col] = '*';
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (isOutOfBounds(row, col, field)) {
                System.out.println("The squirrel is out of the field.");
                theGameEnds = true;
                break;
            }

            if (field[row][col] == 'h') {
                hazelnutCount++;
                if (hazelnutCount == 3) {
                    field[row][col] = 's';
                    System.out.println("Good job! You have collected all hazelnuts!");
                    theGameEnds = true;
                    break;
                }
            } else if (field[row][col] == 't') {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                theGameEnds = true;
                break;
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (hazelnutCount < 3 && !theGameEnds) { System.out.println("There are more hazelnuts to collect."); }

        System.out.println("Hazelnuts collected: " + hazelnutCount);
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateSquirrel(char[][] field) {
        int[] squirrel = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 's') {
                    squirrel[0] = row;
                    squirrel[1] = col;
                }
            }
        }
        return squirrel;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
