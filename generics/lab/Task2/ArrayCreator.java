package javaAdvanced.generics.lab.Task2;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T item) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}

