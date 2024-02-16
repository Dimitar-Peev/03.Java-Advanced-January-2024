package _14_Exams._08_JavaAdvancedRegularExam_22October2022;

import java.util.Scanner;

public class _02_RallyRacing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = scanField(scanner, size);

        int row = 0, col = 0;

        int[] tunnel = findTunnel(matrix);
//-------------------------------------------------------------------------------
        boolean isFinished = false;
        int kilometersPassed = 0;

        String command = scanner.nextLine();
        while (!"End".equals(command) && !isFinished) {
            int oldRow = row, oldCol = col;

            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            matrix[oldRow][oldCol] = '.';
            if (matrix[row][col] == 'F') {
                kilometersPassed += 10;
                isFinished = true;
            } else if (matrix[row][col] == '.') {
                kilometersPassed += 10;
            } else if (matrix[row][col] == 'T') { 
                matrix[row][col] = '.';  
                findAnotherTunnel(matrix, tunnel); 
                row = tunnel[0]; 
                col = tunnel[1]; 
                kilometersPassed += 30;
            }

            command = scanner.nextLine();
        }

        matrix[row][col] = 'C'; 

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", kilometersPassed);
        printMatrix(matrix);
    }

    private static char[][] scanField(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static void findAnotherTunnel(char[][] matrix, int[] tunnel) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'O') {
                    tunnel[0] = row;
                    tunnel[1] = col;
                }
            }
        }
    }

    private static int[] findTunnel(char[][] matrix) {
        int[] tunnel = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'T') {
                    tunnel[0] = row;
                    tunnel[1] = col;
                }
            }
        }
        return tunnel;
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
