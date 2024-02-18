package _10_ExamPreparation.JA_2024_January_2.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // add(Parrot parrot) method
    // - adds an entity to the data if there is room for it
    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    // remove(String name) method -
    // removes a parrot by given name, if such exists, and returns boolean
    public boolean remove(String name) {

        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    // sellParrot(String name) method - sell
    // (set its available property to false without removing it from the collection)
    // the first parrot with the given name, also return the parrot
    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (null != parrot) {
            parrot.setAvailable(false);
        }

        return parrot;
    }

    // sellParrotBySpecies(String species) method -
    // sells and returns all exam_prep.parrots from that species as a List
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotsBySpecies =
                this.data.stream()
                        .filter(p -> p.getSpecies().equals(species))
                        .collect(Collectors.toList());

        parrotsBySpecies.forEach(p -> p.setAvailable(false));

        return parrotsBySpecies;
    }

    // count() - returns the number of exam_prep.parrots
    public int count() {
        return this.data.size();
    }

    // report() - returns a String in the following format,
    // including only not sold exam_prep.parrots:
    //o	"Parrots available at {cageName}:
    //{Parrot 1}
    //{Parrot 2}
    //(…)"
    public String report() {
        List<Parrot> notSoldParrots = this.data.stream()
                .filter(Parrot::isAvailable)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Parrots available at %s:", this.name));

        notSoldParrots.forEach(parrot -> {
            sb.append(System.lineSeparator());
            sb.append(parrot);
        });

        return sb.toString();
    }

}
