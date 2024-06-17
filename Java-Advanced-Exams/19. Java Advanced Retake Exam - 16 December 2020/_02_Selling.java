package _14_Exams._19_JavaAdvancedRetakeExam_16December2020;

import java.util.Scanner;

public class _02_Selling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte size = Byte.parseByte(scanner.nextLine());

        char[][] bakery = bakery(scanner, size);

        int[] seller = locateSeller(bakery);
        int row = seller[0];
        int col = seller[1];
//-------------------------------------------------------------------------------------------------
        int money = 0;
        while (money < 50) {
            bakery[row][col] = '-';

            String command = scanner.nextLine();
            switch (command) {
                case "up": row--; break;
                case "down": row++; break;
                case "left": col--; break;
                case "right": col++; break;
            }

            // If the player goes to the void, print:
            if (!isInBounds(row, col, bakery)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            char symbol = bakery[row][col];
 
            if (Character.isDigit(symbol)) { 
                money += Integer.parseInt(String.valueOf(symbol)); 
                bakery[row][col] = 'S'; 
            } else if (symbol == 'O') { 
                bakery[row][col] = '-';  
                findPillar(bakery, seller); 
                row = seller[0]; 
                col = seller[1]; 
                bakery[row][col] = 'S';
            } else {
                bakery[row][col] = 'S';
            }

        }
//-------------------------------------------------------------------------------------------------
        // If the player collects enough star power, print:
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        printMatrix(bakery);
    }

    private static char[][] bakery(Scanner scanner, int size) {
        char[][] matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }

    private static int[] locateSeller(char[][] bakery) {
        int[] seller = new int[2];
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col] == 'S') {
                    seller[0] = row;
                    seller[1] = col;
                }
            }
        }
        return seller;
    }

    private static boolean isInBounds(int row, int col, char[][] bakery) {
        return row >= 0 && row < bakery.length && col >= 0 && col < bakery[row].length;
    }

    private static void findPillar(char[][] bakery, int[] seller) {
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col] == 'O') {
                    seller[0] = row;
                    seller[1] = col;
                }
            }
        }
    }


    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

}
