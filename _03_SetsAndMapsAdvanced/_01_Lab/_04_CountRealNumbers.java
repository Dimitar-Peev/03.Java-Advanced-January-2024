package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> values = new LinkedHashMap<>();

        for (double number : numbers) {
            values.putIfAbsent(number, 0);
            values.put(number, values.get(number) + 1);
        }

        values.forEach((k, v) -> {
            System.out.printf("%.1f -> %d%n", k, v);
        });
    }
}
