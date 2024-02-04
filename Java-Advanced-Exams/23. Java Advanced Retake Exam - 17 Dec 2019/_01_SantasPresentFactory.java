import java.util.*;
import java.util.stream.Collectors;

public class _01_SantasPresentFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(materials::push);

        Queue<Integer> magics = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(magics::offer);
//-----------------------------------------------------------------------------------------
        Map<String, Integer> presentsMap = new TreeMap<>();
        presentsMap.put("Doll", 0);
        presentsMap.put("Wooden train", 0);
        presentsMap.put("Teddy bear", 0);
        presentsMap.put("Bicycle", 0);

        while (!materials.isEmpty() && !magics.isEmpty()) {
            int material = materials.peek();
            int magic = magics.peek();

            if (material == 0 || magic == 0) {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magic == 0) {
                    magics.poll();
                }
                continue;
            }

            int totalMagic = magic * material;

            switch (totalMagic) {
                case 150:
                    presentsMap.put("Doll", presentsMap.get("Doll") + 1);
                    materials.pop();
                    magics.poll();
                    break;
                case 250:
                    presentsMap.put("Wooden train", presentsMap.get("Wooden train") + 1);
                    materials.pop();
                    magics.poll();
                    break;
                case 300:
                    presentsMap.put("Teddy bear", presentsMap.get("Teddy bear") + 1);
                    materials.pop();
                    magics.poll();
                    break;
                case 400:
                    presentsMap.put("Bicycle", presentsMap.get("Bicycle") + 1);
                    materials.pop();
                    magics.poll();
                    break;
                default:
                    if (totalMagic < 0) {
                        int sum = material + magic;
                        materials.pop();
                        magics.poll();
                        materials.push(sum);
                    } else if (totalMagic > 0) {
                        magics.poll();
                        materials.push(materials.pop() + 15);
                    }
                    break;
            }
        }

        boolean dollAndTrainPair = presentsMap.get("Doll") > 0 && presentsMap.get("Wooden train") > 0;
        boolean teddyBearAndBicyclePair = presentsMap.get("Teddy bear") > 0 && presentsMap.get("Bicycle") > 0;

        String result = dollAndTrainPair || teddyBearAndBicyclePair
                ? "The presents are crafted! Merry Christmas!"
                : "No presents this Christmas!";
        System.out.println(result);

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            String leftMaterials = materials.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(leftMaterials);
        }

        if (!magics.isEmpty()) {
            System.out.print("Magic left: ");
            String leftMagics = magics.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(leftMagics);
        }

        presentsMap.entrySet().stream().filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

    }
}
