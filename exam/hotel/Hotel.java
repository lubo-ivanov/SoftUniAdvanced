package javaAdvanced.exam.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (name.equals(person.getName())) {
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (name.equals(person.getName()) && hometown.equals(person.getHometown())) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The people in the javaAdvanced.exam.hotel %s are:", this.name))
                .append(System.lineSeparator());
        for (Person person : this.roster) {
            stringBuilder.append(person).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }

}
