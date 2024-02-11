package _08_Generics._02_Exercise._11_Threeuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Threeuple> threeples = new ArrayList<>();

        readFirstThreeuples(scanner, threeples);
        readSecondThreeuples(scanner, threeples);
        readThirdThreeuples(scanner, threeples);
        printThreeuples(threeples);
    }

    private static void printThreeuples(List<Threeuple> threeples) {
        StringBuilder text = new StringBuilder();
        for (Threeuple threeuple : threeples) {
            text.append(threeuple).append(System.lineSeparator());
        }
        System.out.print(text);
    }

    private static void readFirstThreeuples(Scanner scanner, List<Threeuple> threeples) {
        String[] inputArr = scanner.nextLine().split("\\s+");
        StringBuilder fullName = new StringBuilder();
        String name = fullName.append(inputArr[0]).append(" ").append(inputArr[1]).toString();
        String address = inputArr[2];
        String town = inputArr[3];

        Threeuple<String, String, String> firstThreeuples = new Threeuple<>(name, address, town);
        threeples.add(firstThreeuples);
    }

    private static void readSecondThreeuples(Scanner scanner, List<Threeuple> threeples) {
        String[] inputArr = scanner.nextLine().split("\\s+");
        String name = inputArr[0];
        int litersOfBeer = Integer.parseInt(inputArr[1]);
        String drunk = inputArr[2];
        boolean isDrunk = true;
        if (!drunk.equals("drunk")) {
            isDrunk = false;
        }

        Threeuple<String, Integer, Boolean> secondThreeuples = new Threeuple<>(name, litersOfBeer, isDrunk);
        threeples.add(secondThreeuples);
    }

    private static void readThirdThreeuples(Scanner scanner, List<Threeuple> threeples) {
        String[] inputArr = scanner.nextLine().split("\\s+");
        String name = inputArr[0];
        double accountBalance = Double.parseDouble(inputArr[1]);
        String bankName = inputArr[2];

        Threeuple<String, Double, String> thirdThreeupless = new Threeuple<>(name, accountBalance, bankName);
        threeples.add(thirdThreeupless);
    }

}
