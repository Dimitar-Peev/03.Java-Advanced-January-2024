package parrots;

import java.util.ArrayList;

public class Cage {
    private final String name;
    private final int capacity;
    private final ArrayList<Parrot> data;

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

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = null;
        for (Parrot p : this.data) {
            if (p.getName().equals(name)) {
                parrot = p;
                p.setAvailable(false);
                break;
            }
        }

        return parrot;
    }

    public ArrayList<Parrot> sellParrotBySpecies(String species) {
        ArrayList<Parrot> soldParrots = new ArrayList<>();
        for (Parrot p : this.data) {
            if (p.getSpecies().equals(species)) {
                soldParrots.add(p);
                sellParrot(p.getName());
            }
        }

        return soldParrots;
    }


    public int count() {
        return this.data.size();
    }

    public String report(){
        StringBuilder text = new StringBuilder();
        text.append("Parrots available at ").append(this.name).append(":");
        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()){
                text.append(System.lineSeparator()).append(parrot);
            }
        }

        return text.toString();
    }

}
