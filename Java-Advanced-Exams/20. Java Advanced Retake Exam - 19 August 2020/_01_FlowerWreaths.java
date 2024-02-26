import java.util.*;

public class _01_FlowerWreaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(lilies::push);

        Queue<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(roses::offer);
//-----------------------------------------------------------------------------------------------

        int wreathCount = 0;
        int storeForLater = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lilie = lilies.peek();
            int rose = roses.peek();
            int sum = lilie + rose;

            if (sum == 15) {
                wreathCount++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                lilies.push(lilies.pop() - 2);
            } else if (sum < 15) {
                storeForLater += sum;
                lilies.pop();
                roses.poll();
            }
        }

        int additionalWreath = storeForLater / 15;
        wreathCount += additionalWreath;

        if (wreathCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreathCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
        }
    }
}
