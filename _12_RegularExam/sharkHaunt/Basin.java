package _12_RegularExam_17February2024.DimitarPeev.sharkHaunt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }


    public void addShark(Shark shark) {
        if (this.sharks.size() < this.capacity) {
            this.sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        Predicate<Shark> isEquals = p -> p.getKind().equals(kind);
        return sharks.removeIf(isEquals);
    }

    public Shark getLargestShark() {
        return Collections.max(sharks, Comparator.comparingInt(Shark::getLength));
    }


    public Shark getShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    public int getCount() {
        return this.sharks.size();
    }
    public int getAverageLength(){
       int average = 0;
        for (Shark shark : sharks) {
            average += shark.getLength();
        }

       return average/sharks.size();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Sharks in %s:",this.name));
        for (Shark shark : sharks) {
            text.append(System.lineSeparator()).append(shark.toString());
        }
        return text.toString();
    }
}
