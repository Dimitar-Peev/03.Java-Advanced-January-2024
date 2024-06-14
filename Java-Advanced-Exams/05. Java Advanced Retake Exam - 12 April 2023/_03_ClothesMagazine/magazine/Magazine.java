package _14_Exams._05_JavaAdvancedRetakeExam_12April2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(c -> c.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public Cloth getCloth(String color) {
        return this.data.stream().filter(c -> c.getColor().equals(color)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(this.type).append(" magazine contains:");

        for (Cloth cloth : data) {
            text.append(System.lineSeparator()).append(cloth.toString());
        }

        return text.toString();
    }
}
