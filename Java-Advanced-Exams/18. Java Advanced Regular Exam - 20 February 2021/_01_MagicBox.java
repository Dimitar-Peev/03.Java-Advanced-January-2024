import java.util.*;

public class _01_MagicBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstBox::offer);

        Stack<Integer> secondBox = new Stack<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBox::push);

        int claimedItems = 0;
//-----------------------------------------------------------------------------------------------------------
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.pop();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBox.poll();
            } else {
                firstBox.offer(secondItem);
            }
        }
//-----------------------------------------------------------------------------------------------------------
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }

    }
}
