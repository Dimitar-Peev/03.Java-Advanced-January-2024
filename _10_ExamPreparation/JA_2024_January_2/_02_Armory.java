package _10_ExamPreparation.JA_2024_January_2;

import java.util.Scanner;

public class _02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] armoury = new String[n][n];

        fillMatrix(scanner, armoury);

        int[] officerCoordinates = findCoordinates(armoury, "A");

        int officerRow = officerCoordinates[0];
        int officerCol = officerCoordinates[1];

        armoury[officerRow][officerCol] = "-";

        // The program ends when the army officer buys blades for at least 65 gold coins,
        // or you guide him out of the armory.
        int goldCoins = 0;

        while (goldCoins < 65) {
            String command = scanner.nextLine();

            // Move
            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            if (isOutOfTheArmoury(armoury, officerRow, officerCol)) {
                break;
            }

            String officerPosition = armoury[officerRow][officerCol];
            armoury[officerRow][officerCol] = "-";
            // "M" - mirror, teleport to the other mirror
            if ("M".equals(officerPosition)) {
                // Find the coordinates of the other mirror
                int[] mirrorCoordinates = findCoordinates(armoury, "M");

                // Move the officer to the other mirror
                int mirrorRow = mirrorCoordinates[0];
                int mirrorCol = mirrorCoordinates[1];

                officerRow = mirrorRow;
                officerCol = mirrorCol;
                armoury[officerRow][officerCol] = "-";
            } else if (!"-".equals(officerPosition)) {  // Digit - buy the sword
                goldCoins += Integer.parseInt(officerPosition);
            }
        }

        if (goldCoins >= 65) {
            armoury[officerRow][officerCol] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.\n", goldCoins);

        print(armoury);
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
    }

    private static int[] findCoordinates(String[][] field, String symbol) {
        int[] coordinates = new int[2];

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (symbol.equals(field[row][col])) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }

    private static boolean isOutOfTheArmoury(String[][] armoury, int officerRow, int officerCol) {
        return officerRow < 0 || officerRow >= armoury.length ||
                officerCol < 0 || officerCol >= armoury[officerRow].length;
    }

    private static void print(String[][] armoury) {
        for (int row = 0; row < armoury.length; row++) {
            for (int col = 0; col < armoury[row].length; col++) {
                System.out.print(armoury[row][col]);
            }
            System.out.println();
        }
    }
}
