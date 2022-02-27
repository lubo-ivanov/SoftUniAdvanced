package javaAdvanced.definingClasses.exercise.Task5;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            if (input.length == 2) {
                Engine.getMapOfEngines().put(model, new Engine(model, power));
            } else if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                Engine.getMapOfEngines().put(model, new Engine(model, power, displacement, efficiency));
            } else {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    Engine.getMapOfEngines().put(model, new Engine(model, power, displacement));
                } catch (NumberFormatException exception) {
                    String efficiency = input[2];
                    Engine.getMapOfEngines().put(model, new Engine(model, power, efficiency));
                }
            }
        }
        n = Integer.parseInt(scanner.nextLine());
        while (n-- >0) {
            String[] input1 = scanner.nextLine().split("\\s+");
            String model = input1[0];
            Engine engine = Engine.getMapOfEngines().get(input1[1]);

            if (input1.length == 2) {
                cars.add(new Car(model, engine));
            } else if (input1.length == 4) {
                int weight = Integer.parseInt(input1[2]);
                String color = input1[3];
                cars.add(new Car(model, engine, weight, color));
            } else {
                try {
                    int weight = Integer.parseInt(input1[2]);
                    cars.add(new Car(model, engine, weight));
                } catch (NumberFormatException exception) {
                    String color = input1[2];
                    cars.add(new Car(model, engine, color));
                }
            }
        }
        cars.forEach(System.out::println);


    }
}
