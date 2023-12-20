package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> graduationList = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            graduationList.put(name, grades);
        }

        graduationList.forEach((k, v) -> {
            System.out.println(k + " is graduated with " + getAverage(v));
        });

    }

    private static double getAverage(double[] grades) {
        double average = 0;
        for (double grade : grades) {
            average += grade;
        }
        return average / grades.length;
    }
}
