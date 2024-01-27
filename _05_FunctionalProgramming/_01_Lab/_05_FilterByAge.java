package _05_FunctionalProgramming._01_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split(",\\s+");
            people.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiFunction<Integer, String, Predicate<Integer>> predicateFactory = (ag, con) -> {
            if ("younger".equals(con)) {
                return a -> a <= ag;
            }
            return a -> a >= ag;
        };

        Function<String, Consumer<Map.Entry<String, Integer>>> consumerFactory = a -> {
            switch (a) {
                case "name":
                    return m -> System.out.println(m.getKey());
                case "age":
                    return m -> System.out.println(m.getValue());
                default:
                    return m -> System.out.println(m.getKey() + " - " + m.getValue());
            }
        };

        Predicate<Integer> predicate = predicateFactory.apply(age, condition);
        Consumer<Map.Entry<String, Integer>> consumer = consumerFactory.apply(format);

        people.entrySet().stream().filter(e->predicate.test(e.getValue())).forEach(consumer);
    }
}
