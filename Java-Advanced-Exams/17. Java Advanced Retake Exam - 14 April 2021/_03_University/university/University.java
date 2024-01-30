package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() >= this.capacity) {
            return "No seats in the university";
        } else if (this.students.contains(student)) {
            return "Student is already in the university";
        } else {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        for (Student s : students) {
            text.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
                    s.getFirstName(), s.getLastName(), s.getBestSubject()));
        }

        return text.toString();
    }
}
