package javaAdvanced.definingClasses.exercise.Task3;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTravelled;

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.distanceTravelled = 0;
    }

    public void move(int distance) {
        if (distance * this.fuelCostFor1Km > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -= distance* this.fuelCostFor1Km;
            this.distanceTravelled += distance;
        }
    }
}
