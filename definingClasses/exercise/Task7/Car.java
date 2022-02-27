package javaAdvanced.definingClasses.exercise.Task7;

public class Car {
    private String carModel;
    private String carSpeed;

    public void setCar(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.carModel, this.carSpeed);
    }

}
