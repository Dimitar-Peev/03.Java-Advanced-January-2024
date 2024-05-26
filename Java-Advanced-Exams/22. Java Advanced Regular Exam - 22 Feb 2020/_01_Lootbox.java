import java.util.*;

public class _01_Lootbox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> firstLootBox = new ArrayDeque<>();
        for (int num : firstLine) {
            firstLootBox.offer(num);
        }

        int[] secondLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> secondLootBox = new ArrayDeque<>();
        for (int num : secondLine) {
            secondLootBox.push(num);
        }
//------------------------------------------------------------------------------------------------------------------
        int collectedItems = 0;
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int item = firstLootBox.peek() + secondLootBox.peek();

            if (item % 2 == 0) {
                collectedItems += item;
                firstLootBox.poll();
                secondLootBox.pop();
            } else {
                firstLootBox.offer(secondLootBox.pop());
            }
        }
//------------------------------------------------------------------------------------------------------------------

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (collectedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + collectedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + collectedItems);
        }
    }
}
