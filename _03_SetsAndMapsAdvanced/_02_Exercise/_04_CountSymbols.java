package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolsCount = new TreeMap<>();

        for (char symbol : input.toCharArray()) {
            symbolsCount.putIfAbsent(symbol, 0);
            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
        }

        symbolsCount.forEach((k, v) -> System.out.printf("%c: %d time/s%n", k, v));

    }
}
