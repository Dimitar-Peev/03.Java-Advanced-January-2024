import java.util.*;

public class _01_PastryShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(liquids::offer);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredients::push);
//---------------------------------------------------------------------------------------------
        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            Integer liquid = liquids.poll();
            Integer ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25: biscuitCount++; break;
                case 50: cakeCount++; break;
                case 75: pastryCount++; break;
                case 100: pieCount++; break;
                default: ingredients.push(ingredient + 3); break;
            }
        }

        if (biscuitCount != 0 && cakeCount != 0 && pastryCount != 0 && pieCount != 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]",""));
        }

        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]",""));
        }

        System.out.println("Biscuit: " + biscuitCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Pie: " +  pieCount);
        System.out.println("Pastry: "+ pastryCount);
    }
}
