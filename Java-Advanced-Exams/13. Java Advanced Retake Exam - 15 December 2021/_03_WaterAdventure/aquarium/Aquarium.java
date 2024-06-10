package _14_Exams._13_JavaAdvancedRetakeExam_15December2021._03_WaterAdventure.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity && findFish(fish.getName()) == null) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Aquarium: ").append(this.name).append(" ^ Size: ").append(this.size).append(System.lineSeparator());
        for (Fish fish : fishInPool) {
            text.append(fish.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
