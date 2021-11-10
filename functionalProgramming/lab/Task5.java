package javaAdvanced.functionalProgramming.lab;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            map.put(input.split(", ")[0], Integer.parseInt(input.split(", ")[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Consumer<Stream<Map.Entry<String, Integer>>> printer = stream -> stream.forEach(entry -> {
            if (format.equals("age")) {
                System.out.println(entry.getValue());
            } else if (format.equals("name")) {
                System.out.println(entry.getKey());
            } else if (format.equals("name age")){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        });

        Predicate<Integer> test = number -> {
            if (condition.equals("older")) {
                return number >= age;
            }
            return number <= age;

        };
        printer.accept(map.entrySet().stream().filter(entry -> test.test(entry.getValue())));

    }
}
