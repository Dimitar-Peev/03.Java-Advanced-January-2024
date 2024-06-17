package _14_Exams._01_JavaAdvancedRetakeExam_13Dec2023._03_FishingPond.fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (this.fishes.size() < this.capacity) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        return this.fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }

    public Fish getFish(String species) {
        return this.fishes.stream().filter(fish -> fish.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getVacancies() {
        return capacity - fishes.size();
    }

    public int getCount() {
        return fishes.size();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Fishes in the pond:").append(System.lineSeparator());

        for (Fish fish : fishes) {
            text.append(fish.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
