package javaAdvanced.iteratorsAndComparators.lab.Task3_4;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.getTitle().compareTo(book2.getTitle());
        if (result != 0) {
            return result;
        } else {
            return Integer.compare(book1.getYear(), book2.getYear());
        }
    }
}
