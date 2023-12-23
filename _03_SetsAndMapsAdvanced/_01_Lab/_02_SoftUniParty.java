package _03_SetsAndMapsAdvanced._01_Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> guestList = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)){
            guestList.add(input);
            input= scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"END".equals(input)){
            guestList.remove(input);
            input= scanner.nextLine();
        }

        System.out.println(guestList.size());
        guestList.forEach(System.out::println);
    }
}
