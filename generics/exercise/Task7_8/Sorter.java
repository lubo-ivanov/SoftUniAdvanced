package javaAdvanced.generics.exercise.Task7_8;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size() - 1; ) {
            int result = list.get(i).compareTo(list.get(i + 1));
            if (result > 0) {
                list.swap(i, i + 1);
                i   = 0;
            } else {
                i++;
            }
        }
    }
}
