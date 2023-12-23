package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _09_PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
		
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> prevPlants = new ArrayDeque<>();
        prevPlants.push(0);

        int[] days = new int[plants.length];
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;

            while (!prevPlants.isEmpty() && plants[prevPlants.peek()] >= plants[x]) {
                maxDays = Integer.max(days[prevPlants.pop()], maxDays);
            }

            if (!prevPlants.isEmpty()) {
                days[x] = maxDays + 1;
            }

            prevPlants.push(x);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
