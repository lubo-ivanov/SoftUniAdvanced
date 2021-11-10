package javaAdvanced.functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e-> System.out.println("Sir " + e));
    }
}
