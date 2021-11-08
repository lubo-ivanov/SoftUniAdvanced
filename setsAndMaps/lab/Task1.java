package javaAdvanced.setsAndMaps.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> cars = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(", ");
            switch (command[0]) {
                case "IN":
                    cars.add(command[1]);
                    break;
                case "OUT":
                    cars.remove(command[1]);
                    break;
            }

            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(System.out::println);
        }
    }
}
