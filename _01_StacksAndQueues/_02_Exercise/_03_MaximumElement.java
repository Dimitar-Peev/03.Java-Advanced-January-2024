package _01_StacksAndQueues._02_Exercise;

import java.util.*;

public class _03_MaximumElement_v2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) { 
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            switch (line[0]) {
                case 1:
                    numbersStack.push(line[1]); 
                    break;
                case 2:
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop(); 
                    }
                    break;
                case 3:
                    System.out.println(getMaxElement(numbersStack));
                    break;
            }
        }
    }

    public static int getMaxElement(ArrayDeque<Integer> stack) {
        int maxNum = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            maxNum = (integer > maxNum) ? integer : maxNum;
        }
        return maxNum;
    }
}
