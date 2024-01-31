package _05_FunctionalProgramming._02_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {

    static List<String> names = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Party!".equals(input)) {
            String[] inputArr = input.split("\\s+");

            switch (inputArr[0]) {
                case "Double":
                    addOneMore(getPredicate(inputArr));
                    break;
                case "Remove":
                    removeName(getPredicate(inputArr));
                    break;
            }
			input = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.print(String.join(", ", names) + " are going to the party!");
        }
    }

    public static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    public static void addOneMore(Predicate<String> predicate) {
        List<String> nameToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(nameToAdd::add);
        names.addAll(nameToAdd);
    }

    public static Predicate<String> getPredicate(String[] inputArr) {
        Predicate<String> predicate = null;

        switch (inputArr[1]) {
            case "StartsWith":
                predicate = name -> name.startsWith(inputArr[2]);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(inputArr[2]);
                break;
            default:
                predicate = name -> name.length() == Integer.parseInt(inputArr[2]);
                break;
        }
        return predicate;
    }
}
