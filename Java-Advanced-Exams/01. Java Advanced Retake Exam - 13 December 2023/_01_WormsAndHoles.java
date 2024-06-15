package _14_Exams._01_JavaAdvancedRetakeExam_13Dec2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_WormsAndHoles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> worms = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(worms::push);

        Queue<Integer> holes = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(holes::offer);
//----------------------------------------------------------------------------------------------------------------------
        int matches = 0;
        int wormsInitialValue = worms.size();

        while (!worms.isEmpty() && !holes.isEmpty()) {
            int lastWorm = worms.peek();
            int firstHole = holes.peek();

            if (lastWorm == firstHole) {
                matches++;
                worms.pop();
                holes.poll();
            } else {
                int newValue = worms.pop() - 3;
                if (newValue > 0) {
                    worms.push(newValue);
                }
                holes.poll();
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (matches > 0) {
            System.out.println("Matches: " + matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (worms.isEmpty()) {
            if (matches == wormsInitialValue) {
                System.out.println("Every worm found a suitable hole!");
            } else {
                System.out.println("Worms left: none");
            }
        } else {
            List<Integer> wormsLeft = new ArrayList<>(worms);
            Collections.reverse(wormsLeft);
            System.out.printf("Worms left: %s%n", wormsLeft.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!holes.isEmpty()) {
            System.out.printf("Holes left: %s%n", holes.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Holes left: none");
        }

    }
}
