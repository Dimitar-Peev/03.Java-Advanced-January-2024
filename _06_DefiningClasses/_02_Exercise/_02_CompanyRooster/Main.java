package _06_DefiningClasses._02_Exercise._02_CompanyRooster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departmentMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
			
            Employee employee = null;
            departmentMap.putIfAbsent(department, new Department());
			
            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("^\\d+$")) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departmentMap.get(department).addEmployee(employee);
        }

        double bestAvgSalary = Integer.MIN_VALUE;
        String bestDepartment = "";
        for (var stringDepartmentEntry : departmentMap.entrySet()) {
            if (stringDepartmentEntry.getValue().getAverageSalary() > bestAvgSalary) {
                bestAvgSalary = stringDepartmentEntry.getValue().getAverageSalary();
                bestDepartment = stringDepartmentEntry.getKey();
            }
        }

        Department department = departmentMap.get(bestDepartment);
        System.out.println(String.format("Highest Average Salary: %s", bestDepartment));
        department
                .getEmployeeList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
