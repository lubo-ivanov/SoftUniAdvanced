package javaAdvanced.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> children = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(children::offer);
        int iteration = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (children.size() > 1) {
            counter++;
            for (int i = 1; i < iteration; i++) {
                children.offer(children.poll());
            }
            if (isPrime(counter)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }

        }
        System.out.println("Last is " + children.peek());

    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}



