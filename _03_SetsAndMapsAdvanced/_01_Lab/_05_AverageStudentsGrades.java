package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String name = inputArr[0];
            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(Double.parseDouble(inputArr[1]));
        }

        studentsGrades.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            value.forEach(v -> System.out.printf("%.2f ", v));
            System.out.printf("(avg: %.2f)%n", getAverage(studentsGrades.get(key)));
        });

    }

    private static double getAverage(List<Double> grades) {
        double average = 0;
        for (double grade : grades) {
            average += grade;
        }
        return average / grades.size();
    }
}
