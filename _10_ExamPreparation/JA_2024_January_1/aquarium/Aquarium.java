package aquarium;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;

    private Set<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.capacity > this.getFishInPool()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish dummyFish = new Fish(name, "", 0);
        return this.fishInPool.remove(dummyFish);
    }

    public Fish findFish(String name) {
        Fish dummyFish = new Fish(name, "", 0);
        if (this.fishInPool.contains(dummyFish)) {
            for (Fish fish : this.fishInPool) {
                if (fish.getName().compareTo(dummyFish.getName()) == 0) {
                    return fish;
                }
            }
        }
        return null;
    }

    public String report() {
        String format = "Aquarium: %s ^ Size: %s%n%s";
        String allFish = this.fishInPool.stream()
                .map(Fish::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format(format,this.getName(),this.getSize(),allFish);
    }
}
