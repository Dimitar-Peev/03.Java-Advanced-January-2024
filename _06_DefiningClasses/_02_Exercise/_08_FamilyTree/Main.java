package _06_DefiningClasses._02_Exercise._08_FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nameOrBirthday = scanner.nextLine();

        Map<String, List<String>> familyMap = new LinkedHashMap<>();
        Set<String> familySet = new LinkedHashSet<>();
        List<Person> personsList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            if (input.contains(" - ")) {
                String[] inputArr = input.split("\\s+-\\s+");
                String parentData = inputArr[0];
                String childData = inputArr[1];

                familyMap.putIfAbsent(parentData, new ArrayList<>());
                familyMap.get(parentData).add(childData);
                familySet.add(parentData);
                familySet.add(childData);

            } else {
                String[] inputArr2 = input.split("\\s+");
                String name = inputArr2[0] + " " + inputArr2[1];
                String birthday = inputArr2[inputArr2.length - 1];
                Person person = new Person(name, birthday);
                personsList.add(person);

            }

            input = scanner.nextLine();
        }

        familySet.forEach(data -> {
            Person person = getPersonInfo(data, personsList);
            familyMap.forEach((key, value) -> {
                Person parent = getPersonInfo(key, personsList);
                value.forEach(childEntry -> {
                    Person child = getPersonInfo(childEntry, personsList);
                    if (person == child) {
                        person.addParent(parent);
                    } else if (person == parent) {
                        person.addChild(child);
                    }
                });
            });
        });

        System.out.println(getPersonInfo(nameOrBirthday, personsList).toString());
    }

    private static Person getPersonInfo(String data, List<Person> personsList) {
        Person currentPerson = null;
        for (Person person : personsList) {
            if (person.getName().equals(data) || person.getBirthday().equals(data)) {
                currentPerson = person;
            }
        }
        return currentPerson;
    }
}
