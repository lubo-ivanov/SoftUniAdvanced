package javaAdvanced.definingClasses.exercise.Task7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> persons = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            persons.putIfAbsent(tokens[0], new Person(new Company(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new Car()));
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    persons.get(tokens[0]).getCompany().setCompany(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    persons.get(tokens[0]).getPokemons().add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    persons.get(tokens[0]).getParents().add(new Parent(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    persons.get(tokens[0]).getChildren().add(new Child(childName, childBirthday));
                    break;
                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    persons.get(tokens[0]).getCar().setCar(carModel, carSpeed);
                    break;


            }

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("Company:");
        if (persons.get(name).getCompany().getCompanyName() != null) {
            System.out.println(persons.get(name).getCompany().toString());
        }
        System.out.println("Car:");
        if (persons.get(name).getCar().getCarModel() != null) {
            System.out.println(persons.get(name).getCar().toString());
        }
        System.out.println("Pokemon:");
        persons.get(name).getPokemons().forEach(System.out::println);
        System.out.println("Parents:");
        persons.get(name).getParents().forEach(System.out::println);
        System.out.println("Children:");
        persons.get(name).getChildren().forEach(System.out::println);
    }
}
