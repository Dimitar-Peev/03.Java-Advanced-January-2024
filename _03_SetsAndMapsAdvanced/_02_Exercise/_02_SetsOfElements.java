package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < first + second; i++) {
            if (i < first) {
                firstSet.add(scanner.nextInt());
            } else {
                secondSet.add(scanner.nextInt());
            }
        }

        firstSet.forEach(e -> {
            if (secondSet.contains(e)) {
                System.out.print(e + " ");
            }
        });
    }
}
