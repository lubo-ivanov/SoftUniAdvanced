package javaAdvanced.generics.exercise.Task1_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Box(Integer.parseInt(scanner.nextLine())));
        }
        for (Box box : items) {
            System.out.println(box);
        }

    }
}
