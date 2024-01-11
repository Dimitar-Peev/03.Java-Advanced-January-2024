package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String argument = "";
            String command = inputArr[0];

            if (inputArr.length > 1) {
                argument = inputArr[1];
            }

            switch (command) {
                case "1": 
                    stack.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    stack.push(text.toString());
                    int count = Integer.parseInt(argument);
                    int start = text.length() - count;
                    text.delete(start, start + count);
                    break;
                case "3":
                    int index = Integer.parseInt(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4": 
                    if (!stack.isEmpty()) {
                       text = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}
