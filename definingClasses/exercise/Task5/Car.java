package javaAdvanced.definingClasses.exercise.Task5;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = String.valueOf(weight);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = String.valueOf(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n", this.model) +
                engine.toString() +
                String.format("Weight: %s%n", this.weight) +
                String.format("Color: %s", this.color);
    }
}
