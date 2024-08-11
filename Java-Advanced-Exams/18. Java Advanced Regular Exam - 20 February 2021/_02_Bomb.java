import java.util.Scanner;

public class _02_Bomb {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[n][n];

        int sapperRow = 0, sapperCol = 0;
        int bombCounter = 0;

        for (int row = 0; row < n; row++) {
            char[] arr = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < n; col++) {
                char currentChar = arr[col];

                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (currentChar == 'B') {
                    bombCounter++;
                }
				
                matrix[row][col] = currentChar;
            }
        }

        for (String command : commands) {

            switch (command) {
                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow != n - 1) {
                        sapperRow++;
                    }
                    break;
                case "right":
                    if (sapperCol != n - 1) {
                        sapperCol++;
                    }
                    break;
                case "left":
                    if (sapperCol != 0) {
                        sapperCol--;
                    }
                    break;
            }

            if (matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = '+';
                bombCounter--;
                if (bombCounter == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombCounter);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter, sapperRow, sapperCol);
    }
}
