package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] inputArr = input.split(", ");
            if (inputArr[0].equals("IN")) {
                parkingLot.add(inputArr[1]);
            } else {
                parkingLot.remove(inputArr[1]);
            }
            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
