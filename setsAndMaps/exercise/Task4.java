package javaAdvanced.setsAndMaps.exercise;


import java.util.Scanner;
import java.util.TreeMap;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> occurrences = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            occurrences.putIfAbsent(input.charAt(i), 0);
            occurrences.put(input.charAt(i), occurrences.get(input.charAt(i)) + 1);
        }
        occurrences.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
