package javaAdvanced.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentURL = "";
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                stack.push(input);
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }
            currentURL = stack.peek();
            System.out.println(currentURL);

            input = scanner.nextLine();
        }

    }
}
