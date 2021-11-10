package javaAdvanced.functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Function<String, IntStream> numbers = str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt);
        System.out.println("Count = " + numbers.apply(input).count());
        System.out.println("Sum = " + numbers.apply(input).sum());

    }
}
