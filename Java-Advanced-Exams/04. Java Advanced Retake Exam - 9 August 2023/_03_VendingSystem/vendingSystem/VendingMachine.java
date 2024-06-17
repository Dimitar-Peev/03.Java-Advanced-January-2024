package _14_Exams._04_JavaAdvancedRetakeExam_9August2023.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return drinks.removeIf(d -> d.getName().equals(name));
    }

    public Drink getLongest() {
        return drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest() {
        return drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    public String buyDrink(String name) {
        Drink buyDrink = null;
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                buyDrink = drink;
            }
        }
        return buyDrink.toString();
    }


    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Drinks available:").append(System.lineSeparator());

        for (Drink drink : drinks) {
            text.append(drink.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
