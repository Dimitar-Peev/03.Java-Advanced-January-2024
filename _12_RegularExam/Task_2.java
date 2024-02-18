package _12_RegularExam_17February2024.DimitarPeev;

import java.util.Arrays;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] airspace = scanField(scanner, size);

        int[] jetfighter = locateJetfighter(airspace);
        int row = jetfighter[0];
        int col = jetfighter[1];

//-----------------------------------------------------------------------------------
        int armour = 300;
        int enemyPlanes = 0;

        while (armour > 0) {
            String command = scanner.nextLine();

            airspace[row][col] = '-';
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (airspace[row][col] == 'E') {
                enemyPlanes++;
                if (enemyPlanes == 4) {
                    break;
                }
                armour -= 100;
            } else if (airspace[row][col] == 'R') {
                armour = 300;
            }


        }
		
        airspace[row][col] = 'J';
        if (enemyPlanes == 4) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }

        if (armour <= 0) {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", row, col);
        }

        Arrays.stream(airspace).map(r -> Arrays.toString(r)
                .replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
    }

    private static char[][] scanField(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateJetfighter(char[][] field) {
        int[] jetfighter = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'J') {
                    jetfighter[0] = row;
                    jetfighter[1] = col;
                }
            }
        }
        return jetfighter;
    }
}
