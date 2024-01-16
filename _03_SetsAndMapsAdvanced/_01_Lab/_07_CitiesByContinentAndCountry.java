package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.*;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> info = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputArr = scanner.nextLine().split(" ");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            info.putIfAbsent(continent, new LinkedHashMap<>());
            info.get(continent).putIfAbsent(country, new ArrayList<>());
            info.get(continent).get(country).add(city);
        }

        info.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((k, v) -> {
                System.out.printf("  %s -> %s%n", k, String.join(", ", v));
            });
        });
    }
}
