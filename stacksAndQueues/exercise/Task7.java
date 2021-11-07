package javaAdvanced.stacksAndQueues.exercise;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <BigInteger> numbers = new ArrayDeque<>();
        numbers.push(new BigInteger("1"));
        numbers.push(new BigInteger("1"));
        if (n==1) {
            System.out.println(1);
        } else {
            for (int i = 1; i < n; i++) {
                getFibonacci(numbers);
            }
            System.out.println(numbers.pop());
        }


    }

    private static void getFibonacci(ArrayDeque<BigInteger> numbers) {

        BigInteger lastNumber = new BigInteger(String.valueOf(numbers.pop()));
        BigInteger secondToLast = new BigInteger(String.valueOf(numbers.pop()));
        numbers.push(lastNumber);
        numbers.push(lastNumber.add(secondToLast));

    }
}
