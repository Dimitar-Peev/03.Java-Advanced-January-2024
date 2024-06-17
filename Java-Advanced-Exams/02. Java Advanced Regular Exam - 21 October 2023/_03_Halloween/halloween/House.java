package _14_Exams._02_JavaAdvancedRegularExam_21October2023._03_Halloween.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(kid -> kid.getName().equals(name));
    }

    public Kid getKid(String street) {
        return data.stream().filter(kid -> kid.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("Children who visited a house for candy:").append(System.lineSeparator());

        for (Kid kid : data) {
            text.append(kid.getName()).append(" from ").append(kid.getStreet()).append(" street").append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
