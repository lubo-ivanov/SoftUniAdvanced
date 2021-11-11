package javaAdvanced.generics.exercise.Task5_6;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{

    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public Box() {
        this.items = new ArrayList<>();
    }
    public void add(T item) {
        this.items.add(item);
    }

    public int countGreater(T element) {
        return (int) this.items.stream().filter(e -> e.compareTo(element) > 0).count();
    }

}
