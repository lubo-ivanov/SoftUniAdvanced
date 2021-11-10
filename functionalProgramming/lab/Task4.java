package javaAdvanced.functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVAT= x -> x * 1.2;
        String input = scanner.nextLine();
        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(", ")).mapToDouble(Double::parseDouble).forEach(e-> System.out.printf("%.2f%n", addVAT.apply(e)));
    }
}
