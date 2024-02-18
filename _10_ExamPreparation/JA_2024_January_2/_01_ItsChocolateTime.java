package _10_ExamPreparation.JA_2024_January_2;

import java.util.*;

public class _01_ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoStack::push);

        Map<String, Integer> chocolateMap = new TreeMap<>();

        // You need to stop producing chocolates
        // when you run out of milk or cacao powder values.
        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            // Take first milk
            double milk = milkQueue.poll();
            // Take last cacao
            double cacao = cacaoStack.pop();

            // Chocolate formula
            // (cacao / (milk + cacao) ) * 100
            double chocolate = (cacao / (milk + cacao)) * 100;

            if (chocolate == 30) {

                chocolateMap.putIfAbsent("Milk", 0);
                chocolateMap.put("Milk", chocolateMap.get("Milk") + 1);

            } else if (chocolate == 50) {
                chocolateMap.putIfAbsent("Dark", 0);
                chocolateMap.put("Dark", chocolateMap.get("Dark") + 1);

            } else if (chocolate == 100) {
                chocolateMap.putIfAbsent("Baking", 0);
                chocolateMap.put("Baking", chocolateMap.get("Baking") + 1);

            } else {
                milk += 10;
                milkQueue.offer(milk);
            }

        }

        if (chocolateMap.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolateMap.forEach((k, v) -> System.out.printf("# %s Chocolate --> %d\n", k, v));
    }
}
