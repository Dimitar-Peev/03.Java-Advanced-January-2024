package _05_FunctionalProgramming._02_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Print".equals(input)) {
            String[] inputArr = input.split(";");
            String predicateName = inputArr[1] + inputArr[2];

            if (inputArr[0].contains("Add")) {
                Predicate<String> predicate = getPredicate(inputArr);
                predicateMap.put(predicateName, predicate);
            } else {
                predicateMap.remove(predicateName);
            }
            input = scanner.nextLine();
        }

        guests.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicateMap.values()) {
                if (predicate.test(guest)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }

    public static Predicate<String> getPredicate(String[] inputArr) {
        Predicate<String> predicate = null;

        switch (inputArr[1]) {
            case "Starts with":
                predicate = name -> name.startsWith(inputArr[2]);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(inputArr[2]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(inputArr[2]);
                break;
            case "Contains":
                predicate = name -> name.contains(inputArr[2]);
                break;
        }

        return predicate;
    }
}
