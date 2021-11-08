package javaAdvanced.setsAndMaps.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        while (count-- >0) {
            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        System.out.println(String.join(" ", elements));
    }
}
