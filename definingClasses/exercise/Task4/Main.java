package javaAdvanced.definingClasses.exercise.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            createCarsList(cars, input);
        }

        String command = scanner.nextLine();

        Function<List<Car>, Stream<Car>> carStream = list -> list.stream().filter(car -> car.getCargoType().equals(command));
        Consumer<Stream<Car>> printCars = carStream1 -> carStream1.forEach(car1 -> System.out.println(car1.getModel()));
        Predicate<List<Double>> checkPressure = list -> list.stream().anyMatch(tyre -> tyre < 1.0);

        printCars.accept(carStream.apply(cars).filter(car -> {
            if (command.equals("fragile")) {
                return checkPressure.test(car.getTyresPressure());
            }
            return car.getEnginePower() > 250;
        }));
    }

    private static void createCarsList(List<Car> cars, String[] input) {
        String model = input[0];
        int engineSpeed = Integer.parseInt(input[1]);
        int enginePower = Integer.parseInt(input[2]);
        int cargoWeight = Integer.parseInt(input[3]);
        String cargoType = input[4];
        List<Double> tyresPressure = Stream.of(input[5], input[7], input[9], input[11])
                .map(Double::parseDouble).collect(Collectors.toList());
        List<Integer> tyresAge = Stream.of(input[6], input[8], input[10], input[12])
                .map(Integer::parseInt).collect(Collectors.toList());
        cars.add(new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tyresPressure, tyresAge));
    }
}
