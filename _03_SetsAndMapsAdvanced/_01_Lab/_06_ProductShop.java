package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.*;

public class _06_ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> foodShops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] inputArr = input.split(", ");
            String shop = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);

            foodShops.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> shopData = foodShops.get(shop);
            shopData.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        foodShops.forEach((k, v) -> {
            System.out.println(k + "->");
            v.forEach((key, value) -> {
                System.out.printf("Product: %s, Price: %.1f%n", key, value);
            });
        });
    }
}
