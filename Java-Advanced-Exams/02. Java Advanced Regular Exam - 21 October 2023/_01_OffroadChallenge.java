package _14_Exams._02_JavaAdvancedRegularExam_21October2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _01_OffroadChallenge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> fuelSequence = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(fuelSequence::push);

        Queue<Integer> additionalConsumptionIndex = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(additionalConsumptionIndex::offer);

        Queue<Integer> amountOfFuelNeeded = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(amountOfFuelNeeded::offer);
//----------------------------------------------------------------------------------------------------------------------
        int counter = 0;
        int altitudesSize = amountOfFuelNeeded.size();
        List<String> reachedAltitudes = new LinkedList<>();

        while (!amountOfFuelNeeded.isEmpty()) {
            int fuel = fuelSequence.pop();
            int consumtionIndex = additionalConsumptionIndex.poll();
            int result = fuel - consumtionIndex;

            if (result >= amountOfFuelNeeded.poll()) {
                counter++;
                System.out.println("John has reached: Altitude " + counter);
                reachedAltitudes.add("Altitude " + counter);
            } else {
                System.out.println("John did not reach: Altitude " + (counter + 1));
                break;
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (reachedAltitudes.size() == altitudesSize) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
            if (counter == 0) {
                System.out.println("John didn't reach any altitude.");
            } else {
                System.out.print("Reached altitudes: ");
                System.out.println(String.join(", ", reachedAltitudes));
            }
        }
    }
}
