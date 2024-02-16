package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private  int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void  add(Animal animal){
        if (this.data.size() < this.capacity){
            this.data.add(animal);
        }
    }
    public boolean remove(String name){
        return data.removeIf(a->a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker){
        return this.data.stream().filter(animal -> animal.getName().equals(name)
                && animal.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal(){
        return data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }
    public int getCount() {
        return data.size();
    }

    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append("The shelter has the following animals:").append(System.lineSeparator());

        for (Animal a : data) {
            text.append(a.getName()).append(" ").append(a.getCaretaker()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
