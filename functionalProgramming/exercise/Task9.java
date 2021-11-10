package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        BiPredicate<Integer, List<Integer>> divisible = (e1, e2) -> {
            for (Integer number : e2) {
                if (e1 % number != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.rangeClosed(1, n).filter(integer-> divisible.test(integer, numbers)).forEach(integer-> System.out.print(integer + " "));
    }
}

