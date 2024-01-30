import java.util.Scanner;

public class _02_CookingJourney {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = new char[n][n];

        int currentRow = 0, currentCol = 0;
        int firstPillarRow = 0, firstPillarCol = 0;
        int secondPillarRow = 0, secondPillarCol = 0;

        boolean weFoundFirstPillar = false;

        for (int row = 0; row < n; row++) {
            pastryShop[row] = scanner.nextLine().toCharArray();
			
            for (int col = 0; col < n; col++) {
				
                if (pastryShop[row][col] == 'S') {
                    currentRow = row;
                    currentCol = col;
                }
				
                if (pastryShop[row][col] == 'P' && !weFoundFirstPillar) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    weFoundFirstPillar = true;
                }
				
                if (pastryShop[row][col] == 'P' && weFoundFirstPillar) { 
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }

        int money = 0;
        while (money < 50) {
            String command = scanner.nextLine();

            int oldRow = currentRow;
            int oldCol = currentCol;

            switch (command) {
                case "left": currentCol--; break;
                case "right": currentCol++; break;
                case "up": currentRow--; break;
                case "down":currentRow++; break;
            }

            if (isOutOfBounds(currentCol, currentRow, n, pastryShop, oldRow, oldCol)) break;

            if (currentCol == firstPillarCol && currentRow == firstPillarRow) {
                currentRow = secondPillarRow;
                currentCol = secondPillarCol;
                pastryShop[oldRow][oldCol] = '-';
                pastryShop[firstPillarRow][firstPillarCol] = '-';
                pastryShop[currentRow][currentCol] = 'S';
            } else if (currentCol == secondPillarCol && currentRow == secondPillarRow) {
                currentRow = firstPillarRow;
                currentCol = firstPillarCol;
                pastryShop[oldRow][oldCol] = '-';
                pastryShop[secondPillarRow][secondPillarCol] = '-';
                pastryShop[currentRow][currentCol] = 'S';
            } else if (pastryShop[currentRow][currentCol] == '-') {
                pastryShop[oldRow][oldCol] = '-';
                pastryShop[currentRow][currentCol] = 'S';
            } else {
                money += Integer.parseInt(String.valueOf(pastryShop[currentRow][currentCol]));
                pastryShop[oldRow][oldCol] = '-';
                pastryShop[currentRow][currentCol] = 'S';
            }
        }

        String result = money >= 50
                ? "Good news! You succeeded in collecting enough money!"
                : "Bad news! You are out of the pastry shop.";
        System.out.println(result);

        System.out.println("Money: " + money);

        printMatrix(n, pastryShop);

    }

    private static void printMatrix(int size, char[][] matrix) {
        for (char[] chars : matrix) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int currentCol, int currentRow, int size, char[][] pastryShop, int oldRow, int oldCol) {
        if (currentCol < 0 || currentRow < 0 || currentRow >= size || currentCol >= size) {
            pastryShop[oldRow][oldCol] = '-';
            return true;
        }
        return false;
    }
}
