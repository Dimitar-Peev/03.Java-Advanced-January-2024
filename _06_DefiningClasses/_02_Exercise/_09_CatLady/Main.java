package _06_DefiningClasses._02_Exercise._09_CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Cat> cats = new HashMap<>();

        while (!"End".equals(input)) {
            String[] catData = input.split(" ");
            String catBreed = catData[0];
            String catName = catData[1];

            Cat cat = null;

            switch (catBreed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(catName, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(catName, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(catName, decibels);
                    break;
            }

            cats.put(catName, cat);
            input = scanner.nextLine();
        }

        String catNameToPrint = scanner.nextLine();
        if (cats.containsKey(catNameToPrint)) {
            System.out.println(cats.get(catNameToPrint));
        }

    }
}
