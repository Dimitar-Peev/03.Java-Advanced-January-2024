package _14_Exams._10_JavaAdvancedRegularExam_25June2022;

import java.util.Scanner;

public class _02_StickyFingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[n][n];

        int currentRow = 0, currentCol = 0;

        for (int row = 0; row < n; row++) {
            char[] arr = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < n; col++) {
                char currentChar = arr[col];

                if (currentChar == 'D') {
                    currentRow = row;
                    currentCol = col;
                }
                matrix[row][col] = currentChar;
            }
        }

        matrix[currentRow][currentCol] = '+';

        int totalMoneyStolen = 0;

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (isInBounds(currentRow - 1, currentCol, matrix)) {
                        currentRow--;
                    }
                    break;
                case "down":
                    if (isInBounds(currentRow + 1, currentCol, matrix)) {
                        currentRow++;
                    }
                    break;
                case "left":
                    if (isInBounds(currentRow, currentCol - 1, matrix)) {
                        currentCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(currentRow, currentCol + 1, matrix)) {
                        currentCol++;
                    }
                    break;

            }

            if (matrix[currentRow][currentCol] == ('$')) {
                matrix[currentRow][currentCol] = '+';
                totalMoneyStolen += (currentRow * currentCol);
                System.out.printf("You successfully stole %d$.%n", currentRow * currentCol);
            } else if (matrix[currentRow][currentCol] == ('P')) {
                matrix[currentRow][currentCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoneyStolen);
                printMatrix(matrix);
                return;
            }
        }

        matrix[currentRow][currentCol] = 'D';

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoneyStolen);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        boolean isValid = row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
        if (!isValid) {
            System.out.println("You cannot leave the town, there is police outside!");
        }
        return isValid;
    }
}