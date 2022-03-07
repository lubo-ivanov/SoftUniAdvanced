package javaAdvanced.iteratorsAndComparators.exercise.Task1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(String command) {
        this.list = new ArrayList<>(Arrays.asList(Arrays.stream(command.split("\\s+")).skip(1).toArray(String[]::new)));
        this.index = 0;
    }

    public boolean move() {
        if (!this.list.isEmpty()) {
            if (this.index < list.size() - 1) {
                this.index += 1;
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    public void print() {
        if (this.list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(this.index));
        }
    }

    public void printAll() {
        for (String element : this) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public boolean hasNext() {
        return !this.list.isEmpty() && this.index < this.list.size() - 1;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < list.size();
            }

            @Override
            public String next() {
                return list.get(this.index++);
            }
        };
    }
}
