package _03_SetsAndMapsAdvanced._02_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String contact = scanner.nextLine();
        while (!"search".equals(contact)) {
            String[] contactDetails = contact.split("-");
            String name = contactDetails[0];
            String phoneNumber = contactDetails[1];
            phonebook.put(name, phoneNumber);
            contact = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }

    }
}
