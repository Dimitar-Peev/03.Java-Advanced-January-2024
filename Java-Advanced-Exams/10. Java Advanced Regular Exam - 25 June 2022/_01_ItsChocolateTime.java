package _14_Exams._10_JavaAdvancedRegularExam_25June2022;

import java.util.*;

public class _01_ItsChocolateTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Double> milkQuantities = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).forEach(milkQuantities::offer);

        Deque<Double> cacaoPowderQuantities = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).forEach(cacaoPowderQuantities::push);
//-----------------------------------------------------------------------------------------------
        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkQuantities.isEmpty() && !cacaoPowderQuantities.isEmpty()) {
            Double firstMilkValue = milkQuantities.peek();
            Double lastCacaoPowderValue = cacaoPowderQuantities.peek();

            double cacaoPercentage = (lastCacaoPowderValue / (firstMilkValue + lastCacaoPowderValue)) * 100;

            if (cacaoPercentage == 30) {
                addChocolate(chocolates, "Milk Chocolate");
                removeParts(milkQuantities, cacaoPowderQuantities);
            } else if (cacaoPercentage == 50) {
                addChocolate(chocolates, "Dark Chocolate");
                removeParts(milkQuantities, cacaoPowderQuantities);
            } else if (cacaoPercentage == 100) {
                addChocolate(chocolates, "Baking Chocolate");
                removeParts(milkQuantities, cacaoPowderQuantities);
            } else {
                double milk = milkQuantities.poll();
                cacaoPowderQuantities.pop();
                milkQuantities.offer(milk + 10);
            }
        }

        String result = chocolates.size() == 3
                ? "It’s a Chocolate Time. All chocolate types are prepared."
                : "Sorry, but you didn't succeed to prepare all types of chocolates.";
        System.out.println(result);

        chocolates.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }

    private static void removeParts(Queue<Double> milkQuantities, Deque<Double> cacaoPowderQuantities) {
        milkQuantities.poll();
        cacaoPowderQuantities.pop();
    }

    private static void addChocolate(Map<String, Integer> chocolates, String current) {
        if (chocolates.containsKey(current)) {
            int count = chocolates.get(current);
            chocolates.put(current, count + 1);
        } else {
            chocolates.put(current, 1);
        }
    }
}
