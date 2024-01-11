package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Character> openBrackets = new ArrayDeque<>();

        String brackets = "({[";

        boolean areBalanced = true;

        for (char currentBracket : input.toCharArray()) {
            if (brackets.contains(currentBracket + "")) {
                openBrackets.push(currentBracket);
            } else {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char top = openBrackets.pop();

                if (!(top == '(' && currentBracket == ')' 
                        || top == '{' && currentBracket == '}'
                        || top == '[' && currentBracket == ']')) {
                    areBalanced = false;
                    break;
                }
            }
        }
        String result = areBalanced ? "YES" : "NO";
        System.out.println(result);
    }
}