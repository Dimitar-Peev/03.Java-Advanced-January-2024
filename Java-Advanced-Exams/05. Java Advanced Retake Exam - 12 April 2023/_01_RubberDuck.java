package _14_Exams._05_JavaAdvancedRetakeExam_12April2023;

import java.util.*;

public class _01_RubberDuck {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> time = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(time::offer);

        Deque<Integer> numberOfTasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(numberOfTasks::push);
//----------------------------------------------------------------------------------------------------------
        int countDarthVaderDucky = 0;
        int countThorDucky = 0;
        int countBigBlueRubberDucky = 0;
        int countSmallYellowRubberDucky = 0;

        while (!time.isEmpty() && !numberOfTasks.isEmpty()) {
            int timeForTask = time.poll();
            int singleTask =  numberOfTasks.pop();

            int result = timeForTask * singleTask;

            if (result >= 0 && result <= 60) {
                countDarthVaderDucky++;
            } else if (result >= 61 && result <= 120) {
                countThorDucky++;
            } else if (result >= 121 && result <= 180) {
                countBigBlueRubberDucky++;
            } else if (result >= 181 && result <= 240) {
                countSmallYellowRubberDucky++;
            } else if (result > 240) {
                time.offer(timeForTask);
                numberOfTasks.push(singleTask - 2);
            }
        }
//----------------------------------------------------------------------------------------------------------
        if (numberOfTasks.isEmpty()) {
            System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        }

        System.out.printf("Darth Vader Ducky: %d%n" +
                        "Thor Ducky: %d%n" +
                        "Big Blue Rubber Ducky: %d%n" +
                        "Small Yellow Rubber Ducky: %d%n",
                countDarthVaderDucky, countThorDucky, countBigBlueRubberDucky, countSmallYellowRubberDucky);
    }
}
