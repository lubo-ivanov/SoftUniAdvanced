package javaAdvanced.functionalProgramming.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();
        String condition = scanner.nextLine();
        Predicate<Integer> oddOrEven = integer -> {
            if (condition.equals("odd")) {
                return integer % 2 != 0;
            }
            return integer % 2 == 0;
        };
        List<Integer> numbers = new ArrayList<>();
        while (start <= end) {
           numbers.add(start++);
        }
        numbers.forEach(number -> {
            if(oddOrEven.test(number)) {
                System.out.print(number + " ");
            }
        });

    }
}
