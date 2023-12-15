package _01_StacksAndQueues._01_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class _01_BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> history = new ArrayDeque<>();
        String currentURL = null; 

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {
            if ("back".equals(command)) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.removeFirst(); 
                }
            } else {
                if (currentURL != null) {
                    history.addFirst(currentURL); 
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}
