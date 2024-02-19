package _14_Exams._06_JavaAdvancedRegularExam_18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_ApocalypsePreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(textiles::offer);

        Deque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(medicaments::push);
//-----------------------------------------------------------------------------------------------
        Map<String, Integer> healingItems = new TreeMap<>();

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.peek();
            int medicament = medicaments.peek();
            int sum = textile + medicament;

            switch (sum) {
                case 30:
                    addItem(healingItems, "Patch");
                    removeParts(textiles, medicaments);
                    break;
                case 40:
                    addItem(healingItems, "Bandage");
                    removeParts(textiles, medicaments);
                    break;
                case 100:
                    addItem(healingItems, "MedKit");
                    removeParts(textiles, medicaments);
                    break;
                default:
                    if (sum > 100) {
                        addItem(healingItems, "MedKit");
                        removeParts(textiles, medicaments);
                        int result = sum - 100;
                        medicaments.push(medicaments.pop() + result);
                    } else {
                        textiles.poll();
                        int newValue = medicaments.pop() + 10;
                        medicaments.push(newValue);
                    }
                    break;
            }
        }
       if (textiles.isEmpty() && medicaments.isEmpty()){
           System.out.println("Textiles and medicaments are both empty.");
       } else if (medicaments.isEmpty()) {
           System.out.println("Medicaments are empty.");
       } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
       }

        healingItems.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                });

        if (!medicaments.isEmpty()) {
            System.out.printf("Medicaments left: %s%n", medicaments.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!textiles.isEmpty()){
            System.out.printf("Textiles left: %s%n", textiles.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }

    private static void addItem(Map<String, Integer> healingItems, String item) {
        if (healingItems.containsKey(item)) {
            int count = healingItems.get(item);
            healingItems.put(item, count + 1);
        } else {
            healingItems.put(item, 1);
        }
    }

    private static void removeParts(Queue<Integer> textiles, Deque<Integer> medicaments) {
        textiles.poll();
        medicaments.pop();
    }
}
