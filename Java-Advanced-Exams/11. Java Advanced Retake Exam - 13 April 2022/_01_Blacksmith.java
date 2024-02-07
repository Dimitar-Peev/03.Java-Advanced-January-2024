package _14_Exams._11_JavaAdvancedRetakeExam_13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Blacksmith {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> steels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(steels::offer);

        Deque<Integer> carbons = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(carbons::push);
//-----------------------------------------------------------------------------------------------
        Map<String, Integer> swords = new TreeMap<>();

        while (!steels.isEmpty() && !carbons.isEmpty()) {
            int steel = steels.peek();
            int carbon = carbons.peek();
            int sum = steel + carbon;

            switch (sum) {
                case 70:
                    addSword(swords, "Gladius");
                    removeParts(steels, carbons);
                    break;
                case 80:
                    addSword(swords, "Shamshir");
                    removeParts(steels, carbons);
                    break;
                case 90:
                    addSword(swords, "Katana");
                    removeParts(steels, carbons);
                    break;
                case 110:
                    addSword(swords, "Sabre");
                    removeParts(steels, carbons);
                    break;
                default:
                    carbon = carbons.pop();
                    steels.poll();
                    carbons.push(carbon + 5);
                    break;
            }
        }

        if (!swords.isEmpty()) {
            System.out.printf("You have forged %d swords.%n", swords.values().stream().mapToInt(Integer::valueOf).sum());
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        String steelsOutput = "Steel left: "
                + (steels.isEmpty() ? "none"
                : steels.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(steelsOutput);

        String carbonsOutput = "Carbon left: "
                + (carbons.isEmpty() ? "none"
                : carbons.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(carbonsOutput);

        swords.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }

    private static void addSword(Map<String, Integer> swords, String sword) {
        if (swords.containsKey(sword)) {
            int count = swords.get(sword);
            swords.put(sword, count + 1);
        } else {
            swords.put(sword, 1);
        }
    }

    private static void removeParts(Queue<Integer> steels, Deque<Integer> carbons) {
        steels.poll();
        carbons.pop();
    }
}
