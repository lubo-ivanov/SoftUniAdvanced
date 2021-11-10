package javaAdvanced.functionalProgramming.exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Consumer<List<Integer>> evenFirst = element -> element.stream().sorted().sorted(Comparator.comparing(e -> e % 2 != 0)).forEach(e -> System.out.print(e + " "));
        evenFirst.accept(numbers);
    }
}
