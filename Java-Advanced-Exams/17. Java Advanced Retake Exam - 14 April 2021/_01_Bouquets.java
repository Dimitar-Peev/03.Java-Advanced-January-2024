import java.util.*;

public class _01_Bouquets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> tulips = new Stack<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(tulips::push);

        Queue<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(daffodils::offer);

        int bouquets = 0;
        int leftFlowers = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int daffodil = daffodils.poll();
            int tulip = tulips.pop();
            int sum = tulip + daffodil;

            while (sum > 15) {
                tulip -= 2;
                sum = tulip + daffodil;
            }

            if (sum == 15) {
                bouquets++;
            } else {
                leftFlowers += sum;
            }
        }

        int bouquetsLeftFlowers = leftFlowers / 15;
        bouquets += bouquetsLeftFlowers;

       String result = bouquets >= 5
        ? String.format("You made it! You go to the competition with %d bouquets!", bouquets)
        : String.format("You failed... You need more %d bouquets.", 5 - bouquets);
        System.out.println(result);
    }
}
