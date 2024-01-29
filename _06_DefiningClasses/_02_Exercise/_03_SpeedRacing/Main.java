package _06_DefiningClasses._02_Exercise._03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(name, fuelAmount, fuelCost);
            cars.add(car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputArr = input.split("\\s+");
            String carModel = inputArr[1];
            int amountOfKm = Integer.parseInt(inputArr[2]);

            Car car = cars.stream().filter(c -> c.getModel().equals(carModel))
                    .findFirst()
                    .orElse(null);

            if (car != null && car.isFuelSufficient(amountOfKm)) {
                car.reduceFuel(amountOfKm);
                car.setDistanceTraveled(car.getDistanceTraveled() + amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }
        cars.forEach(System.out::println);
    }
}
