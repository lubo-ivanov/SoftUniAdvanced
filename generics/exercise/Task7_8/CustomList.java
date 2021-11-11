package javaAdvanced.generics.exercise.Task7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        T firstElement = this.list.get(index1);
        T secondElement = this.list.get(index2);
        this.list.set(index1, secondElement);
        this.list.set(index2, firstElement);
    }

    public int countGreaterThan(T element) {
        return (int) this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void print() {
        for (T element : this.list) {
            System.out.println(element);
        }
    }

    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

}
