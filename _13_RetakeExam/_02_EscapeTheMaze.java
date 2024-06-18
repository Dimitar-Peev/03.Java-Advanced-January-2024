package _13_RetakeExam;

import java.util.Scanner;

public class _02_EscapeTheMaze {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());

        char[][] field = new char[n][n];

        int[] positions = new int[2];

        for (int row = 0; row < field.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = input[col].charAt(0);

                if (field[row][col] == 'P') {
                    positions[0] = row;
                    positions[1] = col;
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        int health = 100;
      
        while (health > 0 && field[positions[0]][positions[1]] != 'X') {
            String input = scanner.nextLine();

            field[positions[0]][positions[1]] = '-';
            switch (input) {
                case "up":
                    positions[0]--;
                    if (isOutOfBounds(positions[0], positions[1], field)) {
                        positions[0]++;
                    }
                    break;
                case "down":
                    positions[0]++;
                    if (isOutOfBounds(positions[0], positions[1], field)) {
                        positions[0]--;
                    }
                    break;
                case "left":
                    positions[1]--;
                    if (isOutOfBounds(positions[0], positions[1], field)) {
                        positions[1]++;
                    }
                    break;
                case "right":
                    positions[1]++;
                    if (isOutOfBounds(positions[0], positions[1], field)) {
                        positions[1]--;
                    }
                    break;
            }

            char symbol = field[positions[0]][positions[1]];
          
            if (symbol == 'M') {
                health = Math.max(health - 40, 0);
            } else if (symbol == 'H') {
                health = Math.min(health + 15, 100);
            }

        }
//----------------------------------------------------------------------------------------------------------------------
        String result = health > 0
                ? "Player escaped the maze. Danger passed!"
                : "Player is dead. Maze over!";

        System.out.println(result);
        System.out.println("Player's health: " + health + " units");

        field[positions[0]][positions[1]] = 'P';
        printMatrix(field);
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
