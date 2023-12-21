package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_Largest3Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int size = Math.min(sorted.size(), 3);

        for (int i = 0; i < size; i++) {
            System.out.print(sorted.get(i) + " ");
        }
    }
}
