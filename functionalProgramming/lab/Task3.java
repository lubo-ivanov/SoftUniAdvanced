package javaAdvanced.functionalProgramming.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate <String> firstIsCaps = str -> Character.isUpperCase(str.charAt(0));

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(firstIsCaps).collect(Collectors.toList());
        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
