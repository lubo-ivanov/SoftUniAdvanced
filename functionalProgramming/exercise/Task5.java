package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        numbers.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));


    }
}
