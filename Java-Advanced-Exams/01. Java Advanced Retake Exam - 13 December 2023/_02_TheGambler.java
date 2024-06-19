package _14_Exams._01_JavaAdvancedRetakeExam_13Dec2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_TheGambler {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        char[][] field = fillMatrix(scanner, n);

        int[] gamblerPosition = locateGambler(field);
        int row = gamblerPosition[0];
        int col = gamblerPosition[1];
//----------------------------------------------------------------------------------------------------------------------
        int amount = 100;

        String input = scanner.nextLine();
        while (!"end".equals(input)){
            String command = input;

            field[row][col] = '-';
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (isOutOfBounds(row, col, field)) {
                System.out.println("Game over! You lost everything!");
                break;
            }

            if (field[row][col] == 'W'){
                amount += 100;
            } else if (field[row][col] == 'P'){
                amount -= 200;
            } else if (field[row][col] == 'J'){
                amount += 100_000;
                System.out.println("You win the Jackpot!");
                break;
            }

            if (amount <= 0) {
                System.out.println("Game over! You lost everything!");
                break;
            }

            input = scanner.nextLine();
        }

        field[row][col] = 'G';
        if (amount > 0){
            System.out.println("End of the game. Total amount: " + amount + "$");
            Arrays.stream(field).map(r -> Arrays.toString(r).replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
        }
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateGambler(char[][] field) {
        int[] gamblerPositions = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'G') {
                    gamblerPositions[0] = row;
                    gamblerPositions[1] = col;
                }
            }
        }
        return gamblerPositions;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
