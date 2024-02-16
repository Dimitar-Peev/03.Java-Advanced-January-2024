package _14_Exams._07_JavaAdvancedRetakeExam_14December2022;

import java.util.Scanner;

public class _02_NavyBattle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = scanField(scanner, size);

        int[] submarine = locateSubmarine(battlefield);
        int row = submarine[0], col = submarine[1];
//--------------------------------------------------------------------------------------
        int minesHit = 0;
        int destroyedCruisers = 0;

        while (minesHit < 3 && destroyedCruisers < 3) {
            String command = scanner.nextLine();
            int oldRow = row, oldCol = col;

            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            battlefield[oldRow][oldCol] = '-';
            if (battlefield[row][col] == '*') {
                minesHit++;
            } else if (battlefield[row][col] == 'C') {
                destroyedCruisers++;
            }

            battlefield[row][col] = 'S';
        }

        if (minesHit == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
        }
        if (destroyedCruisers == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        printMatrix(battlefield);
    }
	
    private static char[][] scanField(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] locateSubmarine(char[][] field) {
        int[] submarine = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'S') {
                    submarine[0] = row;
                    submarine[1] = col;
                }
            }
        }
        return submarine;
    }
}
