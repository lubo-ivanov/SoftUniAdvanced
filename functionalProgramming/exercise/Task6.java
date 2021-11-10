package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> compareLength = string -> string.length() <= n;
        String[] names = scanner.nextLine().split("\\s+");
        Arrays.stream(names).filter(compareLength).forEach(System.out::println);
    }
}
