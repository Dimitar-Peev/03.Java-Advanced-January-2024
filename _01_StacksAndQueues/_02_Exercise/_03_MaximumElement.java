package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            switch (inputArr[0]) {
                case 1:
                    stack.push(inputArr[1]);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    System.out.println(getMaxElement(stack));
                    break;
            }
        }
    }

    public static int getMaxElement(Deque<Integer> stack) {
        int maxNum = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            maxNum = (integer > maxNum) ? integer : maxNum;
        }
        return maxNum;
    }
}
