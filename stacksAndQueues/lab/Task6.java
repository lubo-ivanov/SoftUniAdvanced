package javaAdvanced.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> children = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(children::offer);

        int iteration = Integer.parseInt(scanner.nextLine());

        while (children.size() > 1) {
            for (int i = 1; i < iteration; i++) {
                children.offer(children.poll());
            }
            System.out.println("Removed " + children.poll());
        }
        System.out.println("Last is " + children.peek());


    }
}
