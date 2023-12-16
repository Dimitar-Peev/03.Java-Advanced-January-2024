import java.util.*;

public class _03_MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            switch (input[0]) {
                case 1:
                    numbersStack.push(input[1]);
                    break;
                case 2:
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop();
                    }
                    break;
                case 3:
                    System.out.println(Collections.max(numbersStack));
                    break;
            }
        }
    }
}
