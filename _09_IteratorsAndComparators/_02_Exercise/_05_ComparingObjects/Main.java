package _09_IteratorsAndComparators._02_Exercise._05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            String town = personInfo[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());
        Person searchedPerson = people.get(index - 1);

        int equalPeople = 0;
        for (Person person : people) {
            if (person.compareTo(searchedPerson) == 0) {
                equalPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
			System.out.print(equalPeople + " ");
            System.out.print((people.size() - equalPeople) + " ");
            System.out.print(people.size());
        }
    }
}
