import java.util.Scanner;

public class _02_Bee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];

        int beeRow = -1;
        int beeCol = -1;

        for (int i = 0; i < size; i++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                territory[i][j] = singleRow[j];

                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }

        int flowers = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            territory[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                territory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                flowers++;

            } else if (territory[beeRow][beeCol] == 'O') {
                continue;
            }

            territory[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        print(territory);
    }

    public static void print(char[][] territory) {
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }
    }
}
