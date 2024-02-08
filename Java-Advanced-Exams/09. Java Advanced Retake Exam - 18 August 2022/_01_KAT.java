package _14_Exams._09_JavaAdvancedRetakeExam_18August2022;

import java.util.*;

public class _01_KAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> licensePlates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(licensePlates::offer);

        Deque<Integer> cars = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(cars::push);
//-----------------------------------------------------------------------------------------------
        int daysCount = 0;
        int registeredCars = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            int currentPlates = licensePlates.poll();
            int currentCars = cars.pop();

            if (currentPlates > currentCars * 2) {
                currentPlates -= currentCars * 2;
                registeredCars += currentCars;
                licensePlates.add(currentPlates);
            } else if (currentPlates < currentCars * 2) {
                currentCars -= currentPlates / 2;
                registeredCars += currentPlates / 2;
                cars.offer(currentCars);
            } else {
                registeredCars += currentCars;
            }

            daysCount++;
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, daysCount);

        if (licensePlates.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

        if (!licensePlates.isEmpty()) {
            System.out.println(licensePlates.stream().mapToInt(value -> value).sum() + " license plates remain!");
        }

        if (!cars.isEmpty()) {
            int sum = 0;
            for (int car : cars) {
                sum += car;
            }
            System.out.println(sum + " cars remain without license plates!");
        }

    }
}
