package _14_Exams._03_JavaAdvancedRegularExam_17June2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MouseInTheKitchen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = size[0], m = size[1];

        char[][] cupboard = scanField(scanner, n, m);

        int[] mousePosition = locateMouse(cupboard);
        int row = mousePosition[0];
        int col = mousePosition[1];

        int allCheeseOnTheField = countCheese(cupboard);
//-----------------------------------------------------------------------
        boolean theLastCheese = false;
        boolean trapped = false;

        String command = scanner.nextLine();
        while (!"danger".equals(command)) {

            int oldRow = row, oldCol = col;

            cupboard[row][col] = '*';
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            if (isOutOfBounds(row, col, cupboard)) {
                row = oldRow;
                col = oldCol;
                cupboard[row][col] = 'M';
                System.out.println("No more cheese for tonight!");
                print(cupboard);
                return;
            }

            if (cupboard[row][col] == 'T') {
                cupboard[row][col] = 'M';
                trapped = true;
                break;
            } else if (cupboard[row][col] == 'C') {
                cupboard[row][col] = 'M';
                allCheeseOnTheField--;
                if (allCheeseOnTheField == 0) {
                    theLastCheese = true;
                    break;
                }
            } else if (cupboard[row][col] == '@') {
                row = oldRow;
                col = oldCol;
                cupboard[row][col] = 'M';
            }
            command = scanner.nextLine();
        }


        if (theLastCheese) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        }

        if (command.equals("danger") && allCheeseOnTheField != 0) {
            System.out.println("Mouse will come back later!");
        }

        if (trapped) {
            System.out.println("Mouse is trapped!");
        }

        print(cupboard);

    }

    private static void print(char[][] cupboard) {
        Arrays.stream(cupboard).map(r -> Arrays.toString(r)
                .replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
    }

    private static char[][] scanField(Scanner scanner, int n, int m) {
        char[][] matrix = new char[n][m];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static int[] locateMouse(char[][] field) {
        int[] mousePosition = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'M') {
                    mousePosition[0] = row;
                    mousePosition[1] = col;
                }
            }
        }
        return mousePosition;
    }

    private static int countCheese(char[][] matrix) {
        int cheese = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'C') {
                    cheese++;
                }
            }
        }
        return cheese;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

}
