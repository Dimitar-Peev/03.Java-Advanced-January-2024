package _09_IteratorsAndComparators._02_Exercise._09_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countCommans = Integer.parseInt(scanner.nextLine());

        LinkedListTraversal list = new LinkedListTraversal();

        for (int i = 0; i < countCommans; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            if (command.equals("Add")) {
                list.add(number);
            } else if (command.equals("Remove")) {
                list.remove(number);
            }
        }

        System.out.println(list.size());

        list.forEach(e -> System.out.print(e + " "));
    }
}
