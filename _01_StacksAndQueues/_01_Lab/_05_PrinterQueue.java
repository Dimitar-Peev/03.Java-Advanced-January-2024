package _01_StacksAndQueues._01_Lab;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<String> printerQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!"print".equals(input)) {

            if ("cancel".equals(input)) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledDocument = printerQueue.poll();
                    System.out.println("Canceled " + canceledDocument);
                }
            } else {
                printerQueue.offer(input);
            }

            input = scanner.nextLine();
        }

        printerQueue.forEach(System.out::println);
    }
}
