package _14_Exams._04_JavaAdvancedRetakeExam_9August2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_DeliveryBoy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        char[][] field = new char[numbers[0]][numbers[1]];

        int myRow = -1, myCol = -1;

        for (int row = 0; row < field.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = input[col].charAt(0);

                if (field[row][col] == 'B') {
                    myRow = row;
                    myCol = col;
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        int startRow = myRow, startCol = myCol;
        boolean addressIsReached = false;

        while (!addressIsReached) {
            String input = scanner.nextLine();

            int lastRow = myRow, lastCol = myCol;

            switch (input) {
                case "up": myRow--; break;
                case "down": myRow++; break;
                case "left": myCol--; break;
                case "right": myCol++; break;
            }

            if (isOutOfBounds(myRow, myCol, field)) {
                System.out.println("The delivery is late. Order is canceled.");
                field[startRow][startCol] = ' ';
                break;
            }

            char symbol = field[myRow][myCol];
            if (symbol == '-') {
                field[myRow][myCol] = '.';
            } else if (symbol == 'P') {
                field[myRow][myCol] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (symbol == 'A') {
                field[myRow][myCol] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                addressIsReached = true;
            } else if (field[myRow][myCol] == '*') {
                myRow = lastRow;
                myCol = lastCol;
            }
        }
        printMatrix(field);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
