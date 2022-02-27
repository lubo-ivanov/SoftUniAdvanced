package javaAdvanced.definingClasses.exercise.Task7;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public void setCompany(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.department, this.salary);
    }
}
