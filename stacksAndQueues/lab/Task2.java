package javaAdvanced.stacksAndQueues.lab;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> command = new ArrayDeque<>();
        Collections.reverse(input);
        input.forEach(command::push);

        int currentResult = Integer.parseInt(command.pop());
        while (command.size() > 0 ) {
            if (command.pop().equals("+")) {
                currentResult += Integer.parseInt(command.pop());
            } else {
                currentResult -= Integer.parseInt(command.pop());
            }
        }
        System.out.println(currentResult);
    }
}
