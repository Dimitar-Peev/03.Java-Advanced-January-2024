package _01_StacksAndQueues._02_Exercise;

import java.util.*;

public class _02_BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int count = 0; count < n; count++) {
            stack.push(scanner.nextInt());
        }

        for (int count = 0; count < s; count++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0); 
        } else if (stack.contains(x)) {
            System.out.println(true); 
        } else {
            System.out.println(Collections.min(stack)); 
        }
    }
}
