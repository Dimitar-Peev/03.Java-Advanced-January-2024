package _14_Exams._15_JavaAdvancedRetakeExam_18August2021;

import java.util.Scanner;

public class _02_FormulaOne {
    // If the player goes out of the matrix, he comes in from the other side.
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String rowString = scanner.nextLine();
            for (int col = 0; col < rowString.length(); col++) {
                matrix[row][col] = rowString.charAt(col);

                // find start
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean finishReached = false;

        for (int i = 1; i <= countOfCommands; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    finishReached = playerMove(matrix, -1, 0);
                    break;
                case "down":
                    finishReached = playerMove(matrix, 1, 0);
                    break;
                case "left":
                    finishReached = playerMove(matrix, 0, -1);
                    break;
                case "right":
                    finishReached = playerMove(matrix, 0, 1);
                    break;
            }

            if (finishReached) {
                break;
            }

        }

        String result = finishReached
                ? "Well done, the player won first place!"
                : "Oh no, the player got lost on the track!";
        System.out.println(result);

        printMatrix(matrix);

    }

    private static boolean playerMove(char[][] matrix, int rowModifier, int colModifier) {
        int nextRow = playerRow + rowModifier;
        int nextCol = playerCol + colModifier;

        boolean bonusHit = false;

        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '.';
        }

        if (nextRow < 0) {
            nextRow = matrix.length - 1;
        } else if (nextRow > matrix.length - 1) {
            nextRow = 0;
        } else if (nextCol < 0) {
            nextCol = matrix.length - 1;
        } else if (nextCol > matrix.length - 1) {
            nextCol = 0;
        }

        if (matrix[nextRow][nextCol] == 'F') {
            matrix[nextRow][nextCol] = 'P';
            playerRow = nextRow;
            playerCol = nextCol;
            return true;
        } else if (matrix[nextRow][nextCol] == 'B') {
            bonusHit = true;
        } else if (matrix[nextRow][nextCol] == 'T') {
            nextRow = playerRow;
            nextCol = playerCol;
        }

        if (bonusHit) {
            playerRow = nextRow;
            playerCol = nextCol;
            playerMove(matrix, rowModifier, colModifier);
        } else {
            matrix[nextRow][nextCol] = 'P';
            playerRow = nextRow;
            playerCol = nextCol;
        }

        return false;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
