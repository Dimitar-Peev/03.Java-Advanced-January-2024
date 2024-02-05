package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.count() >= this.getCapacity()) {
            return;
        }
        this.data.add(present);
    }

    public boolean remove(String name) {
       return this.data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviest = this.data.get(0);
        for (Present present : data) {
            if (present.getWeight() > heaviest.getWeight()) {
                heaviest = present;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name) {
        return data.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(this.color).append(" bag contains:").append(System.lineSeparator());

        for (Present datum : data) {
            text.append(datum.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
