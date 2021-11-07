package javaAdvanced.stacksAndQueues.exercise;

import java.util.Scanner;

public class Task7_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print(getFibonacci(n));
    }

    public static int getFibonacci(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        return getFibonacci(n - 2) + getFibonacci(n - 1);
    }
}

