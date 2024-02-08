package _08_Generics._02_Exercise._09_CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> elements = new CustomList<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] inputArr = input.split("\\s+");
            String commandName = inputArr[0];

            switch (commandName) {
                case "Add":
                    String elementToAdd = inputArr[1];
                    elements.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputArr[1]);
                    elements.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToCheck = inputArr[1];
                    System.out.println(elements.contains(elementToCheck));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(inputArr[1]);
                    int index2 = Integer.parseInt(inputArr[2]);
                    elements.swap(index1, index2);
                    break;
                case "Greater":
                    String elementToCompare = inputArr[1];
                    System.out.println(elements.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(elements.getMax());
                    break;
                case "Min":
                    System.out.println(elements.getMin());
                    break;
                case "Print":
                    System.out.println(elements);
                    break;
                case "Sort":
                    Sorter.sort(elements);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
