package _06_DefiningClasses._02_Exercise._08_FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parentsList;
    private List<Person> childrenList;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void addParent(Person person) {
        if (isNotExist(person, parentsList)) {
            this.parentsList.add(person);
        }
    }

    public void addChild(Person person) {
        if (isNotExist(person, childrenList)) {
            this.childrenList.add(person);
        }
    }

    private boolean isNotExist(Person person, List<Person> personsList) {
        for (Person currentPerson : personsList) {
            if (currentPerson.equals(person)) {
                return false;
            }
        }
        return true;
    }

    public String getOutput(List<Person> personList) {
        StringBuilder output = new StringBuilder();
        if (!personList.isEmpty()) {
            personList.forEach(person -> output.append(String.format("%s %s%n", person.getName(), person.getBirthday())));
        }
        return output.toString();
    }

    @Override
    public String toString() {

        return String.format("%s %s%nParents:%n%sChildren:%n%s", name, String.join("/", birthday), getOutput(parentsList), getOutput(childrenList));
    }
}
