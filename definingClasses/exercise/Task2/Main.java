package javaAdvanced.definingClasses.exercise.Task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee;
            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                if (input[4].contains("@")) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            departments.putIfAbsent(department, new Department(new ArrayList<>()));
            departments.get(department).getEmployees().add(employee);
            departments.get(department).calcAvgSalary();
        }


        Map.Entry<String, Department> bestDepartment = departments.entrySet().stream().max(Comparator.comparing(element -> element.getValue().getAverageSalary()))
                .orElseThrow();

        System.out.println("Highest Average Salary: " + bestDepartment.getKey());
        bestDepartment.getValue().getEmployees().sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(bestDepartment.getValue().getEmployees());
        System.out.println(bestDepartment.getValue());

    }


}
