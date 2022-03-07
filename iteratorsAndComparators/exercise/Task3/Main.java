package javaAdvanced.iteratorsAndComparators.exercise.Task3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];
            switch (command) {
                case "Push":
                    String[] tokens = Arrays.stream(input.split("[, ]+")).skip(1).toArray(String[]::new);
                    for (String element : tokens) {
                        stack.push(Integer.parseInt(element));
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            input = scanner.nextLine();
        }
        for (var element : stack) {
            System.out.println(element);
        }
        for (var element : stack) {
            System.out.println(element);
        }
    }
}
