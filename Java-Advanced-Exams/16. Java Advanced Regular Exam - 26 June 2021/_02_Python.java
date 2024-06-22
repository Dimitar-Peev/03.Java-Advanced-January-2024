package _14_Exams._16_JavaAdvancedRegularExam_26June2021;

import java.util.*;

public class _02_Python {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Queue<String> directions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).forEach(directions::offer);

        char[][] field = fillMatrix(scanner, n);

        int[] positions = findLocation(field);
        int pythonRow = positions[0];
        int pythonCol = positions[1];

        int food = findFood(field);
//----------------------------------------------------------------------------------------------------------------------
        int length = 1;
        while (!directions.isEmpty()) {
            String direction = directions.poll();

            field[pythonRow][pythonCol] = '*';

            switch (direction) {
                case "up": pythonRow--; break;
                case "down": pythonRow++; break;
                case "left": pythonCol--; break;
                case "right": pythonCol++; break;
            }

            if (pythonRow < 0) {
                pythonRow = n - 1;
            } else if (pythonRow > n - 1) {
                pythonRow = 0;
            } else if (pythonCol < 0) {
                pythonCol = n - 1;
            } else if (pythonCol > n - 1) {
                pythonCol = 0;
            }

            if (field[pythonRow][pythonCol] == 'f') {
                field[pythonRow][pythonCol] = '*';
                length++;
                food--;

                if (food == 0) {
                    System.out.println("You win! Final python length is " + length);
                    break;
                }

            } else if (field[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

        }
//----------------------------------------------------------------------------------------------------------------------

        if (directions.isEmpty() && food > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }

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
                if (field[row][col] == 's') {
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

    private static int findFood(char[][] field) {
        int food = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'f') {
                    food++;
                }
            }
        }
        return food;
    }
}
