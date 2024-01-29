package _05_FunctionalProgramming._02_Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = e -> e % n == 0;
        numbers.removeIf(predicate);

        Collections.reverse(numbers);

        Consumer<Integer> consumer = e -> System.out.print(e + " ");
        numbers.forEach(consumer);
    }
}
