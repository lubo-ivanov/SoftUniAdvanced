package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], Integer> findMin = e-> Arrays.stream(e).min().orElse(0);
        System.out.println(findMin.apply(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()));

    }
}
