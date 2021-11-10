package javaAdvanced.functionalProgramming.exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestIndex = element -> element.lastIndexOf(Collections.min(element));

        Function<List<Integer>, Integer> findSmallestInd = element -> IntStream.rangeClosed(0, element.size() - 1).map(i -> element.size() - 1 - i).boxed()
                .min(Comparator.comparingInt(element::get)).orElse(-1);

        System.out.println(findSmallestInd.apply(numbers));
        System.out.println(findSmallestIndex.apply(numbers));

    }

}

