import java.util.*;
import java.util.stream.Collectors;

public class _01_Cooking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(liquids::offer);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(ingredients::push);
//-----------------------------------------------------------------------
        TreeMap<String, Integer> cookedFoods = new TreeMap<>();
        cookedFoods.put("Bread", 0);
        cookedFoods.put("Cake", 0);
        cookedFoods.put("Pastry", 0);
        cookedFoods.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.peek();
            int ingredient = ingredients.peek();
            int sum = ingredient + liquid;

            switch (sum) {
                case 25:
                    addFood(cookedFoods, "Bread");
                    removeParts(liquids, ingredients);
                    break;
                case 50:
                    addFood(cookedFoods, "Cake");
                    removeParts(liquids, ingredients);
                    break;
                case 75:
                    addFood(cookedFoods, "Pastry");
                    removeParts(liquids, ingredients);
                    break;
                case 100:
                    addFood(cookedFoods, "Fruit Pie");
                    removeParts(liquids, ingredients);
                    break;
                default:
                    ingredient = ingredients.pop();
                    liquids.poll();
                    ingredients.push(ingredient + 3);
                    break;
            }
        }

        if (hasCooked(cookedFoods)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String liquidsOutput = "Liquids left: "
                + (liquids.isEmpty() ? "none"
                : liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(liquidsOutput);

        String ingredientsOutput = "Ingredients left: "
                + (ingredients.isEmpty() ? "none"
                : ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(ingredientsOutput);

        cookedFoods.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void addFood(Map<String, Integer> cookedFoods, String food) {
        if (cookedFoods.containsKey(food)) {
            int count = cookedFoods.get(food);
            cookedFoods.put(food, count + 1);
        }
    }

    private static void removeParts(Queue<Integer> liquids, Deque<Integer> ingredients) {
        ingredients.pop();
        liquids.poll();
    }

    private static boolean hasCooked(TreeMap<String, Integer> cookedFoods) {
        return cookedFoods.get("Bread") > 0
                && cookedFoods.get("Cake") > 0
                && cookedFoods.get("Fruit Pie") > 0
                && cookedFoods.get("Pastry") > 0;
    }
}
