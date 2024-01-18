package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
      
        Set<String> usernames = new LinkedHashSet<>(); 
      
        int n = Integer.parseInt(scanner.nextLine());
      
        for (int count = 0; count < n; count++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        usernames.forEach(System.out::println);
    }
}