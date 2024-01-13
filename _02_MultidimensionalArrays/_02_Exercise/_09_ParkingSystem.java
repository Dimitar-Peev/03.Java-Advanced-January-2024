package _02_MultidimensionalArrays._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _09_ParkingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean[][] isOccupied  = readMatrix(scanner);

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String[] inputArr = input.split(" ");
            int entryRow = Integer.parseInt(inputArr[0]);
            int targetRow = Integer.parseInt(inputArr[1]);
            int targetCol = Integer.parseInt(inputArr[2]);

            boolean hasFoundPlace = false;
            int travelDistance = 1;
            travelDistance += Math.abs(targetRow - entryRow);

            if (!isOccupied [targetRow][targetCol]) {
                travelDistance += targetCol;
                isOccupied [targetRow][targetCol]=true;
                hasFoundPlace = true;
            } else {
                for (int offset = 1; offset < isOccupied[targetRow].length && !hasFoundPlace; offset++) {
                    if (targetCol - offset > 0 && !isOccupied[targetRow][targetCol - offset]){
                        isOccupied[targetRow][targetCol - offset] = true;
                        hasFoundPlace = true;
                        travelDistance += targetCol - offset;
                    }

                    if (!hasFoundPlace && targetCol + offset < isOccupied[targetRow].length
                            && !isOccupied[targetRow][targetCol + offset]){
                        isOccupied[targetRow][targetCol + offset] = true;
                        hasFoundPlace = true;
                        travelDistance += offset + targetCol;
                    }
                }
            }

            if (hasFoundPlace){
                System.out.println(travelDistance);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }

            input = scanner.nextLine();
        }
    }

    public static boolean[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        boolean[][] matrix = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row][0] = true;
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
