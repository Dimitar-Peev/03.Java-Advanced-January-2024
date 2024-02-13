package _09_IteratorsAndComparators._02_Exercise._03_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] initialValues = scanner.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            if (input.equals("Pop")) {
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                customStack.push(Integer.parseInt(input.split("\\s+")[1]));
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < 2; i++) {
            for (Integer element : customStack) {
                System.out.println(element);
            }
        }
    }
}
