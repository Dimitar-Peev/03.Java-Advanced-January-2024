package _05_FunctionalProgramming._02_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {

    static List<String> names = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String line;
        while (!"Party!".equals(line= scanner.nextLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Double":
                    addOneMore(getPredicate(tokens));
                    break;
                case "Remove":
                    removeName(getPredicate(tokens));
                    break;
            }
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

    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;

        switch (tokens[1]) {
            case "StartsWith":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            default:
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
        }
        return predicate;
    }
}
