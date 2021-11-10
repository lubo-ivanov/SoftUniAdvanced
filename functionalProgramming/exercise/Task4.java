package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], int[]> add = element -> Arrays.stream(element).map(e-> e +=1).toArray();
        Function<int[], int[]> subtract = element -> Arrays.stream(element).map(e-> e -=1).toArray();
        Function<int[], int[]> multiply = element -> Arrays.stream(element).map(e-> e *=2).toArray();
        Consumer<int[]> print = element -> Arrays.stream(element).forEach(e-> System.out.print(e + " "));

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while(!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
