package javaAdvanced.functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Function<String, IntStream> splitAndMap = str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).filter(e -> e % 2 == 0);
        Function<IntStream, IntStream> sortedNumbers = IntStream::sorted;
        Function<IntStream, String> stringOfNumbers = element -> element.mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(stringOfNumbers.apply(splitAndMap.apply(input)));
        System.out.println(stringOfNumbers.apply(sortedNumbers.apply((splitAndMap.apply(input)))));

    }
}
