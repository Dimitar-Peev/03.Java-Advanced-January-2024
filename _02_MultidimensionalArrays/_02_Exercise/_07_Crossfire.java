package _02_MultidimensionalArrays._02_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimentions[0];
        int cols = dimentions[1];

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(rows, cols);

        String input = scanner.nextLine();

        while (!"Nuke it from orbit".equals(input)) {
            int[] inputArr = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = inputArr[0];
            int col = inputArr[1];
            int radius = inputArr[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInRange(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }

            for (int c = col - radius; c <= col + radius; c++) {
                if (isInRange(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                matrix.set(i, matrix.get(i).stream().filter(e -> e != 0).collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                    i--;
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    public static boolean isInRange(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(value++);
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i).toString().replaceAll("\\[|\\]|,", ""));
        }
    }
}
