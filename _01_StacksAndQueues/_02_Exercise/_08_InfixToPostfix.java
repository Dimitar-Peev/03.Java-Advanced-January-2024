package _01_StacksAndQueues._02_Exercise;

import java.util.*;

public class _08_InfixToPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        Deque<String> operatorsStack = new ArrayDeque<>();
        Queue<String> outputQueue = new ArrayDeque<>();

        for (String current : inputArr) {
            if (!"-+/*()".contains(current)) {
                outputQueue.offer(current);
            } else if (current.equals("(")) {
                operatorsStack.push(current);
            } else if (current.equals(")") && (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("("))) {
                outputQueue.offer(operatorsStack.pop());
                operatorsStack.pop();
            } else {
                if ("-+".contains(current)) {
                    while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                } else {
                    while (!operatorsStack.isEmpty() && !"+-(".contains(operatorsStack.peek())) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                }
                operatorsStack.push(current);
            }
        }

        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }

        outputQueue.forEach(e -> System.out.print(e + " "));
    }
}
