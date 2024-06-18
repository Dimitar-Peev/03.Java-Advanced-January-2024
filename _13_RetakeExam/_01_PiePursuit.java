package _13_RetakeExam;

import java.util.*;
import java.util.stream.Collectors;

public class _01_PiePursuit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> contestantsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(contestantsQueue::offer);

        Stack<Integer> piesStack = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(piesStack::push);
//----------------------------------------------------------------------------------------------------------------------
        while (!piesStack.isEmpty() && !contestantsQueue.isEmpty()) {
            int contestantCapacity = contestantsQueue.poll();
            int pieSize = piesStack.pop();

            if (pieSize > contestantCapacity) {
                pieSize -= contestantCapacity;
                if (!piesStack.isEmpty()) {
                    if (pieSize == 1) {
                        piesStack.push(piesStack.pop() + 1);
                    } else {
                        piesStack.push(pieSize);
                    }
                } else {
                    piesStack.push(pieSize);
                }
            } else {
                contestantCapacity -= pieSize;
                if (contestantCapacity > 0) {
                    contestantsQueue.offer(contestantCapacity);
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (piesStack.isEmpty()) {
            if (!contestantsQueue.isEmpty()) {
                System.out.println("We will have to wait for more pies to be baked!");
                System.out.printf("Contestants left: %s%n", contestantsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                System.out.println("We have a champion!");
            }
        }

        if (contestantsQueue.isEmpty() && !piesStack.isEmpty()){
            System.out.println("Our contestants need to rest!");
            System.out.printf("Pies left: %s%n", piesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
