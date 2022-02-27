package javaAdvanced.definingClasses.exercise.Task3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);
            cars.put(model, new Car(model, fuelAmount, fuelCost));
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String model = command[1];
            int distance = Integer.parseInt(command[2]);
            cars.get(model).move(distance);
            input = scanner.nextLine();
        }
        cars.values().forEach(System.out::println);
    }
}
