package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _09_PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] days = new int[n];

        for (int i = 1; i < n; i++) {
            int lastDay = 0;
            while (!indexes.isEmpty() && plants[indexes.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, days[indexes.pop()]);
            }
            if (!indexes.isEmpty()) {
                days[i] = lastDay + 1;
            }
            indexes.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        return Arrays.stream(days).filter(day -> day >= 0).max().orElse(0);
    }
}
