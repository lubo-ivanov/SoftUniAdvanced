package javaAdvanced.definingClasses.exercise.Task2;

import java.util.List;

public class Department {
    private List<Employee> employees;
    private double averageSalary;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            stringBuilder.append(String.format("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        }
        return stringBuilder.toString();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(List<Employee> employees) {
        this.employees = employees;
    }

    public void calcAvgSalary() {
        this.averageSalary = this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }
}
