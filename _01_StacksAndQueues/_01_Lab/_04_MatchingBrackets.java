package _01_StacksAndQueues._01_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currSymbol = input.charAt(i);

            if (currSymbol == '(') {
                stack.push(i);
            } else if (currSymbol == ')') {
                int startIndex = stack.pop();
                String output = input.substring(startIndex, i + 1);
                System.out.println(output);
            }
        }
    }
}
