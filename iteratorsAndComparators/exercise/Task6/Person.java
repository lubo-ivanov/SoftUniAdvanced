package javaAdvanced.iteratorsAndComparators.exercise.Task6;

import java.util.Comparator;
import java.util.Locale;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static class CompareByName implements Comparator<Person> {

        @Override
        public int compare(Person person1, Person person2) {
            int result = Integer.compare(person1.name.length(), person2.name.length());
            if (result == 0) {
                return Integer.compare(person1.name.toLowerCase(Locale.ROOT).charAt(0), person2.name.toLowerCase(Locale.ROOT).charAt(0));
            }
            return result;
        }
    }

    public static class CompareByAge implements Comparator<Person> {

        @Override
        public int compare(Person person1, Person person2) {
            return Integer.compare(person1.age, person2.age);
        }
    }

}
