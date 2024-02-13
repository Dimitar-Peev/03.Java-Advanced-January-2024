package _09_IteratorsAndComparators._02_Exercise._07_EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> personsTree = new TreeSet<>(new ComparatorByHashCode());
        HashSet<Person> personsHash = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            Person person = new Person(name, age);
            personsTree.add(person);
            personsHash.add(person);
        }

        System.out.println(personsTree.size());
        System.out.println(personsHash.size());
    }
}
