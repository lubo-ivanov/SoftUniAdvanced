package javaAdvanced.generics.exercise.Task3_4;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    List<T> items;

    public Box() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);
    }

    public void swap(int indexOne, int indexTwo) {
        indexIsValid(indexOne, indexTwo);
        T placeholder = this.items.get(indexOne);
        this.items.set(indexOne, this.items.get(indexTwo));
        this.items.set(indexTwo, placeholder);
        ;
    }

    private void indexIsValid(int indexOne, int indexTwo) {
        if (indexOne < 0 || indexOne >= this.items.size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
        }
        if (indexTwo < 0 || indexTwo >= this.items.size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T item : items) {
            stringBuilder.append(item.getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(item);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
