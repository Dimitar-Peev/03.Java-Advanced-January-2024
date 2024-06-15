package _14_Exams._02_JavaAdvancedRegularExam_21October2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_FishingCompetition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte size = Byte.parseByte(scanner.nextLine());

        char[][] fishingArea = scanFishingArea(scanner, size);

        int[] captainPosition = locateCaptain(fishingArea);
        int row = captainPosition[0];
        int col = captainPosition[1];
//----------------------------------------------------------------------------------------------------------------------
        int amount = 0;
        boolean quotaIsReached = false;

        String input = scanner.nextLine();
        while (!"collect the nets".equals(input)) {
           String command = input;

            fishingArea[row][col] = '-';
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (col < 0) {
                col = size - 1;
            } else if (col > size - 1) {
                col = 0;
            }

            if (row < 0) {
                row = size - 1;
            } else if (row > size - 1) {
                row = 0;
            }

            if (Character.isDigit(fishingArea[row][col])) {
                amount += Integer.parseInt(fishingArea[row][col] + "");
                if (amount >= 20) {
                    quotaIsReached = true;
                }
            } else if (fishingArea[row][col] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]", row, col);
                return;
            }

            input = scanner.nextLine();
        }
//----------------------------------------------------------------------------------------------------------------------
        fishingArea[row][col] = 'S';
        if (quotaIsReached) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                    "You need %d tons of fish more.%n", 20 - amount);
        }

        if (amount > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", amount);
        }

        Arrays.stream(fishingArea).map(r -> Arrays.toString(r).replaceAll("[\\[\\], ]", "")).forEach(System.out::println);

    }

    private static char[][] scanFishingArea(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateCaptain(char[][] field) {
        int[] captain = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'S') {
                    captain[0] = row;
                    captain[1] = col;
                }
            }
        }
        return captain;
    }
}
