package javaAdvanced.definingClasses.exercise.Task5;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Engine {
    private static Map<String,Engine> mapOfEngines = new HashMap<>();
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";

    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = String.valueOf(displacement);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = String.valueOf(displacement);
        this.efficiency = efficiency;
    }

    public static Map<String, Engine> getMapOfEngines() {
        return mapOfEngines;
    }

    public static void setMapOfEngines(Map<String, Engine> mapOfEngines) {
        Engine.mapOfEngines = mapOfEngines;
    }

    @Override
    public String toString() {

        return String.format("%s:%n", this.model) +
                String.format("Power: %d%n", this.power) +
                String.format("Displacement: %s%n", this.displacement) +
                String.format("Efficiency: %s%n", this.efficiency);
    }
}
