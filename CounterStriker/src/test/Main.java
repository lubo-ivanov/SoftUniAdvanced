package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] command = scanner.nextLine().split("\\s+");
                animals.add(new Human(command[0], command[1]));
        }
        animals.forEach(animal -> System.out.println(animal.getClass().getSimpleName()));


    }

}
