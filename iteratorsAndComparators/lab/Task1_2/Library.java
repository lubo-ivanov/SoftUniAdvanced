package javaAdvanced.iteratorsAndComparators.lab.Task1_2;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    private static class LibIterator implements Iterator<Book> {
        private int index = 0;
        private Book[] books;

        public LibIterator(Book[] books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(books);
    }
}
