package _12_RegularExam_17February2024.DimitarPeev;

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> amountOfMoney = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(amountOfMoney::push);

        Queue<Integer> pricesOfFoods = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(pricesOfFoods::offer);
//-----------------------------------------------------------------------------------------------

        int foods = 0;
        while (!amountOfMoney.isEmpty() && !pricesOfFoods.isEmpty()) {
            int money = amountOfMoney.pop();
            int foodPrice = pricesOfFoods.poll();

            if (money == foodPrice) {
                foods++;
            } else if (money > foodPrice) {
                foods++;
                int diff = money - foodPrice;
                if (amountOfMoney.isEmpty()) {
                    amountOfMoney.push(diff);
                } else {
                    amountOfMoney.push(amountOfMoney.pop() + diff);
                }
            }
        }

        if (foods > 3) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", foods);
        } else if (foods == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else {
            if (foods == 1) {
                System.out.printf("Henry ate: %d food.%n", foods);
            } else {
                System.out.printf("Henry ate: %d foods.%n", foods);
            }
        }
    }
}
