package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _09_PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> populationInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] inputArr = input.split("\\|");
            String city = inputArr[0];
            String country = inputArr[1];
            long population = Long.parseLong(inputArr[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).put(city, population);
            input = scanner.nextLine();
        }

        populationInfo.entrySet().stream().sorted((c1, c2) -> {
            long totalPopulationFirst = c1.getValue().values().stream().mapToLong(l -> l).sum();
            long totalPopulationSecond = c2.getValue().values().stream().mapToLong(e -> e).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst); 
        }).forEach(entry -> {
            long totalPopulation = entry.getValue().values().stream().mapToLong(e -> e).sum();
            System.out.println(String.format("%s (total population: %d)", entry.getKey(), totalPopulation));
            Map<String, Long> cityInfo = entry.getValue();
            cityInfo.entrySet().stream().sorted((s1, s2) -> Long.compare(s2.getValue(),s1.getValue()))
                    .forEach(s-> System.out.println(String.format("=>%s: %d",s.getKey(),s.getValue())));
        });
    }
}
