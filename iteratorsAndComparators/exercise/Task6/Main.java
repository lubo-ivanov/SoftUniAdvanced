package javaAdvanced.iteratorsAndComparators.exercise.Task6;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> set1 = new TreeSet<>(new Person.CompareByName());
        Set <Person>set2 = new TreeSet<>(new Person.CompareByAge());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            set1.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
            set2.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
        }
        for (Person person : set1) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : set2) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
