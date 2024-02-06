package _08_Generics._02_Exercise._06_GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }

        Double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.countNumberOfGreaterElements(elementToCompare));

    }
}
