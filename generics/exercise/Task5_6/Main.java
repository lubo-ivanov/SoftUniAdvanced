package javaAdvanced.generics.exercise.Task5_6;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box <Double>items = new Box<>();
        for (int i = 0; i < n; i++) {
            items.add(Double.parseDouble(scanner.nextLine()));
        }

        System.out.println(items.countGreater(Double.parseDouble(scanner.nextLine())));
    }

}
