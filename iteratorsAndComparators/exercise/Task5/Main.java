package javaAdvanced.iteratorsAndComparators.exercise.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> persons = new ArrayList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            persons.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));

            input = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine());

        Person nPerson = persons.get(index - 1);
        int equalCount = (int) persons.stream().filter(person -> person.compareTo(nPerson) == 0).count();
//        for (javaOOP.encapsulation.exercise.shoppingSpree.person.Person javaOOP.inheritance.exercise.person : persons) {
//            if (javaOOP.inheritance.exercise.person.compareTo(nPerson) == 0) {
//                equalCount++;
//            }
//        }
        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalCount, persons.size() - equalCount, persons.size());
        }
    }
}
