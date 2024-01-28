package _05_FunctionalProgramming._02_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(num -> num += 1).toArray();
        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr).map(num -> num -= 1).toArray();
        Consumer<int[]> printConsumer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            switch (input) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
