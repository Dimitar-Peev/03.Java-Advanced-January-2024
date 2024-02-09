package _10_ExamPreparation.JA_2024_January_1;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Blacksmith {
    public static void main(String[] args) {
        Map<Integer, String> swordTable = new HashMap<>();
        swordTable.put(70, "Gladius");
        swordTable.put(80, "Shamshir");
        swordTable.put(90, "Katana");
        swordTable.put(110, "Sabre");

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);

        Map<String, Integer> forgedSwords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            Integer steel = steelQueue.poll();
            Integer carbon = carbonStack.pop();
            Integer forgedValue = steel + carbon;

            if (swordTable.containsKey(forgedValue)) {
                String sword = swordTable.get(forgedValue);
                forgedSwords.putIfAbsent(sword, 0);
                forgedSwords.put(sword, forgedSwords.get(sword) + 1);

            } else {
                carbon += 5;
                carbonStack.push(carbon);
            }

        }

        if (forgedSwords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
            printDeque(steelQueue, "Steel left: %s%n");
            printDeque(carbonStack, "Carbon left: %s%n");
        } else {
            System.out.printf("You have forged %d swords.%n", forgedSwords.values().stream()
                    .mapToInt(e -> e)
                    .sum());
            printDeque(steelQueue, "Steel left: %s%n");
            printDeque(carbonStack, "Carbon left: %s%n");
            forgedSwords.forEach((key, val) -> System.out.println(key + ": " + val));
        }
    }

    public static void printDeque(Deque<Integer> deque, String format) {
        System.out.printf(format, deque.isEmpty() ? "none" :
                deque.stream().map(String::valueOf)
                        .collect(Collectors.joining(", ")));
    }
}
