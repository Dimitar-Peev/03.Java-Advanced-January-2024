package _13_RetakeExam._03_Spacecrafts.spaceCrafts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public List<Spacecraft> getSpacecrafts() {
        return this.spacecrafts;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < this.capacity) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        return this.spacecrafts.removeIf(s -> s.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        Spacecraft heaviestSpacecraft = null;
        heaviestSpacecraft = Collections.max(spacecrafts, Comparator.comparingInt(Spacecraft::getWeight));
        return String.format(heaviestSpacecraft.getName() + " - " + heaviestSpacecraft.getWeight() + "kg.");
    }

    public Spacecraft getSpacecraft(String name) {
        return this.spacecrafts.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> suitableSpacecrafts = getSpacecrafts().stream().filter(spacecraft -> spacecraft.getMissionType().equals(missionType)).collect(Collectors.toList());
        if (suitableSpacecrafts.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return suitableSpacecrafts;
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Spacecrafts launched from %s:", this.name));

        if (spacecrafts.isEmpty()) {
            text.append(System.lineSeparator()).append("none");
        } else {
            text.append(System.lineSeparator());
            for (int i = 0; i < spacecrafts.size(); i++) {
                text.append(i + 1).append(". ").append(spacecrafts.get(i).getName()).append(System.lineSeparator());
            }
        }
        return text.toString().trim();
    }

}
