package javaAdvanced.iteratorsAndComparators.exercise.Task3;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public int pop() {

        if (this.top == null) {
            System.out.println("No elements");
            return 0;
        } else {
            Node currentTop = this.top;
            this.top = currentTop.prev;
            return currentTop.element;
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node currentTop = top;
            @Override
            public boolean hasNext() {
                return currentTop != null;
            }

            @Override
            public Integer next() {
                int currentElement = currentTop.element;
                this.currentTop = this.currentTop.prev;
                return currentElement;
            }
        };
    }



}



