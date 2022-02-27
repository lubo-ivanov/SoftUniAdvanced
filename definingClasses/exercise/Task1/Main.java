package javaAdvanced.definingClasses.exercise.Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if (age > 30) {
                persons.add(new Person(name, age));
            }
        }
        persons.stream().sorted(Comparator.comparing(Person::getName)).forEach(e-> System.out.println(e.getName() + " - " + e.getAge()));


    }
}
