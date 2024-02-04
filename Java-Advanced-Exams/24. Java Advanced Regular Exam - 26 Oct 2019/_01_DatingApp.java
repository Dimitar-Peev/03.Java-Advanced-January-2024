import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_DatingApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int female = females.peek();
            int male = males.peek();

            if (female <= 0) {
                females.poll();
                continue;
            } else if (male <= 0) {
                males.pop();
                continue;
            }

            if (female % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            } else if (male % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }

            if (female == male) {
                matches++;
                females.poll();
                males.pop();
            } else {
                females.poll();
                males.push(males.pop() - 2);
            }
        }

        System.out.println("Matches: " + matches);
        System.out.println("Males left: " + formatArrayDeque(males));
        System.out.println("Females left: " + formatArrayDeque(females));

    }

    private static String formatArrayDeque(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }

        return deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
