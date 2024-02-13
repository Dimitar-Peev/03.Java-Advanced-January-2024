package _09_IteratorsAndComparators._02_Exercise._06_StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
		
        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            Person person = new Person(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.forEach(person -> System.out.println(person.toString()));
        peopleByAge.forEach(person -> System.out.println(person.toString()));

    }
}
