package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public int getCount(){
        return this.data.size();
    }
    public String insert(Student student) {
        if (this.data.size() >= this.capacity) {
            return "The hall is full.";
        } else if (this.data.contains(student)) {
            return "Student is already in the hall.";
        } else {
            data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
    }
    public String remove(Student student) {
        if (this.data.contains(student)) {
            data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName){
        return this.data.stream().filter(s -> s.getFirstName().equals(firstName)
                && s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("Hall size: ").append(getCount()).append(System.lineSeparator());

        for (Student student : data) {
            text.append(student.toString()).append(System.lineSeparator());
        }
        return text.toString().trim();
    }
}
