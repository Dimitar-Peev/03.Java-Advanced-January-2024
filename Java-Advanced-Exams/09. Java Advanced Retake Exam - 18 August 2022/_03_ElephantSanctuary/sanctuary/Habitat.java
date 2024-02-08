package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream().filter(e -> e.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder text = new StringBuilder();
        text.append("Saved elephants in the park:").append(System.lineSeparator());

        for (Elephant elephant : data) {
            text.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom())).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
