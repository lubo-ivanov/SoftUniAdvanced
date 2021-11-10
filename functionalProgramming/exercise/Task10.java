package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        BiPredicate<String, String[]> testCondition = (e1, e2) -> {
            if (e2[1].equals("StartsWith")) {
                return e1.startsWith(e2[2]);
            }
            if (e2[1].equals("EndsWith")) {
                return e1.endsWith(e2[2]);
            }
            if (e2[1].equals("Length")) {
                return e1.length() == Integer.parseInt(e2[2]);
            }
            return false;
        };


        while (!input.equals("Party!")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Remove")) {
                guests = guests.stream().filter(e -> !testCondition.test(e, command)).collect(Collectors.toList());
            }
            if (command[0].equals("Double")) {
                guests.addAll(guests.stream().filter(e -> testCondition.test(e, command)).collect(Collectors.toList()));
            }
            input = scanner.nextLine();
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }

    }
}
