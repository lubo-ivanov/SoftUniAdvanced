package javaAdvanced.stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> output = new ArrayDeque<>();
        if (input == 0) {
            System.out.println(0);
        } else {
            while (input > 0) {
                output.push(input % 2);
                input /= 2;
            }
            output.forEach(e -> System.out.print("" + e));
        }
    }
}
