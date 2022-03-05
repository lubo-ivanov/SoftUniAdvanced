package javaAdvanced.exam.vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet: this.data) {
            if (pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getOwner().equals(owner) && pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return Collections.max(this.data, Comparator.comparing(Pet::getAge));
        //this.data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : this.data) {
            stringBuilder.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
