package _01_StacksAndQueues._02_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
		
        StringBuilder text = new StringBuilder();
        Deque<String> memoryStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String argument = "";

            if (inputArr.length > 1) {
                argument = inputArr[1];
            }

            switch (inputArr[0]) {
                case "1": 
                    memoryStack.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    memoryStack.push(text.toString());
                    int count = Integer.parseInt(argument);
                    int start = text.length() - count;
                    text.delete(start, start + count);
                    break;
                case "3":
                    int index = Integer.parseInt(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4": 
                    if (!memoryStack.isEmpty()) {
                       text = new StringBuilder(memoryStack.pop());
                    }
                    break;
            }
        }
    }
}
