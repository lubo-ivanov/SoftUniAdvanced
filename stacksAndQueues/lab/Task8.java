package javaAdvanced.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        String currentURL = "";
        while (!input.equals("Home")) {
            switch (input) {
                case "back":
                    if (backStack.size() > 1) {
                        forwardStack.push(backStack.pop());
                        System.out.println(backStack.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (forwardStack.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        backStack.push(forwardStack.pop());
                        System.out.println(backStack.peek());
                    }
                    break;
                default:
                    backStack.push(input);
                    System.out.println(backStack.peek());
                    forwardStack.clear();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
