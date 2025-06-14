package _14_Exams._09_JavaAdvancedRetakeExam_18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        char[][] field = scanField(scanner, n, m);

        int[] hunter = locateHunter(field);
        int row = hunter[0];
        int col = hunter[1];
//-------------------------------------------------------------------------------
        List<String> directions = new ArrayList<>();

        String command = scanner.nextLine();
        while (!"Finish".equals(command)) {
            int oldRow = row;
            int oldCol = col;

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
            }

            if (isOutOfBounds(row,col,field)){
                if (row < 0 || row >= field.length) {
                    row = oldRow;
                }
                if (col < 0 || col >= field[0].length) {
                    col = oldCol;
                }
            } else {
                if (field[row][col] == 'T') {
                    row = oldRow;
                    col = oldCol;
                } else if (field[row][col] == 'X') {
                    directions.add(command);
                    System.out.println("I've found the treasure!");
                    System.out.println("The right path is " + (String.join(", ", directions)));
                    return;
                } else if (field[row][col] == '-') {
                    directions.add(command);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("The map is fake!");

    }


    private static char[][] scanField(Scanner scanner, int n, int m) {
        char[][] matrix = new char[n][m];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateHunter(char[][] field) {
        int[] position = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'Y') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return seller;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
