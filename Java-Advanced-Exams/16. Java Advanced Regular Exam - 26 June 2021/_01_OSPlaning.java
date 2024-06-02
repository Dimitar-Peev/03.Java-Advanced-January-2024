package _14_Exams._16_JavaAdvancedRegularExam_26June2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01_OSPlaning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tasks::push);

        Queue<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(threads::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
//-----------------------------------------------------------------------------------------------
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int firstThread = threads.peek();
            int lastTask = tasks.pop();

            if (lastTask == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d%n", firstThread, taskToBeKilled);
                System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                return;
            } else {
                threads.poll();
                if (firstThread < lastTask) {
                    tasks.push(lastTask);
                }
            }
        }

    }
}
