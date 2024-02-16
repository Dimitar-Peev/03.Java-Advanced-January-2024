package _14_Exams._08_JavaAdvancedRegularExam_22October2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01_EnergyDrinks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(milligramsOfCaffeine::push);

        Queue<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(energyDrinks::offer);
//-----------------------------------------------------------------------------------------------
        int coffeinStamat = 0;

        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int firstDrink = energyDrinks.poll();
            int lastMiligrams = milligramsOfCaffeine.pop();
            int sum = lastMiligrams * firstDrink;

            if (coffeinStamat + sum <= 300) {
                coffeinStamat += sum;
            } else {
                energyDrinks.offer(firstDrink);
                coffeinStamat -= 30;
                coffeinStamat = Math.max(0, coffeinStamat);
            }
        }

        String result = !energyDrinks.isEmpty()
                ? String.format("Drinks left: %s", energyDrinks.stream().map(String::valueOf).collect(Collectors.joining(", ")))
                : "At least Stamat wasn't exceeding the maximum caffeine.";
        System.out.println(result);

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", coffeinStamat);
    }
}
