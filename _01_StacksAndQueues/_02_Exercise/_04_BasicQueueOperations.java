package _01_StacksAndQueues._02_Exercise;

import java.util.*;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int count = 1; count <= n; count++) {
            queue.offer(scanner.nextInt());
        }

        for (int count = 1; count <= s; count++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
