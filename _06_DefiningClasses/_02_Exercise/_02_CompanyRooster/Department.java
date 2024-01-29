package _06_DefiningClasses._02_Exercise._02_CompanyRooster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public double getAverageSalary() {
        double avgSalary = 0;
        for (Employee employee : employeeList) {
            avgSalary += employee.getSalary();
        }
        return avgSalary / this.employeeList.size();
    }
}
