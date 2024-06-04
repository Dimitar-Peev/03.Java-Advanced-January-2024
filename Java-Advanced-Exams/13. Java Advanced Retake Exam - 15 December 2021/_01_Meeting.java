package _14_Exams._13_JavaAdvancedRetakeExam_15December2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01_Meeting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(males::push);

        Queue<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(females::offer);
//-----------------------------------------------------------------------------------------
        int matchesCount = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int lastMale = males.peek();
            int firstFemale = females.peek();
			
            if (lastMale <= 0 || firstFemale <= 0) {
                if (lastMale <= 0) {
                    males.pop();
                }
                if (firstFemale <= 0) {
                    females.poll();
                }
            } else if (lastMale % 25 == 0 || firstFemale % 25 == 0) {
                if (lastMale % 25 == 0) {
                    males.pop(); // you should remove him
                    males.pop(); // and the next person of the same gender.
                }
                if (firstFemale % 25 == 0) {
                    females.poll(); // you should remove her
                    females.poll(); // and the next person of the same gender.
                }
            } else {
                if (lastMale == firstFemale) {
                    matchesCount++;
                    males.pop();
                    females.poll();
                } else {
                    females.poll();
                    males.push(males.pop() - 2);
                }
            }
        }
//-----------------------------------------------------------------------------------------
        System.out.println("Matches: " + matchesCount);
        System.out.println(males.isEmpty() ? "Males left: none"
                : String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println(females.isEmpty() ? "Females left: none"
                : String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
}