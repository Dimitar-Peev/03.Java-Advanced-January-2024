package _05_FunctionalProgramming._01_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));

        Consumer<String> printToConsole = System.out::println;

        List<String> result = Arrays.stream(reader.readLine().split("\\s+")).filter(x-> isUpperCase.test(x)).collect(Collectors.toList());

        printToConsole.accept(String.valueOf(result.size()));
        result.forEach(printToConsole);
    }
}
