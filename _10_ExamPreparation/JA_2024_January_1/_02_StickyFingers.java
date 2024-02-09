package _10_ExamPreparation.JA_2024_January_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _02_StickyFingers {
    private static String[][] field = null;
    private static Integer[] currentPosition;

    private static Integer totalMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dim = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        field = new String[dim][];
        Integer[] initialPosition = new Integer[2];

        for (int i = 0; i < dim; i++) {
            final int row = i;
            AtomicInteger integer = new AtomicInteger(0);
            field[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .peek(e -> {
                        int col = integer.getAndIncrement();
                        if ("D".equals(e)) {
                            initialPosition[0] = row;
                            initialPosition[1] = col;
                        }
                    }).toArray(String[]::new);
        }

        currentPosition = new Integer[]{initialPosition[0], initialPosition[1]};

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];
            boolean stop = false;
            switch (command) {
                case "up":
                    Integer[] newPosition = new Integer[]
                            {
                                    currentRow - 1,
                                    currentCol};
                    boolean isValid = validatePosition(dim, dim, newPosition);
                    if (isValid) {
                        stop = move(newPosition);
                    }
                    break;
                case "down":
                    newPosition = new Integer[]
                            {
                                    currentRow + 1,
                                    currentCol};
                    isValid = validatePosition(dim, dim, newPosition);
                    if (isValid) {
                        stop = move(newPosition);
                    }
                    break;
                case "left":
                    newPosition = new Integer[]
                            {
                                    currentRow,
                                    currentCol - 1};
                    isValid = validatePosition(dim, dim, newPosition);
                    if (isValid) {
                        stop = move(newPosition);
                    }
                    break;
                case "right":
                    newPosition = new Integer[]
                            {
                                    currentRow,
                                    currentCol + 1};
                    isValid = validatePosition(dim, dim, newPosition);
                    if (isValid) {
                        stop = move(newPosition);
                    }
                    break;
            }
            if (stop) {
                break;
            }

            if (i == commands.length - 1) {
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);

            }

        }

        for (String[] row : field) {
            System.out.println(String.join(" ", row));
        }

    }

    private static boolean move(Integer[] newPosition) {
        int newRow = newPosition[0];
        int newCol = newPosition[1];
        String newPositionSymbol = field[newRow][newCol];
        switch (newPositionSymbol) {
            case "+":
                field[newRow][newCol] = "D";
                field[currentPosition[0]][currentPosition[1]] = "+";
                currentPosition = newPosition;
                return false;
            case "$":
                int money = newRow * newCol;
                totalMoney += money;
                System.out.printf("You successfully stole %d$.%n", money);
                field[newRow][newCol] = "D";
                field[currentPosition[0]][currentPosition[1]] = "+";
                currentPosition = newPosition;
                return false;
            case "P":
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                field[newRow][newCol] = "#";
                field[currentPosition[0]][currentPosition[1]] = "+";
                currentPosition = newPosition;
                return true;
            default:
                return true;
        }
    }

    public static boolean validatePosition(int row, int col, Integer[] newPosition) {
        boolean isValid = newPosition[0] >= 0 && newPosition[0] < row &&
                newPosition[1] >= 0 && newPosition[1] < col;
        if (!isValid) {
            System.out.println("You cannot leave the town, there is police outside!");
        }
        return isValid;
    }
}
