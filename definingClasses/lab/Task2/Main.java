package javaAdvanced.definingClasses.lab.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 3) {
                cars.add(new Car(input[0], input[1], Integer.parseInt(input[2])));
            } else {
                cars.add(new Car(input[0]));
            }
        }

        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
