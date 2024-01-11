package _01_StacksAndQueues._02_Exercise;

import java.util.*;

public class _06_RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Long> stack = new ArrayDeque<>(Arrays.asList(1L, 0L)) ;

        int n = scanner.nextInt();

        if (n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }
        System.out.println(stack.pop());
    }
}