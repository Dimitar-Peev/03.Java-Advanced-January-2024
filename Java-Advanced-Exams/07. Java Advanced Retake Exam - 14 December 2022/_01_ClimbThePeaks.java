package _14_Exams._07_JavaAdvancedRetakeExam_14December2022;

import java.util.*;

public class _01_ClimbThePeaks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        Deque<Integer> foodPortions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(foodPortions::push);

        Queue<Integer> stamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(stamina::offer);
//-----------------------------------------------------------------------------------------------

        Map<String, Integer> conqueredPeaks = new LinkedHashMap<>();

        while (!foodPortions.isEmpty() && !stamina.isEmpty() && !peaks.isEmpty()) {
            int lastDailyFood = foodPortions.peek();
            int firstDailyStamina = stamina.peek();
            int sum = lastDailyFood + firstDailyStamina;
            String currentPeak = peaks.peek();

            if (sum >= 80 && currentPeak.equals("Vihren")) {
                addPeak(conqueredPeaks, "Vihren");
                peaks.poll();
            } else if (sum >= 90 && currentPeak.equals("Kutelo")) {
                addPeak(conqueredPeaks, "Kutelo");
                peaks.poll();
            } else if (sum >= 100 && currentPeak.equals("Banski Suhodol")) {
                addPeak(conqueredPeaks, "Banski Suhodol");
                peaks.poll();
            } else if (sum >= 60 && currentPeak.equals("Polezhan")) {
                addPeak(conqueredPeaks, "Polezhan");
                peaks.poll();
            } else if (sum >= 70 && currentPeak.equals("Kamenitza")) {
                addPeak(conqueredPeaks, "Kamenitza");
                peaks.poll();
            }

            removeParts(foodPortions, stamina);
        }

        String result = peaks.isEmpty() ? "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK"
                : "Alex failed! He has to organize his journey better next time -> @PIRINWINS";
        System.out.println(result);

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach((key, value) -> System.out.println(key));
        }
    }

    private static void addPeak(Map<String, Integer> conqueredPeeks, String currentPeak) {
        if (conqueredPeeks.containsKey(currentPeak)) {
            int count = conqueredPeeks.get(currentPeak);
            conqueredPeeks.put(currentPeak, count + 1);
        } else {
            conqueredPeeks.put(currentPeak, 1);
        }
    }

    private static void removeParts(Deque<Integer> foodPortions, Queue<Integer> stamina) {
        stamina.poll();
        foodPortions.pop();
    }
}
