import java.util.*;
import java.util.stream.Collectors;

public class _01_TempleOfDoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(tools::offer);

        Stack<Integer> substances = new Stack<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(substances::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
//----------------------------------------------------------------------------------------------------------------------------------
        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {
            int tool = tools.poll();
            int substance = substances.peek();
            int multiply = tool * substance;

            if (challenges.contains(multiply)) {
                challenges.remove(Integer.valueOf(multiply));
                substances.pop();
            } else {
                tools.offer(tool + 1);
                substances.push(substances.pop() - 1);

                if (substances.peek() == 0) {
                    substances.pop();
                }

            }
        }

        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!tools.isEmpty()) {
            System.out.println("Tools: " + tools.toString().replace("[", "").replace("]", ""));
        }
        if (!substances.isEmpty()) {
            System.out.println("Substances: " + substances.toString().replace("[", "").replace("]", ""));
        }
        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.toString().replace("[", "").replace("]", ""));
        }

    }
}
