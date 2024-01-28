package _05_FunctionalProgramming._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println("Sir ".concat(name));

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);

    }
}
