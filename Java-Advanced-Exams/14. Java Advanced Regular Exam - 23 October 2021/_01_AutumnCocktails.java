package _14_Exams._14_JavaAdvancedRegularExam_23Oct2021;

import java.util.*;

public class _01_AutumnCocktails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(ingredients::offer);

        Deque<Integer> freshnessLevel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(freshnessLevel::push);
//-----------------------------------------------------------------------------------------------
        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int ingredient = ingredients.peek();
            if (ingredient == 0) {
                ingredients.poll();
                continue;
            }
            int freshLevel = freshnessLevel.peek();
            int totalFreshnessLevel = ingredient * freshLevel;

            switch (totalFreshnessLevel) {
                case 150:
                    addCocktail(cocktails, "Pear Sour");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 250:
                    addCocktail(cocktails, "The Harvest");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 300:
                    addCocktail(cocktails, "Apple Hinny");
                    removeParts(freshnessLevel, ingredients);
                    break;
                case 400:
                    addCocktail(cocktails, "High Fashion");
                    removeParts(freshnessLevel, ingredients);
                    break;
                default:
                    ingredient = ingredients.poll();
                    freshnessLevel.pop();
                    ingredients.offer(ingredient + 5);
                    break;
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        cocktails.forEach((k, v) -> System.out.printf(" # %s --> %d%n", k, v));

    }

    private static void addCocktail(Map<String, Integer> cocktails, String currentCocktail) {
        if (cocktails.containsKey(currentCocktail)) {
            int count = cocktails.get(currentCocktail);
            cocktails.put(currentCocktail, count + 1);
        } else {
            cocktails.put(currentCocktail, 1);
        }
    }

    private static void removeParts(Deque<Integer> freshnessLevel, Queue<Integer> ingredients) {
        ingredients.poll();
        freshnessLevel.pop();
    }
}
