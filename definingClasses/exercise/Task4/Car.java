package javaAdvanced.definingClasses.exercise.Task4;

import java.util.List;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private List<Double> tyresPressure;
    private List<Integer> tyresAge;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Double> tyresPressure, List<Integer> tyresAge) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tyresPressure = tyresPressure;
        this.tyresAge = tyresAge;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public List<Double> getTyresPressure() {
        return tyresPressure;
    }
}
