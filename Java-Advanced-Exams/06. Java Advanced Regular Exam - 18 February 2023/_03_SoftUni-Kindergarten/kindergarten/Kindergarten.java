package _14_Exams._06_JavaAdvancedRegularExam_18February2023.kindergarten;

import java.util.*;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        return registry.removeIf(c -> c.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream().filter(c -> c.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        Comparator<Child> compare = Comparator.comparing((Child c) -> c.getAge())
                .thenComparing(c -> c.getFirstName())
                .thenComparing(c -> c.getLastName());
        this.registry.sort(compare);

        StringBuilder text = new StringBuilder();
        text.append("Registered children in ").append(this.name).append(":");

        this.registry.forEach(child -> text.append(System.lineSeparator()).append("--").append(System.lineSeparator()).append(child.toString()));

        return text.toString();
    }
}
