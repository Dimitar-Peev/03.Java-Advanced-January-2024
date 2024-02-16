package _14_Exams._14_JavaAdvancedRegularExam_23Oct2021._03_Hotel.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Person person){
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown){
        return roster.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);

       // return roster.stream().filter(p->p.getName().equals(name) && p.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder text = new StringBuilder();
        text.append("The people in the hotel ").append(this.getName()).append(" are:").append(System.lineSeparator());

        for (Person person : roster) {
            text.append(person.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
